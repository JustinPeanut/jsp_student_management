package com.peanut.bean;

public class Student {
    private int Sno;
    private String Sname;
    private String Ssex;
    private int Sage;
    private int SdeptId;
    private String city;
    private String Spassword;

    public Student (){}

    public void setSno(int sno) {
        Sno = sno;
    }

    public Student(int sno, String sname, String ssex, int sage, int sdeptId, String city, String spassword) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        SdeptId = sdeptId;
        this.city = city;
        Spassword = spassword;
    }

    public String getSpassword() {
        return Spassword;
    }

    public void setSpassword(String spassword) {
        Spassword = spassword;
    }

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public int getSdeptId() {
        return SdeptId;
    }

    public void setSdeptId(int sdeptId) {
        SdeptId = sdeptId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno='" + Sno + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sage=" + Sage +
                ", SdeptId=" + SdeptId +
                ", city='" + city + '\'' +
                '}';
    }
}
