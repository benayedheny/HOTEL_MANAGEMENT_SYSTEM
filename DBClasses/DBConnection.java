package DBClasses;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection conn = null;
    public static Connection connectTODB()
    {
        try {
            String USERNAME="USER";
            String PASSWORD="0000";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem",USERNAME,PASSWORD);
            return conn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            return null;
        }
    }
}
