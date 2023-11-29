package C2.Invoice;

import java.time.LocalDate;

public class Customer {

    private String name_customer;
    private String phoneNumber;
    private String idR;
    private LocalDate start;

    public Customer(String name_customer, String phoneNumber, String idR, LocalDate start) {
        this.name_customer = name_customer;
        this.phoneNumber = phoneNumber;
        this.idR = idR;
        this.start = start;
    }

    public String getIdR() {
        return idR;
    }

    public LocalDate getStart() {
        return start;
    }

    public String getName_customer() {
        return name_customer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "in4{" +
                "name_customer='" + name_customer + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idR=" + idR +
                ", start=" + start +
                '}';
    }
}

