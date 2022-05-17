package it.pa.repdgt.shared.storico.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STORICO_ENTE_GESTORE_PROGETTO")
@Setter
@Getter
public class StoricoEnteGestoreProgettoEnitity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2923601798326996692L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PROGRAMMA_ID", nullable = false)
	private Long idProgramma;


	@Column(name = "PROGETTO_ID", nullable = false)
	private Long idProgetto;
	
	
	@Column(name = "STATO", nullable = false)
	private String stato;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE", nullable = false)
	private Date dataOraCreazione;
}