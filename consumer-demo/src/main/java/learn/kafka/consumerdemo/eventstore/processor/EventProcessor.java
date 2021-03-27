package learn.kafka.consumerdemo.eventstore.processor;

public interface EventProcessor {

    <T> T getAggregate(String aggregateId, Class<T> aggregateClass);
}
