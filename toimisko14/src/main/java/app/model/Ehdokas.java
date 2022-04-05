package app.model;

import java.io.Serializable;

public class Ehdokas implements Serializable{
	private int id;
	private String etunimi;
	private String sukunimi;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String miksi_eduskuntaan;
	private String mita_asioita_haluat_edistaa;
	private String ammatti;
	
	


	public String getpuolue() {
		return puolue;
	}
	public void setpuolue(String puolue) {
		this.puolue = puolue;
	}
	public String getkotipaikkakunta() {
		return kotipaikkakunta;
	}
	public void setkotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	public int getika() {
		return ika;
	}
	public void setika(int ika) {
		this.ika = ika;
	}
	public String getmiksi_eduskuntaan() {
		return miksi_eduskuntaan;
	}
	public void setmiksi_eduskuntaan(String miksi_eduskuntaan) {
		this.miksi_eduskuntaan = miksi_eduskuntaan;
	}
	public String getmita_asioita_haluat_edistaa() {
		return mita_asioita_haluat_edistaa;
	}
	public void setmita_asioita_haluat_edistaa(String mita_asioita_haluat_edistaa) {
		this.mita_asioita_haluat_edistaa = mita_asioita_haluat_edistaa;
	}
	public String getammatti() {
		return ammatti;
	}
	public void setammatti(String ammatti) {
		this.ammatti = ammatti;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getetunimi() {
		return this.etunimi;
	}
	public void setetunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getsukunimi() {
		return this.sukunimi;
	}
	public void setsukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	
	
	
	public String toString() {
		return id+" "+etunimi+" "+sukunimi+" "+puolue+" "+kotipaikkakunta+" "+ika+" "+miksi_eduskuntaan+" "+mita_asioita_haluat_edistaa+" "+ammatti;
	}
}

