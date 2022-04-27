package com.view;

import java.util.Scanner;

public class Main {
    public Main() {
        PhoneBookView phoneBookView =new PhoneBookView();
        Scanner scanner =new Scanner(System.in);
        System.out.println("1. Thêm số điện thoại");
        System.out.println("2. Hiển thị danh bạ");
        System.out.println("3. Xóa điện thoại");
        System.out.println("4. Sửa thông tin danh bạ");
        System.out.println("5. Tìm kiếm số diện thoại");
        System.out.println("6. Thoát");
        System.out.println("Chọn chức năng: ");
        int chooseMenu =scanner.nextInt();
        switch (chooseMenu){
            case 1:
                phoneBookView.formCreatePhoneBook();
                break;
            case 2:
                phoneBookView.showListPhoneBook();
                break;
            case 3:
                phoneBookView.deletePhoneBook();
                break;
            case 4:
                phoneBookView.editPhoneNumber();
                break;
            case 5:
                phoneBookView.searchNumber();
                break;
            case 6:
                phoneBookView.exit();
                break;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
