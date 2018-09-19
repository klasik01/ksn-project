package entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column (name = "table_id")
    protected String id;

    protected AbstractEntity(String id) {
        this.id = id;
    }

    protected AbstractEntity() {
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (getId() == null) {
            return false;
        }
        if (!testInstanceEntity(other)) {
            return false;
        }
        if (other == null) {
            return false;
        }
        AbstractEntity otherEntity = (AbstractEntity) other;// NOSONAR
        if (!otherEntity.testInstanceEntity(this)) {
            return false;
        }

        return getId().equals(otherEntity.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }


    abstract boolean testInstanceEntity(Object other);
}
