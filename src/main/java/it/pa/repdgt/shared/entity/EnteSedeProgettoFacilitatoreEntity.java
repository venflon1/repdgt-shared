package it.pa.repdgt.shared.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import it.pa.repdgt.shared.entity.key.EnteSedeProgettoFacilitatoreKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ENTE_SEDE_PROGETTO_FACILITATORE")
public class EnteSedeProgettoFacilitatoreEntity {
	
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
}