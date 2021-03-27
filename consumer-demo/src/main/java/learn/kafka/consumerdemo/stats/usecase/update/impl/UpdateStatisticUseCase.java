package learn.kafka.consumerdemo.stats.usecase.update.impl;

import learn.kafka.consumerdemo.common.Validator;
import learn.kafka.consumerdemo.stats.entity.Statistic;
import learn.kafka.consumerdemo.stats.repository.StatisticRepository;
import learn.kafka.consumerdemo.stats.usecase.update.UpdateStatisticInputBoundary;
import learn.kafka.consumerdemo.stats.usecase.update.UpdateStatisticOutputBoundary;
import learn.kafka.consumerdemo.stats.usecase.update.vo.UpdateStatisticRequest;
import learn.kafka.consumerdemo.stats.usecase.update.vo.UpdateStatisticResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateStatisticUseCase implements UpdateStatisticInputBoundary {

    private final StatisticRepository repository;

    @Override
    @Transactional
    public void update(UpdateStatisticRequest request, UpdateStatisticOutputBoundary presenter) {
        Validator.validate(request, presenter);
        repository.findById(request.getId()).ifPresent(this::update);
        UpdateStatisticResponse response = new UpdateStatisticResponse(true);
        presenter.present(response);
    }

    private void update(Statistic statistic) {
        statistic.setStats(statistic.getStats() + 1);
        repository.save(statistic);
    }
}
