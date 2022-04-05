package app;
 
import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import app.dao.UserDao;
import app.model.Users;
 
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
         
        try {
            Users user = userDao.checkLogin(email, password);
            String destPage = "/login.jsp";
             
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "/home.jsp";
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