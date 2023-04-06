package khachHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.SwingConstants;

public class khachHang_Update extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khachHang_Update frame = new khachHang_Update();
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
	public khachHang_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(438,555);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Cập nhật thông tin");
		
		JButton back = new JButton("Xong");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		back.setBounds(324, 21, 85, 32);
		back.setBackground(Color.GRAY);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("CẬP NHẬT TÀI KHOẢN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(35, 20, 223, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(35, 135, 96, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(35, 209, 96, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("S\u0110T");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(35, 280, 96, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u0103m sinh");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(35, 352, 96, 21);
		contentPane.add(lblNewLabel_4);
		
		JButton reset = new JButton("Đặt lại");
		reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reset.setBounds(77, 444, 125, 33);
		reset.setBackground(Color.RED);
		contentPane.add(reset);
		
		JButton update = new JButton("C\u1EACP NH\u1EACT");
		final JTextField dc;
		final JTextField email;
		final JTextField sdt;
		final JTextField ns;
		
		dc = new JTextField();
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		dc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dc.setBounds(193, 130, 216, 32);
		contentPane.add(dc);
		dc.setColumns(10);
		dc.setBackground(new Color(240, 240, 240));
		dc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		email.setBounds(193, 204, 216, 32);
		contentPane.add(email);
		email.setColumns(10);
		email.setBackground(new Color(240, 240, 240));
		email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		sdt = new JTextField();
		sdt.setHorizontalAlignment(SwingConstants.CENTER);
		sdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sdt.setBounds(193, 275, 216, 32);
		contentPane.add(sdt);
		sdt.setColumns(10);
		sdt.setBackground(new Color(240, 240, 240));
		sdt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		ns = new JTextField();
		ns.setHorizontalAlignment(SwingConstants.CENTER);
		ns.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ns.setBounds(193, 347, 216, 32);
		contentPane.add(ns);
		ns.setColumns(10);
		ns.setBackground(new Color(240, 240, 240));
		ns.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_5 = new JLabel("---------------------------------------------------------------------------------------------------------------");
		lblNewLabel_5.setBounds(0, 98, 444, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Thông tin");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 77, 67, 21);
		contentPane.add(lblNewLabel_6);
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);

					PreparedStatement up_qq = (PreparedStatement) conn.prepareStatement("update khachhang set diachi_kh=? where user_kh=?;");
					up_qq.setString(1, dc.getText());
					up_qq.setString(2, khachHang_Login.kh_us.getText());
					up_qq.executeUpdate();
				} catch (Exception ex) {
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);

					PreparedStatement up_email = (PreparedStatement) conn.prepareStatement("update khachhang set email_kh=? where user_kh=?;");
					up_email.setString(1, email.getText());
					up_email.setString(2, khachHang_Login.kh_us.getText());
					up_email.executeUpdate();
				} catch (Exception ex) {
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);

					PreparedStatement up_sdt = (PreparedStatement) conn.prepareStatement("update khachhang set sdt_kh=? where user_kh=?;");
					up_sdt.setString(1, sdt.getText());
					up_sdt.setString(2, khachHang_Login.kh_us.getText());
					up_sdt.executeUpdate();
				} catch (Exception ex) {
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);

					PreparedStatement up_ns = (PreparedStatement) conn.prepareStatement("update khachhang set ngaysinh_kh=? where user_kh=?;");
					up_ns.setString(1, ns.getText());
					up_ns.setString(2, khachHang_Login.kh_us.getText());
					up_ns.executeUpdate();
				} catch (Exception ex) {
				}
				JOptionPane.showMessageDialog(khachHang_Update.this, "Cập nhật thành công");
							
			}
		});
		update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		update.setBounds(245, 444, 135, 33);
		update.setBackground(Color.RED);
		contentPane.add(update);
		
		JLabel namekh = new JLabel("New label");
		namekh.setFont(new Font("Tahoma", Font.BOLD, 13));
		namekh.setBounds(77, 72, 114, 31);
		contentPane.add(namekh);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		String us = khachHang_Login.kh_us.getText();
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select user_kh,ten_kh from khachhang");
		
		while(user.next()) {
		if(us.contains(user.getString("user_kh"))) {
			namekh.setText(user.getString(2));
		}	
		}
		}catch (Exception ex) {
		}
	
	}

}
