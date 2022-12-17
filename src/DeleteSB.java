import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class DeleteSB extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtOrderID;
	private JTextField txtSaleVoucherID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSB frame = new DeleteSB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void clearFields() {
		
		txtCustomerID.setText(null);
		txtOrderID.setText(null);
		txtSaleVoucherID.setText(null);
	}
	/**
	 * Create the frame.
	 */
	public DeleteSB() {	
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

		JLabel PurchaseLabel = new JLabel("Sale Bill");
		PurchaseLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		PurchaseLabel.setBounds(582, 21, 186, 28);
		contentPane.add(PurchaseLabel);
		
		JLabel CustomerIDLabel = new JLabel("Customer ID");
		CustomerIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		CustomerIDLabel.setBounds(406, 181, 116, 41);
		contentPane.add(CustomerIDLabel);
		
		JLabel OrderIDLabel = new JLabel("Order ID");
		OrderIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		OrderIDLabel.setBounds(406, 303, 116, 41);
		contentPane.add(OrderIDLabel);

		JLabel SaleVoucherIDLabel = new JLabel("Sale Voucher");
		SaleVoucherIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleVoucherIDLabel.setBounds(406, 425, 116, 41);
		contentPane.add(SaleVoucherIDLabel);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerID.setBounds(582, 181, 186, 41);
		contentPane.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtOrderID = new JTextField();
		txtOrderID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOrderID.setColumns(10);
		txtOrderID.setBounds(582, 303, 186, 41);
		contentPane.add(txtOrderID);
		
		txtSaleVoucherID = new JTextField();
		txtSaleVoucherID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleVoucherID.setColumns(10);
		txtSaleVoucherID.setBounds(582, 425, 186, 41);
		contentPane.add(txtSaleVoucherID);
		
		JButton btnDeleteButton = new JButton("DELETE");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Delete from F21_S001_5_customer where customerID='"+txtCustomerID.getText()+"' ";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					
					pst.execute();
					pst.close();
					
					String query1="Delete from F21_S001_5_pharmacy where orderID='"+txtOrderID.getText()+"' ";
					pst=oracleConnection.connection.prepareStatement(query1);
					
					pst.execute();
					pst.close();

					String query2="Delete from F21_S001_5_sale_bill where saleVoucherID='"+txtOrderID.getText()+"' ";
					pst=oracleConnection.connection.prepareStatement(query2);
					
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
