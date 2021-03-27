package learn.kafka.consumerdemo.stats.aggregate;

import learn.kafka.consumerdemo.stats.event.AddStatisticEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticAggregate {

    private Integer id;
    private Integer stats = 0;

    public void apply(AddStatisticEvent event) {
        id = event.getId();
        stats++;
    }
}
