package org.itp.studentskasluzba.dto;

public class OglasDTO {

	int id;
	String naziv;
	String sadrzaj;
	int datum;
	boolean aktivan;
	// Strani kljuc
	int oglasnaPlocaId;
	
	public OglasDTO(int id, String naziv, String sadrzaj, int datum, boolean aktivan, int oglasnaPlocaId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.sadrzaj = sadrzaj;
		this.datum = datum;
		this.aktivan = aktivan;
		this.oglasnaPlocaId = oglasnaPlocaId;
	}
	
	public OglasDTO() {
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
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public int getDatum() {
		return datum;
	}
	public void setDatum(int datum) {
		this.datum = datum;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	public int getOglasnaPlocaId() {
		return oglasnaPlocaId;
	}
	public void setOglasnaPlocaId(int oglasnaPlocaId) {
		this.oglasnaPlocaId = oglasnaPlocaId;
	}
	
}
