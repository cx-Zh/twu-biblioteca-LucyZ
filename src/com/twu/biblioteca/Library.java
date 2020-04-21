package com.twu.biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Library {
    private static Set<Books> books = new HashSet<Books>();
    private static Set<Movie> movies = new HashSet<Movie>();
    private static Set<UserAccount> users = new HashSet<UserAccount>();
    private UserAccount userusing = null;

    private Library(){
        books.add(new Books("The Master and Margarita","Mikhail Bulgakov",1967));
        books.add(new Books("The Lord of the Rings","J. R. R. Tolkien",1954));
        books.add(new Books("The Little Prince","Antoine de Saint-Exupéry",1943));
        books.add(new Books("The Alchemist","Paulo Coelho",1988));
        books.add(new Books("The Hobbit","J. R. R. Tolkien",1937));
        books.add(new Books("Harry Potter and the Philosopher's Stone","J. K. Rowling",1997));

        movies.add(new Movie("The Shawshank Redemption","Frank Darabont",1994,9.2));
        movies.add(new Movie("The Godfather","Francis Ford Coppola",1972,9.1));
        movies.add(new Movie("Drishyam","Nishikant Kamat",2015,8.2));
        movies.add(new Movie("Klaus","Sergio Pablos, Carlos Martínez López ",2019,0));

        users.add(new UserAccount("000-0000", "000000", "Liam", "111111@gmail.com", "111111"));
        users.add(new UserAccount("000-0001", "111111", "Emma", "222222@gmail.com", "222222"));
        users.add(new UserAccount("000-0002", "222222", "William", "333333@gmail.com", "333333"));
    }

    private static Library library = new Library();
    public static Library getLibrary(){
        return library;
    }

    public void setUserusing(UserAccount userusing){
        this.userusing = userusing;
    }

//    ------------------------------------Functions about Books---------------------------------------
    public void printBookList(){
        for(Books booknow: books){
            if (booknow.canCheckout()){
                System.out.println("Name: " + booknow.getName() + "\nAuthor: " + booknow.getAuther() +
                        "\nPublication year: " + booknow.getYear() + "\n");
            }
        }
    }

    public void checkoutBook(){
        System.out.println("Please enter the book name you want to checkout:");
        Scanner input = new Scanner(System.in);
        String bookname = input.nextLine();

        int successMessage = 0;
        for(Books booknow: books){
            if (bookname.equals(booknow.getName()) && booknow.canCheckout() ){
                System.out.println("Thank you! Enjoy the book");
                booknow.setCheckout();
                booknow.setCheckout_num(userusing.getNumber());
                successMessage = 1;
            }
        }
        if (successMessage == 0){
            System.out.println("Sorry, that book is not available");
        }
    }

    public void returnBook(){
        System.out.println("Please enter the book name you want to return:");
        Scanner input = new Scanner(System.in);
        String bookname = input.nextLine();

        int successMessage = 0;
        for(Books booknow: books){
            if (bookname.equals(booknow.getName()) && !booknow.canCheckout() ){
                System.out.println("Thank you for returning the book");
                booknow.setCheckout();
                booknow.setCheckout_num("");
                successMessage = 1;
            }
        }
        if (successMessage == 0){
            System.out.println("That is not a valid book to return.");
        }
    }

    public void viewBookCheckout(){
        System.out.println("Please enter the book name you want to view the checkout information:");
        Scanner input = new Scanner(System.in);
        String bookname = input.nextLine();

        for(Books booknow: books){
            if (bookname.equals(booknow.getName())){
                if (booknow.canCheckout()){
                    System.out.println("This book is not checked out");
                }
                else{
                    System.out.println(booknow.getCheckout_num() + ": " + getUserFromNumber(booknow.getCheckout_num()).getName());
                }
            }
        }
    }
//    public Set<Books> getBooks(){
//        return books;
//    }

//    ---------------------------------Functions about Movie--------------------------------
    public void printMovieList(){
        for(Movie movie: movies){
            if (movie.canCheckout()){
                System.out.println("Name: " + movie.getName() + "\nDirector: " + movie.getDirector() +
                        "\nPublication year: " + movie.getYear());
                if (movie.getRating() != 0){
                    System.out.println("Rating: " + movie.getRating() + "\n");
                }
                else{
                        System.out.println("Rating: unrated\n");
                }
            }
        }
    }

    public void checkoutMovie(){
        System.out.println("Please enter the movie name you want to checkout:");
        Scanner input = new Scanner(System.in);
        String moviename = input.nextLine();

        int successMessage = 0;
        for(Movie movienow: movies){
            if (moviename.equals(movienow.getName()) && movienow.canCheckout() ){
                System.out.println("Thank you! Enjoy the movie");
                movienow.setCheckout();
                movienow.setCheckout_num(userusing.getNumber());
                successMessage = 1;
            }
        }
        if (successMessage == 0){
            System.out.println("Sorry, that movie is not available");
        }
    }

    public void returnMovie(){
        System.out.println("Please enter the movie name you want to return:");
        Scanner input = new Scanner(System.in);
        String bookname = input.nextLine();

        int successMessage = 0;
        for(Movie movienow: movies){
            if (bookname.equals(movienow.getName()) && !movienow.canCheckout() ){
                System.out.println("Thank you for returning the movie");
                movienow.setCheckout();
                movienow.setCheckout_num("");
                successMessage = 1;
            }
        }
        if (successMessage == 0){
            System.out.println("That is not a valid movie to return.");
        }
    }

    public void viewMovieCheckout(){
        System.out.println("Please enter the movie name you want to view the checkout information:");
        Scanner input = new Scanner(System.in);
        String moviename = input.nextLine();

        for(Movie movienow: movies){
            if (moviename.equals(movienow.getName())){
                if (movienow.canCheckout()){
                    System.out.println("This movie is not checked out");
                }
                else{
                    System.out.println(movienow.getCheckout_num() + ": " + getUserFromNumber(movienow.getCheckout_num()).getName());
                }
            }
        }
    }

// --------------------------------Functions about User Account-----------------------------------
    public Set<UserAccount> getUsers(){
        return users;
    }

    public UserAccount getUserFromNumber(String usernum){
        for(UserAccount usernow: users){
            if (usernum.equals(usernow.getNumber())){
                return usernow;
            }
        }
        return null;
    }

    public String Login(){
        String result_number = "";
        System.out.println("Please enter the user number:");
        Scanner input = new Scanner(System.in);
        String usernum = input.nextLine();

        System.out.println("Please enter the password:");
        String userpassword = input.nextLine();

        int successMessage = 0;
        Set<UserAccount> users = Library.getLibrary().getUsers();
        for(UserAccount usernow: users){
            if (usernum.equals(usernow.getNumber())){
                if (userpassword.equals(usernow.getPassword()))
                    System.out.println("Hello, " + usernow.getName() + "! Enjoy your BibliotecaApp!\n");
                successMessage = 1;
                result_number = usernum;
            }
        }
        if (successMessage == 0){
            System.out.println("Sorry, please enter the right number and password.\n");
        }

        return result_number;
    }
}