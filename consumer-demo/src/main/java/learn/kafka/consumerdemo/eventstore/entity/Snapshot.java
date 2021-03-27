package learn.kafka.consumerdemo.eventstore.entity;

import learn.kafka.consumerdemo.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "aggregates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Snapshot extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -111473456010293568L;

    @Id
    private String id;

    @Column
    private String lastEventId;

    @Column
    private String payload;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snapshot event = (Snapshot) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
