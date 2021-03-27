package learn.kafka.consumerdemo.stats.usecase.update.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class UpdateStatisticResponse {

    private final boolean success;
}
