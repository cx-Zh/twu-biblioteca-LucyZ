package com.twu.biblioteca;

import java.util.Scanner;
import java.util.Set;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = Library.getLibrary();

        bibliotecaApp.showWelcomeMessage();

        String usernum = "";
        while(true){
            usernum = bibliotecaApp.Login();
            if (usernum.equals("")){
                continue;
            }
            else{
                break;
            }
        }

        while(Menu.Quit.getStatus()){
            UserAccount user = library.getUserFromNumber(usernum);
            bibliotecaApp.showMenu();
            bibliotecaApp.inputOption(user);

        }
    }

//    Display a welcome message.
    public void showWelcomeMessage(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

//    Display the menu.
    public void showMenu(){
        System.out.println("Menu:");
        Menu[] menu = Menu.values();
        int index = 0;
        for (Menu n:menu){
            index += 1;
            System.out.print(index + ".");
            n.showInfo();
        }
        System.out.println();
    }

//    Get the input from customers.
    public void inputOption(UserAccount user){
        Scanner input = new Scanner(System.in);

        System.out.println("Option: ");
        try{
            int Option = input.nextInt();
            setMenu(Option, user);
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("Please select a valid option!");
        }
        System.out.println();
    }

//    Change the status and do something after customers choose an option.
    public void setMenu(int Option, UserAccount user){
        Library library = Library.getLibrary();
        library.setUserusing(user);

        Menu[] menu = Menu.values();
        Menu choice = menu[Option - 1];
        if(choice == Menu.Quit){
            Menu.Quit.setStatus(false);
        }
        else if(choice == Menu.ListofBooks){
            library.printBookList();
        }
        else if(choice == Menu.CheckoutBook){
            library.checkoutBook();
        }
        else if(choice == Menu.ReturnBook){
            library.returnBook();
        }
        else if(choice == Menu.ListofMovies){
            library.printMovieList();
        }
        else if(choice == Menu.CheckoutMovie){
            library.checkoutMovie();
        }
        else if(choice == Menu.ReturnMovie){
            library.returnMovie();
        }
        else if(choice == Menu.ViewMyInfo){
            user.showUserInfo();
        }
    }

    public String Login(){
        Library library = Library.getLibrary();
        return library.Login();
    }
}
