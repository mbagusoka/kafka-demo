package learn.kafka.producerdemo.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class ProducerDemo {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void sendToTopic() {
        IntStream.iterate(0, i -> i + 1)
                .limit(10000)
                .forEach(this::sendMessages);
    }

    private void sendMessages(int n) {
        sendHi(n);
    }

    @SneakyThrows(value = JsonProcessingException.class)
    private void sendEvent() {
        AddStatisticEvent event = new AddStatisticEvent(1);
        String payload = new ObjectMapper().writeValueAsString(event);
        kafkaTemplate.send("event", 0, UUID.randomUUID().toString(), payload);
        kafkaTemplate.send("event", 1, UUID.randomUUID().toString(), payload);
    }

    private void sendHello(int n) {
        kafkaTemplate.send("hello", 0, UUID.randomUUID().toString(), String.format("Hello: [%s]", n));
        kafkaTemplate.send("hello", 1, UUID.randomUUID().toString(), String.format("Hello: [%s]", n));
    }

    private void sendHi(int n) {
        kafkaTemplate.send("hi", "Hi Ana!");
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class AddStatisticEvent {

    private Integer id;
}
