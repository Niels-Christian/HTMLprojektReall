import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("index.html")
public class LoginService {
    @GET
    public String testAhoy(){
        return ("Ahoy");
    }
}
