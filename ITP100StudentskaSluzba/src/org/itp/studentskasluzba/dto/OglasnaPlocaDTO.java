package org.itp.studentskasluzba.dto;

public class OglasnaPlocaDTO {

	int id;
	String obavijest;
	
	public OglasnaPlocaDTO(int id, String obavijest) {
		super();
		this.id = id;
		this.obavijest = obavijest;
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
	public String getObavijest() {
		return obavijest;
	}
	public void setObavijest(String obavijest) {
		this.obavijest = obavijest;
	}
	
}
