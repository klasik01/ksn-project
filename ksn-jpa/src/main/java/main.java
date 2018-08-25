import dao.impl.UserDaoImpl;
import dao.interfaces.UserDao;
import entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import util.PersistenceManager;

import java.util.List;
import java.util.UUID;

@Slf4j
public class main {
    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();

        List<UserEntity> users = dao.getUsers();
        users.forEach(user -> log.info(user.toString()));

        UserEntity newUser = new UserEntity();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setName("Marie");
        newUser.setSurname("Kunstová");
        newUser.setEmail("kunstova@makrie.com");
        newUser.setPassword("Heslo4");
        newUser.setActive(true);

        if(dao.saveUser(newUser)) {
            log.info("Save user - TRUE");
        }else {
            log.info("Save user - FALSE");
        }

        PersistenceManager.INSTANCE.close();
    }
}
