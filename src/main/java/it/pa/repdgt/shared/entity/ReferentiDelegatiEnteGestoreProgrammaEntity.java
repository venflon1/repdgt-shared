package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.pa.repdgt.shared.entity.key.ReferentiDelegatiEnteGestoreProgrammaKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Questo modello contiene gli utenti referenti o delegati
 *  di un ente gestore di programma
 */
@Entity
@Table(name = "REFERENTE_DELEGATI_GESTORE_PROGRAMMA")
@NoArgsConstructor
@Setter
@Getter
public class ReferentiDelegatiEnteGestoreProgrammaEntity implements Serializable {
	private static final long serialVersionUID = -9104734322317672481L;

	@EmbeddedId
	private ReferentiDelegatiEnteGestoreProgrammaKey id;

    @Column(name = "CODICE_RUOLO")
    private String codiceRuolo;
    
    @Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;

	@Column(name = "CANCELLATO")
	private boolean cancellato;
}