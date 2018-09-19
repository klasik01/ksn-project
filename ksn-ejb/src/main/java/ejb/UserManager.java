package ejb;


import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import converter.UserEntityConverter;
import dto.user.UsersRequest;
import entity.QUserEntity;
import entity.UserEntity;
import lombok.NoArgsConstructor;
import rs.user.User;
import rs.user.Users;

import javax.ejb.*;
import java.util.List;

@NoArgsConstructor
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class UserManager extends AbstractQueryManager {

    public void saveUser(UserEntity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void deleteUser(UserEntity entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public Users loadUsers(UsersRequest req) {
        QUserEntity user = QUserEntity.userEntity;
        BooleanExpression condition = BooleanExpression.allOf(
                this.conditionActiveUser(user)
        );
        JPAQuery query = createBaseQuery(condition, user);
        query.orderBy(user.surname.asc());
        query.distinct();

        return Users.builder()
                .total((int) query.count())
                .users(loadUsers(paging(query, req.getPerPage(), req.getPage())))
                .build();
    }

    public User loadUser(final String uuid) {
        return loadUser(findByUuid(uuid));
    }

    private User loadUser(JPAQuery select) {
        final QUserEntity user = QUserEntity.userEntity;
        return select.singleResult(new UserEntityConverter(User.class, user, user.id, user.name, user.surname, user.email, user.active));
    }

    private JPAQuery findByUuid(final String uuid) {
        final QUserEntity user = QUserEntity.userEntity;
        BooleanExpression condition = user.id.stringValue().eq(uuid);
        final JPAQuery select = createBaseQuery(condition, user);
        if (select.notExists()) {
            throw new RuntimeException(String.format("User %s not found", uuid));
        }

        return select;
    }

    private List<User> loadUsers(JPAQuery select) {
        final QUserEntity user = QUserEntity.userEntity;
        return select.list(new UserEntityConverter(User.class, user, user, user.id, user.name, user.surname, user.email, user.active));
    }

}
