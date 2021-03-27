package learn.kafka.consumerdemo;

import learn.kafka.consumerdemo.stats.entity.Statistic;
import learn.kafka.consumerdemo.stats.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class ConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemoApplication.class, args);
    }
}

@Service
@RequiredArgsConstructor
class Initializer {

    private final StatisticRepository statisticRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeModel() {
        Statistic statistic = new Statistic(1, 1);
        statisticRepository.save(statistic);
    }
}

