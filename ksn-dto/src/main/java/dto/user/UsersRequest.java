package dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Locale;

/**
 * class UsersRequest
 *
 * @author Stanislav KASIKA, 8.9.2018
 * @positon Developer
 */
@Builder
@Getter
@ToString
public class UsersRequest {

    private final Locale locale;
    private final int page;
    private final int perPage;
    @Builder.Default
    @NonNull
    private String fullTextSearch = "";
    @Builder.Default
    private UserFilter filter = new UserFilter();
}

