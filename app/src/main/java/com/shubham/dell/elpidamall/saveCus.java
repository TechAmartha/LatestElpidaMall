package com.shubham.dell.elpidamall;

public class saveCus
{
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public saveCus() {
    }

    public saveCus(String email, String addr, String name, String phone, String dob) {
        this.email = email;

        this.addr = addr;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
    }

    public String getAddr() {
        return addr;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDob() {
        return dob;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    String email,addr,name,phone,dob;

}
