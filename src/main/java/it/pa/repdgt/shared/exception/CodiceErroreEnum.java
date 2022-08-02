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
		,R07("Errore impossibile attivare il ruolo per l'utente")
		,RG01("Errore impossibile creare associazione ruolo al gruppo")
		,RG02("Errore impossibile aggiornare associazione ruolo al gruppo")
		
		,U01("Errore utente con codice fiscale già presente")
		,U02("Errore cancellazione utente con ruolo associato")
		,U03("Errore l'utente con codice fiscale possiede già il ruolo")
		,U04("Errore impossibile associare il ruolo all'utente")
		,U05("Errore Impossibile cancellare ruolo non associato all'utente")
		,U06("Errore ruolo non definito per l'utente")
		,U07("Errore utente con codice fiscale o numero documento già presente")
		,U08("Errore codice fiscale o numero documento non specificato")
		,U09("Errore impossibile aggiungere ruolo all'utente")
		,U10("Errore impossibile cancellare ruolo all'utente")

		
		,S01("Errore file upload cittadino non valido")
		,S02("Errore export csv servizio")
		,S03("Errore servizio non accessibile per l'utente")
		,S04("Errore creazione servizio. Nessun questionario template associato al programma")
		,S05("Errore creazione servizio. Utente non ha ruolo FACILITATORE")
		,S06("Errore aggiornare servizio. Utente non ha ruolo FACILITATORE")
		,S07("Errore impossibile eliminare il servizio.")
		
		,SD01("Errore creazione sede")
		,SD02("Errore aggiornamento sede")

		,Q01("Errore questionario inesistente")
		,QT01("Errore export csv questionari template")
		,QT02("Errore impossibile aggiornare il questionario")
		,QT03("Errore impossibile cancellare il questionario")
		
		,QC01("Errore questionario compilato non presente su mySql")
		,QC02("Errore questionario compilato non presente su MongoDB")
		
		,CIT01("Errore upload cittadini")
		,CIT02("Errore impossibile aggiornare cittadino")
		
		,E01("Errore invio email")
		
		,EN01("Errore export csv enti")
		,EN02("Errore file upload enti non valido")
		,EN03("ErroreImpossibile assegnare ente come gestore del programma")
		
		,T01("Errore token non valido")
		,T02("Errore token scaduto")
		
		,P01("Errore creazione programma")
		,P02("Errore creazione programma. Questionario template default associato non esistente")
		,P03("Errore impossibile terminare programma")
		,P04("Errore impossibile cancellare programma")
		,P05("Errore impossibile assegnare programma ad ente gestore")
		,P06("Errore impossibile aggiornare programma")
		,P07("Errore impossibile associare questionario al programma")
		,P08("Errore export csv programmi")
		
		,PR01("Errore creazione progetto")
		,PR02("Errore impossibile cancellare progetto")
		,PR03("Errore impossibile terminare progetto")
		,PR04("Errore impossibile aggiornare progetto")
		,PR05("Errore impossibile assegnare progetto ad ente gestore")
		,PR06("Errore impossibile assegnare progetto ad al programma")
		,PR07("Errore attivare progetto")
		,PR08("Errore export csv progetti")
		;
		
		private String descrizioneErrore;
		
		private CodiceErroreEnum(String descrizioneErrore) {
			this.descrizioneErrore = descrizioneErrore;
		}
}