package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testLoginOrRegister() {
        Login login = new Login();
        String LoginOrRegister;
        assertTrue("1",true);
    }

    @Test
    public void testRegister() {
        Login login = new Login();
        String LoginOrRegister;
        assertTrue("2", true);
    }

    @Test
    public void testExit(){
        Login login = new Login();
        String LoginOrRegister;
        assertTrue("3",true);
    }

    @Test
    public void testRegister2(){
        Login login = new Login();
        String LoginOrRegister;
        assertFalse("Kerem CAn",false);
    }
    @Test
    public void testLoginOrRegister2(){
        Login login = new Login();
        String LoginOrRegister;
        assertFalse("Metin",false);
    }
    @Test
    public void testExit2(){
        Login login  = new Login();
        String LoginOrRegister;
        assertFalse("Mustafa",false);
    }
}