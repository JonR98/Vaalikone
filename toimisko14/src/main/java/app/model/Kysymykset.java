package app.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Entity;
@Table(name = "kysymykset")
    @Entity
    @NamedQuery(name="kysymys_id.findAll", query="SELECT * FROM kysymys_id")
    public class Kysymykset implements Serializable {
    	private static final long serialVersionUID = 1L;
    	@Id
    	@Column(name = "kysymys_id")
    	private String kysymys_id;
    	

//	private String eka;
//	private String toka;
//	private String kolmas;
//	private String nelja;
//	private String viis;
//	private String kuus;
//	private String seiska;
//	private String kasi;
//	private String ysi;
//	private String kyba;
//	private String ykstoist;
//	private String kakstoist;
//	private String kolmetoist;
//	private String neljatoist;
//	private String viistoist;
//	private String kuustoist;
//	private String seittemantoist;
//	private String kaheksantoist;
//	private String yheksantoist;
	
	

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
