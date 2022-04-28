package it.pa.repdgt.shared.entity.light;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.pa.repdgt.shared.entity.key.EntePartnerKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ENTE_PARTNER")
public class EntePartnerLightEntity {
	
	@EmbeddedId
	private EntePartnerKey id;	
}
