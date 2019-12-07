package org.itp.studentskasluzba.dto;

public class NastavnikDTO {

	int id;
	String ime;
	String prezime;
	String zvanje;
	
	public NastavnikDTO(int id, String ime, String prezime, String zvanje) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}
	
	public NastavnikDTO() {
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
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
}
