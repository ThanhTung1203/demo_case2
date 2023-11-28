package C2.Invoice;

import java.time.LocalDate;

public class Invoice {
    private String id_invoice;
    private String room_number;
    private LocalDate chekcin;
    private LocalDate chekcout;
    private double payment_total;

    public Invoice(String id_invoice, String room_number, LocalDate checkin, LocalDate chekcout) {
        this.id_invoice = id_invoice;
        this.room_number = room_number;
        this.chekcin = checkin;
        this.chekcout = chekcout;
        this.payment_total = payment_total;
    }

    public String getId_invoice() {
        return id_invoice;
    }

    public String getRoom_number() {
        return room_number;
    }

    public LocalDate getChekcin() {
        return chekcin;
    }

    public LocalDate getChekcout() {
        return chekcout;
    }

    public double getPayment_total() {
        return payment_total;
    }

    public void setId_invoice(String id_invoice) {
        this.id_invoice = id_invoice;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public void setChekcin(LocalDate chekcin) {
        this.chekcin = chekcin;
    }

    public void setChekcout(LocalDate chekcout) {
        this.chekcout = chekcout;
    }

    public void setPayment_total(double payment_total) {
        this.payment_total = payment_total;
    }

    @Override
    public String toString() {
        return "C2.Invoice{" +
                "id_invoice='" + id_invoice + '\'' +
                ", room_number='" + room_number + '\'' +
                ", chekcin=" + chekcin +
                ", chekcout=" + chekcout +
                ", payment_total=" + payment_total +
                '}';
    }
}
