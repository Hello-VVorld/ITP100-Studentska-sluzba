package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CiklusUnosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		btnUnos.setBounds(341, 226, 91, 23);
		contentPane.add(btnUnos);
	}

}
