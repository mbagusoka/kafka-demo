package learn.kafka.consumerdemo.listener;

import learn.kafka.consumerdemo.stats.usecase.update.UpdateStatisticInputBoundary;
import learn.kafka.consumerdemo.stats.usecase.update.UpdateStatisticOutputBoundary;
import learn.kafka.consumerdemo.stats.usecase.update.vo.UpdateStatisticRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class HelloConsumer {

    private final UpdateStatisticInputBoundary useCase;

    @KafkaListener(topics = "hello")
    public void consumeHello(ConsumerRecord<String, String> record) {
        log.info("Hello " + record.value() + " from: " + Thread.currentThread() + LocalDateTime.now());
        updateStatistic();
    }

    private void updateStatistic() {
        UpdateStatisticRequest request = new UpdateStatisticRequest(1);
        UpdateStatisticOutputBoundary presenter = response -> log.info(response.toString());
        useCase.update(request, presenter);
    }
}
