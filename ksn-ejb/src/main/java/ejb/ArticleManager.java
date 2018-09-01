package ejb;


import com.querydsl.jpa.impl.JPAQuery;
import entity.ArticleEntity;
import entity.QArticleEntity;
import lombok.NoArgsConstructor;

import javax.ejb.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Stateless
//@Interceptors({MeasuringInterceptor.class, LoggingInterceptor.class})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class ArticleManager extends AbstractEntityManager {

    public List<ArticleEntity> getArticles() {
        final JPAQuery<ArticleEntity> query = new JPAQuery<ArticleEntity>(em);
        final QArticleEntity article = QArticleEntity.articleEntity;

        return query.from(article).fetch();
    }

    public List<ArticleEntity> findArticleByNameQueryDSL(String name) {
        final JPAQuery<ArticleEntity> query = new JPAQuery<ArticleEntity>(em);
        final QArticleEntity article = QArticleEntity.articleEntity;

        return query.from(article).where(article.name.eq(name)).fetch();
    }

    public List<ArticleEntity> findArticleByAuthorQueryDSL(UUID userId) {
        final JPAQuery<ArticleEntity> query = new JPAQuery<ArticleEntity>(em);
        final QArticleEntity article = QArticleEntity.articleEntity;

        return null;// query.from(article).where(article.author.eq(userId.toString())).fetch();
    }

    public void saveArticle(ArticleEntity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
}
