package learn.kafka.consumerdemo.stats.usecase.update.vo;

import learn.kafka.consumerdemo.common.ValidationAware;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UpdateStatisticRequest implements ValidationAware {

    private final Integer id;

    @Override
    public void validate() {
        if (null == id) {
            throw new IllegalArgumentException("Id cannot be empty");
        }
    }
}
