package learn.kafka.consumerdemo.stats.entity;

import learn.kafka.consumerdemo.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "statistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Statistic extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2114871830710003240L;

    @Id
    private Integer id;

    @Column
    private Integer stats;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return id.equals(statistic.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
