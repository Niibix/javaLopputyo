package com.Lopputyo.Javalol;

public class Kurssit {
    public String coursename;
    public String kurssiID;
    public String opettaja;

    public String getCoursename() {
        return coursename;
    }

    public Kurssit(String opettaja) {
        this.opettaja = opettaja;
    }

    public String getOpettaja() {
        return opettaja;
    }

    public void setOpettaja(String opettaja) {
        this.opettaja = opettaja;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getKurssiID() {
        return kurssiID;
    }

    public void setKurssiID(String kurssiID) {
        this.kurssiID = kurssiID;
    }

    public Kurssit(String coursename, String kurssiID) {
        this.coursename = coursename;
        this.kurssiID = kurssiID;

    }
}
