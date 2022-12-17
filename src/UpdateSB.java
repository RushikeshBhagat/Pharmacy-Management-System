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

public class UpdateSB extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtDOB;
	private JTextField txtOrderID;
	private JTextField txtSaleVoucherID;
	private JTextField txtSaleDate;
	private JTextField txtFName;
	private JTextField txtAddress;
	private JTextField txtOperatorName;
	private JTextField txtProductID;
	private JTextField txtTotalQty;
	private JTextField txtLName;
	private JTextField txtDocName;
	private JTextField txtPaymentMode;
	private JTextField txtPurchaseID;
	private JTextField txtSaleRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSB frame = new UpdateSB();
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
		txtTotalQty.setText(null);

	}
	/**
	 * Create the frame.
	 */
	public UpdateSB() {
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
				Update up = new Update();
				up.setVisible(true);
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
		
		JLabel FNameLabel = new JLabel("First Name");
		FNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		FNameLabel.setBounds(420, 97, 102, 41);
		contentPane.add(FNameLabel);
		
		JLabel LNameLabel = new JLabel("Last Name");
		LNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LNameLabel.setBounds(900, 97, 102, 41);
		contentPane.add(LNameLabel);
		
		JLabel DOBLabel = new JLabel("DOB");
		DOBLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DOBLabel.setBounds(23, 220, 102, 41);
		contentPane.add(DOBLabel);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AddressLabel.setBounds(420, 220, 102, 41);
		contentPane.add(AddressLabel);
				
		JLabel DocNameLabel = new JLabel("Doc. Name");
		DocNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DocNameLabel.setBounds(900, 220, 102, 41);
		contentPane.add(DocNameLabel);
		
		JLabel OrderIDLabel = new JLabel("Order ID");
		OrderIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		OrderIDLabel.setBounds(23, 340, 102, 41);
		contentPane.add(OrderIDLabel);

		JLabel OperatorNameLabel = new JLabel("Oprtr Name");
		OperatorNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		OperatorNameLabel.setBounds(420, 340, 110, 41);
		contentPane.add(OperatorNameLabel);
		
		JLabel PaymentModeLabel = new JLabel("Pmt. Mode");
		PaymentModeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PaymentModeLabel.setBounds(900, 340, 110, 41);
		contentPane.add(PaymentModeLabel);

		JLabel SaleVoucherIDLabel = new JLabel("Sale Voucher");
		SaleVoucherIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleVoucherIDLabel.setBounds(23, 460, 116, 41);
		contentPane.add(SaleVoucherIDLabel);
		
		JLabel ProductIDLabel = new JLabel("Product ID");
		ProductIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ProductIDLabel.setBounds(420, 460, 116, 41);
		contentPane.add(ProductIDLabel);

		JLabel PurchaseIDLabel = new JLabel("Purchase ID");
		PurchaseIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		PurchaseIDLabel.setBounds(900, 460, 116, 41);
		contentPane.add(PurchaseIDLabel);

		JLabel SaleDateLabel = new JLabel("Sale Date");
		SaleDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleDateLabel.setBounds(23, 580, 116, 41);
		contentPane.add(SaleDateLabel);

		JLabel TotalQuantityLabel = new JLabel("Total Qty");
		TotalQuantityLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TotalQuantityLabel.setBounds(420, 580, 116, 41);
		contentPane.add(TotalQuantityLabel);

		JLabel SaleRateLabel = new JLabel("Sale Rate");
		SaleRateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SaleRateLabel.setBounds(900, 580, 116, 41);
		contentPane.add(SaleRateLabel);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerID.setBounds(149, 97, 240, 41);
		contentPane.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDOB.setColumns(10);
		txtDOB.setBounds(149, 220, 240, 41);
		contentPane.add(txtDOB);
		
		txtOrderID = new JTextField();
		txtOrderID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOrderID.setColumns(10);
		txtOrderID.setBounds(149, 340, 240, 41);
		contentPane.add(txtOrderID);
		
		txtSaleVoucherID = new JTextField();
		txtSaleVoucherID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleVoucherID.setColumns(10);
		txtSaleVoucherID.setBounds(149, 460, 240, 41);
		contentPane.add(txtSaleVoucherID);
		
		txtSaleDate = new JTextField();
		txtSaleDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleDate.setColumns(10);
		txtSaleDate.setBounds(149, 580, 240, 41);
		contentPane.add(txtSaleDate);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtFName.setBounds(544, 99, 320, 41);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtAddress.setColumns(10);
		txtAddress.setBounds(544, 220, 320, 41);
		contentPane.add(txtAddress);
		
		txtOperatorName = new JTextField();
		txtOperatorName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOperatorName.setColumns(10);
		txtOperatorName.setBounds(544, 340, 320, 41);
		contentPane.add(txtOperatorName);
		
		txtProductID = new JTextField();
		txtProductID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtProductID.setColumns(10);
		txtProductID.setBounds(544, 460, 320, 41);
		contentPane.add(txtProductID);
		
		txtTotalQty = new JTextField();
		txtTotalQty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalQty.setColumns(10);
		txtTotalQty.setBounds(544, 580, 320, 41);
		contentPane.add(txtTotalQty);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtLName.setColumns(10);
		txtLName.setBounds(1022, 97, 320, 41);
		contentPane.add(txtLName);
		
		txtDocName = new JTextField();
		txtDocName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDocName.setColumns(10);
		txtDocName.setBounds(1022, 220, 320, 41);
		contentPane.add(txtDocName);
		
		txtPaymentMode = new JTextField();
		txtPaymentMode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPaymentMode.setColumns(10);
		txtPaymentMode.setBounds(1022, 340, 320, 41);
		contentPane.add(txtPaymentMode);
		
		txtPurchaseID = new JTextField();
		txtPurchaseID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPurchaseID.setColumns(10);
		txtPurchaseID.setBounds(1022, 460, 320, 41);
		contentPane.add(txtPurchaseID);
		
		txtSaleRate = new JTextField();
		txtSaleRate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSaleRate.setColumns(10);
		txtSaleRate.setBounds(1022, 580, 320, 41);
		contentPane.add(txtSaleRate);
		
		JButton btnUpdateButton = new JButton("UPDATE");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Update F21_S001_5_customer set customerID='"+txtCustomerID.getText()+"' ,fname='"+txtFName.getText()+"' ,lname='"+txtLName.getText()+"' ,dob='"+txtDOB.getText()+"' ,address='"+txtAddress.getText()+"' ,docName='"+txtDocName.getText()+"' where customerID='"+txtCustomerID.getText()+"' ";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					
					pst.execute();
					pst.close();
					
					String query1="Update F21_S001_5_pharmacy set orderID='"+txtOrderID.getText()+"' ,operatorName='"+txtOperatorName.getText()+"' ,pCustID='"+txtCustomerID.getText()+"' where orderID='"+txtOrderID.getText()+"' ";
					pst=oracleConnection.connection.prepareStatement(query1);
					
					pst.execute();
					pst.close();
					
					String query2="Update F21_S001_5_sale_bill set saleVoucherID='"+txtSaleVoucherID.getText()+"' ,sCustomerID='"+txtCustomerID.getText()+"' ,sorderID='"+txtOrderID.getText()+"' ,sProductID='"+txtProductID.getText()+"' ,sPurchaseID='"+txtPurchaseID.getText()+"' ,paymentMode='"+txtPaymentMode.getText()+"' ,saleDate='"+txtSaleDate.getText()+"' ,totQty='"+txtTotalQty.getText()+"' ,saleRate='"+txtSaleRate.getText()+"' where saleVoucherID='"+txtSaleVoucherID.getText()+"' ";
					pst=oracleConnection.connection.prepareStatement(query2);
					
					pst.execute();
					pst.close();
					
					clearFields();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnUpdateButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdateButton.setBounds(639, 669, 125, 41);
		contentPane.add(btnUpdateButton);
		
		
	}

}
