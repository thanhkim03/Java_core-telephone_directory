package com.view;

import com.controller.PhoneBookController;
import com.model.PhoneBook;
import com.service.PhoneBookServiceIMPL;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBookView {
    Scanner scanner =new Scanner(System.in);
    List<PhoneBook> phoneBookList = PhoneBookServiceIMPL.phoneBooksList;
    PhoneBookController phoneBookController =new PhoneBookController();

    public void showListPhoneBook() {
        if (phoneBookList.size()==0){
            System.out.println("Danh bạ rỗng");
        }else {
            System.out.println(phoneBookController.showListPhoneBook());
        }
        System.out.println("nhấn end dể về Menu");
        String backMenu =scanner.nextLine();
        if (backMenu.equalsIgnoreCase("end")) {
            new Main();
        }
    }
    public void formCreatePhoneBook(){
            System.out.println("Nhập số điện thoại: ");
            String phoneNumber =scanner.nextLine();
            boolean checkPhoneNumber = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",phoneNumber);
            if (!checkPhoneNumber){
                System.err.println("⚠️Không được bỏ trống và viết có dấu ️");
                new Main();
            }
            System.out.println("Nhập nhóm: ");
            String group =scanner.nextLine();
            boolean checkGroup = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",group);
            if (!checkGroup){
                System.err.println("⚠️Không được bỏ trống và viết có dấu ️");
                new Main();
            }
            System.out.println("Nhập tên: ");
            String name =scanner.nextLine();
            boolean checkName = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",name);
            if (!checkName){
                System.err.println("⚠️Không được bỏ trống và viết có dấu ️");
                new Main();
            }
            System.out.println("Nhập giới tính: ");
            String sex =scanner.nextLine();
            boolean checkSex = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",sex);
            if (!checkSex){
                System.err.println("⚠️Không được bỏ trống và viết có dấu ️");
                new Main();
            }
            System.out.println("Nhập nơi ở hiện tại: ");
            String live =scanner.nextLine();
            boolean checkLive = Pattern.matches("[a-z0-9A-Z \\t\\n\\x0b\\r\\f]{1,20}",live);
            if (!checkLive){
                System.err.println("⚠️Không được bỏ trống và viết có dấu ️");
                new Main();
            }
            PhoneBook phoneBook =new PhoneBook(phoneNumber,group,name,sex,live);
            phoneBookController.createPhoneBook(phoneBook);
            System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("end")) {
                new Main();
            }
    }
    public void deletePhoneBook(){
        while (true){
            System.out.println("Nhập số điện thoại cần xóa: ");
            String phoneNumber=scanner.nextLine();
            boolean check =false;
            for (int i = 0; i < phoneBookList.size(); i++) {
                if (phoneBookList.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                    check =true;
                }
            }if (check==false){
                System.out.println("Số điện thoại không tồn tại");
                System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
                String back = scanner.nextLine();
                if (back.equalsIgnoreCase("end")) {
                    new Main();
                }
            }else {
                phoneBookController.deletePhoneBook(phoneNumber);
                System.out.println("Số điện thoại đã được xóa");
                System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
                String back = scanner.nextLine();
                if (back.equalsIgnoreCase("end")) {
                    new Main();
                }
            }
        }
    }
    public void searchNumber(){
        while (true){
            System.out.println("Nhập số điện thoại cần tìm: ");
            String phoneNumber=scanner.nextLine();
            System.out.println(phoneBookController.searchPhoneNumber(phoneNumber));
            System.out.println("Nhấn end để về menu hoặc nhập phím bất kì để tiếp tục");
            String backOut = scanner.nextLine();
            if (backOut.equalsIgnoreCase("end")) {
                new Main();
            }
        }
    }
    public void editPhoneNumber(){
        System.out.println("Nhập số diện thoại bạn cần sửa: ");
        String phoneNumber = scanner.nextLine();
        boolean check1= false;
        for (int i = 0; i <phoneBookList.size(); i++) {
            if(phoneBookList.get(i).getPhoneNumber().equals(phoneNumber)){
                check1 =true;
            }
        }
        if (check1==false){
            System.out.println("Số điện thoại ko tồn tại");
            System.out.println("Nhấn end để về menu hoặc phím bất kì để tiếp tục");
            String back = scanner.nextLine();
            if (back.equalsIgnoreCase("end")) {
                new Main();
            }
        }
        System.out.println("Nhập nhóm mới, nếu không đổi nhập skip");
        String group =scanner.nextLine();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getGroup().equals(group)){
                if (group.equalsIgnoreCase("skip")){
                    group=phoneBookList.get(i).getGroup();
                }
            }
        }
        System.out.println("Nhập tên mới, nếu không đổi nhập skip");
        String name =scanner.nextLine();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getName().equals(name)){
                if (name.equalsIgnoreCase("skip")){
                    name=phoneBookList.get(i).getName();
                }
            }
        }
        System.out.println("nhập giới tính mới,nhập skip néu không muốn thay đổi");
        String sex =scanner.nextLine();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getSex().equals(sex)){
                if (sex.equalsIgnoreCase("skip")){
                    sex=phoneBookList.get(i).getSex();
                }
            }
        }
        System.out.println("Nhập nơi ở mới,nhập skip néu không muốn thay đổi");
        String live =scanner.nextLine();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getLive().equals(live)){
                if (live.equalsIgnoreCase("skip")){
                    live=phoneBookList.get(i).getLive();
                }
            }
        }
        phoneBookController.editPhoneNumber(phoneNumber,group,name,sex,live);
        System.out.println("Nhấn end để về menu");
        String back = scanner.next();
        scanner.nextLine();
        if (back.equalsIgnoreCase("end")) {
            new Main();
        }
    }
    public void exit(){
        System.out.println("THANK YOU");
    }
}
