package it.pa.repdgt.shared.service.storico;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.pa.repdgt.shared.entity.ProgrammaEntity;
import it.pa.repdgt.shared.entity.storico.StoricoEnteGestoreProgettoEntity;
import it.pa.repdgt.shared.entity.storico.StoricoEnteGestoreProgrammaEntity;
import it.pa.repdgt.shared.entity.storico.StoricoEntePartnerEntity;
import it.pa.repdgt.shared.entityenum.StatoEnum;
import it.pa.repdgt.shared.repository.storico.StoricoEnteGestoreProgettoRepository;
import it.pa.repdgt.shared.repository.storico.StoricoEnteGestoreProgrammaRepository;
import it.pa.repdgt.shared.repository.storico.StoricoEntePartnerRepository;
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
	public void storicizzaEnteGestoreProgramma(final ProgrammaEntity programmaEntity) {
		StoricoEnteGestoreProgrammaEntity storicoEnteGestoreProgramma = new StoricoEnteGestoreProgrammaEntity();
		storicoEnteGestoreProgramma.setIdProgramma(programmaEntity.getId());
		storicoEnteGestoreProgramma.setIdEnte(programmaEntity.getEnteGestoreProgramma().getId());
		storicoEnteGestoreProgramma.setStato(StatoEnum.TERMINATO.getValue());
		storicoEnteGestoreProgramma.setDataOraCreazione(new Date());
		this.storicoEnteGestoreProgrammaRepository.save(storicoEnteGestoreProgramma);
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