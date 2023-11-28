package C2.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    managerG menu = new managerG();
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
                                managerG.writeRoom("dcmm.csv", menu.getListRoom());
                                break;
                            case 3:
                                System.out.println("nhập ID phòng muốn sửa :");
                                int addID = scanner.nextInt();
                                menu.editRoom(addID);
                                managerG.writeRoom("dcmm.csv", menu.getListRoom());
                                break;
                            case 4:
                                System.out.println("nhâ Id phòng muốn xóa :");
                                int deleteRoom = scanner.nextInt();
                                menu.deleteRoom(deleteRoom);
                                managerG.writeRoom("dcmm.csv", menu.getListRoom());
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
                                menu.showListInvoice();
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
                    System.out.println(" Mới nhập vào 1 số thông tin ");
                    System.out.println("-Nhập tên khách hàng :");
                    String nameCustomer = scanner1.nextLine();
                    System.out.println("-Nhập sđt :");
                    String phoneNumbr = scanner1.nextLine();
                    System.out.println("-Nhập ID phòng muốn thuê :");
                    String idRoom = scanner1.nextLine();
                    if (menu.isIdAlreadyCheckedIn(idRoom)) {
                        System.out.println("ID đã tồn tại, vui lòng chọn ID khác.");
                    } else {
                        LocalDate start1 = LocalDate.now();
                        menu.checkin(new in4(nameCustomer, phoneNumbr, idRoom, start1));
                        System.out.println("Check-in thành công !!! ");
                    }
                    managerG.writeIn4("saveListIn4.csv", menu.getListIn4());
                    break;
                case 6:
                    System.out.println("Nhập mã hóa đơn muốn checkout ");
                    String id = scanner1.nextLine();
                    System.out.println("Nhập vào thời gian checkout (yyyy/mm/dd)");
                    String checkoutTime = scanner1.nextLine();
                    System.out.println("---Hóa đơn của bạn---");
                    menu.checkout(id, LocalDate.parse(checkoutTime));
                    System.out.println("checkout thành công , cảm ơn ");
//                    double payment = menu.payment(id, start, checkoutTime);
                    break;
                case 7:
                    System.out.println("Chào mừng bạn đến với khách sạn bố đời ");
                    menu.exit();
            }
        } while (choice != 0);

    }
}
