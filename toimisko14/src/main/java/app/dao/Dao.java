package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Game;

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
	
	public ArrayList<Game> readAllGame() {
		ArrayList<Game> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Game game=new Game();
				game.setId(rs.getInt("id"));
				game.setSukunimi(rs.getString("Sukunimi"));
				game.setEtunimi(rs.getString("Etunimi"));
				game.setPuolue(rs.getString("Puolue"));
				game.setKotipaikkakunta(rs.getString("Kotipaikkakunta"));
				game.setIka(rs.getInt("Ika"));
				game.setMiksi_eduskuntaan(rs.getString("Miksi_eduskuntaan?"));
				game.setMita_asioita_haluat_edistaa(rs.getString("Mita_asioita_haluat_edistaa"));
				game.setAmmatti(rs.getString("Ammatti"));
				list.add(game);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateGame(Game game) {
		int count = 0;
		String sql = "update ehdokkaat set breed = ?, weight = ? where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, game.getBreed());
			stmt.setFloat(2, game.getWeight());
			
			stmt.setInt(3, game.getId());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Game getGameInfo(int id) {
		Game result = null;
		String sql = "select * from ehdokkaat where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Game();
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

