package com.Lopputyo.Javalol;

public class Kurssit {
    public String coursename;
    public String opettaja;
    public String ajankohta;
    public String kurssiID;

    public Kurssit(String coursename, String opettaja, String ajankohta, String kurssiID) {
        this.coursename = coursename;
        this.opettaja = opettaja;
        this.ajankohta = ajankohta;
        this.kurssiID = kurssiID;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getOpettaja() {
        return opettaja;
    }

    public void setOpettaja(String opettaja) {
        this.opettaja = opettaja;
    }

    public String getAjankohta() {
        return ajankohta;
    }

    public void setAjankohta(String ajankohta) {
        this.ajankohta = ajankohta;
    }

    public String getKurssiID() {
        return kurssiID;
    }

    public void setKurssiID(String kurssiID) {
        this.kurssiID = kurssiID;
    }
}
