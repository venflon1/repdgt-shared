package it.pa.repdgt.shared;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.pa.repdgt.shared.repository.storico.UtenteXRuoloRepositoryProva;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestFilter implements Filter {

	@Autowired
	private UtenteXRuoloRepositoryProva utenteXRuoloRepository;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Filter - init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		RequestWrapper wrappedRequest = null;
		try {
			wrappedRequest = new RequestWrapper((HttpServletRequest) request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("dcdlckjdlk {}", ((HttpServletRequest) request).getServletPath());
		log.info("dcdlckjdlk {}", ((HttpServletRequest) request).getMethod());
		log.debug("Filter - doFilter");
		/*
		 * 
		 * select p.codice
			from utente_x_ruolo uxr
			inner join ruolo_x_gruppo rxg
			on uxr.ruolo_codice = rxg.ruolo_codice
			inner join gruppo_x_permesso gxp
			on rxg.gruppo_codice = gxp.gruppo_codice 
			inner join permesso p
			on  p.id = gxp.permesso_id
			where uxr.utente_id = 'LIAGLU86B23C169Z'
			and uxr.ruolo_codice = 'REPP';
			
			
			
			select pa.codice_permesso
			from permessi_api pa
			where http_method = 'GET'
			and '/ruolo/' REGEXP endpoint  ;
			
			SELECT '/utente/ /assegnaRuolo/d' REGEXP '/utente/.+/assegnaRuolo/.+';

		 * 
		 * 
		 * 
		 */
		if(!wrappedRequest.getCodiceFiscale().equals("UTENTE1")) {
			HttpServletResponse responseHttp = ((HttpServletResponse) response);
			responseHttp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "culo");
		}else {
			chain.doFilter(wrappedRequest, response);
		}
	}

	@Override
	public void destroy() {
		log.debug("Filter - destroy");
	}
}
