/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.java.Model;

import auca.java.Dao.GenericDao;
import auca.java.domain.EPrice;
import auca.java.domain.EStatus;
import auca.java.domain.Ticket;
import exception.DuplicateError;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author polie
 */

@ManagedBean(name = "UM")
@RequestScoped
public class TicketModel {
 private Ticket usr = new Ticket();
 private List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTicketList() {
        ticketList = new GenericDao<Ticket>().findAll(Ticket.class);
        return  ticketList;
    }
 
 

    public Ticket getTicket() {
        return usr;
    }
 
            Calendar c = Calendar.getInstance();
            Date currentDate = c.getTime();
    public String createTicket(Ticket usrr){ 
        try {
             if(usrr.getReleasedate().before(currentDate)){
        FacesContext fx = FacesContext.getCurrentInstance();
//        fx.addMessage(null, new FacesMessage("Release date can not be in the past"));
        return "TicketRegistrationForm";
        }else{
        GenericDao<Ticket> gd = new GenericDao<>();
        usrr.setTicketStatus(EStatus.BOOKED);
        gd.Create(usrr);
        //    FacesContext fx = FacesContext.getCurrentInstance();
      //  fx.addMessage(null, new FacesMessage("Ticket booked Successfully"));
        return "ticketList";
        }
        } catch (Exception e) {
            throw new DuplicateError();
        }
       
    }
     public void deleteTicket(Ticket usr){
         try {
             FacesContext fc = FacesContext.getCurrentInstance();
        new GenericDao().Delete(usr);
       ticketList = new GenericDao<Ticket>().findAll(Ticket.class);
        fc.addMessage("message", new FacesMessage(FacesMessage.SEVERITY_INFO, "success", "success"));
         } catch (Exception e) {
             throw new DuplicateError();
         }
         
    }
    
    public float nbrofDays(Ticket usr){
       long difference = usr.getReleasedate().getTime() - currentDate.getTime();
       float numberofDays = (difference/ (1000*60*60*24));
       return numberofDays;
    }
    //User=Ticket
    public void cancelTicket(Ticket usr){
    if(usr.getTicketStatus()== EStatus.BOOKED){
        usr.setTicketStatus(EStatus.UNBOOK);
        GenericDao<Ticket> gd = new GenericDao<>();
        gd.Update(usr);
    }
    }
    public void activateTicket(Ticket usr){
    if(usr.getTicketStatus() == EStatus.UNBOOK){
        usr.setTicketStatus(EStatus.BOOKED);
        GenericDao<Ticket> gd = new GenericDao<>();
        gd.Update(usr);
    }
    }
        
        
    
    
    public List<String> getEPrice(){
    List<String> priceList = new ArrayList<>();
    for(EPrice t : EPrice.values()){
    priceList.add(t.toString());
    }
    return priceList;
    }
    
    
    public List<String> getETicketStatus(){
    List<String> statusList = new ArrayList<>();
    for(EStatus s : EStatus.values()){
    statusList.add(s.toString());
    }
    return statusList;
    } 
    public TicketModel() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if(context.getExternalContext().getSessionMap().get("user")==null){
           context.getExternalContext().redirect("Login.xhtml");
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ticketList = new GenericDao<Ticket>().findAll(Ticket.class);
    }
public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        return "Login.xhtml?faces-redirect=true";
    }
}

    

