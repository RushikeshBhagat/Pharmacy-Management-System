import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSaleButton = new JButton("Sale Bill");
		btnSaleButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSB dsb = new DeleteSB();
				dsb.setVisible(true);
				dispose();
			}
		});
		btnSaleButton.setBounds(455, 309, 125, 41);
		contentPane.add(btnSaleButton);

		JButton btnPurchaseButton = new JButton("Purchase Bill");
		btnPurchaseButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnPurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePB dpb = new DeletePB();
				dpb.setVisible(true);
				dispose();
			}
		});
		btnPurchaseButton.setBounds(755, 309, 125, 41);
		contentPane.add(btnPurchaseButton);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
				dispose();
			}
		});
		btnBackButton.setBounds(1217, 50, 125, 41);
		contentPane.add(btnBackButton);
		
		JLabel PopulateLabel = new JLabel("Delete Records");
		PopulateLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		PopulateLabel.setBounds(554, 41, 216, 48);
		contentPane.add(PopulateLabel);

	}

}
