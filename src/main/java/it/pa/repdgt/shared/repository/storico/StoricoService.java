package it.pa.repdgt.shared.repository.storico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.pa.repdgt.shared.entity.storico.StoricoEnteGestoreProgettoEntity;
import it.pa.repdgt.shared.entity.storico.StoricoEnteGestoreProgrammaEntity;
import it.pa.repdgt.shared.entity.storico.StoricoEntePartnerEntity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoricoService {
	@Autowired
	private StoricoEnteGestoreProgrammaRepository storicoEnteGestoreProgrammaRepository;
	@Autowired
	private StoricoEnteGestoreProgettoRepository storicoEnteGestoreProgettoRepository;
	@Autowired
	private StoricoEntePartnerRepository storicoEntePartnerRepository;

	@Transactional(rollbackFor = Exception.class)
	public void storicizzaEnteGestoreProgramma(final StoricoEnteGestoreProgrammaEntity storicoEnteGestoreProgrammaEntity) {
		this.storicoEnteGestoreProgrammaRepository.save(storicoEnteGestoreProgrammaEntity);
		log.info("Ente Gestore Programma storicizzato.");
	}

	@Transactional(rollbackFor = Exception.class)
	public void storicizzaEnteGestoreProgetto(final StoricoEnteGestoreProgettoEntity storicoEnteGestoreProgrammaEntity) {
		this.storicoEnteGestoreProgettoRepository.save(storicoEnteGestoreProgrammaEntity);
		log.info("Ente Gestore Progetto storicizzato.");
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void storicizzaEntePartner(final StoricoEntePartnerEntity storicoEntePartnerEntity) {
		this.storicoEntePartnerRepository.save(storicoEntePartnerEntity);
		log.info("Ente Partner storicizzato.");
	}
}