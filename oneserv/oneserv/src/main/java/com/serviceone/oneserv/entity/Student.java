package com.serviceone.oneserv.entity;

public class Student {
    private Long id;
    private String name;
    private String address;
    private  String favbook;

    public Student() {
        super();
    }

    public Student(Long id, String name, String address, String favbook) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.favbook = favbook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFavbook() {
        return favbook;
    }

    public void setFavbook(String favbook) {
        this.favbook = favbook;
    }
}
