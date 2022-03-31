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
			count=stmt.executeUpdate("insert into ehdokkaat(Sukunimi, Etunimi, Puolue, Kotipaikkakunta, Ika, Miksi_eduskuntaan?, Mita_asioita_haluat_edistaa) values('"+ehdokas.getSukunimi()+"', "+ehdokas.getEtunimi()+")");
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
				ehdokas.setId(rs.getInt("id"));
				ehdokas.setSukunimi(rs.getString("Sukunimi"));
				ehdokas.setEtunimi(rs.getString("Etunimi"));
				ehdokas.setPuolue(rs.getString("Puolue"));
				ehdokas.setKotipaikkakunta(rs.getString("Kotipaikkakunta"));
				ehdokas.setIka(rs.getInt("Ika"));
				ehdokas.setMiksi_eduskuntaan(rs.getString("Miksi_eduskuntaan?"));
				ehdokas.setMita_asioita_haluat_edistaa(rs.getString("Mita_asioita_haluat_edistaa"));
				ehdokas.setAmmatti(rs.getString("Ammatti"));
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
		String sql = "update ehdokkaat set Etunimi = ?, Sukunimi = ?, Puolue = ?, Kotipaikkakunta = ?, Miksi_eduskuntaan = ?, Mita_asioita_haluat_edistaa = ?, Ammatti = ?, where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ehdokas.getId());
			stmt.setString(2, ehdokas.getEtunimi());
			stmt.setFloat(3, ehdokas.getSukunimi());
			stmt.setString(4, ehdokas.getPuolue());
			stmt.setString(5, ehdokas.getKotipaikkakunta());
			stmt.setString(6, ehdokas.getMiksi_eduskuntaan());
			stmt.setString(7, ehdokas.getMita_asioita_haluat_edistaa());
			stmt.setString(8, ehdokas.getAmmatti());
			
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
				result.setId(resultset.getInt("id"));
				result.setId(resultset.getInt("id"));
				result.setSukunimi(resultset.getString("Sukunimi"));
				result.setEtunimi(resultset.getString("Etunimi"));
				result.setPuolue(resultset.getString("Puolue"));
				result.setKotipaikkakunta(resultset.getString("Kotipaikkakunta"));
				result.setIka(resultset.getInt("Ika"));
				result.setMiksi_eduskuntaan(resultset.getString("Miksi_eduskuntaan?"));
				result.setMita_asioita_haluat_edistaa(resultset.getString("Mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("Ammatti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

