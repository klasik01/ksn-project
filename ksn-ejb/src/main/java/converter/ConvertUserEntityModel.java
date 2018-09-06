package converter;

import dto.LinksCalculator;
import entity.UserEntity;
import rs.user.User;

import java.util.UUID;

public class ConvertUserEntityModel {

    public static User convertEntityToModel(UserEntity entity) {
        User model = new User();
        model.setId(UUID.fromString(entity.getId()));
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setActive(entity.isActive());
        model.setLinks(LinksCalculator.resolved(entity));

        return model;
    }

    public UserEntity convertModelToEntity(User model) {
        UserEntity entity = new UserEntity();


        return entity;
    }

}
