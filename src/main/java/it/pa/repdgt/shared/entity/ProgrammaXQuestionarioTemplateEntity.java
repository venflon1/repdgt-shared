package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.pa.repdgt.shared.entity.key.ProgrammaXQuestionarioTemplateKey;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROGRAMMA_X_QUESTIONARIO_TEMPLATE")
@Setter
@Getter
public class ProgrammaXQuestionarioTemplateEntity implements Serializable { 
	private static final long serialVersionUID = -8910020339000772468L;

	@EmbeddedId
	private ProgrammaXQuestionarioTemplateKey programmaXQuestionarioTemplateKey;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;
}