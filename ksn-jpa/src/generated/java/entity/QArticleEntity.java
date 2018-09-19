package entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
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
        this(ArticleEntity.class,  forVariable(variable), INITS);
    }

    public QArticleEntity(Path<? extends ArticleEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QArticleEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QArticleEntity(PathMetadata<?> metadata, PathInits inits) {
        this(ArticleEntity.class,  metadata, inits);
    }

    public QArticleEntity(Class<? extends ArticleEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new QUserEntity(forProperty("author")) : null;
    }

}

