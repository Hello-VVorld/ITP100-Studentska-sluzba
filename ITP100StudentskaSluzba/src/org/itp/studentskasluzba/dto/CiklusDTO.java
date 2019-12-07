package org.itp.studentskasluzba.dto;

public class CiklusDTO {

	int id;
	String naziv;
	
	public CiklusDTO(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	
	public CiklusDTO() {
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

	@Override
	public String toString() {
		return id + "-" + naziv;
	}
	
}
