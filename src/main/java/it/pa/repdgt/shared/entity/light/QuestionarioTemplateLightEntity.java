package it.pa.repdgt.shared.entity.light;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUESTIONARIO_TEMPLATE")
@Setter
@Getter
public class QuestionarioTemplateLightEntity implements Serializable {
	private static final long serialVersionUID = 4567791769914288690L;

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "STATO", nullable = false)
	private String stato;
	
	@Column(name = "TIPOLOGIA_QUESTIONARIO")
	private String tipologiaQuestionario;
}