package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.model.Ehdokas;

/*
 * The name of the servlet is AddEhdokas
 * and the servlet's URI (url-pattern) is 'addehdokas'
 */
@WebServlet(
		name = "AddEhdokas",
		urlPatterns = {"/addehdokas"}
		)
public class AddEhdokas extends HttpServlet {
	/*
	 * If the request type is POST, the request is transferred to the method doGet
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		/*
		 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		 */
		RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		rd.include(request,  response);;
		
		// Read parameters to Model
		Ehdokas ehdokas=readEhdokas(request);
	
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.saveEhdokas(ehdokas);
		ArrayList<Ehdokas> list=dao.readAllEhdokas();
		
		// print output and close connection
		printEhdokasList(out, list);
		dao.close();
		
		
		out.println("<br><a href='./form.html'>Back to form</a>");

		/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 */
		rd=request.getRequestDispatcher("staticpages/htmlend.html");
		rd.include(request,  response);;
	}


	
	private Ehdokas readEhdokas(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Ehdokas ehdokas=new Ehdokas();
<<<<<<< HEAD
		//ehdokas.setId(Integer.parseInt(request.getParameter("id")));
=======
>>>>>>> 0ae9ac63419d9f89a29fbe4ebb50faed7370489d
		ehdokas.setEtunimi(request.getParameter("etunimi"));
		ehdokas.setSukunimi(request.getParameter("sukunimi"));
		ehdokas.setPuolue(request.getParameter("puolue"));
		ehdokas.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		ehdokas.setIka(Integer.parseInt(request.getParameter("Ika")));
		ehdokas.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		ehdokas.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		ehdokas.setAmmatti(request.getParameter("ammatti"));
		return ehdokas;
	}
	
	private void printEhdokasList(PrintWriter out, ArrayList<Ehdokas> list) {
		out.println("<ul>");
		for (Ehdokas g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}