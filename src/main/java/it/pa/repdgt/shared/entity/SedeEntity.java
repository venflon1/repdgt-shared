package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SEDE")
@Getter
@Setter
public class SedeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;
	
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	
	@Column(name = "SERVIZI_EROGATI")
	private String serviziErogati;
	
	@Column(name = "INDIRIZZO")
	private String indirizzo;
	
	@Column(name = "ITINERE")
	private Boolean itinere = false;
	
	@Column(name = "AREA")
	private String area;
	
	@Column(name = "COORDINATE")
	private String coordinate;
	

}