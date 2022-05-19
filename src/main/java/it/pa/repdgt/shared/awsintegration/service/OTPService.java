package it.pa.repdgt.shared.awsintegration.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.amazonaws.services.pinpoint.model.EmailChannelResponse;
import com.amazonaws.services.pinpoint.model.SendOTPMessageRequest;
import com.amazonaws.services.pinpoint.model.SendOTPMessageResult;
import com.amazonaws.services.pinpoint.model.VerifyOTPMessageRequest;
import com.amazonaws.services.pinpoint.model.VerifyOTPMessageResult;

import it.pa.repdgt.shared.exception.InvioOTPException;
import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@Slf4j
public class OTPService {
	private static final String PREFFISSO_NUMERO_ITA = "+39";
	
	@Autowired
	private AWSPinpointService pinpoint;
	
	public SendOTPMessageResult inviaOTP(
			@NotNull(message = "Numero destinatatrio OTO non deve essere null") final String numeroDestinatarioOTP) {
		final String numeroDestinatarioFormatoE164 = PREFFISSO_NUMERO_ITA.concat(numeroDestinatarioOTP);
		try {
			final SendOTPMessageRequest richiestaInvioOTP = this.pinpoint.creaRichiestaPerInvioOTP(numeroDestinatarioFormatoE164);
			final SendOTPMessageResult rispostaDaRichiestaInvioOTP = this.pinpoint.getClient().sendOTPMessage(richiestaInvioOTP);
			log.info("sendOTPMessageResult = {}", rispostaDaRichiestaInvioOTP);
			return rispostaDaRichiestaInvioOTP;
		} catch (Exception exc) {
			String messaggioErrore = String.format("Errore invio OTP al numero='%s'", numeroDestinatarioOTP);
			throw new InvioOTPException(messaggioErrore, exc);
		}
	}

	public VerifyOTPMessageResult verificaOTP(
			@NotNull(message = "Numero destinatatrio OTO non deve essere null") final String numeroDestinatarioOTP, 
			@NotNull(message = "OTP da verificare non deve essere null") final String otpDaVerificare) {
		final String numeroDestinatarioFormatoE164 = PREFFISSO_NUMERO_ITA.concat(numeroDestinatarioOTP);
		try {
			final VerifyOTPMessageRequest richiestaVerificaOTP = this.pinpoint.creaRichiestaPerVerificaOTP(otpDaVerificare, numeroDestinatarioFormatoE164);
			final VerifyOTPMessageResult rispostaDaRichiestaVerificaOTP = this.pinpoint.getClient().verifyOTPMessage(richiestaVerificaOTP);
			log.info("sendOTPMessageResult = {}", rispostaDaRichiestaVerificaOTP);
			return rispostaDaRichiestaVerificaOTP;
		} catch (Exception exc) {
			String messaggioErrore = String.format("Errore verifica OTP");
			throw new InvioOTPException(messaggioErrore, exc);
		}
	}

}