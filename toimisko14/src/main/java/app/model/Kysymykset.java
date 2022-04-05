package app.model;
import java.io.Serializable;
public class Kysymykset implements Serializable{
	

	private String eka;
	private String toka;
	private String kolmas;
	private String nelja;
	private String viis;
	private String kuus;
	private String seiska;
	private String kasi;
	private String ysi;
	private String kyba;
	private String ykstoist;
	private String kakstoist;
	private String kolmetoist;
	private String neljatoist;
	private String viistoist;
	private String kuustoist;
	private String seittemantoist;
	private String kaheksantoist;
	private String yheksantoist;
	
	
	public String getEka() {
		return eka;
	}
	public void setEka(String eka) {
		this.eka = eka;
	}
	public String getToka() {
		return toka;
	}
	public void setToka(String toka) {
		this.toka = toka;
	}
	public String getKolmas() {
		return kolmas;
	}
	public void setKolmas(String kolmas) {
		this.kolmas = kolmas;
	}
	public String getNelja() {
		return nelja;
	}
	public void setNelja(String nelja) {
		this.nelja = nelja;
	}
	public String getViis() {
		return viis;
	}
	public void setViis(String viis) {
		this.viis = viis;
	}
	public String getKuus() {
		return kuus;
	}
	public void setKuus(String kuus) {
		this.kuus = kuus;
	}
	public String getSeiska() {
		return seiska;
	}
	public void setSeiska(String seiska) {
		this.seiska = seiska;
	}
	public String getKasi() {
		return kasi;
	}
	public void setKasi(String kasi) {
		this.kasi = kasi;
	}
	public String getYsi() {
		return ysi;
	}
	public void setYsi(String ysi) {
		this.ysi = ysi;
	}
	public String getKyba() {
		return kyba;
	}
	public void setKyba(String kyba) {
		this.kyba = kyba;
	}
	public String getYkstoist() {
		return ykstoist;
	}
	public void setYkstoist(String ykstoista) {
		this.ykstoist = ykstoista;
	}
	public String getKakstoist() {
		return kakstoist;
	}
	public void setKakstoist(String kakstoist) {
		this.kakstoist = kakstoist;
	}
	public String getKolmetoist() {
		return kolmetoist;
	}
	public void setKolmetoist(String kolmetoist) {
		this.kolmetoist = kolmetoist;
	}
	public String getNeljatoist() {
		return neljatoist;
	}
	public void setNeljatoist(String neljatoist) {
		this.neljatoist = neljatoist;
	}
	public String getViistoist() {
		return viistoist;
	}
	public void setViistoist(String viistoist) {
		this.viistoist = viistoist;
	}
	public String getKuustoist() {
		return kuustoist;
	}
	public void setKuustoist(String kuustoist) {
		this.kuustoist = kuustoist;
	}
	public String getSeittemantoist() {
		return seittemantoist;
	}
	public void setSeittemantoist(String seittemantoist) {
		this.seittemantoist = seittemantoist;
	}
	public String getKaheksantoist() {
		return kaheksantoist;
	}
	public void setKaheksantoist(String kaheksantoist) {
		this.kaheksantoist = kaheksantoist;
	}
	public String getYheksantoist() {
		return yheksantoist;
	}
	public void setYheksantoist(String yheksantoist) {
		this.yheksantoist = yheksantoist;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return eka+" "+toka+" "+kolmas+" "+nelja+" "+viis+" "+kuus+" "+seiska+" "+kasi+" "+ysi+" "+kyba+" "+ykstoist+" "+kakstoist+" "+kolmetoist+" "+neljatoist+" "+viistoist+" "+kuustoist+" "+seittemantoist+" "+kaheksantoist+" "+yheksantoist;
		
	}

}
