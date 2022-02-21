package com.Lopputyo.Javalol;

public class Oppilaat {
    public String fname;
    public String lname;
    public String address;
    public String opiskelijaID;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpiskelijaID() {
        return opiskelijaID;
    }

    public void setOpiskelijaID(String opiskelijaID) {
        this.opiskelijaID = opiskelijaID;
    }

    public Oppilaat(String fname, String lname, String address, String opiskelijaID) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.opiskelijaID = opiskelijaID;

    }
}


