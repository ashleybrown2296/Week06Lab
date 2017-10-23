/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 679918
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        
        HttpSession session = request.getSession();
        
        Cookie[] cookies = request.getCookies();
        
        String cookieName = "userIdCookie";
        String cookieValue = "";
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        if (!cookieValue.equals("")) {
            request.setAttribute("username", cookieValue);
            request.setAttribute("checked", "checked");
        }
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            session.removeAttribute("username");
            request.setAttribute("errorMessage", "Logged Out.");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        String userSession = (String) session.getAttribute("username");
        if (userSession != null) {
            response.sendRedirect("/MyLogin/home");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "Please enter both values.");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        UserService us = new UserService();
        User user = us.loging(username, password);
        
        if (user == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("errorMessage", "Invalid username or password!");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
       
        if (request.getParameter("remember") == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userIdCookie")) {
                    //deletes cookie
                    cookie.setMaxAge(0);
                    //application accesses cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        } else {
            //remember me checked off
            Cookie cke = new Cookie("userIdCookie", username);
            //30 minute cookie
            cke.setMaxAge(60 * 30);
            cke.setPath("/");
            response.addCookie(cke);
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        response.sendRedirect("/MyLogin/home");
        
    }
    
  
}
