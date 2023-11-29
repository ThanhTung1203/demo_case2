package C2.Invoice;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManageInvoice {


    public static void writeInvoice(String path, List<Invoice> listInvoice) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            StringBuilder str = new StringBuilder("id_room, nameCustomer, phone, checkinTime, checkoutTime, Payment \n");
            for (Invoice invoices : listInvoice
            ) {
                str.append(invoices.getIdRoom()).append(",")
                        .append(invoices.getNameCustomer()).append(",")
                        .append(invoices.getPhoneNumber()).append(",")
                        .append(invoices.getCheckInTime()).append(",")
                        .append(invoices.getCheckOutTime()).append(",")
                        .append(invoices.getPayment()).append("\n");
            }
            bufferedWriter.write(str.toString());
        }
    }


    public static List<Invoice> readInvoice(String path) {
        List<Invoice> invoices = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String content = br.readLine();
            while ((content = br.readLine()) != null) {
                String[] value = content.split(",");
                String id = value[0];
                String name = value[1];
                String phone = (value[2]);
                LocalDate start = LocalDate.parse(value[3]);
                LocalDate end = LocalDate.parse(value[4]);
                double payment = Double.parseDouble(value[5]);
                Invoice invoice = new Invoice(id, name, phone, start, end, payment);
                invoices.add(invoice);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return invoices;
    }

    List<Invoice> listInvoice;

    public ManageInvoice(){
        listInvoice = readInvoice("chubin.csv");
    }

    public void showListInvoice() {
        for (Invoice invoice : listInvoice
        ) {
            System.out.println(invoice);
        }

    }
    public List<Invoice> getListInvoice() {
        return listInvoice;
    }



    public void checkout(Invoice invoice) {
        listInvoice.add(invoice);
    }
}
