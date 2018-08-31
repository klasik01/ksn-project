package entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticleEntity extends EntityPathBase<ArticleEntity> {

    private static final long serialVersionUID = 1491915150L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleEntity articleEntity = new QArticleEntity("articleEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QUserEntity author;

    public final StringPath category = createString("category");

    public final ListPath<CommentEntity, QCommentEntity> comments = this.<CommentEntity, QCommentEntity>createList("comments", CommentEntity.class, QCommentEntity.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    public QArticleEntity(String variable) {
        this(ArticleEntity.class, forVariable(variable), INITS);
    }

    public QArticleEntity(Path<? extends ArticleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleEntity(PathMetadata metadata, PathInits inits) {
        this(ArticleEntity.class, metadata, inits);
    }

    public QArticleEntity(Class<? extends ArticleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new QUserEntity(forProperty("author")) : null;
    }

}

