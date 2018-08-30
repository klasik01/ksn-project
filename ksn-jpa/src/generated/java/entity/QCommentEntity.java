package entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QCommentEntity is a Querydsl query type for CommentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommentEntity extends EntityPathBase<CommentEntity> {

    private static final long serialVersionUID = -276070345L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentEntity commentEntity = new QCommentEntity("commentEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QArticleEntity article;

    public final QUserEntity author;

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> date = createDateTime("date", java.sql.Timestamp.class);

    //inherited
    public final StringPath id = _super.id;

    public QCommentEntity(String variable) {
        this(CommentEntity.class, forVariable(variable), INITS);
    }

    public QCommentEntity(Path<? extends CommentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentEntity(PathMetadata metadata, PathInits inits) {
        this(CommentEntity.class, metadata, inits);
    }

    public QCommentEntity(Class<? extends CommentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticleEntity(forProperty("article"), inits.get("article")) : null;
        this.author = inits.isInitialized("author") ? new QUserEntity(forProperty("author")) : null;
    }

}

