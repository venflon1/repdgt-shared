package it.pa.repdgt.shared;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import it.pa.repdgt.shared.service.PermessoApiService;
import it.pa.repdgt.shared.service.PermessoService;
import it.pa.repdgt.shared.service.RuoloService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Profile("dev")
public class RequestFilter implements Filter {
	@Autowired
	@Qualifier(value = "ruoloServiceFiltro")
	private RuoloService ruoloService;
	@Autowired
	@Qualifier(value = "permessoServiceFiltro")
	private PermessoService permessoService;
	@Autowired
	private PermessoApiService permessiApiService;
	
	private static final String OPEN_DATA_BASE_URI = "/open-data";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Filter - init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("Filter - doFilter - START");
		RequestWrapper wrappedRequest = null;
		try {
			wrappedRequest = new RequestWrapper((HttpServletRequest) request);
		} catch (Exception ex) {
			log.error("{}", ex);
			throw new RuntimeException(ex.getMessage());
		}

		final String codiceFiscaleUtenteLoggato = wrappedRequest.getCodiceFiscale();
		final String codiceRuoloUtenteLoggato   = wrappedRequest.getCodiceRuolo();
		boolean hasRuoloUtente = this.ruoloService
				.getRuoliByCodiceFiscaleUtente(wrappedRequest.getCodiceFiscale())
				.stream()
				.anyMatch(codiceRuolo -> codiceRuolo.equalsIgnoreCase(codiceRuoloUtenteLoggato));
		
		String metodoHttp = ((HttpServletRequest) request).getMethod();
		String endpoint = ((HttpServletRequest) request).getServletPath();
		HttpServletResponse responseHttp = ((HttpServletResponse) response);
		
		if(endpoint.contains(OPEN_DATA_BASE_URI)) {
			chain.doFilter(wrappedRequest, response);
		} else {
			// verifico se l'utente loggato possiede il ruolo con cui si è profilato
			if(!hasRuoloUtente) {
				responseHttp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Utente Non Autorizzato");
			} else {
				List<String> codiciPermessoPerApi = this.permessiApiService.getCodiciPermessiApiByMetodoHttpAndPath(metodoHttp, endpoint);
				List<String> codiciPermessoUtenteLoggato = this.permessoService.getCodiciPermessoByUtenteLoggato(codiceFiscaleUtenteLoggato, codiceRuoloUtenteLoggato);

				// verifico il profilo dell'utente loggato è abilitato a poter chiamare quella particolare api
				boolean isUtenteAbilitatoPerApi = false;
				for(String codiciPermesso: codiciPermessoPerApi) {
					if(codiciPermessoUtenteLoggato.contains(codiciPermesso)) {
						isUtenteAbilitatoPerApi = true;
						break;
					}
				}
				
				if(!isUtenteAbilitatoPerApi) {
					responseHttp.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.format("Utente Non Autorizzato per endpoint: %s %s", metodoHttp, endpoint));
				}else {
					chain.doFilter(wrappedRequest, response);
				}
			}
		}
		
	}

	@Override
	public void destroy() {
		log.debug("Filter - destroy");
	}
}