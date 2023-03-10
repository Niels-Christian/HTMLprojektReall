package business;

import model.DatabaseConnector;
import model.ECGSample;
import service.ECG;

import java.sql.*;
import java.lang.String;

public class EcgController {
    public ECG getECG(String cpr){
        Connection conn = null;
        Statement stmt = null;

        try { //
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk/s215846?" +
                    "user=s215846&password=E2yMFR0C4Cs7u3Bc5gsih");
            stmt = conn.createStatement();
            String query = "select cpr, ecg, time from ECGInfo where cpr='" + cpr +"'";
            ResultSet rs = stmt.executeQuery(query);
            ECG ecg = new ECG();
            while (rs.next()) {
                ECGSample ecgSample = new ECGSample();
                ecgSample.setCpr(rs.getString(1));
                ecgSample.setVoltage(rs.getDouble(2));
                ecgSample.setTime(rs.getDouble(3));
                ecg.getSamples().add(ecgSample);
            }
            rs.close();
            return ecg;
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

    public void save(ECGSample ecgSample) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ECGInfo VALUES (?,?,?)");
        preparedStatement.setString(1,ecgSample.getCpr());
        preparedStatement.setDouble(2,ecgSample.getVoltage());
        preparedStatement.setDouble(3,ecgSample.getTime());
        preparedStatement.execute();
        connection.commit();
    }
}
