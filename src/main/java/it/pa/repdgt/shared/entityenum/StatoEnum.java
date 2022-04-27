package it.pa.repdgt.shared.entityenum;

import lombok.Getter;

@Getter
public enum StatoEnum {
	 ATTIVO("ATTIVO")
	,NON_ATTIVO("NON ATTIVO")
	,BOZZA("BOZZA")
	,SOSPESO("SOSPESO")
	;
	
	private String value;
	
	private StatoEnum(String value) {
		this.value = value;
	}
}