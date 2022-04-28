package it.pa.repdgt.shared.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import it.pa.repdgt.shared.entity.key.ReferentiDelegatiEnteGestoreProgrammaKey;
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
@Table(name = "REFERENTE_DELEGATI_GESTORE_PROGRAMMA")
public class ReferentiDelegatiEnteGestoreProgrammaEntity {

	@EmbeddedId
	private ReferentiDelegatiEnteGestoreProgrammaKey id;

    @ManyToOne
    @MapsId(value = "idProgramma")
    @JoinColumn(name = "ID_PROGRAMMA", referencedColumnName = "ID")
    private ProgrammaEntity programma;

    @ManyToOne
    @MapsId(value = "codFiscaleUtente")
    @JoinColumn(name = "CF_UTENTE", referencedColumnName = "CODICE_FISCALE")
    private UtenteEntity utente;

    @Column(name = "CODICE_RUOLO")
    private String codiceRuolo;
}
