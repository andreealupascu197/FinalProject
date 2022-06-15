package ConnectionToDb;

import ro.fasttrackit.code.TimeOfDay;
import ro.fasttrackit.code.Type;
import ro.fasttrackit.code.Usage;

import java.sql.*;
import java.time.LocalDate;

public class DemoCRUDOperations {

    static final String URL = "jdbc:postgresql://localhost:5432/finalproject2";
    static final String USERNAME = "finalprojectapp";
    static final String PASSWORD = "abcde1234";


    public static void main(String[] args) {
        try {
            demoCreate();
             demoRead();
            demoUpdate();
            demoDelete();

            // demoBlobInsert();
            // demoBlobRead();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void demoCreate() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);


        PreparedStatement pStMedication = conn.prepareStatement("INSERT INTO MEDICATION (NAME, QUANTITY,PRICE, EXPIRYDATE, USAGE, TYPE) VALUES (?,?,?,?,?,?)");
        pStMedication.setString(1, "Vitamin C");
        pStMedication.setInt(2, 60);
        pStMedication.setInt(3, 25);
        pStMedication.setDate(4, Date.valueOf(LocalDate.now().plusYears(1)));
        pStMedication.setString(5, Usage.VITAMINS.name());
        pStMedication.setString(6, Type.CAPSULES.name());

        PreparedStatement pStAdministration = conn.prepareStatement("INSERT INTO ADMINISTRATION (FREQUENCY,TIMEOFDAY,BEFOREEATING) VALUES (?,?,?)");
        pStAdministration.setInt(1, 2);
        pStAdministration.setString(2, TimeOfDay.MORNING.name());
        pStAdministration.setBoolean(3, true);


        int rowsInserted = pStMedication.executeUpdate();
        int rowsInserted2 = pStAdministration.executeUpdate();

        pStMedication.close();
        pStAdministration.close();
        conn.close();
    }

    private static void demoRead() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement st = conn.createStatement();
        ResultSet rsMedication = st.executeQuery("SELECT name, quantity,price, expirydate, usage, type FROM medication");

        while (rsMedication.next()) {
            System.out.print(rsMedication.getString("name").trim());
            System.out.print("---");
            System.out.println(rsMedication.getString("quantity").trim());
            System.out.print("---");
            System.out.println(rsMedication.getString("price").trim());
            System.out.print("---");
            System.out.println(rsMedication.getString("expirydate").trim());
            System.out.print("---");
            System.out.println(rsMedication.getString("usage").trim());
            System.out.print("---");
            System.out.println(rsMedication.getString("type").trim());
        }

        ResultSet rsAdministration = st.executeQuery("SELECT frequency, timeofday, beforeeating FROM administration");
        while (rsAdministration.next()) {
            System.out.println(rsAdministration.getString("frequency").trim());
            System.out.print("---");
            System.out.println(rsAdministration.getString("timeofday").trim());
            System.out.print("---");
            System.out.println(rsAdministration.getString("beforeeating").trim());
        }
        rsMedication.close();
        rsAdministration.close();
        st.close();
        conn.close();
    }

    private static void demoUpdate() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pStMedication = conn.prepareStatement("UPDATE MEDICATION SET NAME=?, QUANTITY=?, PRICE=?, EXPIRYDATE=?, USAGE=?, TYPE=? WHERE IDUSER=?"); //so we have 3 params
        pStMedication.setString(1, "Vitamin D");
        pStMedication.setInt(2, 100);
        pStMedication.setInt(3,26);
        pStMedication.setDate(4, Date.valueOf(LocalDate.now().plusYears(1)));
        pStMedication.setString(5, Usage.VITAMINS.name());
        pStMedication.setString(6,Type.EFFERVESCENT.name());
        pStMedication.setLong(7, 1);

        PreparedStatement pStAdministration = conn.prepareStatement("UPDATE ADMINISTRATION SET FREQUENCY=?,TIMEOFDAY=?,BEFOREEATING=? WHERE ID=?");
        pStAdministration.setInt(1,2);
        pStAdministration.setString(2,TimeOfDay.AFTERNOON.name());
        pStAdministration.setBoolean(3,false);
        pStAdministration.setLong(4,1);


        int rowsUpdatedM = pStMedication.executeUpdate();
        int rowsUpdatedA = pStAdministration.executeUpdate();
        System.out.println("updated rows: " + rowsUpdatedM);
        System.out.println("updated rows: " + rowsUpdatedA);

        pStMedication.close();
        pStAdministration.close();
        conn.close();
    }


    private static void demoDelete() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pStMedication = conn.prepareStatement("DELETE FROM MEDICATION WHERE IDUSER=?");
        pStMedication.setLong(1, 1); // once the record with iduser 1 is deleted from Medication, the record with id 1 from Administration is deleted as well


        int rowsDeletedM = pStMedication.executeUpdate();
        System.out.println(rowsDeletedM + " rows were deleted.");

        pStMedication.close();
        conn.close();
    }
}

