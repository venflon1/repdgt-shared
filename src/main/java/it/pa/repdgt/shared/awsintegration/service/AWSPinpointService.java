package it.pa.repdgt.shared.awsintegration.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.pinpoint.AmazonPinpoint;
import com.amazonaws.services.pinpoint.AmazonPinpointClientBuilder;
import com.amazonaws.services.pinpoint.model.SendOTPMessageRequest;
import com.amazonaws.services.pinpoint.model.SendOTPMessageRequestParameters;
import com.amazonaws.services.pinpoint.model.VerifyOTPMessageRequest;
import com.amazonaws.services.pinpoint.model.VerifyOTPMessageRequestParameters;

@Service
@Scope("singleton")
public class AWSPinpointService {
	@Value(value="${aws.app-id}")
	private String appId;
	@Value(value="${aws.access-key}")
	private String accessKey;
	@Value(value="${aws.secret-key}")
	private String secretKey;
	
	public AmazonPinpoint getClient() {
		final BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		return AmazonPinpointClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
				.withRegion(Regions.EU_CENTRAL_1)
				.build();
	}
	
	public SendOTPMessageRequest creaRichiestaPerInvioOTP(final String numeroDestinatario) {
		// richiesta invio OTP
		final SendOTPMessageRequest sendOTPRequest = new SendOTPMessageRequest();
		sendOTPRequest.setApplicationId(this.appId);
		
		// parametri dela richiesta invio OTP
		SendOTPMessageRequestParameters sendOTPMessageRequestParameters = new SendOTPMessageRequestParameters();
//		sendOTPMessageRequestParameters.setAllowedAttempts(null); 							// Il numero di volte in cui il destinatario può tentare senza successo di convalidare l'OTP. (non obbligatorio)
		sendOTPMessageRequestParameters.setBrandName("non_lo_so");							// Il nome del marchio, dell'azienda o del prodotto associato al codice OTP
		sendOTPMessageRequestParameters.setChannel("SMS");									// canale di invio OTP
//		sendOTPMessageRequestParameters.setCodeLength(7);									// lunghezza codice OTP, se omesso = 6 cifre (non obbligatorio)
		sendOTPMessageRequestParameters.setDestinationIdentity(numeroDestinatario);			// numero di telefono in formato E.164 che deve ricevere OTP
//		sendOTPMessageRequestParameters.setEntityId(null);									// non obbligatorio
		sendOTPMessageRequestParameters.setLanguage("en-US");								// lingua usata per invio OTP
		sendOTPMessageRequestParameters.setOriginationIdentity("RepDGDevOTP");				// numero di telefono che deve inviare OTP
		sendOTPMessageRequestParameters.setReferenceId("RepDGDevOTP");						// ID di riferimento univoco per la richiesta
//		sendOTPMessageRequestParameters.setTemplateId(null);								// non obbligatorio
//		sendOTPMessageRequestParameters.setValidityPeriod(3);								// tempo validità OTP in minuti se omesso vale 15 minuti (non obbligatorio)
		sendOTPRequest.setSendOTPMessageRequestParameters(sendOTPMessageRequestParameters);

		return sendOTPRequest;
	}
	
	public VerifyOTPMessageRequest creaRichiestaPerVerificaOTP(final String otpDaValidare, final String numeroDestinatario) {
		 // richiesta verifica OTP
		final VerifyOTPMessageRequest verifyOTPRequest = new VerifyOTPMessageRequest();
		verifyOTPRequest.setApplicationId(this.appId);
	
		// parametri dela richiesta verifica OTP
		VerifyOTPMessageRequestParameters verifyOTPMessageRequestParameters = new VerifyOTPMessageRequestParameters();
		verifyOTPMessageRequestParameters.setOtp(otpDaValidare);							// otp da validare
		verifyOTPMessageRequestParameters.setDestinationIdentity(numeroDestinatario);		// numero di telefono in formato E.164 che deve ricevere OTP					
		verifyOTPMessageRequestParameters.setReferenceId("RepDGDevOTP");					//		
		verifyOTPRequest.setVerifyOTPMessageRequestParameters(verifyOTPMessageRequestParameters);
		
		return verifyOTPRequest;
	}
}	