package converter;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.MappingProjection;
import dto.LinksArticleCalculator;
import entity.ArticleEntity;
import entity.QArticleEntity;
import rs.article.Article;

import java.util.UUID;

/**
 * class ArticleEntityConverter
 *
 * @author Stanislav KASIKA, 8.9.2018
 * @positon Developer
 */
public class ArticleEntityConverter extends MappingProjection<Article> {

    public ArticleEntityConverter(Class<? super Article> type, Expression<?>... args) {
        super(type, args);
    }

    @Override
    protected Article map(Tuple tuple) {
        ArticleEntity entity = tuple.get(QArticleEntity.articleEntity);

        return toDto(entity);
    }

    Article toDto(ArticleEntity entity) {
        Article model = new Article();
        model.setId(UUID.fromString(entity.getId()));
        model.setName(entity.getName());
        model.setCategory(entity.getCategory());
        model.setCreatedDate(entity.getDate());
        //model.setAuthor(entity.getAuthor());
        model.setContent(entity.getContent());
        model.setLinks(LinksArticleCalculator.resolved(entity));
        return model;
    }
}
