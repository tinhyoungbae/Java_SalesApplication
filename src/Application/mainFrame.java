package Application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import hangHoa.hangHoa_All;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import root.root_Login;
import khachHang.khachHang_Forgot;
import khachHang.khachHang_Login;
import khachHang.khachHang_Register;

public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Object kh_us;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Quản trị bán hàng - Trang chủ");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackground(Color.gray);
		
		JLabel lblNewLabel = new JLabel("BÁN HÀNG ĐIỆN TỬ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(363, 235, 336, 51);
		lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
		lblNewLabel.setAlignmentY(CENTER_ALIGNMENT);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Quản trị viên");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new root_Login().setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(271, 509, 165, 50);
		contentPane.add(btnNewButton);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JButton btnKhchHng = new JButton("Khách hàng");
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new khachHang_Login().setVisible(true);
				dispose();
			}
		});
		btnKhchHng.setForeground(Color.WHITE);
		btnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnKhchHng.setBackground(Color.BLUE);
		btnKhchHng.setBounds(609, 509, 165, 50);
		contentPane.add(btnKhchHng);
		
		JLabel lblNewLabel_1 = new JLabel("Tiếp tục sử dụng với");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(413, 430, 217, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đọc hướng dẫn sử dụng chương trình bằng cách bấm");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(496, 711, 405, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("vào đây");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setBackground(Color.BLUE);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(898, 719, 78, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 36, 274, 301);
		contentPane.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Thời gian");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(79, 21, 100, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(39, 88, 205, 24);
		panel.add(lblNewLabel_3);
		
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
		String getd = df.format(today);
		lblNewLabel_3.setText(getd);
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		lblNewLabel_3.setText(Integer.toString(hour) + " giờ " + Integer.toString(minute) +" Phút");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(39, 151, 205, 24);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setText("Ngày " + Integer.toString(day) + " Tháng " + Integer.toString(month+1) + " Năm " + Integer.toString(year));
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(39, 217, 205, 24);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("----------------------------");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(66, 41, 118, 18);
		panel.add(lblNewLabel_5);
		
		if(hour >= 5 & hour < 11) {
			lblNewLabel_4_1.setText("Chào buổi sáng!");
		}
		if(hour >= 11 & hour < 13) {
			lblNewLabel_4_1.setText("Chào buổi trưa!");
		}
		if(hour >= 13 & hour < 18) {
			lblNewLabel_4_1.setText("Chào buổi chiều!");
		}
		if(hour >= 18 & hour < 22) {
			lblNewLabel_4_1.setText("Chào buổi tối!");
		}
		if(hour >= 22 & hour < 5) {
			lblNewLabel_4_1.setText("Chúc ngủ ngon!");
		}
	}
}
