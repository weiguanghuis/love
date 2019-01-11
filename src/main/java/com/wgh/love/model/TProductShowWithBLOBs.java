package com.wgh.love.model;

public class TProductShowWithBLOBs extends TProductShow {
    private String subimg;

    private String detail;

    private String attributelist;

    public String getSubimg() {
        return subimg;
    }

    public void setSubimg(String subimg) {
        this.subimg = subimg == null ? null : subimg.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getAttributelist() {
        return attributelist;
    }

    public void setAttributelist(String attributelist) {
        this.attributelist = attributelist == null ? null : attributelist.trim();
    }
}