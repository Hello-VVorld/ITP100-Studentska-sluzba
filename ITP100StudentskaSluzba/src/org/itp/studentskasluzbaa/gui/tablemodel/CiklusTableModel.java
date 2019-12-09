package org.itp.studentskasluzbaa.gui.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.itp.studentskasluzba.dto.CiklusDTO;

public class CiklusTableModel extends AbstractTableModel {

	// definisemo listu ciklusa
	private List<CiklusDTO> ciklusi;

	public CiklusTableModel(List<CiklusDTO> ciklusi) {
		this.ciklusi = ciklusi;
	}

	@Override
	public int getRowCount() {
		return ciklusi.size();
	}

	@Override
	public int getColumnCount() {
		return 2; // imamo dvije kolone u tabeli ciklus: id i naziv
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CiklusDTO ciklus = ciklusi.get(rowIndex);
		Object value = null;

		switch (columnIndex) {
		case 0:
			value = ciklus.getId();
			break;
		case 1:
			value = ciklus.getNaziv();
			break;
		}

		return value;
	}

	// za zaglavlje tabele
	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
		case 0:
			name = "ID";
			break;
		case 1:
			name = "Naziv";
			break;
		}
		return name;
	}

}
