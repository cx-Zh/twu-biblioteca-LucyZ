package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Library library = Library.getLibrary();

    private void setInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Before
    public void setUpStreams() {
        library.setUserusing(library.getUserFromNumber("000-0000"));
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

//    Check out a book named "The Master and Margarita". We should get the succeed message.
    @Test
    public void test001_CheckOutBook_Right(){
        String input;
        input = "The Master and Margarita" ;
        this.setInput(input);

        library.checkoutBook();

        assertEquals("Please enter the book name you want to checkout:" + System.getProperty("line.separator") +
                        "Thank you! Enjoy the book" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void test002_ViewWhoCheckoutBook(){
        String input;
        input = "The Master and Margarita" ;
        this.setInput(input);

        library.viewBookCheckout();
        assertEquals("Please enter the book name you want to view the checkout information:" +
                        System.getProperty("line.separator") +
                        "000-0000: Liam" +  System.getProperty("line.separator"),
                outContent.toString());
    }

//    Check out a book named "The Master and Margarita" again. We should get the invalid message.
    @Test
    public void test003_CheckOutBook_Wrong(){
        String input;
        input = "The Master and Margarita" ;
        setInput(input);

        library.checkoutBook();
        assertEquals("Please enter the book name you want to checkout:" + System.getProperty("line.separator") +
                "Sorry, that book is not available" + System.getProperty("line.separator"),
                outContent.toString());
    }

//    Return a book named "The Master and Margarita". We should get the succeed message.
    @Test
    public void test004_ReturnBook_Right(){
        String input;
        input = "The Master and Margarita" ;
        setInput(input);

        library.returnBook();
        assertEquals("Please enter the book name you want to return:" + System.getProperty("line.separator") +
                        "Thank you for returning the book" + System.getProperty("line.separator"),
                outContent.toString());
    }

//    Return a book named "The Master and Margarita" again. We should get the invalid message.
    @Test
    public void test005_ReturnBook_Wrong(){
        String input;
        input = "The Master and Margarita" ;
        setInput(input);

        library.returnBook();
        assertEquals("Please enter the book name you want to return:" + System.getProperty("line.separator") +
                        "That is not a valid book to return." + System.getProperty("line.separator"),
                outContent.toString());
    }

    //    Check out a movie named "The Godfather". We should get the succeed message.
    @Test
    public void test006_CheckOutMovie_Right(){
        String input;
        input = "The Godfather" ;
        this.setInput(input);

        library.checkoutMovie();

        assertEquals("Please enter the movie name you want to checkout:" + System.getProperty("line.separator") +
                        "Thank you! Enjoy the movie" + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void test007_ViewWhoCheckoutBook(){
        String input;
        input = "The Godfather";
        this.setInput(input);

        library.viewMovieCheckout();
        assertEquals("Please enter the movie name you want to view the checkout information:" +
                        System.getProperty("line.separator") +
                        "000-0000: Liam" +  System.getProperty("line.separator"),
                outContent.toString());
    }

    //    Check out a movie named "The Godfather" again. We should get the invalid message.
    @Test
    public void test008_CheckOutMovie_Wrong(){
        String input;
        input = "The Godfather" ;
        setInput(input);

        library.checkoutMovie();
        assertEquals("Please enter the movie name you want to checkout:" + System.getProperty("line.separator") +
                        "Sorry, that movie is not available" + System.getProperty("line.separator"),
                outContent.toString());
    }

    //    Return a movie named "The Godfather". We should get the succeed message.
    @Test
    public void test009_ReturnMovie_Right(){
        String input;
        input = "The Godfather" ;
        setInput(input);

        library.returnMovie();
        assertEquals("Please enter the movie name you want to return:" + System.getProperty("line.separator") +
                        "Thank you for returning the movie" + System.getProperty("line.separator"),
                outContent.toString());
    }

    //    Return a movie named "The Godfather" again. We should get the invalid message.
    @Test
    public void test010_ReturnMovie_Wrong(){
        String input;
        input = "The Godfather" ;
        setInput(input);

        library.returnMovie();
        assertEquals("Please enter the movie name you want to return:" + System.getProperty("line.separator") +
                        "That is not a valid movie to return." + System.getProperty("line.separator"),
                outContent.toString());
    }

    @Test
    public void test011_Login(){
        String input;
//        input = "000-0001"+ System.getProperty("line.separator") + "000000";
        input = "000-0000\n000000";
        setInput(input);

        library.Login();
        assertEquals("Please enter the user number:" + System.getProperty("line.separator") +
                        "Please enter the password:" + System.getProperty("line.separator") +
                        "Hello, Liam! Enjoy your BibliotecaApp!\n" + System.getProperty("line.separator"),
                outContent.toString());
    }

}

