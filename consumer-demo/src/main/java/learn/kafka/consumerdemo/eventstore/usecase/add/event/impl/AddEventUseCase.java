package learn.kafka.consumerdemo.eventstore.usecase.add.event.impl;

import learn.kafka.consumerdemo.common.Validator;
import learn.kafka.consumerdemo.eventstore.entity.Event;
import learn.kafka.consumerdemo.eventstore.repository.EventRepository;
import learn.kafka.consumerdemo.eventstore.usecase.add.event.AddEventInputBoundary;
import learn.kafka.consumerdemo.eventstore.usecase.add.event.AddEventOutputBoundary;
import learn.kafka.consumerdemo.eventstore.usecase.add.event.AddEventRequest;
import learn.kafka.consumerdemo.eventstore.usecase.add.event.vo.AddEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddEventUseCase implements AddEventInputBoundary {

    private final EventRepository repository;

    @Override
    public void add(AddEventRequest request, AddEventOutputBoundary presenter) {
        Validator.validate(request, presenter);
        String id = saveEvent(request);
        AddEventResponse response = new AddEventResponse(id);
        presenter.present(response);
    }

    private String saveEvent(AddEventRequest request) {
        String id = UUID.randomUUID().toString();
        Event event = new Event(id, request.getPayload(), request.getEventName(), request.getAggregateName());
        repository.save(event);
        return id;
    }
}
