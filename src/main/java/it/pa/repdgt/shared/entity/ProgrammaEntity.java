package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.pa.repdgt.shared.entityenum.PolicyEnum;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "PROGRAMMA")
public class ProgrammaEntity implements Serializable {
	private static final long serialVersionUID = -1134246828726660200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CODICE", unique = true)
	private String codice;

	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "NOME_BREVE", nullable = false)
	private String nomeBreve;

	/**
	 * L'Ente Gestore di questo (this) Programma
	 * 
	 * */
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, targetEntity = EnteEntity.class)
	@JoinColumn(name = "ID_ENTE_GESTORE_PROGRAMMA", referencedColumnName = "ID")
	private EnteEntity enteGestoreProgramma;
	
	@Column(name = "STATO_GESTORE_PROGRAMMA")
	private String statoGestoreProgramma;

	@Column(name = "POLICY")
	@Enumerated(value = EnumType.STRING)
	private PolicyEnum policy;
	
	@Column(name = "DATA_INIZIO_PROGRAMMA")
	private Date dataInizioProgramma;
	
	@Column(name = "DATA_FINE_PROGRAMMA")
	private Date dataFineProgramma;
	
	@Column(name = "DATA_ORA_ATTIVAZIONE_PROGRAMMA")
	private Date dataOraAttivazioneProgramma;

	@Column(name = "DATA_ORA_TERMINAZIONE_PROGRAMMA")
	private Date dataOraTerminazioneProgramma;

	@Column(name = "STATO")
	private String stato;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;
	
	//Numero Target Punti di Facilitazione
	private Integer nPuntiFacilitazioneTarget1;
	private Integer nPuntiFacilitazioneTarget2;
	private Integer nPuntiFacilitazioneTarget3;
	private Integer nPuntiFacilitazioneTarget4;
	private Integer nPuntiFacilitazioneTarget5;
	
	//Date Target Punti di Facilitazione
	private Date nPuntiFacilitazioneDataTarget1;
	private Date nPuntiFacilitazioneDataTarget2;
	private Date nPuntiFacilitazioneDataTarget3;
	private Date nPuntiFacilitazioneDataTarget4;
	private Date nPuntiFacilitazioneDataTarget5;
	
	//Numero Target Utenti Unici
	private Integer nUtentiUniciTarget1;
	private Integer nUtentiUniciTarget2;
	private Integer nUtentiUniciTarget3;
	private Integer nUtentiUniciTarget4;
	private Integer nUtentiUniciTarget5;
	
	//Date Target Utenti Unici
	private Date nUtentiUniciDataTarget1;
	private Date nUtentiUniciDataTarget2;
	private Date nUtentiUniciDataTarget3;
	private Date nUtentiUniciDataTarget4;
	private Date nUtentiUniciDataTarget5;
	
	//Numero Target Servizi
	private Integer nServiziTarget1;
	private Integer nServiziTarget2;
	private Integer nServiziTarget3;
	private Integer nServiziTarget4;
	private Integer nServiziTarget5;
	
	//Date Target Servizi
	private Date nServiziDataTarget1;
	private Date nServiziDataTarget2;
	private Date nServiziDataTarget3;
	private Date nServiziDataTarget4;
	private Date nServiziDataTarget5;
	
	//Numero Target Facilitatori
	private Integer nFacilitatoriTarget1;
	private Integer nFacilitatoriTarget2;
	private Integer nFacilitatoriTarget3;
	private Integer nFacilitatoriTarget4;
	private Integer nFacilitatoriTarget5;
	
	//Date Target Facilitatori
	private Date nFacilitatoriDataTarget1;
	private Date nFacilitatoriDataTarget2;
	private Date nFacilitatoriDataTarget3;
	private Date nFacilitatoriDataTarget4;
	private Date nFacilitatoriDataTarget5;
}