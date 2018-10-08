package com.example.sys9.jsonserver2;

class BookGS {
    private String id;
    private String name;
    private String email;
    private String address;
    private String mobile;
    private String office;
    private String home;
    public String getAddress() {
        return address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    private String gender;
    public String getId() {
        return id;
    }
    public String getHome() {
        return home;
    }
    public void setHome(String home) {
        this.home = home;
    }
    public String getMobile() {
        return mobile;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
}

