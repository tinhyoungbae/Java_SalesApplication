package root;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class root_DH extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					root_DH frame = new root_DH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public root_DH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(900,700);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Lịch sử đơn đặt hàng");
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel = new JLabel("L\u1ECACH S\u1EEC \u0110\u01A0N H\u00C0NG \u0110\u1EB6T");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(221, 38, 415, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(779, 26, 85, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_6.setBounds(0, 160, 896, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Thông tin các đơn hàng");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(20, 126, 200, 24);
		contentPane.add(lblNewLabel_7);
		
		final JTable table = new JTable();
		
		table.setBounds(241, 110, 205, 79);
		contentPane.add(table);
		
		Vector head = new Vector();
		final Vector dt = new Vector();
		head.add("Tên khách hàng");
		head.add("Tên sản phẩm");
		head.add("Số lượng");
		head.add("Số điện thoại");
		head.add("Địa chỉ");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select ten_kh, ten_tb, sl, sdt, diachi_kh from donhang");
		
		while(user.next()) {
			Vector rows = new Vector();
             rows.add(user.getString(1));
             rows.add(user.getString(2));
             rows.add(user.getString(3));
             rows.add(user.getString(4));
             rows.add(user.getString(5));
             dt.add(rows);
		}
		}catch (Exception ex) {
			
		}	
		table.setModel(new DefaultTableModel(dt, head));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 183, 866, 457);
		contentPane.add(scrollPane);
	}

}
