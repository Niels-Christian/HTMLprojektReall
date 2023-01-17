package service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import business.PatientController;

@Path("patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService{
private PatientController patientController = new PatientController();
    @GET
    @Path("{cpr}")
    public Patient getPatient(@PathParam("cpr") String cpr){

        return patientController.getPatient(cpr);
    }

    @POST
    public Patient postPatient(Patient patient){
        String navn = patient.getName();
        patientController.save(patient);
        navn = navn;
        patient.setName(navn);
        return patient;
    }
}
