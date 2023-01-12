import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import service.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class DatabaseInfo {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPatient(Patient p) {

        Connection conn = null;
        Statement stmt = null;
        Scanner scan = new Scanner(System.in);
        String is = scan.next();

        try { //
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk/s215846?" +
                    "user=s215846&password=E2yMFR0C4Cs7u3Bc5gsih");
            stmt = conn.createStatement();
            String query = "select name, cpr, ecg, note from PatientInfo where cpr='" + is +"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(1);
                String cpr = rs.getString(2);
                String ecg = rs.getString(3);
                String note = rs.getString(4);

                System.out.println("Name: " + name);
                System.out.println("CPR: " + cpr);
                System.out.println("ECG: " + ecg);
                System.out.println("Note: " + note);
                System.out.println("");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {}
        }
    }
}