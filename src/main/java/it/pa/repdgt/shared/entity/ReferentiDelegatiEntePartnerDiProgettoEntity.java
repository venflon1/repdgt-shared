package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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

	@ManyToOne
	@MapsId(value = "idProgetto")
	@JoinColumn(name = "ID_PROGETTO", referencedColumnName = "ID")
	private ProgettoEntity progetto;
	
    @ManyToOne
    @MapsId(value = "idEnte")
    @JoinColumn(name = "ID_ENTE", referencedColumnName = "ID")
    private EnteEntity ente;

    @ManyToOne
    @MapsId(value = "codFiscaleUtente")
    @JoinColumn(name = "CF_UTENTE", referencedColumnName = "CODICE_FISCALE")
    private UtenteEntity utente;

    @Column(name = "CODICE_RUOLO")
    private String codiceRuolo;
}