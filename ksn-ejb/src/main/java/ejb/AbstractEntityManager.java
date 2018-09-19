package ejb;

import com.mysema.query.types.expr.BooleanExpression;
import entity.QUserEntity;
import lombok.NoArgsConstructor;
import util.PersistenceManager;

import javax.ejb.*;
import javax.persistence.EntityManager;

@NoArgsConstructor
@Stateless
//@Interceptors({MeasuringInterceptor.class, LoggingInterceptor.class})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public abstract class AbstractEntityManager {

    protected EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

    protected BooleanExpression conditionActiveUser(QUserEntity user) {
        return user.active.eq(true);
    }
}
