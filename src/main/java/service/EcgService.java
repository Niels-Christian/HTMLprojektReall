package service;
import business.EcgController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.sql.*;
import java.lang.String;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@Path("ecg")
@Consumes(MediaType.APPLICATION_JSON)
public class EcgService {
    private EcgController ecgController = new EcgController();
    @POST
    public String PostEcg(ECG ecg) throws SQLException {
        String id = UUID.randomUUID().toString();
        System.out.println(ecg.getSamples());
        /*
        for (int i = 0; i < ecg.size(); i++) {
            ecgController.save(ecg[i]);
        }*/


        return "tak for data: " + id;
    }
}
