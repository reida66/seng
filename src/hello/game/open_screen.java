package hello.game;
import hello.game.gameGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;


import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class open_screen {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					open_screen window = new open_screen();
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
	public open_screen() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/cosc/student/are66/Downloads/PIXILART-LOCAL (1).png"));
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 555, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumberOfPlayers = new JLabel("Number of Players:");
		lblNumberOfPlayers.setBounds(121, 99, 135, 15);
		frame.getContentPane().add(lblNumberOfPlayers);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days:");
		lblNumberOfDays.setBounds(121, 156, 135, 15);
		frame.getContentPane().add(lblNumberOfDays);
		
		JSpinner spinnerNumOdPlayers = new JSpinner();
		spinnerNumOdPlayers.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gameGUI.setNumOfPlayers(spinnerNumOdPlayers.getValue());
			}
		});
		spinnerNumOdPlayers.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinnerNumOdPlayers.setBounds(416, 97, 39, 20);
		frame.getContentPane().add(spinnerNumOdPlayers);
		
		JSpinner spinnerNumOfDays = new JSpinner();
		spinnerNumOfDays.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gameGUI.setNumOfDays(spinnerNumOfDays.getValue());
			}
		});
		spinnerNumOfDays.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerNumOfDays.setBounds(416, 140, 44, 20);
		frame.getContentPane().add(spinnerNumOfDays);
		
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gameGUI.setNext();
				frame.dispose();
				gameGUI.set_up_players();
				
			}
		});
		btnNext.setBounds(363, 276, 117, 25);
		frame.getContentPane().add(btnNext);
		
		JButton btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.setBounds(90, 276, 135, 25);
		frame.getContentPane().add(btnHowToPlay);
		
		JLabel lblNewLabel = new JLabel("The Game");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setBounds(175, 25, 311, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/cosc/student/are66/Downloads/PIXILART-LOCAL (1).png"));
		lblNewLabel_1.setBounds(0, 0, 1024, 576);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
	
}
