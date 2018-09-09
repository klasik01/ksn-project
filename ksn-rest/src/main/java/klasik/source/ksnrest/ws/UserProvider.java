package klasik.source.ksnrest.ws;

import ejb.UserManager;
import org.springframework.web.bind.annotation.*;
import rs.user.User;
import rs.user.Users;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path = "/user")
public class UserProvider {

    private UserManager userManager = new UserManager();

    @GetMapping(path = "/profile/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") String id) {
        User user = null; //userManager.loadUser(id);

        if (user == null) {
            return null;
        }
        return user;
    }



    @GetMapping(path = "/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadUsers() {

        Users users = userManager.loadUsers();

        return Response.ok().entity(users).build();
    }

}
