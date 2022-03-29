package app.model;

import java.io.Serializable;

public class Ehdokas implements Serializable{
	private int id;
	private String etunimi;
	private float sukunimi;
	


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
		return id+" "+etunimi+" ("+sukunimi+")";
	}
}
