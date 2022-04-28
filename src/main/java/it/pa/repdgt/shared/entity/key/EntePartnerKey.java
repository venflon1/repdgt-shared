package it.pa.repdgt.shared.entity.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntePartnerKey implements Serializable {
	private static final long serialVersionUID = -2038226148572575312L;

	@Column(name = "ID_PROGETTO")
	private Long idProgetto;
	@Column(name = "ID_ENTE")
	private Long idEnte;
}