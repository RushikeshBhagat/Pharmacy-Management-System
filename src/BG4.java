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

public class BG4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BG4 frame = new BG4();
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
	public BG4() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100, 1480, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BG4Label = new JLabel("Profit Percentage");
		BG4Label.setFont(new Font("Times New Roman", Font.BOLD, 30));
		BG4Label.setBounds(528, 20, 387, 48);
		contentPane.add(BG4Label);
		
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
		
		JButton btnExecuteQ1Button = new JButton("Execute Q1");
		btnExecuteQ1Button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExecuteQ1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select (((sum(sale.saleRate*sale.totQty) - sum(pur.purchaseRate*sale.totQty))/sum(sale.saleRate*sale.totQty))*100) as profit_percent from F21_S001_5_purchase_bill pur inner join F21_S001_5_sale_bill sale on pur.purchaseVoucherID=sale.sPurchaseID where sale.saleDate >= '01-Apr-2021' and sale.saleDate <= '30-Jun-2021'";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnExecuteQ1Button.setBounds(244, 216, 125, 41);
		contentPane.add(btnExecuteQ1Button);

		JButton btnExecuteQ2Button = new JButton("Execute Q2");
		btnExecuteQ2Button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExecuteQ2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select (((sum(sale.saleRate*sale.totQty) - sum(pur.purchaseRate*sale.totQty))/sum(sale.saleRate*sale.totQty))*100) as profit_percent from F21_S001_5_purchase_bill pur inner join F21_S001_5_sale_bill sale on pur.purchaseVoucherID=sale.sPurchaseID where sale.saleDate >= '01-Jul-2021' and sale.saleDate <= '30-Sep-2021'";
					PreparedStatement pst=oracleConnection.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnExecuteQ2Button.setBounds(244, 412, 125, 41);
		contentPane.add(btnExecuteQ2Button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 216, 200, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		scrollPane.setViewportView(table);

	}

}
