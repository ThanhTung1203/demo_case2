package C2.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    ManageRoom menu = new ManageRoom();
    ManageCutomer menu1 = new ManageCutomer();
    ManageInvoice menu2 = new ManageInvoice();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);

    public void showMenu() throws IOException {
        int choice;
        do {
            System.out.println("---MENU---");
            System.out.println("1.ListRoom");
            System.out.println("2.ListInvoice");
            System.out.println("3.FindRoomByPrice");
            System.out.println("4.FindRoomBySTT");
            System.out.println("5.Checkin");
            System.out.println("6.Checkout");
            System.out.println("7.Exit");
            System.out.println("Lựa chọn : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int choose;
                    do {
                        System.out.println("---ListRoom---");
                        System.out.println("1.Hiển thị danh sách phòng");
                        System.out.println("2.Thêm phòng");
                        System.out.println("3.Sửa ");
                        System.out.println("4.Xóa");
                        System.out.println("5.Quay lại");
                        System.out.println("Đưa ra lựa chọn ");
                        choose = scanner.nextInt();
                        switch (choose) {
                            case 1:
                                menu.showListRoom();
                                break;
                            case 2:
                                System.out.println("Thực hiện : ");
                                System.out.println("Nhập id :");
                                int id1 = scanner.nextInt();
                                System.out.println("Nhập số phòng");
                                String num1 = scanner1.nextLine();
                                System.out.println("Nhập giá phòng");
                                double price1 = scanner.nextInt();
                                menu.addRoom(new Room(id1, num1, price1));
                                ManageRoom.writeRoom("dcmm.csv", menu.getListRoom());
                                break;
                            case 3:
                                System.out.println("nhập ID phòng muốn sửa :");
                                int addID = scanner.nextInt();
                                menu.editRoom(addID);
                                ManageRoom.writeRoom("dcmm.csv", menu.getListRoom());
                                break;
                            case 4:
                                System.out.println("nhâ Id phòng muốn xóa :");
                                int deleteRoom = scanner.nextInt();
                                menu.deleteRoom(deleteRoom);
                                ManageRoom.writeRoom("dcmm.csv", menu.getListRoom());
                                break;
                            case 5:
                                showMenu();
                                break;
                        }

                    } while (choose != 0);
                    break;
                case 2:
                    int choice1;
                    do {
                        System.out.println("----Hóa đơn ---");
                        System.out.println("1.Xem danh sách hóa đơn ");
                        System.out.println("2.In hóa đơn ( thanh toán )");
                        System.out.println("3.Thoát");
                        System.out.println("Nhập lựa chọn ");
                        choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:

                                menu2.showListInvoice();
                                break;
                            case 2:
                                menu.printInvoice();
                                break;
                            case 3:
                                showMenu();
                                break;
                            case 4:
                                menu.exit();
                                break;
                        }
                    } while (choice1 != 0);

                    break;
                case 3:
                    System.out.println("nhập fromPrice :");
                    double fromPrice = scanner.nextDouble();
                    System.out.println("nhập toPrice :");
                    double toPrice = scanner.nextDouble();
                    menu.findRoomByPrice(fromPrice, toPrice);
                    break;
                case 4:
                    menu.findRoomByStt(true);
                    break;
                case 5:
                    menu.showListRoom();
                    System.out.println(" Mới nhập vào 1 số thông tin ");
                    System.out.println("-Nhập tên khách hàng :");
                    String nameCustomer = scanner1.nextLine();
                    System.out.println("-Nhập sđt :");
                    String phoneNumbr = scanner1.nextLine();
                    System.out.println("-Nhập ID phòng muốn thuê :");
                    String idRoom = scanner1.nextLine();
                    if (!menu1.isIdAlreadyCheckedIn(idRoom)) {
                        LocalDate start1 = LocalDate.now();
                        menu1.checkin(new Customer(nameCustomer, phoneNumbr, idRoom, start1));
                        System.out.println("Check-in thành công !!! ");
                        ManageCutomer.writeIn4("save.csv", menu1.getListIn4());
                    } else {
                        System.out.println("Phòng đã có người thuê . Vui lòng chọn ID khác.");
                    }
                    break;
                case 6:
                    menu1.showListIn4();
                    System.out.println("Nhập mã hóa đơn muốn checkout ");
                    String idPayment = scanner1.nextLine();

                    if (menu1.isIdAlreadyCheckedOut(idPayment)) {

                        System.out.println("Nhập thời gian checkout (có dạng yyyy-mm-dd)");
                        String endString = scanner1.nextLine();
                        LocalDate checkoutTime = LocalDate.parse(endString);
                        LocalDate checkinTime = menu1.getCheckinTimeById(idPayment);
                        double payment = menu1.payment(Integer.parseInt(idPayment), checkinTime, checkoutTime);
                        Customer customer = menu1.findCustomerById(idPayment);
                        menu2.checkout(new Invoice(customer.getIdR(),customer.getName_customer()
                                ,customer.getPhoneNumber(),checkinTime,checkoutTime,payment));
                        ManageInvoice.writeInvoice("chubin.csv",menu2.getListInvoice());
                        System.out.println("Số tiền thanh toán: " + payment);
                    } else {
                        System.out.println("nhưu chubin");
                    }
                    break;
                case 7:
                    System.out.println("Chào mừng bạn đến với khách sạn bố đời ");
                    menu.exit();
            }
        } while (choice != 0);

    }
}
