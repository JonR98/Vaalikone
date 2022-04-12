package app;
 
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import app.dao.UserDao;
import app.model.Users;
 
//Made by Joona Rinta-Könnö

@WebServlet(
		name = "UserLoginServlet",
		urlPatterns = {"/login"}
		)
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLoginServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        UserDao userDao = new UserDao();
         //tarkistaa onko tunnukset syötetty oikein, jos ei ole niin antaa errorin
        try {
            Users user = userDao.checkLogin(email, password);
            String destPage = "/login.jsp";
             
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "/jsp/home.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}