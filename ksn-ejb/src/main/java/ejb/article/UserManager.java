package ejb.article;

import com.querydsl.jpa.impl.JPAQuery;
import entity.QUserEntity;
import entity.UserEntity;
import lombok.NoArgsConstructor;

import javax.ejb.*;
import java.util.List;

@NoArgsConstructor
@Stateless
//@Interceptors({MeasuringInterceptor.class, LoggingInterceptor.class})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class UserManager extends AbstractEntityManager {

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
}
