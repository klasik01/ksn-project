package dao.impl;

import com.querydsl.jpa.impl.JPAQuery;
import dao.interfaces.UserDao;
import entity.QUserEntity;
import entity.UserEntity;
import util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDaoImpl implements UserDao {


    private EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

    @Override
    public List<UserEntity> getUsers() {
        final JPAQuery<UserEntity> query = new JPAQuery<>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).fetch();
    }

    @Override
    public UserEntity save(UserEntity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public List<UserEntity> findUsersByFirstnameQueryDSL(final String firstname) {
        final JPAQuery<UserEntity> query = new JPAQuery<>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).where(user.name.eq(firstname)).fetch();
    }

    @Override
    public List<UserEntity> findUsersByFirstnameAndSurnameQueryDSL(final String firstname, final String surname) {
        final JPAQuery<UserEntity> query = new JPAQuery<>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).where(user.name.eq(firstname).and(user.surname.eq(surname))).fetch();
    }

    @Override
    public List<UserEntity> findUsersByEmailrQueryDSL(final String email) {
        final JPAQuery<UserEntity> query = new JPAQuery<>(em);
        final QUserEntity user = QUserEntity.userEntity;

        return query.from(user).where(user.email.eq(email)).fetch();
    }
}
