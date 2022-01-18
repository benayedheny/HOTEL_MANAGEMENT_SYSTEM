package DBClasses;

import JavaClasses.GuestAccount;
import JavaClasses.Room;
import JavaClasses.RoomBooking;
import JavaClasses.RoomService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBGuest {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public DBGuest() {
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

    public ArrayList<GuestAccount> guestLogin(String accountId, String password) {
        ArrayList<GuestAccount> guestAccounts = new ArrayList<>();
        try {
            accountId += "%";
            password += "%";

            statement = conn.prepareStatement("select * from accountdb where accountId like ? and password like ? and accountType like ?");
            statement.setString(1, accountId);
            statement.setString(2, password);
            statement.setString(3, "GUEST%");
            result = statement.executeQuery();

            System.out.println("Account Search Succeded");
            while (result.next()) {
                guestAccounts.add(new GuestAccount(result.getString(1),result.getString(2), "ACTIVE"));
            }
            statement.close();
            if (guestAccounts.isEmpty())
                System.out.println("Guest Login Failed");
            else
                System.out.println("Guest Login Succeded");
        } catch (SQLException ex) {
            System.out.println("Account Search Failed");
        }

        return guestAccounts;
    }

    public ArrayList<Room> searchRoom(String roomStyle, String roomStatus) {
        ArrayList<Room> rooms=new ArrayList<>();
        try {
            roomStyle += "%";
            roomStatus += "%";
            statement = conn.prepareStatement("select * from roomdb where style like ? and status like ?");
            statement.setString(1, roomStyle);
            statement.setString(2, roomStatus);
            result = statement.executeQuery();


            System.out.println("Room Search Succeded");
            while (result.next()) {
                rooms.add(new Room(result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
            }
            statement.close();
            if (rooms.isEmpty())
                System.out.println("No Such Room Is Available");
            else
                System.out.println("Room Is Available");

        } catch (SQLException ex) {
            System.out.println("Room Search Failed");
        }
        return rooms;
    }

    public ArrayList<RoomBooking> searchRoomBooking(String reservationNumber) {
        ArrayList<RoomBooking> roomBookings=new ArrayList<>();
        try {
            reservationNumber += "%";
            statement = conn.prepareStatement("select * from roombookingdb where reservationNumber like ?");
            statement.setString(1, reservationNumber);
            result = statement.executeQuery();


            while (result.next()) {
                roomBookings.add(new RoomBooking(result.getDate(2), result.getString(3), result.getString(4),result.getString(5)));
            }
            statement.close();
            System.out.println("RoomBooking Search Succeded");
            if (roomBookings.isEmpty())
                System.out.println("RoomBooking Doesnt Exist");
            else
                System.out.println("RoomBooking Exists");
        } catch (SQLException ex) {
            System.out.println("RoomBooking Search Failed");
        }
        return roomBookings;
    }

    public ArrayList<RoomService> searchRoomServices(String reservationNumber) {
        ArrayList<RoomService> roomServices=new ArrayList<>();
        reservationNumber+="%";
        try {
            statement = conn.prepareStatement("select * from roomservicedb where reservationNumber like ?");
            statement.setString(1, reservationNumber);
            result = statement.executeQuery();


            System.out.println("RoomServices Search Succeded");
            while (result.next()) {
                roomServices.add(new RoomService(result.getString(2), result.getString(3), result.getDate(4), result.getString(5)));
            }
            statement.close();
            if (roomServices.isEmpty())
                System.out.println("No RoomService Ordered");
            else
                System.out.println("RoomService were Ordred");

        } catch (SQLException ex) {
            System.out.println("Room Search Failed");
        }
        return roomServices;
    }

}
