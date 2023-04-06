package hangHoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dienThoai.DT_11PM;
import dienThoai.DT_FindX3;
import dienThoai.DT_Mate50;
import dienThoai.DT_S22Ultra;
import khachHang.khachHang_Login;
import khachHang.khachHang_ThongTin;
import lapTop.LT_DELL_Inp15;
import lapTop.LT_HP_240G8;
import lapTop.LT_Macbook_AirM1;
import lapTop.LT_Surface_7Pro;
import mayTinhBang.MTB_HW_MatePad11;
import mayTinhBang.MTB_SS_TabS8;
import mayTinhBang.MTB_Xiaomi_Pad5;
import mayTinhBang.MTB_iPad_ProM1;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class hangHoa_All extends JFrame {
	public static JTextField searchtext;
	public static JLabel s22;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hangHoa_All frame = new hangHoa_All();
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
	public hangHoa_All() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Trang chủ - Cửa hàng điện tử");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 255), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton giohang = new JButton("Gi\u1ECF h\u00E0ng");
		giohang.setBackground(Color.RED);
		giohang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new gioHang().setVisible(true);
				//dispose();
			}
		});
		giohang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		giohang.setBounds(705, 10, 110, 40);
		contentPane.add(giohang);
		
		JButton account = new JButton("T\u00E0i kho\u1EA3n");
		account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new khachHang_ThongTin().setVisible(true);
				//dispose();
			}
		});
		account.setBackground(Color.RED);
		account.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		account.setBounds(779, 60, 110, 40);
		contentPane.add(account);
		
		JButton logout = new JButton("\u0110\u0103ng xu\u1EA5t");
		logout.setBackground(Color.GRAY);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new khachHang_Login().setVisible(true);
				dispose();
			}
		});
		logout.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		logout.setBounds(22, 14, 101, 40);
		contentPane.add(logout);
		
		searchtext = new JTextField();
		searchtext.setBounds(400, 122, 362, 33);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		
		JButton search = new JButton("T\u00ECm ki\u1EBFm");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sea().setVisible(true);
				//dispose();
			}
		});
		search.setBackground(Color.ORANGE);
		search.setForeground(Color.BLACK);
		search.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		search.setBounds(817, 122, 101, 33);
		contentPane.add(search);
		
		JButton donhang = new JButton("\u0110\u01A1n h\u00E0ng");
		donhang.setBackground(Color.RED);
		donhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new donHang_LichSu().setVisible(true);
			}
		});
		donhang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		donhang.setBounds(849, 10, 110, 40);
		contentPane.add(donhang);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 165, 864, 576);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblNewLabel_1 = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 23, 81, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E1y t\u00EDnh b\u1EA3ng");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 210, 96, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Laptop");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 383, 81, 24);
		panel.add(lblNewLabel_3);
		
		JLabel s22 = new JLabel();
		s22.setText("Samsung Galaxy S22 Ultra");
		s22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_S22Ultra().setVisible(true);
				dispose();
			}
		});
		s22.setBounds(40, 155, 148, 33);
		panel.add(s22);
		
		final JLabel pm11 = new JLabel("iPhone 11 Pro Max");
		pm11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_11PM().setVisible(true);
				dispose();
			}
		});
		pm11.setBounds(275, 160, 125, 23);
		panel.add(pm11);
		JLabel lblNewLabel_6 = new JLabel("Oppo Find X3");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_FindX3().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setBounds(496, 160, 87, 23);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Huawei Mate 50");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_Mate50().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_7.setBounds(698, 160, 102, 23);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Xiaomi Pad 5");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_Xiaomi_Pad5().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_8.setBounds(92, 349, 96, 24);
		panel.add(lblNewLabel_8);
		
		JLabel label = new JLabel("New label");
		label.setBounds(315, 383, 45, -17);
		panel.add(label);
		
		JLabel lblNewLabel_9 = new JLabel("Samsung Tab S8");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_SS_TabS8().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_9.setBounds(279, 349, 96, 24);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("iPad Pro M1");
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_iPad_ProM1().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_10.setBounds(492, 344, 81, 24);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Huawei MatePad 11");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_HW_MatePad11().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_11.setBounds(698, 344, 114, 24);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Surface Pro 7");
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_Surface_7Pro().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_12.setBounds(66, 504, 93, 24);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Macbook Air M1");
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_Macbook_AirM1().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_13.setBounds(272, 504, 114, 24);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("HP 240 G8");
		lblNewLabel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_HP_240G8().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14.setBounds(483, 510, 80, 13);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("DELL Inspiron 15");
		lblNewLabel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_DELL_Inp15().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_15.setBounds(669, 510, 131, 13);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("36,990,000");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_16.setBounds(75, 184, 70, 19);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("16,590,000");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_17.setBounds(285, 187, 85, 13);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("18,790,000");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_18.setBounds(496, 186, 77, 14);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("18,190,000");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_19.setBounds(708, 187, 77, 13);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("10,490,000");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_20.setBounds(94, 383, 81, 13);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("20,990,000");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_21.setBounds(290, 383, 70, 13);
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("29,990,000");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_22.setBounds(496, 378, 87, 13);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("13,990,000");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_23.setBounds(708, 378, 77, 13);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_26 = new JLabel("New label");
		lblNewLabel_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_S22Ultra().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_26.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\S22_100x100.jpg"));
		lblNewLabel_26.setBounds(59, 57, 100, 100);
		panel.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("New label");
		lblNewLabel_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_11PM().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_27.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\11PM_100x100.jpg"));
		lblNewLabel_27.setBounds(275, 57, 100, 100);
		panel.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("New label");
		lblNewLabel_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_FindX3().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_28.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\oppofind_100x100.jpg"));
		lblNewLabel_28.setBounds(483, 57, 100, 100);
		panel.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("New label");
		lblNewLabel_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DT_Mate50().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_29.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\HWmate50_100x100.jpg"));
		lblNewLabel_29.setBounds(686, 57, 100, 100);
		panel.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("New label");
		lblNewLabel_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_Xiaomi_Pad5().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_30.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\XiaomiPad5 _100x100.jpg"));
		lblNewLabel_30.setBounds(75, 244, 100, 100);
		panel.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("New label");
		lblNewLabel_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_SS_TabS8().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_31.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\Tab_S8_100x100.jpg"));
		lblNewLabel_31.setBounds(275, 244, 100, 100);
		panel.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("New label");
		lblNewLabel_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_iPad_ProM1().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_32.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\iPad_100x100.jpeg"));
		lblNewLabel_32.setBounds(473, 244, 100, 100);
		panel.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("New label");
		lblNewLabel_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MTB_HW_MatePad11().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_33.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\HW_MatePad11_100x100.jpg"));
		lblNewLabel_33.setBounds(685, 244, 100, 100);
		panel.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("21,590,000");
		lblNewLabel_34.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_34.setBounds(76, 530, 76, 13);
		panel.add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("28,090,000");
		lblNewLabel_35.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_35.setBounds(289, 530, 71, 13);
		panel.add(lblNewLabel_35);
		
		JLabel lblNewLabel_36 = new JLabel("17,690,000");
		lblNewLabel_36.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_36.setBounds(483, 533, 70, 13);
		panel.add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("15,090,000");
		lblNewLabel_37.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_37.setBounds(691, 533, 81, 13);
		panel.add(lblNewLabel_37);
		
		JLabel lblNewLabel_38 = new JLabel("New label");
		lblNewLabel_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_Surface_7Pro().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_38.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Surface_100x100.jpg"));
		lblNewLabel_38.setBounds(59, 432, 100, 62);
		panel.add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("New label");
		lblNewLabel_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_Macbook_AirM1().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_39.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Mac_100x100.jpg"));
		lblNewLabel_39.setBounds(275, 430, 100, 67);
		panel.add(lblNewLabel_39);
		
		JLabel lblNewLabel_40 = new JLabel("New label");
		lblNewLabel_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_HP_240G8().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_40.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\HP_100x100.png"));
		lblNewLabel_40.setBounds(473, 429, 100, 68);
		panel.add(lblNewLabel_40);
		
		JLabel lblNewLabel_41 = new JLabel("New label");
		lblNewLabel_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LT_DELL_Inp15().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_41.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Dell_100x100.jpg"));
		lblNewLabel_41.setBounds(685, 433, 100, 61);
		panel.add(lblNewLabel_41);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_24 = new JLabel("C\u1EECA H\u00C0NG \u0110I\u1EC6N T\u1EEC");
		lblNewLabel_24.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_24.setBounds(288, 38, 302, 40);
		contentPane.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("get_name");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setText(khachHang_Login.kh_us.getText());
		lblNewLabel_25.setForeground(Color.BLUE);
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_25.setBounds(50, 122, 127, 30);
		contentPane.add(lblNewLabel_25);
		
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
			lblNewLabel_25.setText(user.getString(2));
			
		}	
		}
		}catch (Exception ex) {
		}
		
		JLabel lblNewLabel_42 = new JLabel("Nh\u1EADp m\u00E3 s\u1EA3n ph\u1EA9m/ t\u00EAn s\u1EA3n ph\u1EA9m \u0111\u1EC3 t\u00ECm ki\u1EBFm");
		lblNewLabel_42.setBounds(464, 100, 313, 24);
		contentPane.add(lblNewLabel_42);
		lblNewLabel_42.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		

		JLabel gettime = new JLabel("New label");
		gettime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gettime.setBounds(21, 72, 246, 30);
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
		chao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chao.setHorizontalAlignment(SwingConstants.CENTER);
		chao.setBounds(50, 100, 127, 30);
		contentPane.add(chao);
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
