package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "CODICE")
	private String codice;
	
	@Column(name = "DESCRIZIONE", nullable = false, unique = true)
	private String descrizione;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "RUOLO_X_PERMESSO",
		joinColumns = @JoinColumn(name = "RUOLO_CODICE",  referencedColumnName = "CODICE"),
		inverseJoinColumns = @JoinColumn(name = "PERMESSO_ID", referencedColumnName = "ID")
	)
	private List<PermessoEntity> permessi = new ArrayList<>();
	
	@Column(name = "STATO")
	private String stato;

	public List<PermessoEntity> addPermesso(PermessoEntity permesso) {
		this.permessi.add(permesso);
		return this.permessi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuoloEntity other = (RuoloEntity) obj;
		return Objects.equals(codice, other.codice);
	}
}