package it.pa.repdgt.shared.awsintegration.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.workdocs.WorkDocsClient;
import software.amazon.awssdk.services.workdocs.model.ActivateUserRequest;
import software.amazon.awssdk.services.workdocs.model.CreateUserRequest;
import software.amazon.awssdk.services.workdocs.model.CreateUserResponse;
import software.amazon.awssdk.services.workdocs.model.StorageRuleType;

@Service
@Scope("singleton")
@Validated
@Slf4j
public class WorkDocsService {
	@Value(value = "${aws.workdocs.app-id:}")
	private String appId;
	@Value(value = "${aws.workdocs.access-key:}")
	private String accessKey;
	@Value(value = "${aws.workdocs.secret-key:}")
	private String secretKey;
	
	private static WorkDocsClient workdocsInstanceClient = null;
	
	public WorkDocsClient getClient() {
		if(workdocsInstanceClient != null) {
			return workdocsInstanceClient;
		}
		return WorkDocsClient.builder()
				.credentialsProvider(
						StaticCredentialsProvider.create(AwsBasicCredentials.create(this.accessKey, this.secretKey)))
				.region(Region.EU_CENTRAL_1).build();
	}
	
	public CreateUserResponse createWorkDocsUser() {
		final CreateUserRequest createUserRequest = CreateUserRequest.builder()
																.username(null)
																.emailAddress(null)
																.givenName(null)
																.storageRule(StorageRuleType.builder().build())
																.build();
		
		 CreateUserResponse createUserResponse = workdocsInstanceClient.createUser(createUserRequest);
		 return createUserResponse;
	}

	public ActivateUserRequest activeWorkDocsUser() {
		final ActivateUserRequest activateUserRequest = ActivateUserRequest.builder()
																.userId(null)
																.build();
		
		workdocsInstanceClient.activateUser(activateUserRequest);
		return activateUserRequest;
	}
}