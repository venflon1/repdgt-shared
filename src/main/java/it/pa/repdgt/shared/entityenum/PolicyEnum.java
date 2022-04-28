package it.pa.repdgt.shared.entityenum;

import lombok.Getter;

@Getter
public enum PolicyEnum {
	 SCD("Servizio Civile Digitale")
	,RFD("Rete dei serivizi di Facilitazione Digitale")
	;
	
	private String descrizione;
	
	private PolicyEnum(String descrizione) {
		this.descrizione = descrizione;
	}
}