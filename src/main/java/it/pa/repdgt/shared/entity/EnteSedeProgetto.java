package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import it.pa.repdgt.shared.entity.key.EnteSedeProgettoKey;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ENTE_SEDE_PROGETTO")
public class EnteSedeProgetto {

	@EmbeddedId
	@Column(name = "ID")
	private EnteSedeProgettoKey id;

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
	
	@Column(name = "RUOLO")
	private String ruolo;
	
	@Column(name = "TIPOLOGIA_SERVIZIO")
	private String tipologiaServizio;
}