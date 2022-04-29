package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "TIPOLOGIA_ENTE", nullable = true)
	private String tiplogia;

//	/**
//	 * La lista dei Progetti du cui questo (this) ente hai ruolo di GESTORE_PROGETTO
//	 * 
//	 */
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "ID_PROGRAMMA")
//	private List<ProgettoLightEntityNew> progettiCheGestisco;
//
//	/**
//	 *  La lista dei Programmi di cui questo (this) ente ha ruolo di GESTORE_PROGRAMMA
//	 *  
//	 */
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enteGestoreProgramma")
//	@Column(name = "programmi")
//	private List<ProgrammaEntity> programmiCheGestisco;
	
//	@OneToMany(mappedBy = "enteEntity", fetch = FetchType.EAGER)
//	private List<EntePartnerEntity> entiPartner;
	
}