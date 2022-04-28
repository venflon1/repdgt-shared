package it.pa.repdgt.shared.entity;

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

//    @ManyToOne
//    @MapsId(value = "idProgetto")
//    @JoinColumn(name = "ID_PROGETTO", referencedColumnName = "ID")
//    private ProgettoLightEntity progetto;
//
//    /**
//     * Questi sono gli enti partner del progetto
//     * */
//    @ManyToOne
//    @MapsId(value = "idEnte")
//    @JoinColumn(name = "ID_ENTE", referencedColumnName = "ID")
//    private EnteLightEntity enteEntity;
}