/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 679918
 */
public class UserService extends HttpServlet {
    
    private String[] usernames = {"adam", "betty"};
    private String password = "password";
    
    public  User loging(String username, String password){
        User user = null;
        
        for(String userName : usernames)
            if(userName.equals(username))
                if(this.password.equals(password)){
                    user = new User();
                    user.setName(username);
                }
        return user;
    }

}
