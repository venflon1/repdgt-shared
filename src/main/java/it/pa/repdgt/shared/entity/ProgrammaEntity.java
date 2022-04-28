package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.pa.repdgt.shared.entity.ReferentiDelegatiEnteGestoreProgrammaEntity;
import it.pa.repdgt.shared.entityenum.PolicyEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "PROGRAMMA")
public class ProgrammaEntity implements Serializable {
	private static final long serialVersionUID = -1134246828726660200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODICE", nullable = true, unique = true)
	private String codice = UUID.randomUUID().toString().toUpperCase();

	@Column(name = "NOME", nullable = false)
	private String nome;

	/**
	 * La lista dei Progetti di questo (this) Programma
	 * 
	 * */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, targetEntity = ProgettoEntity.class, mappedBy = "programma")
	private List<ProgettoEntity> progetti;

	/**
	 * L'Ente Gestore di questo (this) Programma
	 * 
	 * */
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, targetEntity = EnteEntity.class)
	@JoinColumn(name = "ID_ENTE_GESTORE_PROGRAMMA", referencedColumnName = "ID")
	private EnteEntity enteGestoreProgramma;

	@JsonIgnore
	@OneToMany(mappedBy = "programmaLightEntityId", fetch = FetchType.EAGER)
	private Set<ReferentiDelegatiEnteGestoreProgrammaEntity> referentiDelegatiDellEnteGestoreProgramma;

	/**
	 * L'Ambito del programma (SCD/RFD)
	 * 
	 * */
	@Column(name = "POLICY")
	@Enumerated(value = EnumType.STRING)
	private PolicyEnum policy;
	
	@Column(name = "DATA_INIZIO_PROGRAMMA")
	private Date dataInizioProgramma;
	
	@Column(name = "DATA_FINE_PROGRAMMA")
	private Date dataFineProgramma;

	@Column(name = "STATO")
	private String stato;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProgrammaEntity [id=");
		builder.append(id);
		builder.append(", codice=");
		builder.append(codice);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", policy=");
		builder.append(policy);
		builder.append(", stato=");
		builder.append(stato);
		builder.append("]");
		return builder.toString();
	}
}