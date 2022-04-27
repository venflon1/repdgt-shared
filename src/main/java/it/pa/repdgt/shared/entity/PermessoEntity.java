package it.pa.repdgt.shared.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "PERMESSO")
@Data
@ToString
public class PermessoEntity implements Serializable {
	private static final long serialVersionUID = 7781599515820836346L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRIZIONE", nullable = false, unique = true)
	private String descrizione;
}