package it.pa.repdgt.shared.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUESTIONARIO_COMPILATO")
@Setter
@Getter
public class QuestionatioCompilatoEntity implements Serializable { 
	private static final long serialVersionUID = 4720569058596366321L;

	// corrisponde all'id della collection 'questionario-template-istanza'
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "QUESTIONARIO_TEMPLATE_ID", referencedColumnName = "ID")
	private QuestionarioTemplateEntity questionarioTemplate;

	@OneToOne(optional = false)
	@JoinColumn(name = "CODICE_FISCALE_CITTADINO", referencedColumnName = "CODICE_FISCALE")
	private CittadinoEntity cittadino;
	
	@Column(name = "FACILITATORE_ID")
	private Long idFacilitatore;

	@Column(name = "SEDE_ID")
	private Long idSede;
	
	@Column(name = "ENTE_ID")
	private Long idEnte;
	
	@Column(name = "PROGETTO_ID")
	private Long idProgetto;
}