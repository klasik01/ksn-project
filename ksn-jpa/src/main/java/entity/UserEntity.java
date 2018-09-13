package entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "articles")
@Table(name = "usr01_user")
public class UserEntity extends AbstractEntity implements Serializable {

    @Column(name = "usr01_name")
    private String name;

    @Column(name = "usr01_surname")
    private String surname;

    @Column(name = "usr01_email")
    private String email;

    @Column(name = "usr01_password")
    private String password;

    @Column(name = "usr01_active")
    private boolean active;

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    @OrderBy("date ASC")
    private List<ArticleEntity> articles;

    public List<ArticleEntity> getArticles() {
        if (articles == null) {
            articles = new ArrayList<>();
        }
        return articles;
    }

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
    boolean testInstanceEntity(Object other) {
        return other instanceof UserEntity;
    }

}
