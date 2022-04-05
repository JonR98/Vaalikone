package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Ehdokas;


public class Dao {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "appuser", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int saveEhdokas(Ehdokas ehdokas) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into ehdokkaat(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan?, mita_asioita_haluat_edistaa) values('"+ehdokas.getsukunimi()+"', "+ehdokas.getetunimi()+"', "+ehdokas.getpuolue()+"', "+ehdokas.getkotipaikkakunta()+"', "+ehdokas.getika()+"', "+ehdokas.getmiksi_eduskuntaan()+"', "+ehdokas.getmita_asioita_haluat_edistaa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	public ArrayList<Ehdokas> readAllEhdokas() {
		ArrayList<Ehdokas> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Ehdokas ehdokas=new Ehdokas();
				ehdokas.setid(rs.getInt("id"));
				ehdokas.setsukunimi(rs.getString("Sukunimi"));
				ehdokas.setetunimi(rs.getString("Etunimi"));
				ehdokas.setpuolue(rs.getString("Puolue"));
				ehdokas.setkotipaikkakunta(rs.getString("Kotipaikkakunta"));
				ehdokas.setika(rs.getInt("Ika"));
				ehdokas.setmiksi_eduskuntaan(rs.getString("Miksi_eduskuntaan?"));
				ehdokas.setmita_asioita_haluat_edistaa(rs.getString("Mita_asioita_haluat_edistaa"));
				ehdokas.setammatti(rs.getString("Ammatti"));
				list.add(ehdokas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateEhdokas(Ehdokas ehdokas) {
		int count = 0;
		String sql = "update ehdokkaat set etunimi = ?, sukunimi = ?, puolue = ?, kotipaikkakunta = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ?, where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ehdokas.getid());
			stmt.setString(2, ehdokas.getetunimi());
			stmt.setString(3, ehdokas.getsukunimi());
			stmt.setString(4, ehdokas.getpuolue());
			stmt.setString(5, ehdokas.getkotipaikkakunta());
			stmt.setString(6, ehdokas.getmiksi_eduskuntaan());
			stmt.setString(7, ehdokas.getmita_asioita_haluat_edistaa());
			stmt.setString(8, ehdokas.getammatti());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Ehdokas getEhdokasInfo(int id) {
		Ehdokas result = null;
		String sql = "select * from ehdokkaat where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Ehdokas();
				result.setid(resultset.getInt("id"));
				result.setid(resultset.getInt("id"));
				result.setsukunimi(resultset.getString("sukunimi"));
				result.setetunimi(resultset.getString("etunimi"));
				result.setpuolue(resultset.getString("puolue"));
				result.setkotipaikkakunta(resultset.getString("kotipaikkakunta"));
				result.setika(resultset.getInt("ika"));
				result.setmiksi_eduskuntaan(resultset.getString("miksi_eduskuntaan?"));
				result.setmita_asioita_haluat_edistaa(resultset.getString("mita_asioita_haluat_edistaa"));
				result.setammatti(resultset.getString("ammatti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

