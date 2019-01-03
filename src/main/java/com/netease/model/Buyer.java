package com.netease.model;

/**
 * @author hejiecheng
 * @Date 2019/1/3
 */
public class Buyer {

    private String username ;
    private String password ;

    public Buyer(){}

    public Buyer(String username, String password){
        this.username = username ;
        this.password = password ;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
