package rs.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import rs.user.User;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Articles {

    private int total;
    private List<Article> users;
}
