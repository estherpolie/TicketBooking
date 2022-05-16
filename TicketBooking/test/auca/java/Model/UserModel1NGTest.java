/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.java.Model;

import auca.java.domain.User1;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author polie
 */
public class UserModel1NGTest {
    
    public UserModel1NGTest() {
    }


    @Test
    public void testLogin() {
        User1 user = new User1("polieesther6@gmail.com", "1234");
        UserModel1 model = new UserModel1();
        assertEquals(model.login(user), "TicketRegistrationForm");
    }
    
}
