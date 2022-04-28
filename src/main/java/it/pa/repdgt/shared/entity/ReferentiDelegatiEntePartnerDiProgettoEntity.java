package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.pa.repdgt.shared.entity.key.ReferentiDelegatiEntePartnerDiProgettoKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Questo modello contiene gli utenti referenti o delegati
 *  di un ente gestore di programma
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "REFERENTE_DELEGATI_PARTNER")
public class ReferentiDelegatiEntePartnerDiProgettoEntity {

	@EmbeddedId
	private ReferentiDelegatiEntePartnerDiProgettoKey id;

//    @ManyToOne
//    @MapsId(value = "idEnte")
//    @JoinColumn(name = "ID_ENTE", referencedColumnName = "ID")
//    private Long idEnte;
//
//    @JsonIgnore
//    @ManyToOne
//    @MapsId(value = "codFiscaleUtente")
//    @JoinColumn(name = "CF_UTENTE", referencedColumnName = "CODICE_FISCALE_UTENTE")
//    private UtenteEntity utente;

    @Column(name = "CODICE_RUOLO")
    private String codiceRuolo;
}
