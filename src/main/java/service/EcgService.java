package service;
import business.EcgController;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.ECGSample;

import java.sql.*;
import java.lang.String;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@Path("ecg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EcgService {
    private EcgController ecgController = new EcgController();
    @POST
    public String PostEcg(ECG ecg) throws SQLException {
        String id = UUID.randomUUID().toString();
        System.out.println(ecg.getSamples());
        for (int i = 0; i <= ecg.samples.size(); i++) {
            ecgController.save(ecg.samples.get(i));
        }

        return "tak for data: " + id;
    }

    @GET
    @Path("{cpr}")
    public ECG getECG(@PathParam("cpr") String cpr){

        return ecgController.getECG(cpr);
    }
}
