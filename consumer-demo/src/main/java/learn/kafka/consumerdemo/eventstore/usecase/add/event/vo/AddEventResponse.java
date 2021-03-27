package learn.kafka.consumerdemo.eventstore.usecase.add.event.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class AddEventResponse {

    private final String eventId;
}
