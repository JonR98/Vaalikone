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
			count=stmt.executeUpdate("insert into kysymykset(Suomessa on liian helppo elää sosiaaliturvan varassa, Kaupan ja muiden liikkeiden aukioloajat on vapautettava., Suomessa on siirryttävä perustuloon joka korvaisi nykyisen sosiaaliturvan vähimmäistason., Tyäntekijälle on turvattava lailla minimityäaika., Ansiosidonnaisen tyättämyysturvan kestoa pitää lyhentää., Euron ulkopuolella Suomi pärjäisi paremmin., Ruoan verotusta on varaa kiristää., Valtion ja kuntien taloutta on tasapainotettava ensisijaisesti leikkaamalla menoja., Lapsilisiä on korotettava ja laitettava verolle., Suomella ei ole varaa nykyisen laajuisiin sosiaali- ja terveyspalveluihin., Nato-jäsenyys vahvistaisi Suomen turvallisuuspoliittista asemaa., Suomeen tarvitaan enemmän poliiseja., Maahanmuuttoa Suomeen on rajoitettava terrorismin uhan vuoksi., Venäjän etupiiripolitiikka on uhka Suomelle., Verkkovalvonnassa valtion turvallisuus on tärkeämpää kuin kansalaisten yksityisyyden suoja., Suomen on osallistuttava Isisin vastaiseen taisteluun kouluttamalla Irakin hallituksen joukkoja., Parantumattomasti sairaalla on oltava oikeus avustettuun kuolemaan., Terveys- ja sosiaalipalvelut on tuotettava ensijaisesti julkisina palveluina., Viranomaisten pitää puuttua lapsiperheiden ongelmiin nykyistä herkemmin.) values('"+kysymykset.getEka()+"','"+kysymykset.getToka()+"','"+kysymykset.getKolmas()+"','"+kysymykset.getNelja()+"','"+kysymykset.getViis()+"','"+kysymykset.getKuus()+"','"+kysymykset.getKuus()+"','"+kysymykset.getSeiska()+"','"+kysymykset.getKasi()+"','"+kysymykset.getYsi()+"','"+kysymykset.getKyba()+"','"+kysymykset.getYkstoist()+"','"+kysymykset.getKakstoist()+"','"+kysymykset.getKolmetoist()+"','"+kysymykset.getNeljatoist()+"','"+kysymykset.getViistoist()+"','"+kysymykset.getKuustoist()+"','"+kysymykset.getSeittemantoist()+"','"+kysymykset.getKaheksantoist()+"','"+kysymykset.getYheksantoist()+"')");
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
			ResultSet rs=stmt.executeQuery("select * from kysymykset");
			while (rs.next()) {
				Kysymykset kysymykset=new Kysymykset();
				kysymykset.setEka(rs.getString("eka"));
				kysymykset.setToka(rs.getString("toka"));
				kysymykset.setKolmas(rs.getString("kolmas"));
				kysymykset.setNelja(rs.getString("nelja"));
				kysymykset.setViis(rs.getString("Viis"));
				kysymykset.setKuus(rs.getString("kuus"));
				kysymykset.setSeiska(rs.getString("seiska"));
				kysymykset.setKasi(rs.getString("kasi"));
				kysymykset.setYsi(rs.getString("ysi"));
				kysymykset.setKyba(rs.getString("kyba"));
				kysymykset.setYkstoist(rs.getString("ykstoist"));
				kysymykset.setKakstoist(rs.getString("kakstoist"));
				kysymykset.setKolmetoist(rs.getString("kolmetoist"));
				kysymykset.setNeljatoist(rs.getString("neljatoist"));
				kysymykset.setViistoist(rs.getString("viistoist"));
				kysymykset.setKuustoist(rs.getString("kuustoist"));
				kysymykset.setSeittemantoist(rs.getString("seittemantoist"));
				kysymykset.setKaheksantoist(rs.getString("kaheksantoist"));
				kysymykset.setYheksantoist(rs.getString("yheksantoist"));
				

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
		String sql = "update kysymykset set Suomessa on liian helppo elää sosiaaliturvan varassa = ?, Kaupan ja muiden liikkeiden aukioloajat on vapautettava. = ?, Suomessa on siirryttävä perustuloon joka korvaisi nykyisen sosiaaliturvan vähimmäistason. = ?, Tyäntekijälle on turvattava lailla minimityäaika. = ?, Ansiosidonnaisen tyättämyysturvan kestoa pitää lyhentää. = ?, Euron ulkopuolella Suomi pärjäisi paremmin. = ?, Ruoan verotusta on varaa kiristää. = ?, Valtion ja kuntien taloutta on tasapainotettava ensisijaisesti leikkaamalla menoja. = ?, Lapsilisiä on korotettava ja laitettava verolle. = ?, Suomella ei ole varaa nykyisen laajuisiin sosiaali- ja terveyspalveluihin. = ?, Nato-jäsenyys vahvistaisi Suomen turvallisuuspoliittista asemaa. = ?, Suomeen tarvitaan enemmän poliiseja. = ?, Maahanmuuttoa Suomeen on rajoitettava terrorismin uhan vuoksi. = ?, Venäjän etupiiripolitiikka on uhka Suomelle. = ?, Verkkovalvonnassa valtion turvallisuus on tärkeämpää kuin kansalaisten yksityisyyden suoja. = ?, Suomen on osallistuttava Isisin vastaiseen taisteluun kouluttamalla Irakin hallituksen joukkoja. = ?, Parantumattomasti sairaalla on oltava oikeus avustettuun kuolemaan. = ?, Terveys- ja sosiaalipalvelut on tuotettava ensijaisesti julkisina palveluina. = ?, Viranomaisten pitää puuttua lapsiperheiden ongelmiin nykyistä herkemmin. = ?,  where ehdokas_id = ?";
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
	
	public Kysymykset getEhdokasInfo(int id) {
		Kysymykset result = null;
		String sql = "select * from ehdokkaat where id = ?";
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

