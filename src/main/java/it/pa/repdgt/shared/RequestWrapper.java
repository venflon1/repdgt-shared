package it.pa.repdgt.shared;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {
	private static final int SIZE_BUFFER = 128;
        private static final String AUTH_TOKEN_HEADER = "authToken";
        private static final String USER_ROLE_HEADER  = "userRole";
        private static final String CODICE_RUOLO = "codiceRuolo";
        private static final String CODICE_FISCALE = "codiceFiscale";
                
        private ObjectMapper objectMapper = new ObjectMapper();
		private String body;
		private String codiceFiscale;
		private String codiceRuolo;
		
        public RequestWrapper(final HttpServletRequest httpServletRequest) throws Exception {
            super(httpServletRequest);
            
            // to fix h2 in memory db
            httpServletRequest.getParameterNames();
            
            Map<String, String> headers = this.getRequestHeaders(httpServletRequest);
            Optional<String> authToken = Optional.ofNullable(headers.get(AUTH_TOKEN_HEADER));
            Optional<String> codiceRuolo = Optional.ofNullable(headers.get(USER_ROLE_HEADER));
            
            /****** DECODIFICA TOKEN ********/
            
            /*prova decode payload jwt esempio con codiceFiscale ERRATO
			 * {
  					"codiceFiscale":"EEEEE"
				}
			 */
			//JWT esempio
            //authToken=Optional.of("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2RpY2VGaXNjYWxlIjoiRUVFRUUifQ.q0tcbBXgpeeWYY9GAmIrFtGIuxtMQtSo_X1WyDUqZC4");
            
            /*prova decode payload jwt esempio con codiceFiscale CORRETTO
			 * {
				  "codiceFiscale":"UTENTE1"
				}
			 */
			//JWT esempio
            authToken=Optional.of("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2RpY2VGaXNjYWxlIjoiVVRFTlRFMSJ9.dK1zPRmYFWCF9aGKCQedfj44O1sQeT7bPKsrZkuzP8A");
			
            //split JWT into 3 parts with . delimiter (part 1 = HEADER, part 2 = PAYLOAD, part 3 = SIGNATURE (Algorith (header + payload), secretKey)
			String[] parts = authToken.get().split("\\.");
			
			SpidResult result = null;
			//se non esiste codiceRuolo e/o authToken API GATEWAY blocca la chiamata
			String jwtPayload = decode(parts[1]);
			
			//mappo da stringa a oggetto il payload del jwt
			ObjectMapper oM = new ObjectMapper();
			result = oM.readValue(jwtPayload, SpidResult.class);
			
			log.info("JWT DECODIFICATO: " + jwtPayload);
			this.codiceFiscale = result.getCodiceFiscale();

			//this.codiceRuolo = codiceRuolo.get(); //TODO: da decommentare e commentare riga sotto
			//setto codiceRuolo di esempio
			this.codiceRuolo = "DTD";
			
            //siamo in caso di chiamata a API con HTTP METHOD <> GET
            final String inputCorpoRichiesta = this.getCorpoRichiesta(httpServletRequest);
            if(inputCorpoRichiesta != null  && !inputCorpoRichiesta.trim().isEmpty()) {
	            this.body = this.getCorpoRichiestaArricchitaConDatiContesto(inputCorpoRichiesta);
            }
        }

        public String getCorpoRichiesta(final HttpServletRequest httpServletRequest) throws IOException {
			if(httpServletRequest.getInputStream() == null) {
				return null;
			}
    		
    		final StringBuilder stringBuilder = new StringBuilder();
            try ( InputStream inputStream = httpServletRequest.getInputStream();
            	  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); ) {
                final char[] buffer = new char[SIZE_BUFFER];
                int bytesRead = -1;
                while ( (bytesRead = bufferedReader.read(buffer) ) > 0) {
                    stringBuilder.append(buffer, 0, bytesRead);
                }
            } catch (IOException ex) {
                throw ex;
            }
			return stringBuilder.toString();
		}
        
    	public String getCorpoRichiestaArricchitaConDatiContesto(final String corpoRichiesta) throws Exception {
			final JsonNode jsonNode = objectMapper.readTree(corpoRichiesta);
			final ObjectNode objectNode = (ObjectNode) jsonNode;
			
			objectNode.put(CODICE_FISCALE, this.codiceFiscale);	// setting valore con decodifica auth_token 
			objectNode.put(CODICE_RUOLO, this.codiceRuolo);
		
			return jsonNode.toString();
		}
        
        @Override
        public ServletInputStream getInputStream() throws IOException {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.body.getBytes());
            final ServletInputStream servletInputStream = new ServletInputStream() {
                public int read() throws IOException {
                    return byteArrayInputStream.read();
                }
    
                @Override
                public boolean isFinished() {
                    return false;
                }
    
                @Override
                public boolean isReady() {
                    return false;
                }
    
                @Override
                public void setReadListener(ReadListener listener) {
                	
                }
            };
            return servletInputStream;
        }
    
        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(this.getInputStream()));
        }
        
        private static String decode(String encodedString) {
            return new String(Base64.getUrlDecoder().decode(encodedString));
        }
        
        private Map<String, String> getRequestHeaders(HttpServletRequest request) {
    		Map<String, String> headersMap = new HashMap<String, String>();

    		Enumeration<String> headersName = request.getHeaderNames();
    		
    		
    		while (headersName.hasMoreElements()) {
    			String headerName  = (String) headersName.nextElement();
    			String headerValue = request.getHeader(headerName);
    			headersMap.put(headerName, headerValue);
    		}
    		return headersMap;
    	}
        
        public String getCodiceFiscale() {
        	return this.codiceFiscale;
        }
        
        public String getCodiceRuolo() {
        	return this.codiceRuolo;
        }
}

@Setter
@Getter
class SpidResult{
	private String codiceFiscale;
}