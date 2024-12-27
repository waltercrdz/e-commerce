package dev.waltercrdz.api.ecommerce.orders.infrastructure.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.CreateTopicRequest;

@TestConfiguration
public class TestConfig {

    @Bean
    public static PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");
        container.start();
        return container;
    }

    @Bean
    public static LocalStackContainer localStack() {
        LocalStackContainer localstack = new LocalStackContainer(DockerImageName.parse("localstack/localstack:latest"))
            .withServices(LocalStackContainer.Service.SNS);
        localstack.start();
        return localstack;
    }

    @Bean
    public SnsClient snsClient(LocalStackContainer localStack) {
        return SnsClient.builder()
            .endpointOverride(localStack.getEndpoint())
            .credentialsProvider(StaticCredentialsProvider.create(
                AwsBasicCredentials.create("test", "test")))
            .region(Region.of(localStack.getRegion()))
            .build();
    }

    @Bean
    public String topicArn(SnsClient snsClient) {
        return snsClient.createTopic(CreateTopicRequest.builder()
            .name("order-events")
            .build())
            .topicArn();
    }
}
