package entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Stanislav Kasika
 */

@Entity
@Data
@Table(name = "art02_comment")
public class CommentEntity extends AbstractEntity {

    @Column(name = "art02_content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "art02_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "art02_author")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "art02_article")
    private ArticleEntity article;

    public CommentEntity(String id, String content, UserEntity author, Date date, ArticleEntity article) {
        super(id);
        this.content = content;
        this.author = author;
        this.date = date;
        this.article = article;
    }

    public CommentEntity() {
        super();
    }

    public CommentEntity(String id) {
        super(id);
    }

    @Override
    boolean testInstanceEntity(Object other) {
        return other instanceof CommentEntity;
    }
}
