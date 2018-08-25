package dao.interfaces;

import entity.ArticleEntity;
import entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface ArticleDao {

    public List<ArticleEntity> getArticles();

    public boolean save(ArticleEntity entity);

    public List<ArticleEntity> findArticleByNameQueryDSL(final String name);

    public List<ArticleEntity> findArticleByAuthorQueryDSL(final UUID userId);

}
