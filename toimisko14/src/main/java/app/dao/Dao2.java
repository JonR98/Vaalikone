package app.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Kysymykset;


public class Dao2 {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao2() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
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

	public int saveKysymykset(Kysymykset kysymykset) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into vastaukset2(id, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ,16, 17, 18, 19) values('"+kysymykset.getEka()+"','"+kysymykset.getToka()+"','"+kysymykset.getKolmas()+"','"+kysymykset.getNelja()+"','"+kysymykset.getViis()+"','"+kysymykset.getKuus()+"','"+kysymykset.getSeiska()+"','"+kysymykset.getKasi()+"','"+kysymykset.getYsi()+"','"+kysymykset.getKyba()+"','"+kysymykset.getYkstoist()+"','"+kysymykset.getKakstoist()+"','"+kysymykset.getKolmetoist()+"','"+kysymykset.getNeljatoist()+"','"+kysymykset.getViistoist()+"','"+kysymykset.getKuustoist()+"','"+kysymykset.getSeittemantoist()+"','"+kysymykset.getKaheksantoist()+"','"+kysymykset.getYheksantoist()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	public ArrayList<Kysymykset> readAllKysymykset() {
		ArrayList<Kysymykset> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * vastaukset2");
			while (rs.next()) {
				Kysymykset kysymykset=new Kysymykset();
				kysymykset.setId(rs.getInt("id"));
				kysymykset.setEka(rs.getString("1"));
				kysymykset.setToka(rs.getString("2"));
				kysymykset.setKolmas(rs.getString("3"));
				kysymykset.setNelja(rs.getString("4"));
				kysymykset.setViis(rs.getString("5"));
				kysymykset.setKuus(rs.getString("6"));
				kysymykset.setSeiska(rs.getString("7"));
				kysymykset.setKasi(rs.getString("8"));
				kysymykset.setYsi(rs.getString("9"));
				kysymykset.setKyba(rs.getString("10"));
				kysymykset.setYkstoist(rs.getString("11"));
				kysymykset.setKakstoist(rs.getString("12"));
				kysymykset.setKolmetoist(rs.getString("13"));
				kysymykset.setNeljatoist(rs.getString("14"));
				kysymykset.setViistoist(rs.getString("15"));
				kysymykset.setKuustoist(rs.getString("16"));
				kysymykset.setSeittemantoist(rs.getString("17"));
				kysymykset.setKaheksantoist(rs.getString("18"));
				kysymykset.setYheksantoist(rs.getString("19"));
				

				list.add(kysymykset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateKysymykset(Kysymykset kysymykset) {
		int count = 0;
		String sql = "update vastaukset2 set 1 = ?, 2 = ?, 3 = ?, 4 = ?, 5 = ?, 6 = ?, 7 = ?, 8 = ?, 9 = ?, 10 = ?, 11 = ?, 12 = ?, 13 = ?, 14 = ?, 15 = ?, 16 = ?, 17 = ?, 18 = ?, 19 = ?  whereid = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1, kysymykset.getEka());
			stmt.setString(2, kysymykset.getToka());
			stmt.setString(3, kysymykset.getKolmas());
			stmt.setString(4, kysymykset.getNelja());
			stmt.setString(5, kysymykset.getViis());
			stmt.setString(6, kysymykset.getKuus());
			stmt.setString(7, kysymykset.getSeiska());
			stmt.setString(8, kysymykset.getKasi());
			stmt.setString(9, kysymykset.getYsi());
			stmt.setString(10, kysymykset.getKyba());
			stmt.setString(11, kysymykset.getYkstoist());
			stmt.setString(12, kysymykset.getKakstoist());
			stmt.setString(13, kysymykset.getKolmetoist());
			stmt.setString(14, kysymykset.getNeljatoist());
			stmt.setString(15, kysymykset.getViistoist());
			stmt.setString(16, kysymykset.getKuustoist());
			stmt.setString(17, kysymykset.getSeittemantoist());
			stmt.setString(18, kysymykset.getKaheksantoist());
			stmt.setString(19, kysymykset.getYheksantoist());

			count = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	public Kysymykset getKysymyksetInfo(int id) {
		Kysymykset result = null;
		String sql = "select * from vastaukset2 where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Kysymykset();
				result.setEka(resultset.getString("eka"));
				result.setToka(resultset.getString("toka"));
				result.setKolmas(resultset.getString("kolmas"));
				result.setNelja(resultset.getString("nelja"));
				result.setViis(resultset.getString("viis"));
				result.setKuus(resultset.getString("kuus"));
				result.setSeiska(resultset.getString("seiska"));
				result.setKasi(resultset.getString("kasi"));
				result.setYsi(resultset.getString("ysi"));
				result.setKyba(resultset.getString("kyba"));
				result.setYkstoist(resultset.getString("ykstoist"));
				result.setKakstoist(resultset.getString("kakstoist"));
				result.setKolmetoist(resultset.getString("kolmetoist"));
				result.setNeljatoist(resultset.getString("neljatoist"));
				result.setViistoist(resultset.getString("viistoist"));
				result.setKuustoist(resultset.getString("kuustoist"));
				result.setSeittemantoist(resultset.getString("seittemantoist"));
				result.setKaheksantoist(resultset.getString("kaheksantoist"));
				result.setYheksantoist(resultset.getString("yheksantoist"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

