package C2.Invoice;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class managerG {
    List<Invoice> listInvoice;
    List<Room> listRoom;
    List<in4> listIn4;

    public static List<Invoice> readInvoice(String path) {
        List<Invoice> invoices = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String content = br.readLine();
            while ((content = br.readLine()) != null) {
                String[] value = content.split(",");
                String id = value[0];
                String name = value[1];
                LocalDate start = LocalDate.parse(value[2]);
                LocalDate end = LocalDate.parse(value[3]);
                double payment = Double.parseDouble(value[4]);
                Invoice invoice = new Invoice(id, name, start, end);
                invoices.add(invoice);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return invoices;
    }

    public static List<in4> readIn4(String path) {
        List<in4> in4List = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String content = br.readLine();
            while ((content = br.readLine()) != null) {
                String[] value = content.split(",");
                String nameC = value[0];
                String phoneC = value[1];
                String idC = value[2];
                LocalDate checkC = LocalDate.parse(value[3]);
                in4 in4 = new in4(nameC, phoneC, idC, checkC);
                in4List.add(in4);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return in4List;
    }

    public static void writeIn4(String path, List<in4> listIn4) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            StringBuilder str = new StringBuilder("name_customer, phonenumber, checkinTime \n");
            for (in4 in4 : listIn4
            ) {
                str.append(in4.getName_customer()).append(",")
                        .append(in4.getPhoneNumber()).append(",")
                        .append(in4.getStart()).append(",");
            }
            bufferedWriter.write(str.toString());
        }
    }


    public managerG() {
        listRoom = readRoom("dcmm.csv");
        listIn4 = readIn4("saveListIn4.csv");
//        listInvoice = readInvoice("saveListInvoice.csv");
    }


    private List<Invoice> readInvoice() {
        return null;
    }

    public static void writeInvoice(String path, List<Invoice> listInvoice) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            StringBuilder str = new StringBuilder("id_invoice, room_number, checkinTime , checkoutTime, Payment \n");
            for (Invoice invoices : listInvoice
            ) {
                str.append(invoices.getId_invoice()).append(",")
                        .append(invoices.getRoom_number()).append(",")
                        .append(invoices.getChekcin()).append(",")
                        .append(invoices.getChekcout()).append(",")
                        .append(invoices.getPayment_total()).append("\n");
            }
            bufferedWriter.write(str.toString());
        }
    }


    public static void writeRoom(String path, List<Room> rooms) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            StringBuilder str = new StringBuilder("ID, Tên phòng, Giá phòng, trạng thái  \n");

            for (Room r : rooms) {
                String status = r.isStatus_room() ? "available" : "unavailable";
                str.append(r.getId_room()).append(",").append(r.getName_room()).append(",")
                        .append(r.getPrice()).append(",").append(status).append("\n");
            }

            bufferedWriter.write(str.toString());
        }
    }

    public static List<Room> readRoom(String path) {
        List<Room> rooms = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String content = br.readLine();
            while ((content = br.readLine()) != null) {
                String[] value = content.split(",");
                int id = Integer.parseInt(value[0]);
                String name = value[1];
                double price = Double.parseDouble(value[2]);
                Room room = new Room(id, name, price);
                rooms.add(room);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }


    public void exit() {
        System.exit(1);

    }

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }


    public void checkout(String id, LocalDate checkoutTime) {
    }


    void showListRoom() {
        for (Room dcm : listRoom
        ) {
            System.out.println(dcm);

        }
    }

    void findRoomByID(int id) {
        int index = -1;
        for (int i = 0; i < listRoom.size(); i++) {
            if (id == this.listRoom.get(i).getId_room()) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println(listRoom.get(index));
        } else {
            System.out.println("phòng không tồn tại ");
        }
    }


    void findRoomByPrice(double fromPrice, double toPrice) {
        if (fromPrice > toPrice) {
            System.out.println("Giá không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        int count = 0;
        for (int i = 0; i < this.listRoom.size(); i++) {
            double roomPrice = this.listRoom.get(i).getPrice();
            if (roomPrice >= fromPrice && roomPrice <= toPrice) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không tìm thấy phòng phù hợp");
        } else {

            System.out.println("Có " + count + " phòng phù hợp với yêu cầu của bạn :");
            for (int i = 0; i < this.listRoom.size(); i++) {
                double roomPrice = this.listRoom.get(i).getPrice();
                if (roomPrice >= fromPrice && roomPrice <= toPrice) {
                    System.out.println(this.listRoom.get(i));
                }
            }
        }
    }

    void findRoomByStt(boolean STT) {
        boolean isSTT = false;
        boolean messagePrinted = false;

        for (int i = 0; i < this.listRoom.size(); i++) {
            if (STT == this.listRoom.get(i).isStatus_room()) {
                System.out.println((!messagePrinted ? "Danh sách các phòng còn trống:\n" : "") + this.listRoom.get(i));
                messagePrinted = true;
                isSTT = true;
            }
            if (!isSTT) {
                System.out.println("Không có phòng nào còn trồng !!!");
            }
        }

    }

    void getRoomList() {
    }

    void checkRoomBySTT() {
    }

    void addRoom(Room room) {
        listRoom.add(room);

    }
    public void checkin(in4 in4) {
        listIn4.add(in4);
    }
    public boolean isIdAlreadyCheckedIn(String id) {
        for (in4 checkIn : listIn4) {
            if (checkIn.getIdR().equals(id)) {
                return true; // ID đã được check-in
            }
        }
        return false; // ID chưa được check-in
    }
    void editRoom(int id) {
        Scanner word1 = new Scanner(System.in);
        Scanner number1 = new Scanner(System.in);
        int index = -1;
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getId_room() == id) {
                index = i;
            }
        }
        if (index != -1) {
            int dcmmm;
            do {
                System.out.println("1.Sửa ID");
                System.out.println("2.Sửa tên phòng");
                System.out.println("3.Sửa giá phòng");
                System.out.println("0.Quay lại");
                System.out.println("Lựa chon :");
                dcmmm = number1.nextInt();
                switch (dcmmm) {
                    case 1:
                        System.out.println("nhập vào id mới :");
                        int id2 = number1.nextInt();
                        listRoom.get(index).setId_room(id2);
                        break;
                    case 2:
                        System.out.println("nhập vào tên phòng mới :");
                        String name2 = word1.nextLine();
                        listRoom.get(index).setName_room(name2);
                        break;
                    case 3:
                        System.out.println("nhập vào giá phòng mới :");
                        double price2 = number1.nextDouble();
                        listRoom.get(index).setPrice(price2);
                        break;
                    case 0:
                        break;
                }
            } while (dcmmm != 0);
        } else {
            System.out.println("Id không tồn tại , nhập lại ");
        }
    }

    void deleteRoom(int id) {
        int index = -1;
        for (int i = 0; i < listRoom.size(); i++) {
            if (id == this.listRoom.get(i).getId_room()) {
                index = i;
            }
        }
        if (index != -1) {
            listRoom.remove(index);
            System.out.println("Xóa thành oông phòng có id " + id);
        } else {
            System.out.println("phòng không tồn tại ");
        }
    }

    public void showListInvoice() {
        for (Invoice invoice : listInvoice
        ) {
            System.out.println(invoice);
        }

    }

    public void checkoutTime() {

    }

    public List<in4> getListIn4() {
        return listIn4;
    }

    public double getPriceRoom(int roomId) {
        for (Room room : listRoom) {
            if (roomId == room.getId_room()) {
                return room.getPrice();
            }
        }
        return 0;
    }

    public int payment(int roomId, LocalDate start, LocalDate end) {
        int numberOfDays = (int) start.until(end, ChronoUnit.DAYS);
        double roomPrice = getPriceRoom(roomId);
        return (int) (roomPrice * numberOfDays);
    }

    public void printInvoice() {

    }

    public void addInvoice() {
    }

    public void deleteInvoice() {
    }

    public void setListInvoice(List<Invoice> listInvoice) {
        this.listInvoice = listInvoice;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }
}
