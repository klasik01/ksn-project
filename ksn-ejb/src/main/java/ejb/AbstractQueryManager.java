package ejb;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.EntityPathBase;

/**
 * class AbstractQueryManager
 *
 * @author Stanislav KASIKA, 8.9.2018
 * @positon Developer
 */
public class AbstractQueryManager extends AbstractEntityManager {

    protected JPAQuery createBaseQuery(BooleanExpression condition, EntityPathBase qEntity) {
        JPAQuery select = new JPAQuery(em);
        return select.from(qEntity)
                .where(condition);
    }

    protected JPAQuery paging(JPAQuery select, int perPage, int page) {
        if (page > 0 && perPage > 0) {
            return (JPAQuery) select.limit(perPage)
                    .offset(1L * (page - 1) * (perPage));
        }
        return select;
    }

}
