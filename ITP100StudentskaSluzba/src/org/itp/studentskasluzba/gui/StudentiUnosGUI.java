package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.itp.studentskasluzba.dao.StudentiDAO;
import org.itp.studentskasluzba.dto.StudentiDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentiUnosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnUpis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentiUnosGUI frame = new StudentiUnosGUI();
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
	public StudentiUnosGUI() {
		setTitle("Studenti | Unos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 11, 171, 14);
		contentPane.add(lblIme);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 263, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(10, 67, 171, 14);
		contentPane.add(lblPrezime);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 263, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBrojIndeksa = new JLabel("Broj indeksa:");
		lblBrojIndeksa.setBounds(10, 123, 171, 14);
		contentPane.add(lblBrojIndeksa);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 148, 263, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGodinaUpisa = new JLabel("Godina upisa:");
		lblGodinaUpisa.setBounds(10, 179, 171, 14);
		contentPane.add(lblGodinaUpisa);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 204, 263, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnUpis = new JButton("UNOS");
		btnUpis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String imeStudenta = textField.getText();
				String prezimeStudenta = textField_1.getText();
				int indeksStudenta = Integer.parseInt(textField_2.getText());
				int upisStudenta = Integer.parseInt(textField_3.getText());
				
				StudentiDTO s = new StudentiDTO();
				s.setIme(imeStudenta);
				s.setPrezime(prezimeStudenta);
				s.setIndeks(indeksStudenta);
				s.setUpis(upisStudenta);
				boolean uspjesno = StudentiDAO.dodajStudenti(s);
				String bool = uspjesno ? "Uspjesno ste dodali studenta." : "Dogodila se greska pri dodavanju studenta.";
				JOptionPane.showMessageDialog(null, bool);
			}
		});
		btnUpis.setBounds(341, 239, 91, 23);
		contentPane.add(btnUpis);
	}
}
