package JavaClasses;

public class Room {
    private String roomNumber;
    private String style;
    private String status;
    private String bookingPrice;
    private String isSmoking;


    public Room(String style, String status, String bookingPrice, String isSmoking) {
        this.style = style;
        this.status = status;
        this.bookingPrice = bookingPrice;
        this.isSmoking = isSmoking;
    }
    public Room(String roomNumber,String style, String status, String bookingPrice, String isSmoking) {
        this.style = style;
        this.status = status;
        this.bookingPrice = bookingPrice;
        this.isSmoking = isSmoking;
        this.roomNumber=roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public String isSmoking() {
        return isSmoking;
    }

    public void setSmoking(String smoking) {
        isSmoking = smoking;
    }


    @Override
    public String toString() {
        return "roomNumber : "+roomNumber+" | "+" style : "+style+" | "+" status : "+status+" | "+" bookingPrice : "+bookingPrice+" | "+" isSmoking : "+isSmoking;
    }
}
