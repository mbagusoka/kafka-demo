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
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 810526030148474129L;

    @Id
    private String id;

    @Column(nullable = false)
    private String payload;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String aggregateName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
