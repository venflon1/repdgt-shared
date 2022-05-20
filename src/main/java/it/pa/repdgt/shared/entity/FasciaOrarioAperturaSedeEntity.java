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
@Table(name = "FASCIA_ORARIO_APERTURA_SEDE")
@Setter
@Getter
public class FasciaOrarioAperturaSedeEntity implements Serializable {
	private static final long serialVersionUID = -8849825300824271398L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "GIORNO_APERTURA", nullable = false)
	private String giornoAperturaSede;
	
	@Column(name = "ORARIO_APERTURA", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date orarioAperuturaSede;
	
	@Column(name = "ORARIO_CHIUSURA", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date orarioChiusuraSede;

	@Column(name = "SEDE_ID", nullable = false)
	private Long idSede;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE", nullable = false)
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO", nullable = true)
	private Date dataOraAggiornamento;
}