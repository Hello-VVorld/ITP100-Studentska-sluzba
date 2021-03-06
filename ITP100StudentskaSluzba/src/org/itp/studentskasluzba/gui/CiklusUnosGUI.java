package org.itp.studentskasluzba.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.itp.studentskasluzba.dto.CiklusDTO;
import org.itp.studentskasluzba.dao.CiklusDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CiklusUnosGUI extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnUnos;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CiklusUnosGUI frame = new CiklusUnosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CiklusUnosGUI() {
		setTitle("Ciklus | Unos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(10, 11, 127, 14);
		contentPane.add(lblNaziv);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 263, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnUnos = new JButton("UNOS");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nazivCiklusa = textField.getText();
				CiklusDTO c = new CiklusDTO();
				c.setNaziv(nazivCiklusa);
				boolean uspjesno = CiklusDAO.dodajCiklus(c);
				String bool = uspjesno ? "Uspjesno ste dodali ciklus." : "Dogodila se greska pri dodavanju ciklusa.";
				JOptionPane.showMessageDialog(null, bool);
			}
		});
		btnUnos.setBounds(341, 226, 91, 23);
		contentPane.add(btnUnos);
		
		JButton btnPrikazSvihCiklusa = new JButton("Prikaz svih ciklusa");
		btnPrikazSvihCiklusa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CiklusPrikazSvihGUI prikazSvih=new CiklusPrikazSvihGUI();
				prikazSvih.setVisible(true);
			}
		});
		btnPrikazSvihCiklusa.setBounds(10, 226, 186, 23);
		contentPane.add(btnPrikazSvihCiklusa);
	}
}
