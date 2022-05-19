package it.pa.repdgt.shared.awsintegration.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.pinpoint.PinpointClient;
import software.amazon.awssdk.services.pinpoint.model.EmailChannelResponse;
import software.amazon.awssdk.services.pinpoint.model.SendOTPMessageRequestParameters;
import software.amazon.awssdk.services.pinpoint.model.SendOtpMessageRequest;
import software.amazon.awssdk.services.pinpoint.model.VerifyOTPMessageRequestParameters;
import software.amazon.awssdk.services.pinpoint.model.VerifyOtpMessageRequest;

@Service
@Scope("singleton")
public class AWSPinpointService {
	private static final String REFERENCE_ID_REQ_RESP = "RepDGDevOTP";
	@Value(value="${aws.app-id}")
	private String appId;
	@Value(value="${aws.access-key}")
	private String accessKey;
	@Value(value="${aws.secret-key}")
	private String secretKey;
	
	public PinpointClient getClient() {
		 return PinpointClient.builder()
				 .credentialsProvider(StaticCredentialsProvider
				 .create(AwsBasicCredentials.create(this.accessKey, this.secretKey)))
				 .region(Region.EU_CENTRAL_1)
				 .build();
	}
	
	public SendOtpMessageRequest creaRichiestaPerInvioOTP(final String numeroDestinatario) {
		final SendOTPMessageRequestParameters sendOTPMessageRequestParameters = SendOTPMessageRequestParameters.builder()
				.brandName("Repubblica Digitale")
				.channel("SMS")
				.destinationIdentity(numeroDestinatario)
				.language("en-US")
				.originationIdentity(REFERENCE_ID_REQ_RESP)
				.referenceId(REFERENCE_ID_REQ_RESP)
				.codeLength(6)
				.validityPeriod(15)
				.build();

		return SendOtpMessageRequest.builder()
				.applicationId(this.appId)
				.sendOTPMessageRequestParameters(sendOTPMessageRequestParameters)
				.build();
	}
	
	public VerifyOtpMessageRequest creaRichiestaPerVerificaOTP(final String otpDaValidare, final String numeroDestinatario) {
		final VerifyOTPMessageRequestParameters verifyOTPMessageRequestParameters = VerifyOTPMessageRequestParameters.builder()
				.otp(otpDaValidare)
				.destinationIdentity(numeroDestinatario)
				.referenceId(REFERENCE_ID_REQ_RESP)
				.build();

		return VerifyOtpMessageRequest.builder()
				.applicationId(this.appId)
				.verifyOTPMessageRequestParameters(verifyOTPMessageRequestParameters)
				.build();
	}
	
	// TODO
	public EmailChannelResponse invoEmail(
			@Email(message = "Email inserita non valida") final String emailDestinatario, 
			@NotNull() final String emailDaInviare) {
		try {
//			final SendEmailRequest  richiestaInvioEmail = null;
		} catch (Exception exc) {
			String messaggioErrore = String.format("Errore invio email a '%s'", emailDestinatario);
		}
		return null;
	}
}	