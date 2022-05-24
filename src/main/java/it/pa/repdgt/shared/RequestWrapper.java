package it.pa.repdgt.shared;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RequestWrapper extends HttpServletRequestWrapper {
	private static final int SIZE_BUFFER = 128;
        private static final String AUTH_TOKEN_HEADER = "authToken";
        private static final String USER_ROLE_HEADER  = "userRole";
        private static final String CODICE_RUOLO = "codiceRuolo";
        
        private ObjectMapper objectMapper = new ObjectMapper();
		private String body;
		
        public RequestWrapper(final HttpServletRequest httpServletRequest) throws IOException {
            super(httpServletRequest);
          
            // to fix h2 in memory db
            httpServletRequest.getParameterNames();

            final String inputCorpoRichiesta = this.getCorpoRichiesta(httpServletRequest);
            if(inputCorpoRichiesta != null  && !inputCorpoRichiesta.trim().isEmpty()) {
	            this.body = this.getCorpoRichiestaArricchitaConDatiContesto(inputCorpoRichiesta, httpServletRequest);
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
        
    	public String getCorpoRichiestaArricchitaConDatiContesto(final String corpoRichiesta, final HttpServletRequest httpServletRequest) throws JsonProcessingException, JsonMappingException {
			final JsonNode jsonNode = objectMapper.readTree(corpoRichiesta);
			final ObjectNode objectNode = (ObjectNode) jsonNode;
			
//			objectNode.put(AUTH_TOKEN_HEADER, "");	// setting valore con decodifica auth_token 
//			objectNode.put(CODICE_RUOLO, httpServletRequest.getHeader(USER_ROLE_HEADER));
		
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
}