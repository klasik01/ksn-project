package converter;

import com.mysema.query.Tuple;
import com.mysema.query.types.Expression;
import com.mysema.query.types.MappingProjection;
import dto.LinksUserCalculator;
import entity.QUserEntity;
import rs.user.User;

import java.util.UUID;

public class UserEntityConverter extends MappingProjection<User> {

    public UserEntityConverter(Class<? super User> type, Expression<?>... args) {
        super(type, args);
    }

    @Override
    protected User map(Tuple tuple) {
        final QUserEntity user = QUserEntity.userEntity;
        return User.builder()
                .id(UUID.fromString(tuple.get(user.id)))
                .name(tuple.get(user.name))
                .surname(tuple.get(user.surname))
                .email(tuple.get(user.email))
                .active(true)
                .links(LinksUserCalculator.resolved(new User()))
                .build();
    }

}
