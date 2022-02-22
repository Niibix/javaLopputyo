package com.Lopputyo.Javalol;

public class Kurssit {
    public String coursename;
    public String kurssiID;

    public String getCoursename() {
        return coursename;
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
