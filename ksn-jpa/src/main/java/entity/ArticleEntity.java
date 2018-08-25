package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author Stanislav Kasika
 */

@Entity
@Data
@Table(name = "art01_article")
public class ArticleEntity extends AbstractEntity {

    @Column(name = "art01_name")
    private String name;

    @Column(name = "art01_author")
    private String author;

    @Column(name = "art01_category")
    private String category;

    @Column(name = "art01_content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "art01_created_date")
    private Timestamp date;

//    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinTable(
//            name = "art02_comment",
//            joinColumns = @JoinColumn(name = "art02_article")
//    )
//    private Set<CommentEntity> comments;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "art01_author")
//    private UserEntity userEntity;

    public ArticleEntity(String id, String name, String author, String category, String content, Timestamp date) {
        super(id);
        this.name = name;
        this.author = author;
        this.category = category;
        this.content = content;
        this.date = date;
    }

    public ArticleEntity() {
        super();
    }

    @Override
    boolean testInstanceEntity() {
        return false;
    }
}
