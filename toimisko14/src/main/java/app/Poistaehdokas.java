package app;
import java.io.IOException;

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
		name = "Poistaehdokas",
		urlPatterns = {"/poistaehdokas"}
		)
public class Poistaehdokas extends HttpServlet{
	
		
		@Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF_8");
	        response.sendRedirect("/showdata");
	        Dao dao= new Dao();
	        Ehdokas ehdokas = readEhdokas(request);
	        dao.Poistaehdokas(ehdokas.getId());
	        dao.close();
	        
	        response.sendRedirect("/showdata");
	        
	    }
	    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {

	            response.sendRedirect("/showdata"); }
	    


	    private Ehdokas readEhdokas(HttpServletRequest request) {
			// TODO Auto-generated method stub
			Ehdokas ehdokas=new Ehdokas();
			System.out.println(request.getParameter("id"));
			ehdokas.setId(Integer.parseInt(request.getParameter("id")));
			ehdokas.setEtunimi(request.getParameter("etunimi"));
			ehdokas.setSukunimi(request.getParameter("sukunimi"));
			ehdokas.setPuolue(request.getParameter("puolue"));
			ehdokas.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
			//ehdokas.setIka(Integer.parseInt(request.getParameter("ika")));
			ehdokas.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
			ehdokas.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
			ehdokas.setAmmatti(request.getParameter("ammatti"));
			return ehdokas;
	}
	    

}