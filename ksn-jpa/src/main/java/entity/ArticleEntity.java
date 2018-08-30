package entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Stanislav Kasika
 */

@Entity
@Data
@ToString(exclude = "comments")
@Table(name = "art01_article")
public class ArticleEntity extends AbstractEntity {

    @Column(name = "art01_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "art01_author")
    private UserEntity author;

    @Column(name = "art01_category")
    private String category;

    @Column(name = "art01_content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "art01_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "article")
    @OrderBy("date ASC")
    private List<CommentEntity> comments;

    public List<CommentEntity> getComments() {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        return comments;
    }


    public ArticleEntity(String id, String name, UserEntity author, String category, String content, Date date) {
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
    boolean testInstanceEntity(Object other) {
        return other instanceof ArticleEntity;
    }
}
