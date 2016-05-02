package com.example.dhilipkumaran.myapplication;

import android.text.LoginFilter;

import java.util.Date;

/**
 * Created by Dhilip on 13-10-2015.
 */
public class SummaryDetails {
    Integer Id;
    String Gmail;
    String FaceBook;
    String OutLook;
    String YMail;
    String Description;

    public void setId(Integer id){this.Id = id;}
    public Integer getId(){return this.Id;}

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setFaceBook(String faceBook) {
        FaceBook = faceBook;
    }

    public String getFaceBook() {
        return FaceBook;
    }

    public void setOutLook(String outLook) {
        OutLook = outLook;
    }

    public String getOutLook() {
        return OutLook;
    }

    public void setYMail(String YMail) {
        this.YMail = YMail;
    }

    public String getYMail() {
        return YMail;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }
}
