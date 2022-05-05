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

	@Column(name = "PARTITA_IVA", nullable = true, unique = true)
	private String piva;

	@Column(name = "NOME", nullable = true, unique = true)
	private String nome;
	
	@Column(name = "NOME_BREVE", nullable = false)
	private String nomeBreve;

	@Column(name = "TIPOLOGIA", nullable = true)
	private String tiplogia;
	
	@Column(name = "SEDE_LEGALE", nullable = true)
	private String sedeLegale;
}