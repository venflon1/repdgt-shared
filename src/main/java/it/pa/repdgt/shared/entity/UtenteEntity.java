package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UTENTE")
@NoArgsConstructor
@Data
public class UtenteEntity implements Serializable {
	private static final long serialVersionUID = -1466364242826049157L;
	
	@Id
	@Column(name = "CODICE_FISCALE", nullable = false, unique = true, length = 16)
	private String codiceFiscale;
	
	@Column(name = "NOME", nullable = true)
	private String nome;
	
	@Column(name = "COGNOME", nullable = true)
	private String cognome;
	
	@Column(name = "EMAIL", nullable = false, unique = true)
	@Email
	private String email;
	
	@Column(name = "TELEFONO", nullable = true)
	private String telefono;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = RuoloEntity.class)
	@JoinTable(
		name = "UTENTE_X_RUOLO", 
		joinColumns = @JoinColumn(name = "UTENTE_ID", referencedColumnName = "CODICE_FISCALE"), 
		inverseJoinColumns = @JoinColumn(name = "RUOLO_ID", referencedColumnName = "CODICE")
	)
	private List<RuoloEntity> ruoli = new ArrayList<>();
	
	@Column(name = "STATO", nullable = false)
	private String stato;
}