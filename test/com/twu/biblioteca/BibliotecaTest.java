package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void shouldShowWelcomeMessage(){
        bibliotecaApp.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"
                        + System.getProperty("line.separator"),
                outContent.toString()
        );
    }

    @Test
    public void shouldShowTheMenu(){
        bibliotecaApp.showMenu();

        assertEquals("Menu:" + System.getProperty("line.separator") +
                        "1.List of books" + System.getProperty("line.separator") +
                        "2.Check out a book" + System.getProperty("line.separator") +
                        "3.Return a book" + System.getProperty("line.separator") +
                        "4.List of movies" + System.getProperty("line.separator") +
                        "5.Check out a movie" + System.getProperty("line.separator") +
                        "6.Return a movie" + System.getProperty("line.separator") +
                        "7.View your information" + System.getProperty("line.separator") +
                        "8.Quit" + System.getProperty("line.separator") +
                        "" + System.getProperty("line.separator"),
                outContent.toString()
        );
    }

    @Test
    public void changeStatusOfQuit(){
        bibliotecaApp.setMenu(8, null);
        assertEquals(false, Menu.Quit.getStatus());
    }

}
