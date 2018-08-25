package entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractEntity is a Querydsl query type for AbstractEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractEntity extends EntityPathBase<AbstractEntity> {

    private static final long serialVersionUID = -868746192L;

    public static final QAbstractEntity abstractEntity = new QAbstractEntity("abstractEntity");

    public final StringPath id = createString("id");

    public QAbstractEntity(String variable) {
        super(AbstractEntity.class, forVariable(variable));
    }

    public QAbstractEntity(Path<? extends AbstractEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractEntity(PathMetadata metadata) {
        super(AbstractEntity.class, metadata);
    }

}

