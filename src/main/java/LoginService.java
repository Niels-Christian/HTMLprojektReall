import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginService {
    @POST
    public Response getLogin(@FormParam("username") String username, @FormParam("password") String password){
//Hoi
        if (username.equalsIgnoreCase("qq") && password.equals("qq")) {
           return Response.ok().cookie(new NewCookie.Builder(username).build()).build();
        } else {
           return  Response.status(Response.Status.TEMPORARY_REDIRECT).link("PersonaleHome.html","").build();
        }

    }
}
//IT3E22