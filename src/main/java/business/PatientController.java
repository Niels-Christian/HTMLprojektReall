package business;

import jakarta.ws.rs.FormParam;
import model.DatabaseConnector;
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
                patient.setECG(rs.getDouble(3));
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

    public void save(Patient patient) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PatientInfo VALUES (?,?,?,?)");
        preparedStatement.setString(1,patient.getName());
        preparedStatement.setString(2,patient.getCPR());
        preparedStatement.setDouble(3,patient.getECG());
        preparedStatement.setString(4,patient.getNote());
        preparedStatement.execute();

    }
}
