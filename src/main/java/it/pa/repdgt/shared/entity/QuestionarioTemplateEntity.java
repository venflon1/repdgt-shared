package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUESTIONARIO_TEMPLATE")
@Setter
@Getter
public class QuestionarioTemplateEntity implements Serializable { 
	private static final long serialVersionUID = -3997184755252624867L;

	/** 
	 * Id questionarioTemplate staccato da mongoDB.
	 * L'id coincide con l'id della collection QuestionarioTemplate.
	**/
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "STATO", nullable = false)
	private String stato;
	
	@Column(name = "TIPOLOGIA_QUESTIONARIO")
	private String tipologiaQuestionario;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;
}