package org.itp.studentskasluzba.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.itp.studentskasluzba.dao.OglasnaPlocaDAO;
import org.itp.studentskasluzba.dto.OglasnaPlocaDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class OglasnaPlocaUnosGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnUnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OglasnaPlocaUnosGUI frame = new OglasnaPlocaUnosGUI();
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
	public OglasnaPlocaUnosGUI() {
		setTitle("OglasnaPloca | Unos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 37, 310, 165);
		contentPane.add(textArea);
		
		JLabel lblObavjest = new JLabel("Obavijest:");
		lblObavjest.setBounds(10, 11, 162, 14);
		contentPane.add(lblObavjest);
		
		JButton btnUnos = new JButton("UNOS");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obavijest = textArea.getText();
				OglasnaPlocaDTO o = new OglasnaPlocaDTO();
				o.setObavijest(obavijest);
				boolean uspjesno = OglasnaPlocaDAO.dodajOglasnaPloca(o);
				String bool = uspjesno ? "Uspjesno ste dodali na oglasnu plocu." : "Dogodila se greska pri dodavanju na oglasnu plocu.";
				JOptionPane.showMessageDialog(null, bool);
			}
		});
		btnUnos.setBounds(341, 239, 91, 23);
		contentPane.add(btnUnos);
		

	}
}
