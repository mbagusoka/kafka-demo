package learn.kafka.consumerdemo.eventstore.usecase.add.event;

import learn.kafka.consumerdemo.common.ValidationAware;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@RequiredArgsConstructor
public class AddEventRequest implements ValidationAware {

    private final String payload;
    private final String eventName;
    private final String aggregateName;

    @Override
    public void validate() {
        if (StringUtils.isEmpty(payload)) {
            throw new IllegalArgumentException("Payload cannot be empty");
        }
        if (StringUtils.isEmpty(eventName)) {
            throw new IllegalArgumentException("Event Name cannot be empty");
        }
        if (StringUtils.isEmpty(aggregateName)) {
            throw new IllegalArgumentException("Aggregate Name cannot be empty");
        }
    }
}
