package it.pa.repdgt.shared.awsintegration.service;

import javax.annotation.PostConstruct;

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
import software.amazon.awssdk.services.workdocs.model.StorageType;

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
	@Value(value = "${aws.workdocs.organization-id:}")
	private String organizationId;
	
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
	
	@PostConstruct
	private void init() {
		workdocsInstanceClient = this.getClient();
	}
	
	public CreateUserResponse creaWorkDocsUser(final String username, final String email, final String password) {
		final StorageRuleType storageRuleType = StorageRuleType.builder()
																.storageType(StorageType.QUOTA)
																.storageAllocatedInBytes(new Long(1048576l))
																.build();
		
		final CreateUserRequest createUserRequest = CreateUserRequest.builder()
																.organizationId(this.organizationId)
																.username(username)
																.password(password)
																.emailAddress(email)
																.givenName(username)
																.storageRule(storageRuleType)
																.build();
		
		 CreateUserResponse createUserResponse = workdocsInstanceClient.createUser(createUserRequest);
		 return createUserResponse;
	}

	public ActivateUserRequest attivaWorkDocsUser(final String username) {
		final ActivateUserRequest activateUserRequest = ActivateUserRequest.builder()
																.userId(username)
																.build();
		
		workdocsInstanceClient.activateUser(activateUserRequest);
		return activateUserRequest;
	}
}