package JavaClasses;

import java.sql.Date;

public class RoomService {
    private String serviceId;
    private String serviceDesc;
    private String amount;
    private Date requestTime;
    private String reservationNumber;

    public RoomService(String serviceDesc, String amount, Date requestTime, String reservationNumber) {

        this.serviceDesc = serviceDesc;
        this.amount = amount;
        this.requestTime = requestTime;
        this.reservationNumber=reservationNumber;
    }

    public String getreservationNumber() {
        return reservationNumber;
    }

    public void setreservationNumber(String roomBooking) {
        this.reservationNumber = reservationNumber;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}

