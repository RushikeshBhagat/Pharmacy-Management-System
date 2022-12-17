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

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Search extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	/**
	 * Create the frame.
	 */
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SearchLabel = new JLabel("View Relations");
		SearchLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		SearchLabel.setBounds(617, 10, 195, 48);
		contentPane.add(SearchLabel);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
				dispose();
			}
		});
		btnBackButton.setBounds(1237, 19, 125, 41);
		contentPane.add(btnBackButton);
		
		JButton btnCustomerButton = new JButton("Customer");
		btnCustomerButton.setFont(new Font("Times New Roman", Font.BOLD, 16));		
		btnCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_customer";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCustomerButton.setBounds(45, 96, 125, 41);
		contentPane.add(btnCustomerButton);
		
		JButton btnPharmacyButton = new JButton("Pharmacy");
		btnPharmacyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_pharmacy";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnPharmacyButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnPharmacyButton.setBounds(343, 96, 125, 41);
		contentPane.add(btnPharmacyButton);
		
		JButton btnSupplierButton = new JButton("Supplier");
		btnSupplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_supplier";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSupplierButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSupplierButton.setBounds(641, 96, 125, 41);
		contentPane.add(btnSupplierButton);
		
		JButton btnSupplierPhoneButton = new JButton("Supplier Phone");
		btnSupplierPhoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_supplier_phone";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSupplierPhoneButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSupplierPhoneButton.setBounds(939, 96, 148, 41);
		contentPane.add(btnSupplierPhoneButton);
		
		JButton btnCompanyButton = new JButton("Company");
		btnCompanyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_company";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCompanyButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCompanyButton.setBounds(1237, 96, 125, 41);
		contentPane.add(btnCompanyButton);
		
		JButton btnProductButton = new JButton("Products");
		btnProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_product";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnProductButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnProductButton.setBounds(194, 207, 125, 41);
		contentPane.add(btnProductButton);
		
		JButton btnProductLotButton = new JButton("Product Lot");
		btnProductLotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_product_lot";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnProductLotButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnProductLotButton.setBounds(492, 207, 125, 41);
		contentPane.add(btnProductLotButton);
		
		JButton btnSaleBillButton = new JButton("Sale Bill");
		btnSaleBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_sale_bill";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSaleBillButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSaleBillButton.setBounds(790, 207, 125, 41);
		contentPane.add(btnSaleBillButton);
		
		JButton btnPurchaseBillButton = new JButton("Purchase Bill");
		btnPurchaseBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from F21_S001_5_purchase_bill";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnPurchaseBillButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnPurchaseBillButton.setBounds(1088, 207, 125, 41);
		contentPane.add(btnPurchaseBillButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 306, 1317, 430);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		
		
	}

}
