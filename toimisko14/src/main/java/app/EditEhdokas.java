package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Ehdokas;

@WebServlet(
		name = "EditEhdokas",
		urlPatterns = {"/editehdokas"}
		)
public class EditEhdokas extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Ehdokas ehdokas = dao.getEhdokasInfo(id);
				
				session.setAttribute("ehdokas", ehdokas);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editform.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showdata");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Ehdokas ehdokas = readEhdokas(request);
		
		dao.updateEhdokas(ehdokas);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showdata");
	}
	
	private Ehdokas readEhdokas(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Ehdokas ehdokas=new Ehdokas();
		ehdokas.setid(Integer.parseInt(request.getParameter("id")));
		ehdokas.setetunimi(request.getParameter("etunimi"));
		ehdokas.setsukunimi(request.getParameter("sukunimi"));
		ehdokas.setpuolue(request.getParameter("puolue"));
		ehdokas.setkotipaikkakunta(request.getParameter("kotipaikkakunta"));
		ehdokas.setika(Integer.parseInt(request.getParameter("ika")));
		ehdokas.setmiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		ehdokas.setmita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		ehdokas.setammatti(request.getParameter("ammatti"));
		return ehdokas;
	}
}
