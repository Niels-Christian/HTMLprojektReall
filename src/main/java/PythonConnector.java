import jakarta.ws.rs.POST;
import model.ECG;


public class PythonConnector {
    @POST
    public void postECG(ECG obj) {
        System.out.println(obj.getParam1());
    }
}
