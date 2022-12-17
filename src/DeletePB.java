import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class DeletePB extends JFrame {

	private JPanel contentPane;
	private JTextField txtPurchaseVoucherID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePB frame = new DeletePB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void clearFields() {
		txtPurchaseVoucherID.setText(null);
	}
	/**
	 * Create the frame.
	 */
	public DeletePB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del = new Delete();
				del.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnBackButton.setBounds(1217, 20, 125, 41);
		contentPane.add(btnBackButton);

		JLabel PurchaseLabel = new JLabel("Purchase Bill");
		PurchaseLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		PurchaseLabel.setBounds(582, 21, 186, 28);
		contentPane.add(PurchaseLabel);
		
		JLabel PurchaseVoucherIDLabel = new JLabel("Purchase Voucher");
		PurchaseVoucherIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseVoucherIDLabel.setBounds(371, 166, 158, 41);
		contentPane.add(PurchaseVoucherIDLabel);
		
		txtPurchaseVoucherID = new JTextField();
		txtPurchaseVoucherID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseVoucherID.setBounds(582, 166, 186, 41);
		contentPane.add(txtPurchaseVoucherID);
		txtPurchaseVoucherID.setColumns(10);
		
		JButton btnDeleteButton = new JButton("DELETE");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Delete from F21_S001_5_purchase_bill where purchaseVoucherID='"+txtPurchaseVoucherID.getText()+"' ";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					
					pst.execute();
					pst.close();
					
					clearFields();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnDeleteButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeleteButton.setBounds(614, 562, 125, 41);
		contentPane.add(btnDeleteButton);

	}

}
