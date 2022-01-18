import DBClasses.*;
import JavaClasses.*;
import java.sql.Date;


public class Console {
    public static void main(String[] args) {
        DBManager      m=new DBManager();
        DBReceptionist r=new DBReceptionist();
        DBServer       s=new DBServer();
        DBGuest        g=new DBGuest();
/*
        r.receptionistLogin("4","R0000");
        System.out.println(r.searchRoom("STANDARD","AVAILABLE"));
        System.out.println(r.searchRoomServices("2"));
        System.out.println(r.searchRoomByNumber("7"));
        System.out.println(r.searchRoomBooking("2"));
        System.out.println(r.getRooms());
        System.out.println(r.searchGuest("11113068"));
        r.deleteRoom("9");
        r.updateRoom("8",new Room("DELUXE","NOT AVAILABLE","6969","0"));

        r.updateRoomBooking("2",new RoomBooking(new Date(10,10,10),"69","7","11113068"));
        r.deleteRoomBooking("2");

*/
        //g.guestLogin("1","Guest2");
        //System.out.println(g.searchRoom("DELUXE","NOT AVAILABLE"));
        //r.searchRoomByNumber("7");
        //System.out.println(g.searchRoomServices("3"));
        //System.out.println(g.searchRoomBooking("2"));

        /*
        m.addReceptionistAccount(new ReceptionistAccount("R1234","ACTIVE"));
        m.addReceptionist(new Receptionist("R0","R0","R0","R0","R0"));

        m.addServerAccount(new ServerAccount("S1234","ACTIVE"));
        m.addServer(new Server("S0","S0","S0","S0","S0"));
        */
        //m.updateReceptionist("9",new Receptionist("R1","R1","R1","R1","R1"));
        //m.updateServer("10",new Server("S1","S1","S1","S1","S1"));
/*
        m.deleteServer("10");
        m.blockServerAccount("10");

        m.deleteReceptionist("9");
        m.deleteReceptionist("9");

        s.addRoomService(new RoomService("SEX","1000",new Date(1,1,1),"4"));

        System.out.println(s.serverLogin("11","S1234"));
*/

        System.out.println(r.receptionistLogin("10","R1234"));
        System.out.println(g.guestLogin("13","G1234"));
        System.out.println(s.serverLogin("11","S1234"));










        //System.out.println(r.searchRoom("STANDARD","AVAILABLE"));

        //r.addRoomBooking(new RoomBooking(new Date(20,20,20),"20","10","G3"));

        //s.addRoomService(new RoomService("vodka","400",new Date(10,10,10),"2"));
        //s.addRoomService(new RoomService("beer","300",new Date(10,10,10),"2"));
        //s.addRoomService(new RoomService("coke","200",new Date(10,10,10),"2"));
        //System.out.println(r.issueInvoice("2"));
        //r.addInvoice(r.issueInvoice("2"));

        //r.addGuestAccount(new GuestAccount("Guest2","Active"));
        //r.addGuest(new Guest("3","3","3","3","3"));
        //m.addReceptionistAccount(new ReceptionistAccount("R0000","ACTIVE"));
          // m.addReceptionist(new Receptionist("R0","R0","R0","R0","R0"));
        //m.addServerAccount(new ServerAccount("Server0","Active"));
        //m.addServer(new Server("6","6","S6","6","6"));

       // r.addRoom(new Room("STANDARD","AVAILABLE","100","0"));

        //r.addGuest(new Guest("G3","G3","G3","G3","G3"));
        //r.addRoomBooking(new RoomBooking(new Date(20,20,20),"1","8","G3"));
        //r.addRoomBooking(new RoomBooking(new Date(20,20,20),"2","Room1","1"));
        //r.addGuestAccount(new GuestAccount(0,"Guest2","Active"));
        //r.addGuest(new Guest("0","0","0","0","0"));
               /*
        r.addGuestAccount(new GuestAccount("Guest1","Active"));
        r.addGuest(new Guest("1","1","1","1","1"));
        r.addGuestAccount(new GuestAccount("Guest2","Active"));
        r.addGuest(new Guest("2","2","2","2","2"));



        m.addReceptionistAccount(new ReceptionistAccount("Recep0","Active"));
        m.addReceptionist(new Receptionist("3","3","3","3","3"));
        m.addReceptionistAccount(new ReceptionistAccount("Recep1","Active"));
        m.addReceptionist(new Receptionist("4","4","4","4","4"));
        m.addReceptionistAccount(new ReceptionistAccount("Recep2","Active"));
        m.addReceptionist(new Receptionist("5","5","5","5","5"));


        m.addServerAccount(new ServerAccount("Server0","Active"));
        m.addServer(new Server("6","6","6","6","6"));
        m.addServerAccount(new ServerAccount("Server1","Active"));
        m.addServer(new Server("7","7","7","7","7"));
        m.addServerAccount(new ServerAccount("Server2","Active"));
        m.addServer(new Server("8","8","8","8","8"));

        r.addRoom(new Room("STANDARD","AVAILABLE","100","0"));
        r.addRoom(new Room("DELUXE","AVAILABLE","500","1"));
        r.addRoom(new Room("BUSINESS_SUIT","AVAILABLE","1000","1"));


        r.addRoomBooking(new RoomBooking(new Date(20,20,20),"1","Room0","0"));
        r.addRoomBooking(new RoomBooking(new Date(20,20,20),"2","Room1","1"));
        r.addRoomBooking(new RoomBooking(new Date(20,20,20),"3","Room2","2"));

        s.addRoomService(new RoomService("Cake","10",new Date(10,10,10),"RoomBooking0"));
        s.addRoomService(new RoomService("Sode","10",new Date(20,20,20),"RoomBooking0"));
        s.addRoomService(new RoomService("Dinner","50",new Date(20,20,20),"RoomBooking0"));

        System.out.println(r.issueInvoice("RoomBooking0"));
        System.out.println(r.issueInvoice("RoomBooking1"));
        System.out.println(r.issueInvoice("RoomBooking2"));

        System.out.println(r.issueInvoice("RoomBooking0"));
        r.addInvoice(r.issueInvoice("RoomBooking0"));
        r.addInvoice(r.issueInvoice("RoomBooking1"));
        r.addInvoice(r.issueInvoice("RoomBooking2"));*/

        //r.addRoom(new Room("FAMILLE","AVAILABLE","300","0"));

    }
}
