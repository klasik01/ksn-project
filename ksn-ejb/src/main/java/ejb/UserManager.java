package ejb;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import entity.QUserEntity;
import entity.UserEntity;
import lombok.NoArgsConstructor;
import rs.user.User;
import rs.user.Users;

import javax.ejb.*;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Stateless
//@Interceptors({MeasuringInterceptor.class, LoggingInterceptor.class})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class UserManager extends AbstractQueryManager {

    public List<UserEntity> getUsers() {
        final JPAQuery<UserEntity> query = new JPAQuery<UserEntity>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).fetch();
    }


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

    public List<UserEntity> findUsersByFirstnameQueryDSL(final String firstname) {
        final JPAQuery<UserEntity> query = new JPAQuery<UserEntity>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).where(user.name.eq(firstname)).fetch();
    }

    public List<UserEntity> findUsersByFirstnameAndSurnameQueryDSL(final String firstname, final String surname) {
        final JPAQuery<UserEntity> query = new JPAQuery<UserEntity>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).where(user.name.eq(firstname).and(user.surname.eq(surname))).fetch();
    }

    public List<UserEntity> findUsersByEmailQueryDSL(final String email) {
        final JPAQuery<UserEntity> query = new JPAQuery<UserEntity>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).where(user.email.eq(email)).fetch();
    }

    public Users loadUsers() {
        QUserEntity user = QUserEntity.userEntity;
        BooleanExpression condition = Expressions.asBoolean(true).isTrue();
        JPAQuery query = createBaseQuery(condition, user);
        query.orderBy(user.surname.asc());
        query.distinct();

        return Users.builder()
                //.messages(messages)
                .total((int) query.fetchCount())
                .users(loadUsers(paging(query, 2, 2)))
                .build();
    }

    public User loadUser(final String id) {
        final QUserEntity user = QUserEntity.userEntity;
        final BooleanExpression condition = Expressions.asBoolean(true).isTrue();
        final JPAQuery<UserEntity> query = createBaseQuery(condition, user);
        return null; //UserEntityConverter.toDto(query.fetchOne());
    }

    private List<UserEntity> loadUsers(JPAQuery select) {
        return select.fetch();
    }


}
