package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ISTANZA_QUESTIONARIO_TEMPLATE")
@Setter
@Getter
public class IstanzaQuestionarioTemplateEntity implements Serializable {
	private static final long serialVersionUID = 2891025158768854287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	// chiave esterna a TemplateQuestioanario
	@Column(name = "TEMPLATE_QUESTIONARIO_ID")
	private String idQuestionarioTemplate;
	
	// chiave esterna a Cittadino
	@Column(name = "CODICE_FISCALE_CITTADINO")
	private String codiceFiscaleCittadino;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;
}