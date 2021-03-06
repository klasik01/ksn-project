package entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = 1342460569L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final BooleanPath active = createBoolean("active");

    public final StringPath email = createString("email");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath surname = createString("surname");

    public QUserEntity(String variable) {
        super(UserEntity.class,  forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata<?> metadata) {
        super(UserEntity.class,  metadata);
    }

}

