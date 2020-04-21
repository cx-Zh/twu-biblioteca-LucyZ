/**
 * This is a class about menu containing several options customers can choose.
 * @version 1.1
 */
package com.twu.biblioteca;

public enum Menu {
    ListofBooks("List of books",true),
    CheckoutBook("Check out a book", true),
    ReturnBook("Return a book", true),
    ListofMovies("List of movies", true),
    CheckoutMovie("Check out a movie", true),
    ReturnMovie("Return a movie", true),
    ViewMyInfo("View your information", true),
    Quit("Quit", true);

    private final String desc;
    private boolean status;

    private Menu(String desc, boolean status){
        this.desc = desc;
        this.status = status;
    }

    public String getDescription(){
        return desc;
    }

    public boolean getStatus(){
        return status;
    }

    public void showInfo(){
        System.out.println(this.desc);
    }

    public void setStatus(boolean status){
        this.status = status;
    }


}
