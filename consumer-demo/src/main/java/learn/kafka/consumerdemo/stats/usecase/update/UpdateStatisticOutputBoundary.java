package learn.kafka.consumerdemo.stats.usecase.update;

import learn.kafka.consumerdemo.stats.usecase.update.vo.UpdateStatisticResponse;

public interface UpdateStatisticOutputBoundary {

    void present(UpdateStatisticResponse response);
}
