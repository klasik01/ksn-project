package entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticleEntity extends EntityPathBase<ArticleEntity> {

    private static final long serialVersionUID = 1491915150L;

    public static final QArticleEntity articleEntity = new QArticleEntity("articleEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath author = createString("author");

    public final StringPath category = createString("category");

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> date = createDateTime("date", java.sql.Timestamp.class);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    public QArticleEntity(String variable) {
        super(ArticleEntity.class, forVariable(variable));
    }

    public QArticleEntity(Path<? extends ArticleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleEntity(PathMetadata metadata) {
        super(ArticleEntity.class, metadata);
    }

}

