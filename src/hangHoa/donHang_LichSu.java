package hangHoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import khachHang.khachHang_Login;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class donHang_LichSu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donHang_LichSu frame = new donHang_LichSu();
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
	public donHang_LichSu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(680,616);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Lịch sửu đặt hàng");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel = new JLabel("L\u1ECACH S\u1EEC \u0110\u01A0N H\u00C0NG \u0110\u1EB6T");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(110, 37, 415, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(571, 24, 85, 34);
		contentPane.add(btnNewButton);
		
		JLabel ten_kh = new JLabel("New label");
		ten_kh.setForeground(Color.BLUE);
		ten_kh.setHorizontalAlignment(SwingConstants.CENTER);
		ten_kh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ten_kh.setBounds(354, 126, 130, 24);
		contentPane.add(ten_kh);
		
		JLabel sdt = new JLabel("New label");
		sdt.setForeground(Color.BLUE);
		sdt.setHorizontalAlignment(SwingConstants.CENTER);
		sdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sdt.setBounds(513, 126, 130, 24);
		contentPane.add(sdt);
		
		JLabel dc = new JLabel("New label");
		dc.setForeground(Color.RED);
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		dc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dc.setBounds(336, 147, 320, 24);
		contentPane.add(dc);
		
		JLabel lblNewLabel_6 = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_6.setBounds(0, 160, 666, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Th\u00F4ng tin \u0111\u01A1n h\u00E0ng");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(20, 126, 130, 24);
		contentPane.add(lblNewLabel_7);
		
		JTable table = new JTable();
		
		table.setBounds(241, 110, 205, 79);
		contentPane.add(table);
		
		Vector head = new Vector();
		final Vector dt = new Vector();
		
		head.add("Tên sản phẩm");
		head.add("Số lượng");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		String us = khachHang_Login.kh_us.getText();
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select user_kh, ten_tb, sl from donhang");
		
		while(user.next()) {
		if(us.contains(user.getString("user_kh"))) {
			Vector rows = new Vector();
			 int i=1;
             rows.add(user.getString(2));
             rows.add(user.getString(3));
 
             dt.add(rows);
		}
		}
		}catch (Exception ex) {
			
		}	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		String us = khachHang_Login.kh_us.getText();
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select user_kh, ten_kh, sdt_kh, diachi_kh from khachhang");
		while(user.next()) {
		if(us.contains(user.getString("user_kh"))) {
             ten_kh.setText(user.getString(2));
             sdt.setText(user.getString(3));
             dc.setText(user.getString(4));
		}
		}
		}catch (Exception ex) {
			
		}	
		table.setModel(new DefaultTableModel(dt, head));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(72, 183, 515, 371);
		contentPane.add(scrollPane);
		

		
	}

}
