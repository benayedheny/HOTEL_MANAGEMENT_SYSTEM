package JavaClasses;

public class Invoice {
    private String invoiceId;
    private String reservationNumber;
    private double amount;

    public Invoice(double amount,String reservationNumber) {
        this.reservationNumber = reservationNumber;
        this.amount = amount;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String invoiceId) {
        this.reservationNumber = invoiceId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "reservationNumber='" + reservationNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
