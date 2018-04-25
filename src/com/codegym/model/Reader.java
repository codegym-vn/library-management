package com.codegym.model;

public class Reader {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String avatar;

    public Reader() {
    }

    public Reader(String name, String email, String address, String phone, String avatar) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
    }

    public Reader(int id, String name, String email, String address, String phone, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
