package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.itp.studentskasluzba.dao.CiklusDAO;
import org.itp.studentskasluzba.dao.StudijskiProgramDAO;
import org.itp.studentskasluzba.dto.CiklusDTO;
import org.itp.studentskasluzba.dto.StudijskiProgramDTO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class StudijskiProgramUnosGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnUnesi;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudijskiProgramUnosGUI frame = new StudijskiProgramUnosGUI();
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
	public StudijskiProgramUnosGUI() {
		setTitle("Studijski program | Unos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteNaziv = new JLabel("Unesite naziv:");
		lblUnesiteNaziv.setBounds(10, 11, 157, 14);
		contentPane.add(lblUnesiteNaziv);
		
		textField = new JTextField();
		textField.setBounds(4, 36, 315, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOdaberiteCiklus = new JLabel("Odaberite ciklus:");
		lblOdaberiteCiklus.setBounds(10, 65, 157, 14);
		contentPane.add(lblOdaberiteCiklus);
		
		Vector<CiklusDTO> sviCiklusi = CiklusDAO.getAll();
		
		JComboBox comboBox = new JComboBox(sviCiklusi);
		comboBox.setBounds(10, 90, 157, 22);
		contentPane.add(comboBox);
		
		JButton btnUnesi = new JButton("UNESI");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nazivSP = textField.getText();
				String ciklus = comboBox.getSelectedItem().toString();
				String parsiranCiklus[] = ciklus.split("-");
				int idCiklus = Integer.parseInt(parsiranCiklus[0]);
				StudijskiProgramDTO sp = new StudijskiProgramDTO();
				sp.setNaziv(nazivSP);
				CiklusDTO c = new CiklusDTO();
				c.setId(idCiklus);
				//sp.setCiklusId(c);
				boolean uspjesno = StudijskiProgramDAO.dodajStudijskiProgram(sp);
				String bool = uspjesno ? "Uspjesno ste dodali program." : "Dogodila se greska pri dodavanju program.";
				JOptionPane.showMessageDialog(null, bool);
			}
		});
		btnUnesi.setBounds(341, 239, 91, 23);
		contentPane.add(btnUnesi);
	}
}
