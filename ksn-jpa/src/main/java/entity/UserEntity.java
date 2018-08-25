package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name = "usr01_user")
public class UserEntity extends AbstractEntity{

    @Column(name = "usr01_name")
    private String name;

    @Column(name = "usr01_surname")
    private String surname;

    @Column(name = "usr01_email")
    private String email;

    @Column (name = "usr01_password")
    private String password;

    @Column (name = "usr01_active")
    private boolean active;

    public UserEntity() {
        super();
    }

    public UserEntity(String id, String name, String surname, String email, String password, boolean active) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    @Override
    boolean testInstanceEntity() {
        return true;
    }

}
