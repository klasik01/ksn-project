import dao.impl.UserDaoImpl;
import dao.interfaces.UserDao;
import entity.UserEntity;
import util.PersistenceManager;

import java.util.List;
import java.util.UUID;


public class main {
    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();

        List<UserEntity> users = dao.getUsers();
        users.forEach(user -> System.out.println(user.toString()));

        UserEntity newUser = new UserEntity();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setName("Helena");
        newUser.setSurname("Koubikova");
        newUser.setEmail("koubice@mail.com");
        newUser.setPassword("Heslo5");
        newUser.setActive(false);

        dao.save(newUser);

        (dao.findUsersByFirstnameQueryDSL("Stanislav")).forEach(user -> System.out.println(user.toString()));


        PersistenceManager.INSTANCE.close();
    }
}
