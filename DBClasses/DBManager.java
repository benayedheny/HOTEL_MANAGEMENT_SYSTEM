package DBClasses;

import JavaClasses.Receptionist;
import JavaClasses.ReceptionistAccount;
import JavaClasses.Server;
import JavaClasses.ServerAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public DBManager() {
        conn = DBConnection.connectTODB();
    }

    private static final DBManager SYSTEM = new DBManager();

    public static DBManager getSYSTEM() {
        return SYSTEM;
    }

    public void flushAll() {
        {
            try {
                statement.close();
                result.close();
            } catch (SQLException ex) {
                System.err.print(ex.toString() + " >> CLOSING DB");
            }
        }
    }

    private void flushStatmentOnly() {
        {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.err.print(ex.toString() + " >> CLOSING DB");
            }
        }
    }

    public void addServerAccount(ServerAccount serverAccount) {
        try {
            String insertQuery = "insert into accountdb  values(?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1, serverAccount.getAccountId());
            statement.setString(2, serverAccount.getPassword());
            statement.setString(3, "SERVER");
            statement.setString(4, serverAccount.getStatus());


            statement.execute();
            statement.close();

            System.out.println("InsertQuery of ServerAccount Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of ServerAccount Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void addServer(Server server) {
        try {
            String insertQuery = "insert into persondb  values(?,?,?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1, server.getFname());
            statement.setString(2, server.getLname());
            statement.setString(3, server.getCIN());
            statement.setString(4, server.getEmail());
            statement.setString(5, server.getPhone());
            statement.setString(6, server.getserverAccountId());

            statement.execute();
            statement.close();


            System.out.println("InsertQuery of Server Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of Server Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void updateServer(String serverAccountId, Server server) {
        try {
            String updateQuery = "update persondb set fname = ?,lname = ?,email = ?,phone = ? where accountId = ?";

            statement = conn.prepareStatement(updateQuery);
            statement.setString(1, server.getFname());
            statement.setString(2, server.getLname());
            statement.setString(3, server.getEmail());
            statement.setString(4, server.getPhone());
            statement.setString(5, serverAccountId);

            statement.executeUpdate();
            statement.close();


            System.out.println("Update of Server Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Update of Server Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void blockServerAccount(String serverAccountId) {
        try {
            String updateQuery = "update accountdb set status = ? where accountId = ?";

            statement = conn.prepareStatement(updateQuery);
            statement.setString(1, "BLOCKED");
            statement.setString(2, serverAccountId);
            statement.executeUpdate();
            statement.close();

            System.out.println("Blocking of ServerAcount Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Blocking of ServerAccount Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void deleteServer(String serverAccountId) {

        try {
            String deleteQuery = "delete from persondb where accountId = ?";

            statement = conn.prepareStatement(deleteQuery);
            statement.setString(1, serverAccountId);
            statement.executeUpdate();
            statement.close();

            System.out.println("Delete of Server Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Delete of Server Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    //*********************************************************************************
    public void addReceptionistAccount(ReceptionistAccount receptionistAccount) {
        try {
            String insertQuery = "insert into accountdb  values(?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1, receptionistAccount.getAccountId());
            statement.setString(2, receptionistAccount.getPassword());
            statement.setString(3, "RECEPTIONIST");
            statement.setString(4, receptionistAccount.getStatus());


            statement.execute();
            statement.close();

            System.out.println("InsertQuery of ReceptionistAccount Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of ReceptionistAccount Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void addReceptionist(Receptionist receptionist) {
        try {
            String insertQuery = "insert into persondb values(?,?,?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1, receptionist.getFname());
            statement.setString(2, receptionist.getLname());
            statement.setString(3, receptionist.getCIN());
            statement.setString(4, receptionist.getEmail());
            statement.setString(5, receptionist.getPhone());
            statement.setString(6, receptionist.getreceptionistAccountId());

            statement.execute();
            statement.close();

            System.out.println("InsertQuery of receptionist Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of receptionist Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void updateReceptionist(String receptionistAccountId, Receptionist receptionist) {
        try {
            String updateQuery = "update persondb set fname = ?,lname = ?,email = ?,phone = ? where accountId = ?";

            statement = conn.prepareStatement(updateQuery);
            statement.setString(1, receptionist.getFname());
            statement.setString(2, receptionist.getLname());
            statement.setString(3, receptionist.getEmail());
            statement.setString(4, receptionist.getPhone());
            statement.setString(5, receptionistAccountId);

            statement.executeUpdate();
            statement.close();


            System.out.println("Update of Receptionist Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Update of Receptionist Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void blockReceptionistAccount(String receptionistAccountId) {
        try {
            String updateQuery = "update accountdb set status = ? where accountId = ?";

            statement = conn.prepareStatement(updateQuery);
            statement.setString(1, "BLOCKED");
            statement.setString(2, receptionistAccountId);
            statement.executeUpdate();
            statement.close();

            System.out.println("Blocking of ReceptionistAcount Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Blocking of ReceptionistAcount Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void deleteReceptionist(String receptionistAccountId) {

        try {
            String deleteQuery = "delete from persondb where accountId = ?";

            statement = conn.prepareStatement(deleteQuery);
            statement.setString(1, receptionistAccountId);
            statement.executeUpdate();
            statement.close();

            System.out.println("Delete of Receptionist Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Delete of Receptionist Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }
}
