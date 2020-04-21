package com.twu.biblioteca;

public class UserAccount {
    private final String number;
    private final String password;
    private String name;
    private String email = "";
    private String phone = "";

    public UserAccount(String number, String password, String name){
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public UserAccount(String number, String password, String name, String email, String phone){
        this.name = name;
        this.number = number;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getNumber(){
        return number;
    }

    public String getPassword(){
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void showUserInfo(){
        System.out.println("Your email: " + email);
        System.out.println("Your phone number: " + phone);
    }
}
