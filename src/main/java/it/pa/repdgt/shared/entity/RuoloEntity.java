package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RUOLO")
@NoArgsConstructor
@Data
public class RuoloEntity implements Serializable {
	private static final long serialVersionUID = 3202201467169842152L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRIZIONE", nullable = false, unique = true)
	private String descrizione;
	
	@ManyToMany
	@JoinTable(
		name = "RUOLO_X_PERMESSO",
		joinColumns = @JoinColumn(name = "RUOLO_ID",  referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "PERMESSO_ID", referencedColumnName = "ID")
	)
	private List<PermessoEntity> permessi = new ArrayList<>();
	
	@Column(name = "STATO")
	private String stato;

	public List<PermessoEntity> addPermesso(PermessoEntity permesso) {
		this.permessi.add(permesso);
		return this.permessi;
	}
}