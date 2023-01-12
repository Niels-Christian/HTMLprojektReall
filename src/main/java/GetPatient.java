import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import java.applet.Applet;


public class GetPatient extends Applet {
    private String cprVar;

    public void GetPatient(String value){
        cprVar = value;
        System.out.println(cprVar);
    }
}
