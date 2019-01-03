package com.netease.model;

/**
 * @author hejiecheng
 * @Date 2019/1/3
 */
public class Admin {

    private String username ;
    private String password ;

    public Admin(){}

    public Admin(String username, String password){
        this.username = username ;
        this.password = password ;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
