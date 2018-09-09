package converter;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.MappingProjection;
import dto.LinksUserCalculator;
import entity.QUserEntity;
import entity.UserEntity;
import rs.user.User;

import java.util.UUID;

public class UserEntityConverter extends MappingProjection<User> {

    public UserEntityConverter(Class<? super User> type, Expression<?>... args) {
        super(type, args);
    }

    @Override
    protected User map(Tuple tuple) {
        UserEntity entity = tuple.get(QUserEntity.userEntity);

        return toDto(entity);
    }

    public static User toDto(UserEntity entity) {
        User model = new User();
        model.setId(UUID.fromString(entity.getId()));
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setActive(entity.isActive());
        model.setLinks(LinksUserCalculator.resolved(entity));

        return model;
    }
}
