package com.ust.UserBackEndProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
    private int id;
    private String uname;
    private String pword;

    public Users() {}
    public Users (@JsonProperty("id") int id,
                  @JsonProperty ("uname") String uname,
                  @JsonProperty("pword") String pword) {
        this.id = id;
        this.uname = uname;
        this.pword = pword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                '}';
    }
}
