package klasik.source.ksnrest.ws;

import dto.user.UserFilter;
import dto.user.UsersRequest;
import ejb.UserManager;
import entity.UserEntity;
import org.springframework.web.bind.annotation.*;
import rs.user.Users;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Locale;

@RestController
@RequestMapping(path = "/user")
public class UserProvider {

    private UserManager userManager = new UserManager();

    @GetMapping(path = "/profile/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    UserEntity loadUser(@PathVariable("id") String id) {

        System.out.println(userManager.loadUser(id));
        UserEntity user = userManager.loadUser(id);
        if (user == null) {
            return null;
        }
        return user;
    }


    @GetMapping(path = "/all")
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    Users loadUsers(@RequestParam("page") String page,
                    @RequestParam("per_page") String per_page,
                    @RequestParam("filter") String filter) {

        Users users = userManager.loadUsers(
                UsersRequest.builder()
                        .locale(Locale.ENGLISH)
                        .page(Integer.parseInt(page))
                        .perPage(Integer.parseInt(per_page))
                        .fullTextSearch(filter)
                        .filter(new UserFilter(filter))
                        .build()
        );
        return users;
    }

}
