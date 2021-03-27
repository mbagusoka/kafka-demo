package learn.kafka.consumerdemo.listener;

import learn.kafka.consumerdemo.eventstore.usecase.add.event.AddEventInputBoundary;
import learn.kafka.consumerdemo.eventstore.usecase.add.event.AddEventOutputBoundary;
import learn.kafka.consumerdemo.eventstore.usecase.add.event.AddEventRequest;
import learn.kafka.consumerdemo.stats.aggregate.StatisticAggregate;
import learn.kafka.consumerdemo.stats.event.AddStatisticEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventConsumer {

    private final AddEventInputBoundary useCase;

    @KafkaListener(topics = "event")
    public void consumeEvent(ConsumerRecord<String, String> record) {
        saveEvent(record);
    }

    private void saveEvent(ConsumerRecord<String, String> record) {
        AddEventRequest request = new AddEventRequest(
                record.value(),
                AddStatisticEvent.class.getCanonicalName(),
                StatisticAggregate.class.getCanonicalName()
        );
        AddEventOutputBoundary presenter = response -> log.info(response.toString());
        useCase.add(request, presenter);
    }
}
