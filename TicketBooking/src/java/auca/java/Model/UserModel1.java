/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auca.java.Model;


import auca.java.domain.User1;
import exception.DuplicateError;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author polie
 */
@ManagedBean
@ApplicationScoped
public class UserModel1 {
    private User1 u = new User1();

    
    public User1 getU() {
        return u;
    }

    public void setU1(User1 u) {
        this.u = u;
    }
    
    
    
    public String login(User1 uu){
        FacesContext cx = FacesContext.getCurrentInstance();
        if(uu.getEmail().equals("polieesther6@gmail.com") && uu.getPassword().equals("1234")){
            System.out.println("me again ");
            //comment the below cx for testing
           cx.getExternalContext().getSessionMap().put("user", "polieesther6");
            try {
                //comment this cx for testing
             cx.getExternalContext().redirect("TicketRegistrationForm.xhtml");
              return "TicketRegistrationForm";
            } catch (Exception e) {
                e.printStackTrace();
                return "Login";
            }
        }else{
        return "Login";
        }

   }


    
}

