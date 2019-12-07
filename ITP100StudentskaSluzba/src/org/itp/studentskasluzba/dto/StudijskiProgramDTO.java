package org.itp.studentskasluzba.dto;

public class StudijskiProgramDTO {
	
	int id;
	String naziv;
	// Strani kljuc
	int ciklusId;
	
	public StudijskiProgramDTO(int id, String naziv, int ciklusId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ciklusId = ciklusId;
	}
	
	public StudijskiProgramDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getCiklusId() {
		return ciklusId;
	}
	public void setCiklusId(int ciklusId) {
		this.ciklusId = ciklusId;
	}
	
}
