package learn.kafka.consumerdemo.eventstore.usecase.add.event;

public interface AddEventInputBoundary {

    void add(AddEventRequest request, AddEventOutputBoundary presenter);
}
