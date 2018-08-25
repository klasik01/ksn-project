package entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentEntity is a Querydsl query type for CommentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommentEntity extends EntityPathBase<CommentEntity> {

    private static final long serialVersionUID = -276070345L;

    public static final QCommentEntity commentEntity = new QCommentEntity("commentEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath article = createString("article");

    public final StringPath author = createString("author");

    public final StringPath content = createString("content");

    public final DateTimePath<java.sql.Timestamp> date = createDateTime("date", java.sql.Timestamp.class);

    //inherited
    public final StringPath id = _super.id;

    public QCommentEntity(String variable) {
        super(CommentEntity.class, forVariable(variable));
    }

    public QCommentEntity(Path<? extends CommentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentEntity(PathMetadata metadata) {
        super(CommentEntity.class, metadata);
    }

}

