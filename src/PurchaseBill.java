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

public class PurchaseBill extends JFrame {

	private JPanel contentPane;
	private JTextField txtPurchaseVoucherID;
	private JTextField txtSupplierID;
	private JTextField txtProductID;
	private JTextField txtPurchaseDate;
	private JTextField txtPurchaseRate;
	private JTextField txtTotalQty;
	private JTextField txtDiscount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseBill frame = new PurchaseBill();
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
	public PurchaseBill() {
		
		
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
				Populate pop = new Populate();
				pop.setVisible(true);
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
		PurchaseVoucherIDLabel.setBounds(142, 149, 158, 41);
		contentPane.add(PurchaseVoucherIDLabel);
		
		txtPurchaseVoucherID = new JTextField();
		txtPurchaseVoucherID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseVoucherID.setBounds(310, 149, 320, 41);
		contentPane.add(txtPurchaseVoucherID);
		txtPurchaseVoucherID.setColumns(10);
		
		JLabel SupplierIDLabel = new JLabel("Supplier ID");
		SupplierIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SupplierIDLabel.setBounds(690, 149, 108, 41);
		contentPane.add(SupplierIDLabel);
		
		txtSupplierID = new JTextField();
		txtSupplierID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSupplierID.setColumns(10);
		txtSupplierID.setBounds(820, 149, 320, 41);
		contentPane.add(txtSupplierID);
		
		JLabel ProductIDLabel = new JLabel("Product ID");
		ProductIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ProductIDLabel.setBounds(142, 272, 158, 41);
		contentPane.add(ProductIDLabel);
		
		txtProductID = new JTextField();
		txtProductID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtProductID.setColumns(10);
		txtProductID.setBounds(310, 272, 320, 41);
		contentPane.add(txtProductID);
		
		JLabel PurchaseDateLabel = new JLabel("Purchase Date");
		PurchaseDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseDateLabel.setBounds(690, 272, 125, 41);
		contentPane.add(PurchaseDateLabel);
		
		txtPurchaseDate = new JTextField();
		txtPurchaseDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseDate.setColumns(10);
		txtPurchaseDate.setBounds(820, 272, 320, 41);
		contentPane.add(txtPurchaseDate);
		
		JLabel PurchaseRateLabel = new JLabel("Purchase Rate");
		PurchaseRateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseRateLabel.setBounds(142, 395, 158, 41);
		contentPane.add(PurchaseRateLabel);
		
		txtPurchaseRate = new JTextField();
		txtPurchaseRate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseRate.setColumns(10);
		txtPurchaseRate.setBounds(310, 395, 320, 41);
		contentPane.add(txtPurchaseRate);
		
		JLabel TotalQtyLabel = new JLabel("Total Quantity");
		TotalQtyLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TotalQtyLabel.setBounds(690, 395, 125, 41);
		contentPane.add(TotalQtyLabel);
		
		txtTotalQty = new JTextField();
		txtTotalQty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalQty.setColumns(10);
		txtTotalQty.setBounds(820, 395, 320, 41);
		contentPane.add(txtTotalQty);
		
		JLabel DiscountLabel = new JLabel("Discount");
		DiscountLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DiscountLabel.setBounds(142, 518, 158, 41);
		contentPane.add(DiscountLabel);
		
		txtDiscount = new JTextField();
		txtDiscount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiscount.setColumns(10);
		txtDiscount.setBounds(310, 518, 320, 41);
		contentPane.add(txtDiscount);
		
		JButton btnAddButton = new JButton("ADD");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into F21_S001_5_purchase_bill (purchaseVoucherID,pSupplierID,pProductID,purchaseDate,purchaseRate,totalQuantity,discount) values(?,?,?,?,?,?,?)";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					pst.setString(1, txtPurchaseVoucherID.getText());
					pst.setString(2, txtSupplierID.getText());
					pst.setString(3, txtProductID.getText());
					pst.setString(4, txtPurchaseDate.getText());
					pst.setString(5, txtPurchaseRate.getText());
					pst.setString(6, txtTotalQty.getText());
					pst.setString(7, txtDiscount.getText());
					
					pst.execute();
					
					pst.close();
					clearFields();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAddButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddButton.setBounds(644, 647, 125, 41);
		contentPane.add(btnAddButton);
		
		
		


	}
}
