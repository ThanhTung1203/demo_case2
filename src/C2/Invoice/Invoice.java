package C2.Invoice;

import java.time.LocalDate;

public class Invoice {
    private String nameCustomer;
    private String phoneNumber;
    private String idRoom;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private double payment;

    public Invoice(String idRoom, String nameCustomer,
                   String phoneNumber, LocalDate checkInTime,
                   LocalDate checkOutTime, double payment) {
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.idRoom = idRoom;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.payment = payment;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDate getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDate checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "nameCustomer='" + nameCustomer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idRoom='" + idRoom + '\'' +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", payment=" + payment +
                '}';
    }
}
