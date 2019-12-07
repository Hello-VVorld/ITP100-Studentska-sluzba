package org.itp.studentskasluzba.dto;

public class OglasnaPlocaDTO {

	int id;
	String obavjest;
	
	public OglasnaPlocaDTO(int id, String obavjest) {
		super();
		this.id = id;
		this.obavjest = obavjest;
	}
	
	public OglasnaPlocaDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObavjest() {
		return obavjest;
	}
	public void setObavjest(String obavjest) {
		this.obavjest = obavjest;
	}
	
}
