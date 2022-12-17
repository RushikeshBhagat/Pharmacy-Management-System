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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UpdatePB extends JFrame {

	private JPanel contentPane;
	private JTextField txtPurchaseVoucherID;
	private JTextField txtProductID;
	private JTextField txtPurchaseRate;
	private JTextField txtDiscount;
	private JTextField txtSupplierID;
	private JTextField txtPurchaseDate;
	private JTextField txtTotalQty;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePB frame = new UpdatePB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	private void clearFields() {
		txtDiscount.setText(null);
		txtProductID.setText(null);
		txtPurchaseDate.setText(null);
		txtPurchaseRate.setText(null);
		txtPurchaseVoucherID.setText(null);
		txtSupplierID.setText(null);
		txtTotalQty.setText(null);
	} 
	

	/**
	 * Create the frame.
	 */
	public UpdatePB() {
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
				Update up=new Update(); 
				up.setVisible(true);
				dispose();
			}
		});
		btnBackButton.setBounds(1217, 20, 125, 41);
		contentPane.add(btnBackButton);
		
		JLabel PurchaseLabel = new JLabel("Purchase Bill");
		PurchaseLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		PurchaseLabel.setBounds(582, 21, 186, 28);
		contentPane.add(PurchaseLabel);
		
		JLabel PurchaseVoucherIDLabel = new JLabel("Purchase Voucher");
		PurchaseVoucherIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseVoucherIDLabel.setBounds(142, 149, 158, 41);
		contentPane.add(PurchaseVoucherIDLabel);
		
		JLabel SupplierIDLabel = new JLabel("Supplier ID");
		SupplierIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SupplierIDLabel.setBounds(690, 149, 108, 41);
		contentPane.add(SupplierIDLabel);
		
		JLabel ProductIDLabel = new JLabel("Product ID");
		ProductIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ProductIDLabel.setBounds(142, 272, 158, 41);
		contentPane.add(ProductIDLabel);
		
		JLabel PurchaseDateLabel = new JLabel("Purchase Date");
		PurchaseDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseDateLabel.setBounds(690, 272, 125, 41);
		contentPane.add(PurchaseDateLabel);
		
		JLabel PurchaseRateLabel = new JLabel("Purchase Rate");
		PurchaseRateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseRateLabel.setBounds(142, 395, 158, 41);
		contentPane.add(PurchaseRateLabel);
		
		JLabel TotalQtyLabel = new JLabel("Total Quantity");
		TotalQtyLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TotalQtyLabel.setBounds(690, 395, 125, 41);
		contentPane.add(TotalQtyLabel);
		
		JLabel DiscountLabel = new JLabel("Discount");
		DiscountLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DiscountLabel.setBounds(142, 518, 158, 41);
		contentPane.add(DiscountLabel);
		
		txtPurchaseVoucherID = new JTextField();
		txtPurchaseVoucherID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseVoucherID.setBounds(310, 149, 320, 41);
		contentPane.add(txtPurchaseVoucherID);
		txtPurchaseVoucherID.setColumns(10);
		
		txtProductID = new JTextField();
		txtProductID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtProductID.setColumns(10);
		txtProductID.setBounds(310, 272, 320, 41);
		contentPane.add(txtProductID);
		
		txtPurchaseRate = new JTextField();
		txtPurchaseRate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseRate.setColumns(10);
		txtPurchaseRate.setBounds(310, 395, 320, 41);
		contentPane.add(txtPurchaseRate);
		
		txtDiscount = new JTextField();
		txtDiscount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiscount.setColumns(10);
		txtDiscount.setBounds(310, 518, 320, 41);
		contentPane.add(txtDiscount);
		
		txtSupplierID = new JTextField();
		txtSupplierID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSupplierID.setColumns(10);
		txtSupplierID.setBounds(820, 149, 320, 41);
		contentPane.add(txtSupplierID);
		
		txtPurchaseDate = new JTextField();
		txtPurchaseDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseDate.setColumns(10);
		txtPurchaseDate.setBounds(820, 272, 320, 41);
		contentPane.add(txtPurchaseDate);
		
		txtTotalQty = new JTextField();
		txtTotalQty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalQty.setColumns(10);
		txtTotalQty.setBounds(820, 395, 320, 41);
		contentPane.add(txtTotalQty);
		
		JButton btnUpdateButton = new JButton("UPDATE");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Update F21_S001_5_purchase_bill set purchaseVoucherID='"+txtPurchaseVoucherID.getText()+"' ,pSupplierID='"+txtSupplierID.getText()+"' ,pProductID='"+txtProductID.getText()+"' ,purchaseDate='"+txtPurchaseDate.getText()+"' ,purchaseRate='"+txtPurchaseRate.getText()+"' ,totalQuantity='"+txtTotalQty.getText()+"' ,discount='"+txtDiscount.getText()+"' where purchaseVoucherID='"+txtPurchaseVoucherID.getText()+"' ";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					
					pst.execute();
					pst.close();
					
					clearFields();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnUpdateButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdateButton.setBounds(644, 647, 125, 41);
		contentPane.add(btnUpdateButton);
	}

}
