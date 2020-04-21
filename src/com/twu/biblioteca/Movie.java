package com.twu.biblioteca;

public class Movie {
    private final String name;
    private final String director;
    private final int year;
    private final double rating;
    private boolean checkout = true;
    private String checkout_num = "";

    public Movie(String name, String director, int year, double rating){
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public String getDirector(){
        return director;
    }

    public int getYear(){
        return year;
    }

    public double getRating(){
        return rating;
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
