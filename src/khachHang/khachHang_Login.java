package khachHang;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Application.mainFrame;
import hangHoa.hangHoa_All;
import root.root_Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class khachHang_Login extends JFrame {

	private JPanel contentPane;
	public static JTextField kh_us;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khachHang_Login frame = new khachHang_Login();
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
	public khachHang_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,800);
		setResizable(false);
		setTitle("Đăng nhập - Đăng ký");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(365, 86, 229, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(209, 233, 187, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(241, 333, 108, 32);
		contentPane.add(lblNewLabel_2);
		
		kh_us = new JTextField();
		kh_us.setHorizontalAlignment(SwingConstants.CENTER);
		kh_us.setFont(new Font("Tahoma", Font.PLAIN, 18));
		kh_us.setBackground(new Color(240, 240, 240));
		kh_us.setBounds(469, 228, 359, 46);
		contentPane.add(kh_us);
		kh_us.setColumns(10);
		kh_us.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(469, 328, 359, 46);
		contentPane.add(passwordField);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBackground(new Color(240, 240, 240));
		
		JButton cancel_bt = new JButton("Thoát");
		cancel_bt.setBackground(Color.GRAY);
		cancel_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainFrame().setVisible(true);
				dispose();
			}
		});
		cancel_bt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancel_bt.setBounds(866, 35, 110, 40);
		contentPane.add(cancel_bt);
		
		JButton kh_bt_login = new JButton("Đăng nhập");
		kh_bt_login.setBackground(Color.RED);
		kh_bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					
					JLabel lblNewLabel_8 = new JLabel("");
					lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblNewLabel_8.setBounds(344, 399, 330, 23);
					contentPane.add(lblNewLabel_8);
				String us = kh_us.getText();
				String pw = new String (passwordField.getPassword());
				
				java.sql.Statement a = conn.createStatement();
				ResultSet user = a.executeQuery("select user_kh, pw_kh from khachhang");
				while(user.next()) {
				if(us.contains(user.getString("user_kh")) && pw.contains(user.getString("pw_kh"))) {
					new hangHoa_All().setVisible(true);
					dispose();
					}
				else {
					lblNewLabel_8.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
				}
				}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(khachHang_Login.this, "Đăng nhập không thành công");
				}

			}
		});
		kh_bt_login.setFont(new Font("Tahoma", Font.BOLD, 18));
		kh_bt_login.setBounds(339, 443, 137, 40);
		contentPane.add(kh_bt_login);
		
		JButton kh_bt_register = new JButton("Đặt lại");
		kh_bt_register.setBackground(Color.RED);
		kh_bt_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kh_us.setText("");
				passwordField.setText("");
			}
		});
		kh_bt_register.setFont(new Font("Tahoma", Font.BOLD, 18));
		kh_bt_register.setBounds(537, 443, 137, 40);
		contentPane.add(kh_bt_register);
		
		JLabel lblNewLabel_3 = new JLabel("Sử dụng tên đăng nhập và mật khẩu để đăng nhập");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(305, 519, 418, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("hoặc");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(463, 552, 51, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Đăng ký tài khoản mới");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(395, 584, 199, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Đăng ký");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new khachHang_Register().setVisible(true);
			}
		});
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(606, 579, 68, 32);
		contentPane.add(lblNewLabel_6);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_7 = new JLabel("Quên mật khẩu?");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new khachHang_Forgot().setVisible(true);
			}
		});
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(734, 519, 145, 23);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5_1 = new JLabel("--------------------------");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(360, 116, 198, 18);
		contentPane.add(lblNewLabel_5_1);
		
	
	}
}
