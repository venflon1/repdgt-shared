package it.pa.repdgt.shared.entityenum;

import lombok.Getter;

@Getter
public enum RuoloUtenteEnum {
	  DTD("DTD")
	 ,DSCU("DSCU")
	 ,REG("REFERENTE ENTE GESTORE DI PROGRAMMA")
	 ,DEG("DELEGATO ENTE GESTORE DI PROGRAMMA")
	 ,REGP("REFERENTE ENTE GESTORE DI PROGETTO")
	 ,DEGP("DELEGATO ENTE GESTORE DI PROGETTO")
	 ,REPP("REFERENTE ENTE PARTNER")
	 ,DEPP("DELEGATO ENTE PARTNER")
	 ,FAC("FACILITATORE")
	 ,VOL("VOLONTARIO")
	 ;
	
	private String value; 
	
	private RuoloUtenteEnum(String value) {
		this.value = value;
	}
}