package service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService {

    @GET
    public List<Patient> getPatient(){
        //TODO Dummy data - replace!
        ArrayList<Patient> patients = new ArrayList<>();
        Patient patient = new Patient();
        patient.CPR="1110109996";
        patient.Fornavn="Juliane Test Jørgensen";
        patients.add(patient);
        //---
        return patients;
    }
    /**
     * Verdens dummeste navne converter!
     * @param patient
     * @return
     */
    @POST
    public Patient postPatient(Patient patient){
        String navn = patient.getFornavn();
        navn = "Fru. " + navn;
        patient.setFornavn(navn);
        return patient;
    }
}
