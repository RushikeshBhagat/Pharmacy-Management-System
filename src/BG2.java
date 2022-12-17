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

public class BG2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BG2 frame = new BG2();
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
	public BG2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BG2Label = new JLabel("Supplier Purchase Frequency");
		BG2Label.setFont(new Font("Times New Roman", Font.BOLD, 30));
		BG2Label.setBounds(528, 20, 387, 48);
		contentPane.add(BG2Label);
		
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
					String query="\r\n"
							+ "with temp as(select prod.productID,sum(sale.totQty) as total,row_number() over (order by sum(sale.totQty) desc) as best_seller_rank from F21_S001_5_product prod inner join F21_S001_5_sale_bill sale on prod.productID=sale.sProductID where sale.saleDate >= '01-Jul-2021' and sale.saleDate <= '30-Sep-2021' group by prod.productID) select sup.supplierName, prod.productName from F21_S001_5_purchase_bill pur inner join F21_S001_5_supplier sup on pur.pSupplierID=sup.supplierID inner join F21_S001_5_product prod on pur.pProductID=prod.productID \r\n"
							+ "where pur.pProductID in (select prod.productID from temp) and pur.purchaseDate >='01-Jul-2021' and pur.purchaseDate <='30-Sep-2021'";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnExecuteButton.setBounds(77, 363, 125, 41);
		contentPane.add(btnExecuteButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 111, 1052, 605);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		scrollPane.setViewportView(table);

	}

}
