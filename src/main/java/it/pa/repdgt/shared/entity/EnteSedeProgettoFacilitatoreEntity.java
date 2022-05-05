package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.pa.repdgt.shared.entity.key.EnteSedeProgettoFacilitatoreKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ENTE_SEDE_PROGETTO_FACILITATORE")
@NoArgsConstructor
@Getter
@Setter
public class EnteSedeProgettoFacilitatoreEntity implements Serializable {
	private static final long serialVersionUID = -4733831100623543478L;

	@EmbeddedId
	private EnteSedeProgettoFacilitatoreKey id;
	
	@MapsId(value = "idEnte")
	@ManyToOne(targetEntity = EnteEntity.class)
	@JoinColumn(name = "ID_ENTE", referencedColumnName = "ID")
	private EnteEntity ente;
	
	@MapsId(value = "idSede")
	@ManyToOne(targetEntity = SedeEntity.class)
	@JoinColumn(name = "ID_SEDE", referencedColumnName = "ID")
	private SedeEntity sede;
	
	@MapsId(value = "idProgetto")
	@ManyToOne(targetEntity = ProgettoEntity.class)
	@JoinColumn(name = "ID_PROGETTO", referencedColumnName = "ID")
	private ProgettoEntity progetto;
	
	@MapsId(value = "idFacilitarore")
	@ManyToOne(targetEntity = UtenteEntity.class)
	@JoinColumn(name = "ID_FACILITATORE", referencedColumnName = "CODICE_FISCALE")
	private UtenteEntity facilitatore;
	
	// FACILITATORE O VOLONTARIO
	@Column(name = "RUOLO_UTENTE")
	private String ruoloUtente;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;
}