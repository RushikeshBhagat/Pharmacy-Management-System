import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Query extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query frame = new Query();
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
	public Query() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PopulateLabel = new JLabel("Business Goals");
		PopulateLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		PopulateLabel.setBounds(576, 20, 216, 48);
		contentPane.add(PopulateLabel);
		
		JButton btnBG1Button = new JButton("Business Goal 1");
		btnBG1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BG1 bg1=new BG1();
				bg1.setVisible(true);
				dispose();
				
			}
		});
		btnBG1Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnBG1Button.setBounds(393, 314, 257, 48);
		contentPane.add(btnBG1Button);
		
		JButton btnBG2Button = new JButton("Business Goal 2");
		btnBG2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BG2 bg2=new BG2();
				bg2.setVisible(true);
				dispose();
			}
		});
		btnBG2Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnBG2Button.setBounds(747, 314, 257, 48);
		contentPane.add(btnBG2Button);
		
		JButton btnBG3Button = new JButton("Business Goal 3");
		btnBG3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BG3 bg3=new BG3();
				bg3.setVisible(true);
				dispose();
			}
		});
		btnBG3Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnBG3Button.setBounds(393, 412, 257, 48);
		contentPane.add(btnBG3Button);
		
		JButton btnBG4Button = new JButton("Business Goal 4");
		btnBG4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BG4 bg4=new BG4();
				bg4.setVisible(true);
				dispose();
			}
		});
		btnBG4Button.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnBG4Button.setBounds(747, 412, 257, 48);
		contentPane.add(btnBG4Button);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnBackButton.setBounds(1217, 20, 125, 41);
		contentPane.add(btnBackButton);


	}

}
