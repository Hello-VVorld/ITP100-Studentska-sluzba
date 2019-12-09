package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.itp.studentskasluzba.dao.OglasDAO;
import org.itp.studentskasluzba.dto.OglasDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class OglasUnosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnUnos;
	private JTextArea textArea;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OglasUnosGUI frame = new OglasUnosGUI();
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
	public OglasUnosGUI() {
		setTitle("Oglas | Unos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(10, 11, 157, 14);
		contentPane.add(lblNaziv);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 273, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSadrzaj = new JLabel("Sadrzaj:");
		lblSadrzaj.setBounds(10, 67, 157, 14);
		contentPane.add(lblSadrzaj);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 95, 273, 59);
		contentPane.add(textArea);
		
		JLabel lblOglasnaPloca = new JLabel("Oglasna ploca:");
		lblOglasnaPloca.setBounds(10, 165, 157, 14);
		contentPane.add(lblOglasnaPloca);
		
		Vector<OglasDTO> sviOglasi = OglasDAO.getAll();
		
		JComboBox comboBox = new JComboBox(sviOglasi);
		comboBox.setBounds(10, 190, 157, 22);
		contentPane.add(comboBox);
		
		JButton btnUnos = new JButton("UNOS");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nazivOg = textField.getText();
				String sadrzajOg = textArea.getText();
				String oglas = comboBox.getSelectedItem().toString();
				String parsiranOglas[] = oglas.split("-");
				int idOglas = Integer.parseInt(parsiranOglas[0]);
				OglasDTO og = new OglasDTO();
				og.setNaziv(nazivOg);
				og.setSadrzaj(sadrzajOg);
				og.setOglasnaPlocaId(idOglas);
				boolean uspjesno = OglasDAO.dodajOglas(og);
				String bool = uspjesno ? "Uspjesno ste dodali oglas." : "Dogodila se greska pri dodavanju oglas.";
				JOptionPane.showMessageDialog(null, bool);
				
			}
		});
		btnUnos.setBounds(335, 228, 89, 23);
		contentPane.add(btnUnos);
	}
}
