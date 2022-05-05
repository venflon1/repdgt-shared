package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GRUPPO")
@Setter
@Getter
public class GruppoEntity implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "DESCRIZIONE")
	public String descrizione;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "GRUPPO_X_PERMESSO",
		joinColumns = @JoinColumn(name = "GRUPPO_ID",  referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "PERMESSO_ID", referencedColumnName = "ID")
	)
	private List<PermessoEntity> permessi = new ArrayList<>();
	
	public List<PermessoEntity> addPermesso(PermessoEntity permesso) {
		this.permessi.add(permesso);
		return this.permessi;
	}
	
}
