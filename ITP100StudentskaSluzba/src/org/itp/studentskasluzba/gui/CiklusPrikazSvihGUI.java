package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.itp.studentskasluzba.dao.CiklusDAO;
import org.itp.studentskasluzba.dto.CiklusDTO;
import org.itp.studentskasluzbaa.gui.tablemodel.CiklusTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Window.Type;

public class CiklusPrikazSvihGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CiklusPrikazSvihGUI frame = new CiklusPrikazSvihGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CiklusPrikazSvihGUI() {
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Prikaz svih ciklusa iz baze");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//1. kreiramo listu CiklusDTO objekata
		Vector<CiklusDTO> ciklusi=CiklusDAO.getAll();
		List<CiklusDTO> ciklusiKaoLista=new ArrayList<>(ciklusi);
		
		//2. kreiranje table modela
		CiklusTableModel ctm=new CiklusTableModel(ciklusiKaoLista);
		//3. proslijedimo table model tabeli kroz konstruktor JTable
		table = new JTable(ctm);
		table.setBounds(10, 11, 414, 240);
		//kad se dodaje skroler, ova linija ispod je visak
		//contentPane.add(table);
		
		//4. dodati skroler da se prikaze zaglavlje
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 240);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
			
		
	}
}




