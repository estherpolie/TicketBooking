/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.java.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author polie
 */
@Entity
public class Ticket {

    @Id
    private String Ticket_Id;
   private String moviename;
   private String name;
   private Date releasedate;
   @Enumerated(EnumType.STRING)
   private EStatus ticketStatus;
    @Enumerated(EnumType.STRING) 
   private EPrice Price;
    private String starttime;
    private String endtime;

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
 

    public String getTicket_Id() {
        return Ticket_Id;
    }

    public void setTicket_Id(String Ticket_Id) {
        this.Ticket_Id = Ticket_Id;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public EStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(EStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public EPrice getPrice() {
        return Price;
    }

    public void setPrice(EPrice Price) {
        this.Price = Price;
    }


    
    
    
    
    
    
}

    