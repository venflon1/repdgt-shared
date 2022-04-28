package it.pa.repdgt.shared.entity.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import it.pa.repdgt.shared.entity.UtenteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EnteSedeProgettoFacilitatoreKey implements Serializable {
	private static final long serialVersionUID = -2038226148572575312L;

	@Column(name = "ID_ENTE")
	private Long idEnte;
	
	@Column(name = "ID_SEDE")
	private Long idSede;
	
	@Column(name = "ID_PROGETTO")
	private Long idProgetto;
	
	@Column(name = "CODICE_FISCALE")
	private UtenteEntity idFacilitatore;
}