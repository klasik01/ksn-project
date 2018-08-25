package dao.interfaces;

import entity.UserEntity;

import java.util.List;

public interface UserDao {

    public List<UserEntity> getUsers();

    public boolean saveUser(UserEntity userEntity);
}
