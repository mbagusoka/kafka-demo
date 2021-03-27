package learn.kafka.consumerdemo.stats.repository;

import learn.kafka.consumerdemo.stats.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
