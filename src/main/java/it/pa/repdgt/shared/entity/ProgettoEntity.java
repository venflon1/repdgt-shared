package it.pa.repdgt.shared.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PROGETTO")
public class ProgettoEntity implements Serializable {
	private static final long serialVersionUID = 5557015252878732182L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 199)
	private String nome;
	
	@Column(name = "DESCRIZIONE", nullable = true)
	private String descrizione;

	/**
	 * Programma di appartenza di questo (this) progetto
	 * 
	 * */
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, targetEntity = ProgrammaEntity.class)
	@JoinColumn(name = "ID_PROGRAMMA", referencedColumnName = "ID")
	private ProgrammaEntity programma;

	/**
	 * L'Ente Gestore di questo (this) programma
	 * 
	 * */
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, targetEntity = EnteEntity.class)
	@JoinColumn(name = "ID_ENTE_GESTORE", referencedColumnName = "ID")
	private EnteEntity enteGestoreProgetto;

//    /**
//     * Utente Referenti o Delegati dell'ente gestore di progetto
//     *
//     * */
//	@JsonIgnore
//	@OneToMany(mappedBy = "progettoLightEntityId", fetch = FetchType.EAGER)
//	private Set<ReferentiDelegatiEnteGestoreProgettoEntity> referentiDelegatiDellEnteGestoreProgetto;
//    
	@Column(name = "STATO")
	private String stato;
}