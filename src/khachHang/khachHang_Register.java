package khachHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class khachHang_Register extends JFrame {

	private JPanel contentPane;
	private JTextField kh_username;
	private JTextField kh_dc;
	private JPasswordField kh_pw;
	private JTextField kh_sdt;
	private JTextField kh_date;
	private JTextField kh_name;
	private JTextField email_kh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khachHang_Register frame = new khachHang_Register();
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
	public khachHang_Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,800);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(330, 43, 291, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(51, 280, 45, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(28, 364, 90, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(528, 360, 115, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(550, 447, 93, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Họ tên");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(36, 448, 60, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày sinh");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(28, 530, 101, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Giới tính");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(784, 258, 92, 23);
		contentPane.add(lblNewLabel_7);
		
		JRadioButton nam_radio = new JRadioButton("Nam");
		nam_radio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nam_radio.setBounds(735, 302, 74, 21);
		contentPane.add(nam_radio);
		
		final JRadioButton nu_radio = new JRadioButton("N\u1EEF");
		nu_radio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nu_radio.setBounds(855, 302, 60, 21);
		contentPane.add(nu_radio);
		
		JButton btnNewButton = new JButton("Xong");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(863, 49, 93, 44);
		contentPane.add(btnNewButton);
		
		kh_username = new JTextField();
		kh_username.setHorizontalAlignment(SwingConstants.CENTER);
		kh_username.setBounds(205, 277, 249, 33);
		contentPane.add(kh_username);
		kh_username.setColumns(10);
		
		kh_dc = new JTextField();
		kh_dc.setHorizontalAlignment(SwingConstants.CENTER);
		kh_dc.setBounds(694, 445, 249, 33);
		contentPane.add(kh_dc);
		kh_dc.setColumns(10);
		
		kh_pw = new JPasswordField();
		kh_pw.setHorizontalAlignment(SwingConstants.CENTER);
		kh_pw.setBounds(205, 362, 249, 33);
		contentPane.add(kh_pw);
		kh_pw.setColumns(10);
		
		kh_sdt = new JTextField();
		kh_sdt.setHorizontalAlignment(SwingConstants.CENTER);
		kh_sdt.setBounds(694, 362, 249, 33);
		contentPane.add(kh_sdt);
		kh_sdt.setColumns(10);
		
		kh_date = new JTextField();
		kh_date.setHorizontalAlignment(SwingConstants.CENTER);
		kh_date.setBounds(205, 532, 249, 33);
		contentPane.add(kh_date);
		kh_date.setColumns(10);
		
		kh_name = new JTextField();
		kh_name.setHorizontalAlignment(SwingConstants.CENTER);
		kh_name.setBounds(205, 445, 249, 33);
		contentPane.add(kh_name);
		
		ButtonGroup g = new ButtonGroup();
		g.add(nam_radio);
		g.add(nu_radio);
		
		email_kh = new JTextField();
		email_kh.setHorizontalAlignment(SwingConstants.CENTER);
		email_kh.setBounds(694, 532, 249, 33);
		contentPane.add(email_kh);
		email_kh.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(561, 535, 60, 23);
		contentPane.add(lblNewLabel_9);
		
		JButton register_bt = new JButton("Đăng ký");
		register_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					String pw_kh = new String (kh_pw.getPassword());
					String kh_gioitinh = "Nam";
					if(nu_radio.isSelected()) {
						kh_gioitinh = "Nu";
					}
					PreparedStatement register = (PreparedStatement) conn.prepareStatement("insert into khachhang values(?, ?, ?, ?, ?, ?, ?, ?)");
					register.setString(1, kh_username.getText());
					register.setString(2, pw_kh);
					register.setString(3, kh_name.getText());
					register.setString(4, kh_date.getText());
					register.setString(5, kh_gioitinh);
					register.setString(6, kh_sdt.getText());
					register.setString(7, kh_dc.getText());
					register.setString(8, email_kh.getText());
					register.executeUpdate();
					
					JOptionPane.showMessageDialog(khachHang_Register.this, "Đăng ký thành công");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(khachHang_Register.this, "Đăng ký thất bại");
				}

			}
		});
		register_bt.setBackground(Color.RED);
		register_bt.setFont(new Font("Tahoma", Font.BOLD, 20));
		register_bt.setBounds(490, 652, 131, 53);
		contentPane.add(register_bt);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_10 = new JLabel("------------------------------------------------------------------------------------");
		lblNewLabel_10.setBounds(295, 80, 340, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("Thông tin đăng ký");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(75, 158, 249, 34);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10_1 = new JLabel("-----------------------------------------------------------------------------");
		lblNewLabel_10_1.setBounds(30, 187, 340, 13);
		contentPane.add(lblNewLabel_10_1);
		
		
	}
}
