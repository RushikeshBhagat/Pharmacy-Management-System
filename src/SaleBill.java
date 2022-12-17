import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class SaleBill extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtDOB;
	private JTextField txtAddress;
	private JTextField txtDocName;
	private JTextField txtOrderID;
	private JTextField txtOperatorName;
	private JTextField txtPaymentMode;
	private JTextField txtSaleVoucherID;
	private JTextField txtProductID;
	private JTextField txtPurchaseID;
	private JTextField txtSaleDate;
	private JTextField txtTotalQuantity;
	private JTextField txtSaleRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleBill frame = new SaleBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void clearFields() {
		txtAddress.setText(null);
		txtCustomerID.setText(null);
		txtDOB.setText(null);
		txtDocName.setText(null);
		txtFName.setText(null);
		txtLName.setText(null);
		txtOperatorName.setText(null);
		txtOrderID.setText(null);
		txtPaymentMode.setText(null);
		txtProductID.setText(null);
		txtPurchaseID.setText(null);
		txtSaleDate.setText(null);
		txtSaleRate.setText(null);
		txtSaleVoucherID.setText(null);
		txtTotalQuantity.setText(null);

	}
	/**
	 * Create the frame.
	 */
	public SaleBill() {
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
		btnBackButton.setBounds(1217, 20, 125, 41);
		contentPane.add(btnBackButton);
		
		
		JLabel SaleLabel = new JLabel("Sale Bill");
		SaleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		SaleLabel.setBounds(633, 21, 110, 28);
		contentPane.add(SaleLabel);
		
		JLabel CustomerIDLabel = new JLabel("Cusotmer ID");
		CustomerIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		CustomerIDLabel.setBounds(23, 97, 116, 41);
		contentPane.add(CustomerIDLabel);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerID.setBounds(149, 97, 240, 41);
		contentPane.add(txtCustomerID);
		txtCustomerID.setColumns(10);

		JLabel FNameLabel = new JLabel("First Name");
		FNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		FNameLabel.setBounds(420, 97, 102, 41);
		contentPane.add(FNameLabel);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtFName.setBounds(544, 99, 320, 41);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		JLabel LNameLabel = new JLabel("Last Name");
		LNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LNameLabel.setBounds(900, 97, 102, 41);
		contentPane.add(LNameLabel);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtLName.setBounds(1012, 99, 330, 41);
		contentPane.add(txtLName);
		txtLName.setColumns(10);

		JLabel DOBLabel = new JLabel("DOB");
		DOBLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DOBLabel.setBounds(23, 220, 102, 41);
		contentPane.add(DOBLabel);
		
		txtDOB = new JTextField();
		txtDOB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDOB.setColumns(10);
		txtDOB.setBounds(149, 220, 240, 41);
		contentPane.add(txtDOB);

		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AddressLabel.setBounds(420, 220, 102, 41);
		contentPane.add(AddressLabel);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtAddress.setColumns(10);
		txtAddress.setBounds(544, 220, 320, 41);
		contentPane.add(txtAddress);
		
		JLabel DocNameLabel = new JLabel("Doc. Name");
		DocNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DocNameLabel.setBounds(900, 220, 102, 41);
		contentPane.add(DocNameLabel);
		
		txtDocName = new JTextField();
		txtDocName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDocName.setColumns(10);
		txtDocName.setBounds(1012, 220, 330, 41);
		contentPane.add(txtDocName);

		JLabel OrderIDLabel = new JLabel("Order ID");
		OrderIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		OrderIDLabel.setBounds(23, 340, 102, 41);
		contentPane.add(OrderIDLabel);
		
		txtOrderID = new JTextField();
		txtOrderID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOrderID.setColumns(10);
		txtOrderID.setBounds(149, 340, 240, 41);
		contentPane.add(txtOrderID);

		JLabel OperatorNameLabel = new JLabel("Oprtr Name");
		OperatorNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		OperatorNameLabel.setBounds(420, 340, 110, 41);
		contentPane.add(OperatorNameLabel);
		
		txtOperatorName = new JTextField();
		txtOperatorName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOperatorName.setColumns(10);
		txtOperatorName.setBounds(544, 340, 320, 41);
		contentPane.add(txtOperatorName);
		
		JLabel PaymentModeLabel = new JLabel("Pmt. Mode");
		PaymentModeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaymentModeLabel.setBounds(900, 340, 110, 41);
		contentPane.add(PaymentModeLabel);
		
		txtPaymentMode = new JTextField();
		txtPaymentMode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPaymentMode.setColumns(10);
		txtPaymentMode.setBounds(1012, 340, 330, 41);
		contentPane.add(txtPaymentMode);

		JLabel SaleVoucherIDLabel = new JLabel("Sale Voucher");
		SaleVoucherIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleVoucherIDLabel.setBounds(23, 460, 116, 41);
		contentPane.add(SaleVoucherIDLabel);
		
		txtSaleVoucherID = new JTextField();
		txtSaleVoucherID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleVoucherID.setColumns(10);
		txtSaleVoucherID.setBounds(149, 460, 240, 41);
		contentPane.add(txtSaleVoucherID);
		
		JLabel ProductIDLabel = new JLabel("Product ID");
		ProductIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ProductIDLabel.setBounds(420, 460, 116, 41);
		contentPane.add(ProductIDLabel);
		
		txtProductID = new JTextField();
		txtProductID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtProductID.setColumns(10);
		txtProductID.setBounds(544, 460, 320, 41);
		contentPane.add(txtProductID);

		JLabel PurchaseIDLabel = new JLabel("Purchase ID");
		PurchaseIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseIDLabel.setBounds(900, 460, 116, 41);
		contentPane.add(PurchaseIDLabel);
		
		txtPurchaseID = new JTextField();
		txtPurchaseID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseID.setColumns(10);
		txtPurchaseID.setBounds(1012, 460, 330, 41);
		contentPane.add(txtPurchaseID);

		JLabel SaleDateLabel = new JLabel("Sale Date");
		SaleDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleDateLabel.setBounds(23, 580, 116, 41);
		contentPane.add(SaleDateLabel);
		
		txtSaleDate = new JTextField();
		txtSaleDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleDate.setColumns(10);
		txtSaleDate.setBounds(149, 580, 240, 41);
		contentPane.add(txtSaleDate);

		JLabel TotalQuantityLabel = new JLabel("Total Qty");
		TotalQuantityLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TotalQuantityLabel.setBounds(420, 580, 116, 41);
		contentPane.add(TotalQuantityLabel);
		
		txtTotalQuantity = new JTextField();
		txtTotalQuantity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalQuantity.setColumns(10);
		txtTotalQuantity.setBounds(544, 580, 320, 41);
		contentPane.add(txtTotalQuantity);

		JLabel SaleRateLabel = new JLabel("Sale Rate");
		SaleRateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleRateLabel.setBounds(900, 580, 116, 41);
		contentPane.add(SaleRateLabel);
		
		txtSaleRate = new JTextField();
		txtSaleRate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleRate.setColumns(10);
		txtSaleRate.setBounds(1012, 580, 330, 41);
		contentPane.add(txtSaleRate);
		
		JButton btnAddButton = new JButton("ADD");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into F21_S001_5_customer (customerID,fname,lname,dob,address,docName) values(?,?,?,?,?,?)";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					pst.setString(1, txtCustomerID.getText());
					pst.setString(2, txtFName.getText());
					pst.setString(3, txtLName.getText());
					pst.setString(4, txtDOB.getText());
					pst.setString(5, txtAddress.getText());
					pst.setString(6, txtDocName.getText());

					pst.execute();
					
					pst.close();

					String query1="insert into F21_S001_5_pharmacy (orderID,operatorName,pCustID) values(?,?,?)";
					pst=oracleConnection.connection.prepareStatement(query1);
					pst.setString(1, txtOrderID.getText());
					pst.setString(2, txtOperatorName.getText());
					pst.setString(3, txtCustomerID.getText());
					
					pst.execute();
					
					pst.close();
					
					String query2="insert into F21_S001_5_sale_bill (saleVoucherID,sCustomerID,sorderID,sProductID,sPurchaseID,paymentMode,saleDate,totQty,saleRate) values(?,?,?,?,?,?,?,?,?)";
					pst=oracleConnection.connection.prepareStatement(query2);
					pst.setString(1, txtSaleVoucherID.getText());
					pst.setString(2, txtCustomerID.getText());
					pst.setString(3, txtOrderID.getText());
					pst.setString(4, txtProductID.getText());
					pst.setString(5, txtPurchaseID.getText());
					pst.setString(6, txtPaymentMode.getText());
					pst.setString(7, txtSaleDate.getText());
					pst.setString(8, txtTotalQuantity.getText());
					pst.setString(9, txtSaleRate.getText());

					pst.execute();
					
					pst.close();
					clearFields();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAddButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAddButton.setBounds(639, 669, 125, 41);
		contentPane.add(btnAddButton);

	}
}
