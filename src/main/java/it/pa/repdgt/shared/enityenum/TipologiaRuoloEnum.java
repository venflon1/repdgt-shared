package it.pa.repdgt.shared.enityenum;

import lombok.Getter;

@Getter
public enum TipologiaRuoloEnum {
	  DTD_AMMINISTRATORE("DTD AMMINISTRATORE")
	 ,ENTE_GESTORE_PROGETTO("ENTE GESTORE PROGETTO")
	 ,ENTE_GESTORE_PROGRAMMA("ENTE GESTORE PROGRAMMA")
	 ,ENTE_PROGETTO("ENTE PROGETTO")
	 ,FACILITATORE("FACILITATORE")
	 ,VOLONTARIO("VOLONTARIO")
	 ;
	
	private String value; 
	
	private TipologiaRuoloEnum(String value) {
		this.value = value;
	}
}