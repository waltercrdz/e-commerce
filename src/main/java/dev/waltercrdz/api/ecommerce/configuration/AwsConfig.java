package dev.waltercrdz.api.ecommerce.configuration;

import dev.waltercrdz.api.ecommerce.shared.infrastructure.event.SnsPublisher;
import io.awspring.cloud.sns.core.SnsOperations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.sns.topic-arn}")
    private String topicArn;

    private SnsOperations snsOperations;

    public AwsConfig(SnsOperations snsOperations) {
        this.snsOperations = snsOperations;
    }

    @Bean
    public SnsPublisher snsPublisher() {
        return new SnsPublisher(snsOperations, topicArn);
    }
}
