package org.itp.studentskasluzba.dto;

public class IspitiDTO {

	int id;
	String datum;
	int ocjena;
	int brojBodova;
	// Strani kljuc
	int nastavnikId;
	int predmetId;
	int studentiId;
	int studijskiProgramId;
	
	public IspitiDTO(int id, String datum, int ocjena, int brojBodova, int nastavnikId, int predmetId, int studentiId, int studijskiProgramId) {
		super();
		this.id = id;
		this.datum = datum;
		this.ocjena = ocjena;
		this.brojBodova = brojBodova;
		this.nastavnikId = nastavnikId;
		this.predmetId = predmetId;
		this.studentiId = studentiId;
		this.studijskiProgramId = studijskiProgramId;
	}
	
	public IspitiDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public int getOcjena() {
		return ocjena;
	}
	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	public int getBrojBodova() {
		return brojBodova;
	}
	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}
	public int getNastavnikId() {
		return nastavnikId;
	}
	public void setNastavnikId(int nastavnikId) {
		this.nastavnikId = nastavnikId;
	}
	public int getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(int predmetId) {
		this.predmetId = predmetId;
	}
	public int getStudentiId() {
		return studentiId;
	}
	public void setStudentiId(int studentiId) {
		this.studentiId = studentiId;
	}
	public int getStudijskiProgramId() {
		return studijskiProgramId;
	}
	public void setStudijskiProgramId(int studijskiProgramId) {
		this.studijskiProgramId = studijskiProgramId;
	}
	
}
