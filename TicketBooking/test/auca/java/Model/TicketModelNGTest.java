/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.java.Model;

import auca.java.domain.EPrice;
import auca.java.domain.EStatus;
import auca.java.domain.Ticket;
import auca.java.domain.User1;
import exception.DuplicateError;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author polie
 */
public class TicketModelNGTest {
    
    public TicketModelNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testGetTicketList() {
    }

    @Test
    public void testGetTicket() {
    }

    @Test
    public void testCreateTicket() {
        Ticket t = new Ticket();
        t.setMoviename("the name");
        t.setName("poli");
        t.setPrice(EPrice.$500);
        t.setReleasedate(new Date());
        t.setTicketStatus(EStatus.BOOKED);
        t.setTicket_Id("U123");
        TicketModel tc = new TicketModel();
       
         assertEquals(tc.createTicket(t), "TicketRegistrationForm");
       
    }
        @Test(expectedExceptions = DuplicateError.class)
    public void testDeleteTicketNeg() {
        
        Ticket t=new Ticket();
        t.setTicket_Id("MTN");
        t.setMoviename("ruburi");
        new TicketModel().deleteTicket(t);
    }
    @Test(expectedExceptions = DuplicateError.class)
    public void testCreateTicketNeg() {
        Ticket t = new Ticket();
        t.setMoviename("the name");
        t.setName("poli");
        t.setPrice(EPrice.$500);
        t.setReleasedate(new Date());
        t.setTicketStatus(EStatus.BOOKED);
        TicketModel tc = new TicketModel();
       tc.createTicket(t);

       
    }
    

    @Test
    public void testCancelTicket() {
       Ticket t=new Ticket();
     t.setTicketStatus(EStatus.UNBOOK);
    }

    @Test
    public void testActivateTicket() {
    Ticket t=new Ticket();
    t.setTicketStatus(EStatus.BOOKED);
    }
    
 

    @Test
    public void testNbrofDays() {
    }


    @Test
    public void testGetEPrice() {
    }
   @Test
    public void testDeleteTicket() { 
    }
    @Test
    public void testGetETicketStatus() {
    }

    @Test
    public void testLogout() {
     
    }

}
