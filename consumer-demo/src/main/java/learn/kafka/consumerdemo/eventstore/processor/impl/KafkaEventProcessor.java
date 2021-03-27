package learn.kafka.consumerdemo.eventstore.processor.impl;

import learn.kafka.consumerdemo.eventstore.processor.EventProcessor;

public class KafkaEventProcessor implements EventProcessor {

    @Override
    public <T> T getAggregate(String aggregateId, Class<T> aggregateClass) {
        return null;
    }
}
