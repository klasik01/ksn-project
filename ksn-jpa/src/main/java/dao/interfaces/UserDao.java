package dao.interfaces;

import entity.UserEntity;

import java.util.List;

public interface UserDao {

    public List<UserEntity> getUsers();

    public UserEntity save(UserEntity entity);

    public List<UserEntity> findUsersByFirstnameQueryDSL(final String firstname);

    public List<UserEntity> findUsersByFirstnameAndSurnameQueryDSL(final String firstname, final String surname);

    public List<UserEntity> findUsersByEmailrQueryDSL(final String email);

}
