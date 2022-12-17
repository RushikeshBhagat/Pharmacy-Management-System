import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.naming.directory.SearchControls;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsertButton = new JButton("Populate");
		btnInsertButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Populate pop = new Populate();
				pop.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnInsertButton.setBounds(146, 343, 105, 41);
		contentPane.add(btnInsertButton);
		
		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update up=new Update();
				up.setVisible(true);
				dispose();
			}
		});
		btnUpdateButton.setBounds(396, 343, 105, 41);
		contentPane.add(btnUpdateButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del=new Delete();
				del.setVisible(true);
				dispose();
			}
		});
		btnDeleteButton.setBounds(646, 343, 105, 41);
		contentPane.add(btnDeleteButton);
		
		JButton btnQueryButton = new JButton("Query");
		btnQueryButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQueryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query query=new Query();
				query.setVisible(true);
				dispose();
			}
		});
		btnQueryButton.setBounds(896, 343, 105, 41);	
		contentPane.add(btnQueryButton);
		
		JButton btnSearchButton = new JButton("Search");
		btnSearchButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search search=new Search();
				search.setVisible(true);
				dispose();;
			}
		});
		btnSearchButton.setBounds(1146, 343, 105, 41);
		contentPane.add(btnSearchButton);
		
		JLabel ProjectTitleLabel = new JLabel("Pharmacy Management System");
		ProjectTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		ProjectTitleLabel.setBounds(396, 48, 689, 72);
		contentPane.add(ProjectTitleLabel);

		JButton btnExitButton = new JButton("Exit");
		btnExitButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		btnExitButton.setBounds(1217, 20, 125, 41);
		contentPane.add(btnExitButton);

		
		

		
	}

}
