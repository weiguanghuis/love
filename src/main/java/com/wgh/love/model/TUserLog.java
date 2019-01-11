package com.wgh.love.model;

import java.util.Date;

public class TUserLog {
    private Integer id;

    private Integer pid;

    private String userip;

    private String usersearch;

    private String visiturl;

    private String fromurl;

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

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public String getUsersearch() {
        return usersearch;
    }

    public void setUsersearch(String usersearch) {
        this.usersearch = usersearch == null ? null : usersearch.trim();
    }

    public String getVisiturl() {
        return visiturl;
    }

    public void setVisiturl(String visiturl) {
        this.visiturl = visiturl == null ? null : visiturl.trim();
    }

    public String getFromurl() {
        return fromurl;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl == null ? null : fromurl.trim();
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