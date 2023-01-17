package model;

import jakarta.ws.rs.FormParam;
import service.Patient;

import java.sql.*;
import java.lang.String;

public class PatientController {
    public Patient getPatient(String cpr){
        Connection conn = null;
        Statement stmt = null;
//        Scanner scan = new Scanner(System.in);
//        String is = scan.next();

        try { //
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk/s215846?" +
                    "user=s215846&password=E2yMFR0C4Cs7u3Bc5gsih");
            stmt = conn.createStatement();
            String query = "select name, cpr, ecg, note from PatientInfo where cpr='" + cpr +"'";
            ResultSet rs = stmt.executeQuery(query);
            Patient patient = new Patient();
            while (rs.next()) {
                patient.setName(rs.getString(1));
                patient.setCPR(rs.getString(2));
                patient.setECG(rs.getString(3));
                patient.setNote(rs.getString(4));
            }
            rs.close();
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {}
        }

    return null;
    }
}
