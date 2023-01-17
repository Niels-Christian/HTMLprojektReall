package service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public Patient postPatient(Patient patient){
        String navn = patient.getName();
        navn = "Hr." + navn;
        patient.setName(navn);
        return patient;
    }
}
