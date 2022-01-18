package DBClasses;


import JavaClasses.RoomService;
import JavaClasses.ServerAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBServer {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public DBServer() {
        conn = DBConnection.connectTODB();
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

    public void addRoomService(RoomService roomService) {
        try {
            String insertQuery ="insert into roomservicedb values(?,?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1, roomService.getServiceId());
            statement.setString(2, roomService.getServiceDesc());
            statement.setString(3, roomService.getAmount());
            statement.setObject(4,roomService.getRequestTime());
            statement.setString(5, roomService.getreservationNumber());

            statement.execute();
            statement.close();

            System.out.println("InsertQuery of RoomService Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of RoomService Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public ArrayList<ServerAccount> serverLogin(String accountId, String password) {
        ArrayList<ServerAccount> serverAccounts = new ArrayList<>();
        try {
            accountId += "%";
            password += "%";

            statement = conn.prepareStatement("select * from accountdb where accountId like ? and password like ? and accountType like ?");
            statement.setString(1, accountId);
            statement.setString(2, password);
            statement.setString(3, "SERVER%");
            result = statement.executeQuery();

            System.out.println("Account Search Succeded");
            while (result.next()) {
                serverAccounts.add(new ServerAccount(result.getString(1),result.getString(2), "ACTIVE"));
            }
            statement.close();
            if (serverAccounts.isEmpty())
                System.out.println("Server Login Failed");
            else
                System.out.println("Server Login Succeded");
        } catch (SQLException ex) {
            System.out.println("Account Search Failed");
        }

        return serverAccounts;
    }
}
