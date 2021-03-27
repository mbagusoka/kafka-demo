package learn.kafka.consumerdemo.stats.usecase.update;

import learn.kafka.consumerdemo.stats.usecase.update.vo.UpdateStatisticRequest;

public interface UpdateStatisticInputBoundary {

    void update(UpdateStatisticRequest request, UpdateStatisticOutputBoundary presenter);
}
