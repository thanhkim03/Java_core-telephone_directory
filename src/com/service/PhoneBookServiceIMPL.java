package com.service;

import com.config.ConfigReadAndWriteFile;
import com.model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookServiceIMPL implements IPhoneBookService{
    public static String PATH ="D:\\MD2\\MD2_thi\\src\\com\\data\\phoneBook.txt";
    public static List<PhoneBook> phoneBooksList =new ConfigReadAndWriteFile<PhoneBook>().readFromFile(PATH);
    @Override
    public List<PhoneBook> findAll() {
        new ConfigReadAndWriteFile<PhoneBook>().writeToFile(PATH, phoneBooksList);
        return phoneBooksList;
    }
public void add(){new ConfigReadAndWriteFile<PhoneBook>().writeToFile(PATH,phoneBooksList);}
    @Override
    public void save(PhoneBook phoneBook) {
        phoneBooksList.add(phoneBook);
    }

    @Override
    public void delete(String phoneNumber) {
        for (int i = 0; i < phoneBooksList.size(); i++) {
            if (phoneBooksList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBooksList.remove(phoneBooksList.get(i));
                add();
            }
        }
    }

    @Override
    public List<PhoneBook> search(String numberPhone) {
        List<PhoneBook> phoneBooks =new ArrayList<>();
        for (int i = 0; i < phoneBooksList.size(); i++) {
            if (phoneBooksList.get(i).getPhoneNumber().equals(numberPhone)){
                phoneBooks.add(phoneBooksList.get(i));
            }
        }
        return phoneBooks;
    }

    @Override
    public void edit(String phoneNumber, String group, String name, String sex, String live) {
        for (int i = 0; i < phoneBooksList.size(); i++) {
            if (phoneBooksList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBooksList.get(i).setGroup(group);
                phoneBooksList.get(i).setName(name);
                phoneBooksList.get(i).setSex(sex);
                phoneBooksList.get(i).setLive(live);
            }
        }
    }
}
