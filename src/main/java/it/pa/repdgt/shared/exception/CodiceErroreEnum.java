package it.pa.repdgt.shared.exception;

import lombok.Getter;

@Getter
public enum CodiceErroreEnum {
	 C01("Errore Risorsa non trovata")
	,C02("Errore storicizazione ente")
	,C03("Errore Utente con ruolo DEGP/REGP non definito per il progetto")
	,C04("Errore Utente con ruolo DEG/REG non definito per il programma")
	,C05("Errore Utente con ruolo DEPP/REPP non definito per il progetto")
	,C06("Errore Combinazione (Programma,Progetto) non trovata")
	,C07("Errore integrazione dati utente")
	
	,G01("Errore Generico")
	,G02("Errore Richista errata")
	,G03("Errore Pagina richista non esistente")
	
	,R01("Errore Ruolo già esistente")
	,R02("Errore impossibile aggiornare il ruolo")
	,R03("Errore impossibile cancellare il ruolo DTD/DSCU")
	,R04("Errore impossibile cancellare il ruoli predefiniti")
	,R05("Errore impossibile cancellare ruolo associato ad utente")
	,R06("Errore impossibile cancellare ruolo")
	,RG01("Errore impossibile creare associazione ruolo al gruppo")
	,RG02("Errore impossibile aggiornare associazione ruolo al gruppo")
	
	,U01("Errore utente con codice fiscale già presente")
	,U02("Errore cancellazione utente con ruolo associato")
	,U03("Errore l'utente con codice fiscale possiede già il ruolo")
	,U04("Errore impossibile associare il ruolo all'utente")
	,U05("Errore Impossibile cancellare ruolo non associato all'utente")
	;
	
	private String descrizioneErrore;
	
	private CodiceErroreEnum(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}
}