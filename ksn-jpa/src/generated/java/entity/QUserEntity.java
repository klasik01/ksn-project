package entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = 1342460569L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final BooleanPath active = createBoolean("active");

    public final SetPath<ArticleEntity, QArticleEntity> articles = this.<ArticleEntity, QArticleEntity>createSet("articles", ArticleEntity.class, QArticleEntity.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath surname = createString("surname");

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

