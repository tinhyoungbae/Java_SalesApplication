package khachHang;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class khachHang_Forgot extends JFrame {

	private JPanel contentPane;
	private JTextField user_kh;
	public static JTextField new_pw;
	private JTextField rnew_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khachHang_Forgot frame = new khachHang_Forgot();
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
	public khachHang_Forgot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(398,475);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cấp lại mật khẩu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(58, 83, 197, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(32, 160, 99, 29);
		contentPane.add(lblNewLabel_1);
		
		user_kh = new JTextField();
		user_kh.setHorizontalAlignment(SwingConstants.CENTER);
		user_kh.setBounds(190, 160, 179, 29);
		contentPane.add(user_kh);
		user_kh.setColumns(10);
		user_kh.setBackground(new Color(240, 240, 240));
		user_kh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		new_pw = new JTextField();
		new_pw.setHorizontalAlignment(SwingConstants.CENTER);
		new_pw.setColumns(10);
		new_pw.setBounds(190, 230, 179, 29);
		contentPane.add(new_pw);
		new_pw.setBackground(new Color(240, 240, 240));
		new_pw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		rnew_pw = new JTextField();
		rnew_pw.setHorizontalAlignment(SwingConstants.CENTER);
		rnew_pw.setColumns(10);
		rnew_pw.setBounds(190, 300, 179, 29);
		contentPane.add(rnew_pw);
		rnew_pw.setBackground(new Color(240, 240, 240));
		rnew_pw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel pwlable = new JLabel("Nhập mật khẩu mới");
		pwlable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pwlable.setBounds(21, 230, 123, 29);
		contentPane.add(pwlable);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhập lại mật khẩu mới");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(20, 300, 137, 29);
		contentPane.add(lblNewLabel_1_2);
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					JLabel inf = new JLabel("");
					inf.setBounds(113, 339, 150, 23);
					contentPane.add(inf);
				java.sql.Statement a = conn.createStatement();
				ResultSet user = a.executeQuery("select * from khachhang");
				while(user.next()) {
					if(user_kh.getText().contains(user.getString("user_kh"))) {
						if(new_pw.getText().contains(rnew_pw.getText())) {
							if(user_kh.getText().contains(user.getString("user_kh"))) {
								PreparedStatement up = (PreparedStatement) conn.prepareStatement("update khachhang set pw_kh=? where user_kh=?;");
								up.setString(1, new_pw.getText());
								up.setString(2, user_kh.getText());
								up.executeUpdate();
								JOptionPane.showMessageDialog(khachHang_Forgot.this, "Cấp lại mật khẩu thành công\nTự động chuyển về trang đăng nhập");
								new khachHang_Login().setVisible(true);
								dispose();
							}	
						}
					}
				} inf.setText("Mật khẩu không khớp");
				
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(khachHang_Forgot.this, "Lỗi kết nối đến cơ sở dữ liệu");
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(139, 372, 99, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xong");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(284, 33, 74, 35);
		contentPane.add(btnNewButton_1);
		setTitle("Cấp lại mật khẩu");
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_2 = new JLabel("-----------------------------------------------------------");
		lblNewLabel_2.setBounds(32, 109, 246, 19);
		contentPane.add(lblNewLabel_2);
		
	}
}
