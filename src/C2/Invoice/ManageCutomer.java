package C2.Invoice;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ManageCutomer {


   public List<Customer> listIn4;



    public List<Customer> getListIn4() {
        return listIn4;
    }

    void checkin(Customer inf) {
        listIn4.add(inf);
    }
    public void showListIn4() {
        for (Customer sss:listIn4
        ) {
            System.out.println(sss);

        }
    }



    public int payment(int roomId, LocalDate start, LocalDate end) {
        ManageRoom m1= new ManageRoom();
        int numberOfDays = (int) start.until(end, ChronoUnit.DAYS);
        double roomPrice =m1.getPriceRoom(roomId);
        return (int) (roomPrice * numberOfDays);
    }
    public boolean isIdAlreadyCheckedIn(String id) {
        for (Customer checkIn : listIn4) {
            if (checkIn.getIdR().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public boolean isIdAlreadyCheckedOut(String id) {
        for (Customer checkIn : listIn4) {
            if (checkIn.getIdR().equals(id) ) {
                return true;
            }
        }
        return false;
    }

    public LocalDate getCheckinTimeById(String id) {
        for (Customer checkIn : listIn4) {
            if (checkIn.getIdR().equals(id)) {
                return checkIn.getStart();
            }
        }
        return null;
    }

    public static void writeIn4(String path, List<Customer> listIn4) {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            StringBuilder str = new StringBuilder("name_customer, phonenumber, id_room, checkinTime\n");
            for (Customer in4 : listIn4) {
                str.append(in4.getName_customer()).append(",")
                        .append(in4.getPhoneNumber()).append(",")
                        .append(in4.getIdR()).append(",")
                        .append(in4.getStart()).append("\n");
            }
            bufferedWriter.write(str.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }



    public static List<Customer> readIn4(String path) {
        List<Customer> in4List = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String content = br.readLine();
            while ((content = br.readLine()) != null) {
                String[] value = content.split(",");
                String nameC = value[0];
                String phoneC = value[1];
                String idC = value[2];
                LocalDate checkC = LocalDate.parse(value[3]);
                Customer in4 = new Customer(nameC, phoneC, idC, checkC);
                in4List.add(in4);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return in4List;
    }
    public ManageCutomer() {
        listIn4 = readIn4("save.csv");
    }
    public Customer findCustomerById(String id) {
        for (Customer customer : listIn4) {
            if (customer.getIdR().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}






