package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
    INSTANCE;

    private EntityManagerFactory entityManagerFactory;

    PersistenceManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ksn-jpa");
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
