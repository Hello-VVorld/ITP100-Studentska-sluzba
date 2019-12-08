package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.itp.studentskasluzba.dao.NastavnikDAO;
import org.itp.studentskasluzba.dto.NastavnikDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NastavnikUpisGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnUnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NastavnikUpisGUI frame = new NastavnikUpisGUI();
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
	public NastavnikUpisGUI() {
		setTitle("Nastavnici | Upis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 11, 149, 14);
		contentPane.add(lblIme);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 235, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(10, 67, 149, 14);
		contentPane.add(lblPrezime);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 235, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblZvanje = new JLabel("Zvanje:");
		lblZvanje.setBounds(10, 123, 149, 14);
		contentPane.add(lblZvanje);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 148, 235, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnUnos = new JButton("UNOS");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imeNastavnika = textField.getText();
				String prezimeNastavnika = textField_1.getText();
				String zvanjeNastavnika = textField_2.getText();
				
				NastavnikDTO n = new NastavnikDTO();
				n.setIme(imeNastavnika);
				n.setPrezime(prezimeNastavnika);
				n.setZvanje(zvanjeNastavnika);
				boolean uspjesno = NastavnikDAO.dodajNastavnik(n);
				String bool = uspjesno ? "Uspjesno ste dodali nastavnika." : "Dogodila se greska pri dodavanju nastavnika.";
				JOptionPane.showMessageDialog(null, bool);
			}
		});
		btnUnos.setBounds(341, 239, 91, 23);
		contentPane.add(btnUnos);
	}

}
