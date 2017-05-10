package hello.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class set_upplayers {

	JFrame frame;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					set_upplayers window = new set_upplayers();
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
	public set_upplayers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 1024, 576));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 1024, 576));
		frame.getContentPane().setMaximumSize(new Dimension(576, 1024));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How many pets?");
		lblNewLabel.setBounds(52, 93, 130, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWhatIsYour = new JLabel("What is your name?");
		lblWhatIsYour.setBounds(55, 153, 152, 15);
		frame.getContentPane().add(lblWhatIsYour);
		
		JSpinner spinnerPetNum = new JSpinner();
		spinnerPetNum.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gameGUI.setNumberofPets(spinnerPetNum.getValue());
			}
		});
		spinnerPetNum.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spinnerPetNum.setBounds(259, 91, 28, 20);
		frame.getContentPane().add(spinnerPetNum);
		
		txtName = new JTextField();
		txtName.setText("name?");
		txtName.setBounds(213, 151, 114, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnStartGame = new JButton("Next");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				//gameGUI.setNext();
				gameGUI.setnumofdone();
				gameGUI.setPlayerName(txtName.getText());
				gameGUI.addPlayer();
				
				
				frame.repaint();
				if (gameGUI.numofDone == gameGUI.numberOfPlayers){
					System.out.println(gameGUI.players);
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
				
			}


		});
		btnStartGame.setBounds(259, 211, 117, 25);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							open_screen window = new open_screen();
							window.frame.setVisible(true);
							frame.setVisible(false);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBack.setBounds(55, 211, 117, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblplayerName = new JLabel("Player "+ (gameGUI.numofDone +1));
		lblplayerName.setBounds(160, 40, 130, 15);
		frame.getContentPane().add(lblplayerName);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/cosc/student/are66/Downloads/PIXILART-LOCAL (2).png"));
		lblNewLabel_1.setBounds(0, 0, 448, 274);
		frame.getContentPane().add(lblNewLabel_1);
		
	
	}
	
		
}
