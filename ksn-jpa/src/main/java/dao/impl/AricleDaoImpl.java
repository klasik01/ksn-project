package dao.impl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.interfaces.ArticleDao;
import entity.ArticleEntity;
import entity.QArticleEntity;
import entity.QUserEntity;
import entity.UserEntity;
import util.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public class AricleDaoImpl implements ArticleDao {

    private EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

    @Override
    public List<ArticleEntity> getArticles() {
        final JPAQuery<ArticleEntity> query = new JPAQuery<>(em);
        final QArticleEntity article = QArticleEntity.articleEntity;

        return query.from(article).fetch();
    }

    @Override
    public boolean save(ArticleEntity entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<ArticleEntity> findArticleByNameQueryDSL(String name) {
        final JPAQuery<ArticleEntity> query = new JPAQuery<>(em);
        final QArticleEntity article = QArticleEntity.articleEntity;

        return query.from(article).where(article.name.eq(name)).fetch();
    }

    @Override
    public List<ArticleEntity> findArticleByAuthorQueryDSL(UUID userId) {
        final JPAQuery<ArticleEntity> query = new JPAQuery<>(em);
        final QArticleEntity article = QArticleEntity.articleEntity;

        return query.from(article).where(article.author.eq(userId.toString())).fetch();
    }
}
