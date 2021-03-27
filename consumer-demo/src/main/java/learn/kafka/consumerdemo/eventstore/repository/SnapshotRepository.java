package learn.kafka.consumerdemo.eventstore.repository;

import learn.kafka.consumerdemo.eventstore.entity.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnapshotRepository extends JpaRepository<Snapshot, String> {
}
