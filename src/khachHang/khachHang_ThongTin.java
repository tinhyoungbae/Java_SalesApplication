package khachHang;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import hangHoa.hangHoa_All;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class khachHang_ThongTin extends JFrame {

	private JPanel contentPane;
	public static JTextField dc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khachHang_ThongTin frame = new khachHang_ThongTin();
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
	public khachHang_ThongTin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(447,568);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel liskh = new JPanel();
		liskh.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(liskh);
		liskh.setLayout(null);
		setTitle("Thông tin tài khoản");
		
		JLabel lblNewLabel = new JLabel("T\u00C0I KHO\u1EA2N");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(107, 10, 194, 41);
		liskh.add(lblNewLabel);
		
		JButton back = new JButton("Tr\u1EDF v\u1EC1");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		back.setBounds(338, 26, 85, 42);
		back.setBackground(Color.GRAY);
		liskh.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 116, 57, 21);
		liskh.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 186, 72, 21);
		liskh.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(22, 253, 72, 26);
		liskh.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(22, 330, 45, 13);
		liskh.add(lblNewLabel_5);
		JTextField tenkh = new JTextField();
		tenkh.setEditable(false);
		tenkh.setHorizontalAlignment(SwingConstants.CENTER);
		tenkh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tenkh.setBounds(130, 110, 293, 35);
		liskh.add(tenkh);
		tenkh.setColumns(10);
		tenkh.setBackground(new Color(240, 240, 240));
		tenkh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JTextField ns = new JTextField();
		ns.setEditable(false);
		ns.setHorizontalAlignment(SwingConstants.CENTER);
		ns.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ns.setBounds(130, 180, 293, 35);
		liskh.add(ns);
		ns.setColumns(10);
		ns.setBackground(new Color(240, 240, 240));
		ns.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JTextField dc = new JTextField();
		dc.setEditable(false);
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		dc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dc.setBounds(130, 250, 293, 35);
		liskh.add(dc);
		dc.setColumns(10);
		dc.setBackground(new Color(240, 240, 240));
		dc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JTextField email = new JTextField();
		email.setEditable(false);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		email.setBounds(130, 320, 293, 35);
		liskh.add(email);
		email.setColumns(10);
		email.setBackground(new Color(240, 240, 240));
		email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(22, 390, 96, 32);
		liskh.add(lblNewLabel_3);
		
		JTextField sdt = new JTextField();
		sdt.setEditable(false);
		sdt.setHorizontalAlignment(SwingConstants.CENTER);
		sdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sdt.setBounds(130, 390, 293, 35);
		liskh.add(sdt);
		sdt.setColumns(10);
		sdt.setBackground(new Color(240, 240, 240));
		sdt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		String us = khachHang_Login.kh_us.getText();
		
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select user_kh, ten_kh, ngaysinh_kh, diachi_kh, sdt_kh, email_kh from khachhang");
		
		while(user.next()) {
		if(us.contains(user.getString("user_kh"))) {
			tenkh.setText(user.getString(2));
			ns.setText(user.getString(3));
			dc.setText(user.getString(4));
			email.setText(user.getString(5));
			sdt.setText(user.getString(6));
			}	
		}
		}catch (Exception ex) {
		}

		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		liskh.add(un_b);
		
		JLabel lblNewLabel_7 = new JLabel("----------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_7.setBounds(0, 82, 498, 13);
		liskh.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Thông tin");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 62, 92, 21);
		liskh.add(lblNewLabel_8);
		
		JLabel del_acc = new JLabel("Xóa tài khoản");
		del_acc.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				Object[] options = {"Đồng ý", "Hủy"};
				int rs = JOptionPane.showOptionDialog(khachHang_ThongTin.this, "Bạc có chắc chắn muốn xóa tài khoản\nSau khi xóa bạn không thể đăng nhập vào hệ thống\nbằng tài khoản này nữa", "Xóa tài khoản",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if(rs == JOptionPane.YES_OPTION) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					String us = khachHang_Login.kh_us.getText();
					
					PreparedStatement del_account1 = (PreparedStatement) conn.prepareStatement("delete from giohang where user_kh=?");
					del_account1.setString(1, us);
					del_account1.executeUpdate();
					
					PreparedStatement del_account2 = (PreparedStatement) conn.prepareStatement("delete from donhang where user_kh=?");
					del_account2.setString(1, us);
					del_account2.executeUpdate();

					PreparedStatement del_account = (PreparedStatement) conn.prepareStatement("delete from khachhang where user_kh=?");
					del_account.setString(1, us);
					del_account.executeUpdate();
					
					JOptionPane.showMessageDialog(khachHang_ThongTin.this, "Xóa tài khoản thành công\nBạn sẽ được đăng xuất ra khỏi hệ thống", "Xóa tài khoản", JOptionPane.PLAIN_MESSAGE);
					new khachHang_Login().setVisible(true);
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(khachHang_ThongTin.this, "Thất bại", "Xóa tài khoản", JOptionPane.ERROR_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(khachHang_ThongTin.this, "Đã hủy yêu cầu xóa tài khoản", "Xóa tài khoản", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		del_acc.setForeground(Color.BLUE);
		del_acc.setBackground(Color.BLUE);
		del_acc.setFont(new Font("Tahoma", Font.BOLD, 12));
		del_acc.setHorizontalAlignment(SwingConstants.CENTER);
		del_acc.setBounds(320, 488, 103, 33);
		liskh.add(del_acc);
		
		JButton up_acc = new JButton("Cập nhật thông tin");
		up_acc.setBackground(Color.RED);
		up_acc.setFont(new Font("Tahoma", Font.BOLD, 15));
		up_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new khachHang_Update().setVisible(true);
			}
		});
		up_acc.setBounds(128, 460, 182, 35);
		liskh.add(up_acc);
		
	}
}
