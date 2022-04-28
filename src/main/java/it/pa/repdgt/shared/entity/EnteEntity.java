package it.pa.repdgt.shared.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ENTE")
public class EnteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", nullable = true, unique = true)
	private String nome;

	/**
	 * La lista dei Progetti du cui questo (this) ente hai ruolo di GESTORE_PROGETTO
	 * 
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enteGestoreProgetto")
	@Column(name = "progetti")
	private List<ProgettoEntity> progettiCheGestisco;

	/**
	 *  La lista dei Programmi di cui questo (this) ente ha ruolo di GESTORE_PROGRAMMA
	 *  
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enteGestoreProgramma")
	@Column(name = "programmi")
	private List<ProgrammaEntity> programmiCheGestisco;
	
//	@OneToMany(mappedBy = "enteEntity", fetch = FetchType.EAGER)
//	private List<EntePartnerEntity> entiPartner;
	
	@Column(name = "STATO")
	private String stato;

}