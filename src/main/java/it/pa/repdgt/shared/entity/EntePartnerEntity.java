package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.pa.repdgt.shared.entity.key.EntePartnerKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ENTE_PARTNER")
public class EntePartnerEntity {

	@EmbeddedId
	private EntePartnerKey id;

	@Column(name = "STATO_ENTE_PARTNER")
	private String statoEntePartner;
}