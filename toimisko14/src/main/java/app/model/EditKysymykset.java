package app.model;

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

import app.dao.Dao2;
import app.model.Kysymykset;

@WebServlet(
		name = "EditEhdokas",
		urlPatterns = {"/editkysymykset"}
		)
public class EditKysymykset extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao2 dao = new Dao2();
				Kysymykset kysymykset = dao.getKysymyksetInfo(id);
				
				session.setAttribute("kysymykset", kysymykset);
				
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
		Dao2 dao=new Dao2();
		Kysymykset kysymykset = readKysymykset(request);
		
		dao.updateKysymykset(kysymykset);
		
		dao.close();
		
		// Back to list after actions
		RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		rd.forward(request, response);
		response.sendRedirect("/showdata");
	}
	
	private Kysymykset readKysymykset(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Kysymykset kysymykset=new Kysymykset();
		kysymykset.setId(Integer.parseInt(request.getParameter("id")));
		kysymykset.setEka(request.getParameter("eka"));
		kysymykset.setToka(request.getParameter("toka"));
		kysymykset.setKolmas(request.getParameter("kolmas"));
		kysymykset.setNelja(request.getParameter("nelja"));
		kysymykset.setViis(request.getParameter("viis"));
		kysymykset.setKuus(request.getParameter("kuus"));
		kysymykset.setSeiska(request.getParameter("seiska"));
		kysymykset.setKasi(request.getParameter("kasi"));
		kysymykset.setYsi(request.getParameter("ysi"));
		kysymykset.setKyba(request.getParameter("kyba"));
		kysymykset.setYkstoist(request.getParameter("ykstoist"));
		kysymykset.setKakstoist(request.getParameter("kakstoist"));
		kysymykset.setKolmetoist(request.getParameter("kolmetoist"));
		kysymykset.setNeljatoist(request.getParameter("neljatoist"));
		kysymykset.setViistoist(request.getParameter("viistoist"));
		kysymykset.setKuustoist(request.getParameter("kuustoist"));
		kysymykset.setSeittemantoist(request.getParameter("seittemantoist"));
		kysymykset.setKaheksantoist(request.getParameter("kaheksantoist"));
		kysymykset.setYheksantoist(request.getParameter("yheksantoist"));

	
		return kysymykset;
	}
}
