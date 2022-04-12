package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Ehdokas;

@WebServlet(
		name = "EditEhdokas",
		urlPatterns = {"/editehdokas"}
		)

//Made by Joni Repo, Joona Rinta-Könnö

public class EditEhdokas extends HttpServlet {
	private Connection conn;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("id");
		System.out.println(idValue);
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
		RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		rd.forward(request, response);
		//response.sendRedirect("/showdata");
	}
	
	private Ehdokas readEhdokas(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Ehdokas ehdokas=new Ehdokas();
		System.out.println(request.getParameter("id"));
		ehdokas.setId(Integer.parseInt(request.getParameter("id")));
		ehdokas.setEtunimi(request.getParameter("etunimi"));
		ehdokas.setSukunimi(request.getParameter("sukunimi"));
		ehdokas.setPuolue(request.getParameter("puolue"));
		ehdokas.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		ehdokas.setIka(Integer.parseInt(request.getParameter("ika")));
		ehdokas.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		ehdokas.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		ehdokas.setAmmatti(request.getParameter("ammatti"));
		return ehdokas;
	}
	public Ehdokas getEhdokasInfo(int id) {
		Ehdokas result = null;
		String sql = "delete * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Ehdokas();
				result.setId(resultset.getInt("ehdokas_id"));
				result.setSukunimi(resultset.getString("sukunimi"));
				result.setEtunimi(resultset.getString("etunimi"));
				result.setPuolue(resultset.getString("puolue"));
				result.setKotipaikkakunta(resultset.getString("kotipaikkakunta"));
				result.setIka(resultset.getInt("ika"));
				result.setMiksi_eduskuntaan(resultset.getString("miksi_eduskuntaan"));
				result.setMita_asioita_haluat_edistaa(resultset.getString("mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("ammatti"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
//	public ArrayList<Ehdokas> readAllEhdokas(HttpServletRequest request) {
//		ArrayList<Ehdokas> list=new ArrayList<>();
			
//			ResultSet rs=stmt.executeQuery("select ehdokas_id from ehdokkaat");
//			while (rs.next()) {
//				Ehdokas ehdokas=new Ehdokas();
//				ehdokas.setId(rs.getInt("Ehdokas_id"));
//				list.remove("ehdokas_id");
//			}
//		} catch (SQLException e) {
//			 TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	
	
	//private Ehdokas updateEhdokas(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//Ehdokas ehdokas=new Ehdokas();
		  //String sql="delete from ehdokas where id=?";
		  //System.out.println(request.getParameter("id"));
		
			//return ehdokas;
		
		
	}

}
	
	
