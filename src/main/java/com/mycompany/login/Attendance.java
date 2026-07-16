package com.mycompany.login;

public class Attendance {

    private String username;
    private String date;
    private String loginTime;
    private String logoutTime;
    private String status;
    private String name;

    public Attendance() {
    }

    public Attendance(String username, String name, String date,
                      String loginTime,
                      String logoutTime,
                      String status) {

        this.username = username;
        this.date = date;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.status = status;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public String getStatus() {
        return status;
    }
    public String getName() {
        return name;
    }
    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}