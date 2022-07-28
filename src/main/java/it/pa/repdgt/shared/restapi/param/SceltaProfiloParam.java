package it.pa.repdgt.shared.restapi.param;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import it.pa.repdgt.shared.entityenum.RuoloUtenteEnum;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Setter
public class SceltaProfiloParam {

	@NotNull
	private String codiceRuoloUtenteLoggato;
	
	@NotNull
	private String cfUtenteLoggato;
	
	// NB: idProgramma=null SSE ruolo utenteLoggato = {DTD, DSCU, ruolo_custom}
	private Long idProgramma;
		
	// NB: idProgetto=null SSE ruolo utenteLoggato = {DTD, DSCU, ruolo_custom, REG, DEG}
	private Long idProgetto;
}
