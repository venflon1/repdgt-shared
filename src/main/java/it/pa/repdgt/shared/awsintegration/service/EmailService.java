package it.pa.repdgt.shared.awsintegration.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.pa.repdgt.shared.exception.InvioOTPException;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.pinpoint.model.SendMessagesRequest;
import software.amazon.awssdk.services.pinpoint.model.SendMessagesResponse;

@Service
@Validated
@Slf4j
public class EmailService {
	@Autowired
	private AWSPinpointService pinpoint;
	
	public SendMessagesResponse inviaEmail(
			@NotNull final String oggetto, 
			@NotNull final String indirizzoEmailMittente, 
			@NotNull final String indirizzoEmailDestinatario, 
			@NotNull final String corpoEmailinHtml) {
		try {
			final SendMessagesRequest richiestaInvioEmail = this.pinpoint.creaRichiestaInvioEmail(oggetto, indirizzoEmailMittente, indirizzoEmailDestinatario, corpoEmailinHtml);
			final SendMessagesResponse  rispostaDaRichiestaInvioEmail = this.pinpoint.getClient().sendMessages(richiestaInvioEmail);
			log.info("sendMessagesResponse = {}", rispostaDaRichiestaInvioEmail);
			return rispostaDaRichiestaInvioEmail;
		} catch (Exception exc) {
			String messaggioErrore = String.format("Errore invio email a '%s'", indirizzoEmailDestinatario);
			throw new InvioOTPException(messaggioErrore, exc);
		}
	}
}