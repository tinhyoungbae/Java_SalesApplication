package root;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Application.mainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class root_Login extends JFrame {

	private JPanel contentPane;
	public static JTextField user_root;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					root_Login frame = new root_Login();
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
	public root_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Đăng nhập");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN TRỊ VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(399, 57, 247, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(252, 312, 174, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(276, 402, 108, 32);
		contentPane.add(lblNewLabel_2);
		
		user_root = new JTextField();
		user_root.setHorizontalAlignment(SwingConstants.CENTER);
		user_root.setFont(new Font("Tahoma", Font.PLAIN, 18));
		user_root.setBounds(535, 310, 295, 41);
		contentPane.add(user_root);
		user_root.setColumns(10);
		user_root.setBackground(new Color(240, 240, 240));
		user_root.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setToolTipText("");
		passwordField.setBounds(535, 402, 295, 41);
		contentPane.add(passwordField);
		passwordField.setBackground(new Color(240, 240, 240));
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		

		
		JButton bt_reset = new JButton("Đặt lại");
		bt_reset.setBackground(Color.RED);
		bt_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_root.setText("");
				passwordField.setText("");
			}
		});
		bt_reset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bt_reset.setBounds(602, 517, 125, 53);
		contentPane.add(bt_reset);
		JButton btnlogin = new JButton("Đăng nhập");
		btnlogin.setBackground(Color.RED);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					JLabel lblNewLabel_4 = new JLabel("");
					lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblNewLabel_4.setBounds(353, 262, 337, 23);
					contentPane.add(lblNewLabel_4);
					String us = user_root.getText();
				String pw = new String (passwordField.getPassword());
				
				java.sql.Statement a = conn.createStatement();
				ResultSet user = a.executeQuery("select user_root, pw_root from root");
				
				while(user.next()) {
				if(us.contains(user.getString("user_root")) && pw.contains(user.getString("pw_root"))) {
					new root_HangHoa().setVisible(true);
					dispose();
				}
				else lblNewLabel_4.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
				}
				}catch (Exception ex) {
					System.out.println("Fail!");
				}

			}
		});
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnlogin.setBounds(369, 517, 125, 53);
		contentPane.add(btnlogin);
		
		JButton btnNewButton_2 = new JButton("Thoát");
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(864, 24, 101, 53);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập tên đăng nhập và mật khẩu để đăng nhập");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(353, 604, 397, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblngNhp = new JLabel("Đăng Nhập");
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblngNhp.setBounds(442, 179, 174, 42);
		contentPane.add(lblngNhp);
		
		JLabel lblNewLabel_5 = new JLabel("-----------------------");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(413, 219, 198, 18);
		contentPane.add(lblNewLabel_5);
	}
}
