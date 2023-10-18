package telefon.pojo;

import java.sql.Date;

public class Telefon {

	private int id;
	private String marca;
	private int dimensiune;
	private Date aparitie;
	
	public Telefon() {
	}
	
	public Telefon(int id, String marca, int dimensiune, Date aparitie) {
		super();
		this.id = id;
		this.marca = marca;
		this.dimensiune = dimensiune;
		this.aparitie = aparitie;
	}

	public Telefon(String marca, int dimensiune, Date aparitie) {
		super();
		this.marca = marca;
		this.dimensiune = dimensiune;
		this.aparitie = aparitie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getDimensiune() {
		return dimensiune;
	}

	public void setDimensiune(int dimensiune) {
		this.dimensiune = dimensiune;
	}

	public Date getAparitie() {
		return aparitie;
	}

	public void setAparitie(Date aparitie) {
		this.aparitie = aparitie;
	}
	
	
	
	
}
