package hotelmanage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Hotel hotel = new Hotel();
        Room room;
        Scanner scc = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        String name;
        int age;
        int priceDay;
        String passport;
        int choice = -1;
        while (choice != 5) {
//            hotel.setPersonList(FileHotel.readFile("personA.csv"));
            System.out.println("Chào mừng bạn đến");
            System.out.println("1.Thêm người vào phòng");
            System.out.println("2.Xóa người khỏi phòng");
            System.out.println("3.Tính tiền ");
            System.out.println("4.Hiển thị tất cả khách thuê phòng ");
            System.out.println("5.Thoát");
            System.out.print("Nhập lựa chọn : ");
            choice = checkException(scs);
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên : ");
                    name = scc.nextLine();
                    age = checkExceptionNumber("Nhập tuổi : ");
                    System.out.println("Nhập cmt : ");
                    passport = scc.nextLine();
                    if (hotel.findByPassport(passport) == -1) {
                        priceDay = checkExceptionNumber("Nhập ngày thuê phòng : ");
                        int choice_1 = -1;
                        while (choice_1 != 0) {
                            System.out.println("Mời bạn chọn phòng ");
                            System.out.println("1.Phòng loại A");
                            System.out.println("2.Phòng loại B");
                            System.out.println("3.Phòng loại C");
                            System.out.println("0.Thoát");
                            System.out.print("Nhập lựa chọn : ");
                            choice_1 = checkException(scs);
                            switch (choice_1) {
                                case 1:
                                    room = new RoomA();
                                    hotel.add(new Person(name, age, passport, room, priceDay));
                                    System.out.println("Bạn đã thêm thành công " + name + " vào phòng " + room.getCategory());
                                    FileHotel.writeFile("personA.csv", hotel.getPersonList());
                                    choice_1 = 0;
                                    break;
                                case 2:
                                    room = new RoomB();
                                    hotel.add(new Person(name, age, passport, room, priceDay));
                                    System.out.println("Bạn đã thêm thành công " + name + " vào phòng " + room.getCategory());
                                    FileHotel.writeFile("personA.csv", hotel.getPersonList());
                                    choice_1 = 0;
                                    break;
                                case 3:
                                    room = new RoomC();
                                    hotel.add(new Person(name, age, passport, room, priceDay));
                                    System.out.println("Bạn đã thêm thành công " + name + " vào phòng " + room.getCategory());
                                    FileHotel.writeFile("personA.csv", hotel.getPersonList());
                                    choice_1 = 0;
                                    break;
                            }
                        }
                    } else System.out.println("cmt đã tồn tại!!");
                    break;
                case 2:
                    System.out.println("Mời bạn nhập cmt người cần xóa ");
                    passport = scc.nextLine();
                    hotel.delete(passport);
                    FileHotel.writeFile("personA.csv", hotel.getPersonList());
                    break;
                case 3:
                    System.out.println("Nhập cmt ");
                    passport = scc.nextLine();
                    System.out.println("Bạn có xác nhận thanh toán hay không y/n !!!");
                    String flag = scc.nextLine();
                    if (flag.equals("y")) {
                        System.out.println("Tiền bạn phải thanh toán là : " + hotel.result(passport));
                        hotel.delete(passport);
                    }
                    break;
                case 4:
                    System.out.println("Tất cả các khách là");
                    hotel.displayAll();
                    break;

            }
        }
    }

    private static int checkException(Scanner scs) {
        int choice;
        try {
            choice = scs.nextInt();
            if (choice > 5 || choice < 1) {
                throw new Exception();
            }
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Chỉ được nhập số !!!!" + ANSI_RESET);
            scs.nextLine();
            choice = -1;
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Chỉ được nhập số từ 1 đến 5 !!!" + ANSI_RESET);
            choice = -1;
        }
        return choice;
    }


    private static int checkExceptionNumber(String message) {
        int choice = -1;
        Scanner scs = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            try {
                System.out.println(message);
                choice = scs.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Chỉ được nhập số !!!!!" + ANSI_RESET);
                scs.nextLine();
            }
        }
        return choice;
    }


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}
