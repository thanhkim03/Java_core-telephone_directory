package com.controller;

import com.model.PhoneBook;
import com.service.PhoneBookServiceIMPL;

import java.util.List;

public class PhoneBookController {
    PhoneBookServiceIMPL phoneBookServiceIMPL =new PhoneBookServiceIMPL();
    public List<PhoneBook> showListPhoneBook() {
        return phoneBookServiceIMPL.findAll();
    }
    public void createPhoneBook(PhoneBook phoneBook){
        phoneBookServiceIMPL.save(phoneBook);
        phoneBookServiceIMPL.findAll();
    }
    public void deletePhoneBook(String phoneNumber){
        phoneBookServiceIMPL.delete(phoneNumber);
    }
    public List<PhoneBook> searchPhoneNumber(String phoneNumber){
        return phoneBookServiceIMPL.search(phoneNumber);
    }
    public void editPhoneNumber(String number,String group,String name , String sex,String live){
        phoneBookServiceIMPL.edit(number,group,name,sex,live);
    }
}
