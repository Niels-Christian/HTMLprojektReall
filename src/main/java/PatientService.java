import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.Patient;

import java.util.ArrayList;
import java.util.List;

@Path("patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService{

    @GET
    public List<Patient> getPatient(){
        ArrayList<Patient> patients = new ArrayList<>();
        Patient patient = new Patient();
        patient.setCPR("1234567890");
        patient.setFornavn("Holger Danske");
        patients.add(patient);

        return patients;
    }

    @POST
    public Patient postPatient(Patient patient){
        String navn = patient.getFornavn();
        navn = "Hr." + navn;
        patient.setFornavn(navn);
        return patient;
    }
}
