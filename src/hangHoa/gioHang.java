package hangHoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import dienThoai.DT_11PM;
import khachHang.khachHang_Login;
import khachHang.khachHang_Update;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class gioHang extends JFrame {

	private static final String geta = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField get;
	private JTextField get_tb;
	private JTextField get_sl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gioHang frame = new gioHang();
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
	
	public gioHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(450,600);
		setResizable(false);
		setTitle("Giỏ hàng");
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel = new JLabel("GI\u1ECE H\u00C0NG");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 57, 162, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(341, 27, 85, 36);
		contentPane.add(btnNewButton);
		
		get = new JTextField();
		get.setBounds(0, 0, 0, 0);
		contentPane.add(get);
		get.setColumns(10);
		
		get_tb = new JTextField();
		get_tb.setBounds(0, 0, 0, 0);
		contentPane.add(get_tb);
		get_tb.setColumns(10);
		
		get_sl = new JTextField();
		get_sl.setColumns(10);
		get_sl.setBounds(0, 0, 0, 0);
		contentPane.add(get_sl);
		
		
		JLabel lblNewLabel_1 = new JLabel("-------------------------------------------------");
		lblNewLabel_1.setBounds(118, 111, 205, 13);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel t = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				String id = t.getValueAt(selectedRowIndex,  1).toString();
				String ten_tb = t.getValueAt(selectedRowIndex,  0).toString();
				get.setText(id);
				get_tb.setText(ten_tb);
				get_sl.setText(t.getValueAt(selectedRowIndex,  2).toString());
			}
		});
		JButton del = new JButton("Xóa");
		del.setBackground(Color.RED);
		del.setForeground(Color.BLACK);
		del.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(241, 110, 205, 79);
		contentPane.add(table);
		
		Vector head = new Vector();
		final Vector dt = new Vector();
		
		
		head.add("Tên thiết bị");
		head.add("Mã thiết bị");
		head.add("Số lượng");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		String us = khachHang_Login.kh_us.getText();
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select distinct user_kh, ten_tb, thietbi.id_tb, giohang.sl from giohang, thietbi where giohang.id_tb = thietbi.id_tb;");
		
		while(user.next()) {
		if(us.contains(user.getString("user_kh"))) {
			Vector rows = new Vector();
			 int i=1;
             rows.add(user.getString(2));
             rows.add(user.getString(3));
             rows.add(user.getString(4));
             dt.add(rows);
		}
		}
		}catch (Exception ex) {
			
		}	
		table.setModel(new DefaultTableModel(dt, head));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 159, 386, 336);
		contentPane.add(scrollPane);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
				PreparedStatement hh = (PreparedStatement) conn.prepareStatement("delete from giohang where id_tb=? and user_kh=?;");
				hh.setString(1, get.getText());
				hh.setString(2, khachHang_Login.kh_us.getText());
				hh.executeUpdate();
				JOptionPane.showMessageDialog(gioHang.this, "Xóa thành công");
				new gioHang().setVisible(true);
				dispose();
				}catch (Exception ex) {
					
				}	
			}
		});
		del.setBounds(58, 505, 100, 36);
		contentPane.add(del);
		
		JButton btntHng = new JButton("Đặt hàng");
		btntHng.setBackground(Color.RED);
		btntHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order();
			}
		});
		btntHng.setForeground(Color.BLACK);
		btntHng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntHng.setBounds(255, 505, 100, 36);
		contentPane.add(btntHng);
	}
	
	public void order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(450,600);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel = new JLabel("XÁC NHẬN ĐƠN HÀNG");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(74, 57, 279, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new gioHang().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(341, 27, 85, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("-------------------------------------------------");
		lblNewLabel_1.setBounds(118, 111, 205, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(37, 242, 85, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(37, 304, 115, 28);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("SDT");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(37, 366, 85, 28);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_3.setBounds(37, 430, 85, 28);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("T\u00EAn thi\u1EBFt b\u1ECB");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_4.setBounds(37, 180, 85, 28);
		contentPane.add(lblNewLabel_3_4);
		
		final JTextField sltb = new JTextField();
		sltb.setHorizontalAlignment(SwingConstants.CENTER);
		sltb.setText(get_sl.getText());
		sltb.setBounds(285, 243, 27, 28);
		contentPane.add(sltb);
		sltb.setColumns(10);
		
		final JLabel tentb = new JLabel("New label");
		tentb.setHorizontalAlignment(SwingConstants.CENTER);
		tentb.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tentb.setBounds(195, 184, 205, 21);
		contentPane.add(tentb);
		
		final JLabel tenkh = new JLabel("New label");
		tenkh.setHorizontalAlignment(SwingConstants.CENTER);
		tenkh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tenkh.setBounds(195, 312, 205, 21);
		contentPane.add(tenkh);
		
		final JLabel sdt = new JLabel("New label");
		sdt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sdt.setHorizontalAlignment(SwingConstants.CENTER);
		sdt.setBounds(195, 374, 205, 21);
		contentPane.add(sdt);
		
		final JLabel dc = new JLabel("New label");
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		dc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		dc.setBounds(195, 430, 205, 21);
		contentPane.add(dc);
		tentb.setText(get_tb.getText());
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
				java.sql.Statement a = conn.createStatement();
				ResultSet user = a.executeQuery("select user_kh, ten_kh, diachi_kh, sdt_kh from khachhang");
				String us = khachHang_Login.kh_us.getText();
				while(user.next()) {
				if(us.contains(user.getString("user_kh"))) {
					tenkh.setText(user.getString(2));
					dc.setText(user.getString(3));
					sdt.setText(user.getString(4));
					}	
				}
			} catch (Exception ex) {
			}		
			JButton btnNewButton_1 = new JButton("Đặt hàng");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						String dbURL = "jdbc:mysql://localhost:3306/sale";
						String username = "root";
						String password = "";
						Connection conn = DriverManager.getConnection(dbURL, username, password);
						PreparedStatement order = (PreparedStatement) conn.prepareStatement("insert into donhang values(?, ?, ?, ?, ?, ?)");
						order.setString(1, tentb.getText());
						order.setString(2, sltb.getText());
						order.setString(3, tenkh.getText());
						order.setString(4, sdt.getText());
						order.setString(5, dc.getText());
						order.setString(6, khachHang_Login.kh_us.getText());
						order.executeUpdate();
						try {
							Class.forName("com.mysql.jdbc.Driver");
							String dbURL1 = "jdbc:mysql://localhost:3306/sale";
							String username1 = "root";
							String password1 = "";
							Connection conn1 = DriverManager.getConnection(dbURL1, username1, password1);
						PreparedStatement del = (PreparedStatement) conn1.prepareStatement("delete from giohang where id_tb=? and user_kh=?;");
						del.setString(1, get.getText());
						del.setString(2, khachHang_Login.kh_us.getText());
						del.executeUpdate();
						new gioHang().setVisible(true);
						dispose();
						}catch (Exception ex) {						
						}
						JOptionPane.showMessageDialog(gioHang.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(gioHang.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
		}	
}