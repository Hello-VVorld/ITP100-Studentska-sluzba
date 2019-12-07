package org.itp.studentskasluzba.dto;

public class PredmetDTO {

	int id;
	String naziv;
	boolean obavezan;
	int ects;
	
	public PredmetDTO(int id, String naziv, boolean obavezan, int ects) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.obavezan = obavezan;
		this.ects = ects;
	}
	
	public PredmetDTO() {
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
	public boolean isObavezan() {
		return obavezan;
	}
	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	
}
