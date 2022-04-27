package com.service;

import com.model.PhoneBook;

import java.util.List;

public interface IPhoneBookService {
    List<PhoneBook> findAll() ;
    void save(PhoneBook phoneBook);
    void delete(String phoneNumber);
    List<PhoneBook> search(String numberPhone);
    void edit(String phoneNumber,String group,String name,String sex,String live);
}
