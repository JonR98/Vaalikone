package app.model;

import java.io.Serializable;

public class Ehdokas implements Serializable{
	private int id;
	private String etunimi;
	private float sukunimi;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String miksi_eduskuntaan;
	private String mita_asioita_haluat_edistaa;
	private String ammatti;
	
	


	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}
	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	public int getIka() {
		return ika;
	}
	public void setIka(int ika) {
		this.ika = ika;
	}
	public String getMiksi_eduskuntaan() {
		return miksi_eduskuntaan;
	}
	public void setMiksi_eduskuntaan(String miksi_eduskuntaan) {
		this.miksi_eduskuntaan = miksi_eduskuntaan;
	}
	public String getMita_asioita_haluat_edistaa() {
		return mita_asioita_haluat_edistaa;
	}
	public void setMita_asioita_haluat_edistaa(String mita_asioita_haluat_edistaa) {
		this.mita_asioita_haluat_edistaa = mita_asioita_haluat_edistaa;
	}
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtunimi() {
		return getEtunimi();
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public float getSukunimi() {
		return getSukunimi();
	}
	public void setSukunimi(float sukunimi) {
		this.sukunimi = sukunimi;
	}
	public void setSukunimi(String s) {
		try {
			this.sukunimi=Float.parseFloat(s);
		}
		catch(NumberFormatException e) {
			this.sukunimi=0;
		}
	}
	
	
	public String toString() {
		return id+" "+etunimi+" "+sukunimi+" "+puolue+" "+kotipaikkakunta+" "+ika+" "+miksi_eduskuntaan+" "+mita_asioita_haluat_edistaa+" "+ammatti;
	}
}
