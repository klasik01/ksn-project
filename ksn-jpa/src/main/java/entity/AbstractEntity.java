package entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column (name = "table_id")
    private String id;

    protected AbstractEntity(String id) {
        this.id = id;
    }

    protected AbstractEntity() {
    }

    abstract boolean testInstanceEntity();
}
