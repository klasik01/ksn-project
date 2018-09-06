package klasik.source.ksnrest.ws;

import ejb.UserManager;
import entity.UserEntity;
import org.springframework.web.bind.annotation.*;
import rs.user.User;

@RestController
@RequestMapping(path = "/user")
public class UserProvider {

    private UserManager userManager = new UserManager();

    @GetMapping(path = "/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") String id) {
        User user = userManager.findUserById(id);

        if (user == null) {
            return null;
        }
        return user;
    }
}
