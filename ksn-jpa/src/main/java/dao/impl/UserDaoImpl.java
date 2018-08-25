package dao.impl;

import dao.interfaces.UserDao;
import entity.UserEntity;
import util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getUsers() {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        Query query = em.createQuery("SELECT a from UserEntity a");

        List<UserEntity> result = query.getResultList();
        return result;
    }

    @Override
    public boolean saveUser(UserEntity userEntity) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(userEntity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
