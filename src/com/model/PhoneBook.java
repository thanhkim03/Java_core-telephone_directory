package com.model;

import java.io.Serializable;

public class PhoneBook implements Serializable {
   public String phoneNumber;
   public String group;
   public String name;
   public String sex;
   public String live;

    public PhoneBook(String phoneNumber, String group, String name, String sex, String live) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.live = live;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public PhoneBook(){
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "PhoneBook:" +
                "phoneNumber= " + phoneNumber +
                ", group= " + group +
                ", name= " + name +
                ", sex= " + sex +
                ", live= " + live +
                "\n";
    }
}
