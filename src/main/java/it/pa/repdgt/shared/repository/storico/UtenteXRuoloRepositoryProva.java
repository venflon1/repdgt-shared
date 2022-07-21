package it.pa.repdgt.shared.repository.storico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.pa.repdgt.shared.entity.UtenteXRuolo;
import it.pa.repdgt.shared.entity.key.UtenteXRuoloKey;

@Repository
public interface UtenteXRuoloRepositoryProva extends JpaRepository<UtenteXRuolo, UtenteXRuoloKey>{

}
