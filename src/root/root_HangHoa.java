package root;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import khachHang.khachHang_Login;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.awt.SystemColor;

public class root_HangHoa extends JFrame {

	private JPanel contentPane;
	private JTable kh_tb;
	private JTable table_1;
	private JTextField userkh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					root_HangHoa frame = new root_HangHoa();
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
	public root_HangHoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,800);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setTitle("Hàng hóa");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm sản phẩm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_themHH().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 115, 138, 40);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(Color.RED);
		
		JButton btnNewButton_2 = new JButton("Xóa sản phẩm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_xoaHH().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(185, 115, 138, 40);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBackground(Color.RED);
		
		JButton btnNewButton_3 = new JButton("Đăng xuất");
		btnNewButton_3.setForeground(SystemColor.windowText);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 10, 97, 38);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setBackground(SystemColor.controlDkShadow);
		
		JLabel lblNewLabel = new JLabel("QUẢN TRỊ HỆ THỐNG");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(328, 31, 335, 40);
		contentPane.add(lblNewLabel);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JButton btnCpNhtGi = new JButton("C\u1EADp nh\u1EADt gi\u00E1");
		btnCpNhtGi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_upPrice().setVisible(true);
			}
		});
		btnCpNhtGi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCpNhtGi.setBackground(Color.RED);
		btnCpNhtGi.setBounds(358, 115, 138, 40);
		contentPane.add(btnCpNhtGi);
		
		JButton btnnHng = new JButton("\u0110\u01A1n h\u00E0ng");
		btnnHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_DH().setVisible(true);
			}
		});
		btnnHng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnnHng.setBackground(Color.RED);
		btnnHng.setBounds(535, 115, 138, 40);
		contentPane.add(btnnHng);
		
		JTable table = new JTable();
		
		table.setBounds(241, 110, 205, 79);
		contentPane.add(table);
		
		Vector head = new Vector();
		final Vector dt = new Vector();
		
		head.add("Tên thiết bị");
		head.add("Mã thiết bị");
		head.add("CPU");
		head.add("GPU");
		head.add("Hệ diều hành");
		head.add("Màn hình");
		head.add("Giá");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select distinct ten_tb, thietbi.id_tb, ten_cpu, gpu, ten_hdh, ver_hdh, ten_display, dophangiai, gia_tb from thietbi, gia, cpu, hdh, display where thietbi.id_tb = gia.id_tb and thietbi.id_tb=cpu.id_tb and thietbi.id_tb=hdh.id_tb and thietbi.id_tb=display.id_tb order by ten_tb;");
		
		while(user.next()) {
			Vector rows = new Vector();
			 int i=1;
             rows.add(user.getString(1));
             rows.add(user.getString(2));
             rows.add(user.getString(3));
             rows.add(user.getString(4));
             rows.add(user.getString(5) + user.getString(6));
             rows.add(user.getString(7) + user.getString(8));
             rows.add(user.getString(9));
             dt.add(rows);
		}
		}catch (Exception ex) {
			
		}
		
		table.setModel(new DefaultTableModel(dt, head));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 165, 966, 266);
		contentPane.add(scrollPane);
		table.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("----------------------------------------------------------------------------------");
		lblNewLabel_1.setBounds(328, 70, 344, 19);
		contentPane.add(lblNewLabel_1);
		
		

		final JTable kh_tb = new JTable();
		kh_tb.setBounds(27, 554, 884, 156);
		contentPane.add(kh_tb);
		
		Vector head_kh = new Vector();
		final Vector dt_kh = new Vector();
		
		head_kh.add("User");
		head_kh.add("Tên khách hàng");
		head_kh.add("Ngày sinh");
		head_kh.add("Giới tính");
		head_kh.add("Số điện thoại");
		head_kh.add("Email");
		head_kh.add("Password");
		head_kh.add("Địa chỉ");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select user_kh, ten_kh, ngaysinh_kh, gioitinh_kh, sdt_kh, email_kh, pw_kh, diachi_kh from khachhang order by ten_kh;");
		
		while(user.next()) {
			Vector rows_kh = new Vector();
			 rows_kh.add(user.getString(1));
			 rows_kh.add(user.getString(2));
			 rows_kh.add(user.getString(3));
			 rows_kh.add(user.getString(4));
			 rows_kh.add(user.getString(5));
			 rows_kh.add(user.getString(6));
			 rows_kh.add(user.getString(7));
			 rows_kh.add(user.getString(8));
			 dt_kh.add(rows_kh);
		}
		}catch (Exception ex) {
			
		}
		
		kh_tb.setModel(new DefaultTableModel(dt_kh, head_kh));
		JScrollPane scrollPane1 = new JScrollPane(kh_tb);
		kh_tb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel t = (DefaultTableModel)kh_tb.getModel();
				int selectedRowIndex = kh_tb.getSelectedRow();
				String id = t.getValueAt(selectedRowIndex,  0).toString();
				userkh.setText(id);
			}
		});
	
		scrollPane1.setBounds(10, 507, 966, 246);
		contentPane.add(scrollPane1);
		
		userkh = new JTextField();
		userkh.setBounds(0, 0, 0, 0);
		contentPane.add(userkh);
		userkh.setColumns(10);
		

		JButton btnCpNhtGi_1 = new JButton("Xóa người dùng");
		btnCpNhtGi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
				
				PreparedStatement del_account1 = (PreparedStatement) conn.prepareStatement("delete from giohang where user_kh=?");
				del_account1.setString(1, userkh.getText());
				del_account1.executeUpdate();
				
				PreparedStatement del_account2 = (PreparedStatement) conn.prepareStatement("delete from donhang where user_kh=?");
				del_account2.setString(1, userkh.getText());
				del_account2.executeUpdate();
				
				PreparedStatement del_kh = (PreparedStatement) conn.prepareStatement("delete from khachhang where user_kh=?");
				del_kh.setString(1, userkh.getText());
				del_kh.executeUpdate();
				JOptionPane.showMessageDialog(root_HangHoa.this, "Thành công");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(root_HangHoa.this, "Thất bại");
				}	
			}
		});
		btnCpNhtGi_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCpNhtGi_1.setBackground(Color.RED);
		btnCpNhtGi_1.setBounds(10, 457, 138, 40);
		contentPane.add(btnCpNhtGi_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quản trị viên:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 53, 97, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(117, 52, 104, 30);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setText(root_Login.user_root.getText());
		
		JLabel gettime = new JLabel("New label");
		gettime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gettime.setBounds(730, 10, 246, 30);
		contentPane.add(gettime);
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
		String getd = df.format(today);
		gettime.setText(getd);
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		gettime.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ", Ngày " + Integer.toString(day) + " Tháng " + Integer.toString(month+1) + " Năm " + Integer.toString(year));
		
		JLabel chao = new JLabel("New label");
		chao.setHorizontalAlignment(SwingConstants.CENTER);
		chao.setBounds(780, 42, 138, 30);
		contentPane.add(chao);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_HangHoa().setVisible(true);
				dispose();
			}
		});
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRefresh.setBackground(Color.RED);
		btnRefresh.setBounds(876, 115, 88, 40);
		contentPane.add(btnRefresh);
		if(hour >= 5 & hour < 11) {
			chao.setText("Chào buổi sáng!");
		}
		if(hour >= 11 & hour < 13) {
			chao.setText("Chào buổi trưa!");
		}
		if(hour >= 13 & hour < 18) {
			chao.setText("Chào buổi chiều!");
		}
		if(hour >= 18 & hour < 22) {
			chao.setText("Chào buổi tối!");
		}
		if(hour >= 22 & hour < 5) {
			chao.setText("Chúc ngủ ngon!");
		}

	}
}
