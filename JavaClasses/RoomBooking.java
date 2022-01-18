package JavaClasses;

import java.sql.Date;

public class RoomBooking {
    public static int id=0;
    private String reservationNumber;
    private Date checkIn;
    private String nDays;
    private String roomNumber;
    private String guestCIN;

    public RoomBooking(Date checkIn, String nDays, String roomNumber, String guestCIN) {
        this.checkIn = checkIn;
        this.nDays = nDays;
        this.roomNumber = roomNumber;
        this.guestCIN=guestCIN;
    }
    public RoomBooking(String reservationNumber,Date checkIn, String nDays, String roomNumber, String guestCIN) {
        this.checkIn = checkIn;
        this.nDays = nDays;
        this.roomNumber = roomNumber;
        this.guestCIN=guestCIN;
        this.reservationNumber=reservationNumber;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public String getnDays() {
        return nDays;
    }

    public void setnDays(String nDays) {
        this.nDays = nDays;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String room) {
        this.roomNumber = roomNumber;
    }

    public String getGuestCIN() {
        return guestCIN;
    }

    public void setGuest(String guestCINe) {
        this.guestCIN = guestCIN;
    }

    @Override
    public String toString() {
        return "RoomBooking{" +
                "reservationNumber='" + reservationNumber + '\'' +
                ", checkIn=" + checkIn +
                ", nDays=" + nDays +
                ", roomNumber='" + roomNumber + '\'' +
                ", guestCIN='" + guestCIN + '\'' +
                '}';
    }
}
