package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class StudijskiProgramUnosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		lblUnesiteNaziv.setBounds(10, 11, 80, 14);
		contentPane.add(lblUnesiteNaziv);
		
		textField = new JTextField();
		textField.setBounds(4, 36, 315, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOdaberiteCiklus = new JLabel("Odaberite ciklus:");
		lblOdaberiteCiklus.setBounds(10, 65, 80, 14);
		contentPane.add(lblOdaberiteCiklus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 90, 29, 22);
		contentPane.add(comboBox);
		
		JButton btnUnesi = new JButton("UNESI");
		btnUnesi.setBounds(341, 239, 91, 23);
		contentPane.add(btnUnesi);
	}
}
