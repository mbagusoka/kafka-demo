package learn.kafka.consumerdemo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic helloTopic() {
        return TopicBuilder.name("hello")
                .partitions(2)
                .build();
    }

    @Bean
    public NewTopic eventTopic() {
        return TopicBuilder.name("event")
                .partitions(2)
                .build();
    }

    @Bean
    public NewTopic hiTopic() {
        return TopicBuilder.name("hi")
                .partitions(1)
                .build();
    }
}
