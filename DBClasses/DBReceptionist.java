package DBClasses;

import JavaClasses.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBReceptionist {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public DBReceptionist() {
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

    public String addRoom(Room room) {
        try {
            String insertQuery="insert into roomdb  values(?,?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1,room.getRoomNumber());
            statement.setString(2,room.getStyle());
            statement.setString(3,room.getStatus());
            statement.setString(4,room.getBookingPrice());
            statement.setString(5,room.isSmoking());

            statement.execute();
            statement.close();

            return "InsertQuery of Room Class Succeded";
        } catch (SQLException e) {
            return "InsertQuery of Room Class Failed";
        } finally {
            flushStatmentOnly();
        }
    }

    public String updateRoom(String roomNumber,Room room) {
        try {
            String updateQuery = "update roomdb set style = ?,status = ?,bookingPrice = ?,isSmoking = ? where roomNumber = ?";

            statement = conn.prepareStatement(updateQuery);
            statement.setString(1,room.getStyle());
            statement.setString(2,room.getStatus());
            statement.setString(3,room.getBookingPrice());
            statement.setString(4,room.isSmoking());
            statement.setString(5,roomNumber);

            statement.executeUpdate();
            statement.close();

            return "InsertQuery of Room Class Succeded";
        } catch (SQLException e) {
            return "InsertQuery of Room Class Failed";
        } finally {
            flushStatmentOnly();
        }
    }

    public String deleteRoom(String roomId) {

        try {
            String deleteQuery = "delete from roomdb where roomNumber=" + roomId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            statement.close();

            return "Delete of Room Class Succeded";
        } catch (SQLException ex) {
            return "Delete of Room Class Failed";
        } finally {
            flushStatmentOnly();
        }
    }
    public ArrayList<Room> searchRoomByNumber(String roomNumber) {
        ArrayList<Room> rooms=new ArrayList<>();
        try {
            roomNumber += "%";
            statement = conn.prepareStatement("select * from roomdb where roomNumber like ?");
            statement.setString(1, roomNumber);
            result = statement.executeQuery();

            System.out.println("Room Search Succeded");
            while (result.next()) {
                rooms.add(new Room(result.getString(1),result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
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



    public ArrayList<Room> searchRoom(String roomStyle, String roomStatus , String isSomking) {
        ArrayList<Room> rooms=new ArrayList<>();
        try {
            roomStyle += "%";
            roomStatus += "%";
            statement = conn.prepareStatement("select * from roomdb where style like ? and status like ? and isSmoking like ?");
            statement.setString(1, roomStyle);
            statement.setString(2, roomStatus);
            statement.setString(3, isSomking);
            result = statement.executeQuery();


            while (result.next()) {
                rooms.add(new Room(result.getString(1),result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
            }
            statement.close();
            System.out.println("Room Search Succeded");
            if (rooms.isEmpty())
                System.out.println("No Such Room Is Available");
            else
                System.out.println("Room Is Available");
        } catch (SQLException ex) {
            System.out.println("Room Search Failed");
        }

        return rooms;
    }

    public ArrayList<Guest> searchGuest(String CIN) {
        ArrayList<Guest> guests=new ArrayList<>();
        try {
            CIN += "%";
            statement = conn.prepareStatement("select * from persondb,accountdb where CIN like ? and accountType like ? and persondb.accountId=accountdb.accountId");
            statement.setString(1, CIN);
            statement.setString(2, "GUEST%");
            result = statement.executeQuery();


            System.out.println("Guest Search Succeded");
            while (result.next()) {
                guests.add(new Guest(result.getString(2), result.getString(3), result.getString(4), result.getString(5),result.getString(6)));
            }
            statement.close();

            if (guests.isEmpty())
                System.out.println("No Such Guest Is Available");
            else
                System.out.println("Guest Is Available");
        } catch (SQLException ex) {
            System.out.println("Guest Search Failed");
        }

        return guests;
    }
    public void addGuestAccount(GuestAccount guestAccount) {
        try {
            String insertQuery="insert into accountdb values(?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1, guestAccount.getAccountId());
            statement.setString(2,guestAccount.getPassword());
            statement.setString(3,"GUEST");
            statement.setString(4,guestAccount.getStatus());


            statement.execute();
            statement.close();

            System.out.println("InsertQuery of GuestAccount Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of GuestAccount Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void addGuest(Guest guest) {
        try {
            String insertQuery="insert into persondb values(?,?,?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1,guest.getFname());
            statement.setString(2,guest.getLname());
            statement.setString(3,guest.getCIN());
            statement.setString(4,guest.getEmail());
            statement.setString(5,guest.getPhone());
            statement.setString(6,guest.getGuestAccountId());

            statement.execute();
            statement.close();

            System.out.println("InsertQuery of Guest Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of Guest Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void addRoomBooking(RoomBooking roomBooking) {
        try {
            String insertQuery="insert into roombookingdb  values(?,?,?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1,roomBooking.getReservationNumber());
            statement.setObject(2,roomBooking.getCheckIn());
            statement.setString(3,roomBooking.getnDays());
            statement.setString(4,roomBooking.getRoomNumber());
            statement.setString(5,roomBooking.getGuestCIN());

            statement.execute();
            statement.close();


            System.out.println("InsertQuery of RoomBooking Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of RoomBooking Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void updateRoomBooking(String reservationNumber,RoomBooking roomBooking) {
        try {
            String updateQuery = "update roombookingdb set checkIn = ?,nDays = ?,roomNumber = ?,CIN = ? where reservationNumber = ?";

            statement = conn.prepareStatement(updateQuery);
            statement.setObject(1,roomBooking.getCheckIn());
            statement.setString(2,roomBooking.getnDays());
            statement.setString(3,roomBooking.getRoomNumber());
            statement.setString(4,roomBooking.getGuestCIN());
            statement.setString(5,reservationNumber);

            statement.execute();
            statement.close();


            System.out.println("Update of RoomBooking Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Update of RoomBooking Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public void deleteRoomBooking(String reservationNumber) {

        try {
            String deleteQuery = "delete from roombookingdb where reservationNumber = ?";

            statement = conn.prepareStatement(deleteQuery);
            statement.setString(1,reservationNumber);
            statement.executeUpdate();
            statement.close();


            System.out.println("Delete of RoomBooking Class Succeded");
        } catch (SQLException ex) {
            System.out.println("Delete of RoomBooking Class Failed");
        } finally {
            flushStatmentOnly();
        }
    }

    public ArrayList<ReceptionistAccount> receptionistLogin(String accountId, String password) {
        ArrayList<ReceptionistAccount> receptionistAccounts=new ArrayList<>();
        try {

            statement = conn.prepareStatement("select * from accountdb where accountId = ? and password = ? and accountType = ?");
            statement.setString(1, accountId);
            statement.setString(2, password);
            statement.setString(3, "RECEPTIONIST");
            result = statement.executeQuery();


            System.out.println("Account Search Succeded");
            while (result.next()) {
                receptionistAccounts.add(new ReceptionistAccount(result.getString(1),result.getString(2),"ACTIVE"));
            }
            statement.close();

            if (receptionistAccounts.isEmpty())
                System.out.println("Receptionist Login Failed");
            else
                System.out.println("Receptionist Login Succeded");

        } catch (SQLException ex) {
            System.out.println("Account Search Failed");
        }
        return receptionistAccounts;
    }

    public ArrayList<RoomBooking> searchRoomBooking(String reservationNumber) {
        ArrayList<RoomBooking> roomBookings=new ArrayList<>();
        try {
            reservationNumber += "%";
            statement = conn.prepareStatement("select * from roombookingdb where reservationNumber like ?");
            statement.setString(1, reservationNumber);
            result = statement.executeQuery();

            while (result.next()) {
                roomBookings.add(new RoomBooking(result.getString(1),result.getDate(2), result.getString(3), result.getString(4),result.getString(5)));
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

    public Invoice issueInvoice(String reservationNumber) {
        try {
            Double rs=0.0,bp=0.0,nd=0.0;
            reservationNumber+="%";
            statement = conn.prepareStatement("select sum(roomservicedb.amount) from roomservicedb where reservationNumber like ? ");
            statement.setString(1, reservationNumber);
            result = statement.executeQuery();
            while (result.next())
                rs = result.getDouble(1);

            String roomNumber=searchRoomBooking(reservationNumber).get(0).getRoomNumber();

            String searchQuery1 =("select bookingPrice from roomdb where roomNumber like ?");
            statement = conn.prepareStatement(searchQuery1);
            statement.setString(1, roomNumber+"%");
            result = statement.executeQuery();
            while (result.next())
                bp=Double.parseDouble(result.getString(1));


            String searchQuery2 =("select nDays from roombookingdb where reservationNumber like ?");
            statement = conn.prepareStatement(searchQuery2);
            statement.setString(1, reservationNumber);
            result = statement.executeQuery();
            while (result.next()){
                nd=Double.parseDouble(result.getString(1));
            }
            System.out.println("Invoice Issue Succeded");


            Invoice invoice=new Invoice(rs+bp*nd,reservationNumber.substring(0, reservationNumber.length() - 1));
            return invoice ;

        } catch (SQLException ex) {
            System.out.println("Invoice Issue Failed");
        }
        return new Invoice(0, null);
    }

    public void addInvoice(Invoice invoice) {
        try {
            String insertQuery="insert into invoicedb  values(?,?,?)";

            statement = conn.prepareStatement(insertQuery);
            statement.setString(1,invoice.getInvoiceId());
            statement.setDouble(2,invoice.getAmount());
            statement.setString(3,invoice.getReservationNumber());

            statement.execute();
            statement.close();

            System.out.println("InsertQuery of Invoice Class Succeded");
        } catch (SQLException e) {
            System.out.println("InsertQuery of Invoice Class Failed");
        } finally {
            flushStatmentOnly();
        }
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

    public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String searchQuery = "SELECT * FROM roomdb";
            statement = conn.prepareStatement(searchQuery);
            result = statement.executeQuery();

            System.out.println("Search Succeded");
            while (result.next()) {
                rooms.add(new Room(result.getString(1),result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
            }
            statement.close();
            if (rooms.isEmpty())
                System.out.println("No Room Exists");
            else
                System.out.println("Room Exists");
        } catch (SQLException ex) {
            System.out.println("Search Failed");
        }

        return rooms;
    }


}

