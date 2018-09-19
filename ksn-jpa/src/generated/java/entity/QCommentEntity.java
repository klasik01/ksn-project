package entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCommentEntity is a Querydsl query type for CommentEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCommentEntity extends EntityPathBase<CommentEntity> {

    private static final long serialVersionUID = -276070345L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentEntity commentEntity = new QCommentEntity("commentEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QArticleEntity article;

    public final QUserEntity author;

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    //inherited
    public final StringPath id = _super.id;

    public QCommentEntity(String variable) {
        this(CommentEntity.class,  forVariable(variable), INITS);
    }

    public QCommentEntity(Path<? extends CommentEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCommentEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCommentEntity(PathMetadata<?> metadata, PathInits inits) {
        this(CommentEntity.class,  metadata, inits);
    }

    public QCommentEntity(Class<? extends CommentEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticleEntity(forProperty("article"), inits.get("article")) : null;
        this.author = inits.isInitialized("author") ? new QUserEntity(forProperty("author")) : null;
    }

}

