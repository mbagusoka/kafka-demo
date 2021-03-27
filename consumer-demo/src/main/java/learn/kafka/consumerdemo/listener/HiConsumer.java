package learn.kafka.consumerdemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class HiConsumer {

    @KafkaListener(topics = "hi")
    public void consumeHi(ConsumerRecord<String, String> record) {
        log.info("Consumed by [{}] on [{}]", Thread.currentThread(), LocalDateTime.now());
    }
}
