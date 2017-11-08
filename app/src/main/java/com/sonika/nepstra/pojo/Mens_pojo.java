package com.sonika.nepstra.pojo;

/**
 * Created by sonika on 10/17/2017.
 */

public class Mens_pojo {
    public String menname, menprice, menimage, menDesc;
    public Integer menid;
    public Integer mencid;

    public Mens_pojo() {
    }

    public Mens_pojo(String menname, String menprice, String menimage, String menDesc, Integer menid, Integer mencid) {
        this.menname = menname;
        this.menprice = menprice;
        this.menimage = menimage;
        this.menDesc = menDesc;
        this.menid = menid;
        this.mencid = mencid;
    }

    public String getMenname() {
        return menname;
    }

    public void setMenname(String menname) {
        this.menname = menname;
    }

    public String getMenprice() {
        return menprice;
    }

    public void setMenprice(String menprice) {
        this.menprice = menprice;
    }

    public String getMenimage() {
        return menimage;
    }

    public void setMenimage(String menimage) {
        this.menimage = menimage;
    }

    public String getMenDesc() {
        return menDesc;
    }

    public void setMenDesc(String menDesc) {
        this.menDesc = menDesc;
    }

    public Integer getMenid() {
        return menid;
    }

    public void setMenid(Integer menid) {
        this.menid = menid;
    }

    public Integer getMencid() {
        return mencid;
    }

    public void setMencid(Integer mencid) {
        this.mencid = mencid;
    }
}
