package com.example.billbook.Model;

public class BillModel {
    String categary,billname,billnumber,date,time,satus,photo;
    int id,amountpaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }

    public String getBillName() {
        return billname;
    }

    public void setBillName(String billName) {
        this.billname = billName;
    }

    public String getBillNumber() {
        return billnumber;
    }

    public void setBillNumber(String billNumber) {
        this.billnumber = billNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(int amountpaid) {
        this.amountpaid = amountpaid;
    }
}
