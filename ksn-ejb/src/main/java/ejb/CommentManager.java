package ejb;

import com.mysema.query.jpa.impl.JPAQuery;
import entity.ArticleEntity;
import entity.CommentEntity;
import entity.QCommentEntity;
import lombok.NoArgsConstructor;

import javax.ejb.*;
import java.util.List;

@NoArgsConstructor
@Stateless
//@Interceptors({MeasuringInterceptor.class, LoggingInterceptor.class})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class CommentManager extends AbstractEntityManager {

    public CommentEntity getCommentByIdQueryDSL(String id) {
        return null;
    }

    public List<CommentEntity> findAllArticleComments(ArticleEntity entity) {
        return null;
    }

    public List<CommentEntity> getComments() {
        final JPAQuery query = new JPAQuery(em);
        final QCommentEntity comment = QCommentEntity.commentEntity;

        return query.from(comment).list(comment);
    }

    public void saveComment(CommentEntity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
}
