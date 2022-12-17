import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BG3 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtProductID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BG3 frame = new BG3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void clearFields() {
		txtProductID.setText(null);
	}
	/**
	 * Create the frame.
	 */
	public BG3() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BG3Label = new JLabel("Rate Comparison");
		BG3Label.setFont(new Font("Times New Roman", Font.BOLD, 30));
		BG3Label.setBounds(528, 20, 387, 48);
		contentPane.add(BG3Label);
		
		JLabel ProductIDLabel = new JLabel("Product ID");
		ProductIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		ProductIDLabel.setBounds(309, 71, 216, 48);
		contentPane.add(ProductIDLabel);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query query = new Query();
				query.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnBackButton.setBounds(1217, 20, 125, 41);
		contentPane.add(btnBackButton);

		JButton btnExecuteButton = new JButton("Execute");
		btnExecuteButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExecuteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select sup.supplierName,prod.productName,min(pur.purchaseRate) as purchase_rate,row_number() over (order by min(pur.purchaseRate)) as lowest_price_rank from F21_S001_5_purchase_bill pur inner join F21_S001_5_supplier sup on pur.pSupplierID=sup.supplierID inner join F21_S001_5_product prod on pur.pProductID=prod.productID where pur.pProductID ='"+txtProductID.getText()+"' group by sup.supplierName,prod.productName";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					clearFields();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnExecuteButton.setBounds(86, 363, 125, 41);
		contentPane.add(btnExecuteButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(309, 139, 1033, 542);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		txtProductID = new JTextField();
		txtProductID.setBounds(500, 78, 250, 41);
		txtProductID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(txtProductID);
		txtProductID.setColumns(10);
	}

}
