package service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.PatientController;

@Path("patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService{
private PatientController getPatient = new PatientController();
    @GET
    @Path("{cpr}")
    public Patient getPatient(@PathParam("cpr") String cpr){

        return getPatient.getPatient(cpr);
    }

    @POST
    public Patient postPatient(Patient patient){
        String navn = patient.getName();
        navn = navn;
        patient.setName(navn);
        return patient;
    }
}
