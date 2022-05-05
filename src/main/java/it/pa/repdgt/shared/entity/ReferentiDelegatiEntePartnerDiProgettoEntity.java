package it.pa.repdgt.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.pa.repdgt.shared.entity.key.ReferentiDelegatiEntePartnerDiProgettoKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Questo modello contiene gli utenti referenti o delegati
 *  di un ente gestore di programma
 */
@Entity
@Table(name = "REFERENTE_DELEGATI_PARTNER")
@NoArgsConstructor
@Getter
@Setter
public class ReferentiDelegatiEntePartnerDiProgettoEntity implements Serializable {
	private static final long serialVersionUID = 1012883699498666609L;

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
    
    @Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_CREAZIONE")
	private Date dataOraCreazione;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "DATA_ORA_AGGIORNAMENTO")
	private Date dataOraAggiornamento;
}