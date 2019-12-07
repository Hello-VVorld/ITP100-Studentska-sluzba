package org.itp.studentskasluzba.dto;

public class StudentiDTO {

	int id;
	String ime;
	String prezime;
	int indeks;
	int upis;
	
	public StudentiDTO(int id, String ime, String prezime, int indeks, int upis) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.upis = upis;
	}
	
	public StudentiDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public int getIndeks() {
		return indeks;
	}
	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}
	public int getUpis() {
		return upis;
	}
	public void setUpis(int upis) {
		this.upis = upis;
	}
	
}
