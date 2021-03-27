package learn.kafka.consumerdemo.eventstore.usecase.add.event;

import learn.kafka.consumerdemo.eventstore.usecase.add.event.vo.AddEventResponse;

public interface AddEventOutputBoundary {

    void present(AddEventResponse response);
}
