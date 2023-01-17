package service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.GetPatient;

@Path("patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService{
    private GetPatient getPatient = new GetPatient();
    @GET
    @Path("{cpr}")
    public Patient getPatient(@PathParam("cpr") String cpr){
        return getPatient.getPatient(cpr);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPatient(Patient patient){
        System.out.println(patient);

    }

}
