package com.wgh.love.model;

import java.util.Date;

public class TProductAttributePrice {
    private Integer id;

    private Integer pid;

    private String productspecs;

    private Integer specsseq;

    private Integer stock;

    private Integer price;

    private Date uptime;

    private Date creattime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductspecs() {
        return productspecs;
    }

    public void setProductspecs(String productspecs) {
        this.productspecs = productspecs == null ? null : productspecs.trim();
    }

    public Integer getSpecsseq() {
        return specsseq;
    }

    public void setSpecsseq(Integer specsseq) {
        this.specsseq = specsseq;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}