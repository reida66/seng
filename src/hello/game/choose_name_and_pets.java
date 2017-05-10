package hello.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class choose_name_and_pets {

	 JFrame frame;
	 private JTextField txtName;
	 private JButton btnNewButton;
	 private JButton btnNewButton_1;
	 private JButton btnNewButton_2;
	 private JButton btnNewButton_3;
	 private JButton btnNewButton_4;
	 private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choose_name_and_pets window = new choose_name_and_pets();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public choose_name_and_pets() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Name?");
		lblNewLabel_4.setBounds(73, 69, 70, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtName = new JTextField();
		txtName.setText("name?");
		txtName.setBounds(194, 67, 114, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnPet = new JButton("Dog");
		btnPet.setBounds(38, 125, 117, 25);
		frame.getContentPane().add(btnPet);
		
		btnNewButton = new JButton("Pig");
		btnNewButton.setBounds(38, 162, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cat");
		btnNewButton_1.setBounds(38, 199, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("bird");
		btnNewButton_2.setBounds(249, 125, 117, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("fish");
		btnNewButton_3.setBounds(249, 162, 117, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("giraffe");
		btnNewButton_4.setBounds(249, 199, 117, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("NEXT");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameGUI.setNext();
			}
		});
		btnNewButton_5.setBounds(307, 236, 117, 25);
		frame.getContentPane().add(btnNewButton_5);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
