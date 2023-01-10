import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("login")
public class LoginService {
    @GET
    public String getLogin(){
        return ("Ahoy");
    }
}
//IT3E22