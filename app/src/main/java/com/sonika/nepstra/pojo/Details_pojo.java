package com.sonika.nepstra.pojo;

/**
 * Created by sonika on 10/26/2017.
 */

public class Details_pojo {
    public String detailsname, detailsprice, detailsimage, detailsdesc;
    public Integer detailsid;
    public Integer detailscid;

    public Details_pojo(String detailsname, String detailsprice, String detailsimage, String detailsdesc, Integer detailsid, Integer detailscid) {
        this.detailsname = detailsname;
        this.detailsprice = detailsprice;
        this.detailsimage = detailsimage;
        this.detailsdesc = detailsdesc;
        this.detailsid = detailsid;
        this.detailscid = detailscid;
    }

    public Details_pojo() {
    }

    public String getDetailsname() {
        return detailsname;
    }

    public void setDetailsname(String detailsname) {
        this.detailsname = detailsname;
    }

    public String getDetailsprice() {
        return detailsprice;
    }

    public void setDetailsprice(String detailsprice) {
        this.detailsprice = detailsprice;
    }

    public String getDetailsimage() {
        return detailsimage;
    }

    public void setDetailsimage(String detailsimage) {
        this.detailsimage = detailsimage;
    }

    public String getDetailsdesc() {
        return detailsdesc;
    }

    public void setDetailsdesc(String detailsdesc) {
        this.detailsdesc = detailsdesc;
    }

    public Integer getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(Integer detailsid) {
        this.detailsid = detailsid;
    }

    public Integer getDetailscid() {
        return detailscid;
    }

    public void setDetailscid(Integer detailscid) {
        this.detailscid = detailscid;
    }
}

