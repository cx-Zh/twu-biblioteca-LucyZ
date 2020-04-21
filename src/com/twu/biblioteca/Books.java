package com.twu.biblioteca;

public class Books {
    private final String name;
    private final String auther;
    private final int year;
    private boolean checkout = true;
    private String checkout_num = "";

    public Books(String name, String auther, int year){
        this.name = name;
        this.auther = auther;
        this.year = year;
    }

    public String getName(){
        return name;
    }

    public String getAuther(){
        return auther;
    }

    public int getYear(){
        return year;
    }

    public String getCheckout_num(){
        return checkout_num;
    }

    public boolean canCheckout(){
        return checkout;
    }

    public void setCheckout(){
        this.checkout = !checkout;
    }

    public void setCheckout_num(String member_num){
        this.checkout_num = member_num;
    }
}