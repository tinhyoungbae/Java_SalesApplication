package dienThoai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.mysql.jdbc.PreparedStatement;

import hangHoa.gioHang;
import hangHoa.hangHoa_All;
import khachHang.khachHang_Login;

public class DT_Mate50 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DT_Mate50 frame = new DT_Mate50();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(450,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Sản phẩm");
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
				new DT_Mate50().setVisible(true);
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
		sltb.setText("1");
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

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
				java.sql.Statement a = conn.createStatement();
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='Mate_50';");
				
				while(detail.next()) {
					tentb.setText(detail.getString(1));
				}
			} catch (Exception ex) {
			}
			
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
						
						JOptionPane.showMessageDialog(DT_Mate50.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(DT_Mate50.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
			
			
		}
		
	
	public DT_Mate50() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 779);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new hangHoa_All().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(818, 10, 85, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0110\u1EB7t mua");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order();
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(182, 347, 94, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gi\u1ECF h\u00E0ng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					PreparedStatement gh = (PreparedStatement) conn.prepareStatement("insert into giohang values(?, ?, ?);");
					gh.setString(1, khachHang_Login.kh_us.getText());
					gh.setString(2, "Mate_50");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(DT_Mate50.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Huawei Mate 50");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Giá: 18,190,000");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(264, 298, 94, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u00F4ng s\u1ED1 k\u1EF9 thu\u1EADt");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(720, 91, 161, 38);
		contentPane.add(lblNewLabel_2);
		
		JTextField mh = new JTextField();
		mh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mh.setHorizontalAlignment(SwingConstants.CENTER);
		mh.setText("M\u00E0n h\u00ECnh");
		mh.setBounds(690, 155, 224, 33);
		contentPane.add(mh);
		mh.setColumns(10);
		mh.setEditable(false);
		
		JTextField dpg = new JTextField();
		dpg.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		dpg.setHorizontalAlignment(SwingConstants.CENTER);
		dpg.setText("\u0110\u1ED9 ph\u00E2n gi\u1EA3i");
		dpg.setBounds(690, 195, 224, 33);
		contentPane.add(dpg);
		dpg.setColumns(10);
		dpg.setEditable(false);
		
		JTextField camt = new JTextField();
		camt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		camt.setText("Camera tr\u01B0\u1EDBc");
		camt.setHorizontalAlignment(SwingConstants.CENTER);
		camt.setBounds(690, 255, 224, 33);
		contentPane.add(camt);
		camt.setColumns(10);
		camt.setEditable(false);
		
		JTextField cams = new JTextField();
		cams.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cams.setText("Camera sau");
		cams.setHorizontalAlignment(SwingConstants.CENTER);
		cams.setBounds(690, 295, 224, 33);
		contentPane.add(cams);
		cams.setColumns(10);
		cams.setEditable(false);
		
		JTextField hdh = new JTextField();
		hdh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		hdh.setText("H\u1EC7 \u0111i\u1EC1u h\u00E0nh");
		hdh.setHorizontalAlignment(SwingConstants.CENTER);
		hdh.setBounds(690, 360, 224, 33);
		contentPane.add(hdh);
		hdh.setColumns(10);
		hdh.setEditable(false);
		
		JTextField chip = new JTextField();
		chip.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chip.setHorizontalAlignment(SwingConstants.CENTER);
		chip.setText("Chip x\u1EED l\u00FD");
		chip.setBounds(690, 403, 224, 33);
		contentPane.add(chip);
		chip.setColumns(10);
		chip.setEditable(false);
		
		JTextField cpu = new JTextField();
		cpu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cpu.setHorizontalAlignment(SwingConstants.CENTER);
		cpu.setText("T\u1ED1c \u0111\u1ED9 CPU");
		cpu.setBounds(690, 446, 224, 33);
		contentPane.add(cpu);
		cpu.setColumns(10);
		cpu.setEditable(false);
		
		JTextField gpu = new JTextField();
		gpu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		gpu.setText("GPU");
		gpu.setHorizontalAlignment(SwingConstants.CENTER);
		gpu.setBounds(690, 489, 224, 33);
		contentPane.add(gpu);
		gpu.setColumns(10);
		gpu.setEditable(false);
		
		JTextField ram = new JTextField();
		ram.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ram.setHorizontalAlignment(SwingConstants.CENTER);
		ram.setText("RAM");
		ram.setBounds(690, 550, 224, 33);
		contentPane.add(ram);
		ram.setColumns(10);
		ram.setEditable(false);
		
		JTextField rom = new JTextField();
		rom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rom.setText("ROM");
		rom.setHorizontalAlignment(SwingConstants.CENTER);
		rom.setBounds(690, 593, 224, 33);
		contentPane.add(rom);
		rom.setColumns(10);
		rom.setEditable(false);
		
		JTextField pin = new JTextField();
		pin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pin.setHorizontalAlignment(SwingConstants.CENTER);
		pin.setText("xxxmAh");
		pin.setBounds(690, 656, 224, 33);
		contentPane.add(pin);
		rom.setColumns(10);
		pin.setEditable(false);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		java.sql.Statement a = conn.createStatement();
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='Mate_50' and display.id_tb='Mate_50' and  camera.id_tb='Mate_50' and hdh.id_tb='Mate_50' and cpu.id_tb='Mate_50' and mem.id_tb='Mate_50' and battery.id_tb='Mate_50' ;");
		
		while(detail.next()) {
			mh.setText(detail.getString(1));
			dpg.setText(detail.getString(2));
			camt.setText(detail.getString(3) + " MP");
			cams.setText(detail.getString(4) + " MP");
			hdh.setText(detail.getString(5));
			chip.setText(detail.getString(6));
			cpu.setText(detail.getString(7) + " Ghz");
			gpu.setText(detail.getString(8));
			ram.setText(detail.getString(9) + " GB");
			rom.setText(detail.getString(10) + " GB");
			pin.setText(detail.getString(11) + " mAh");	
		}
		}catch (Exception ex) {
		}
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E0n h\u00ECnh");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(595, 138, 74, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Camera");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(595, 238, 52, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("H\u0110H & CPU");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(586, 347, 94, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("B\u1ED9 nh\u1EDB");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(609, 531, 57, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PIN");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(609, 638, 45, 18);
		contentPane.add(lblNewLabel_7);
		
		JTextArea txt = new JTextArea();
		txt.setBackground(new Color(240, 240, 240));
		txt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt.setText("Huawei Mate 50 Pro - Tiên phong trong công nghệ nhiếp ảnh kỹ thuật số\r\n"
				+ "Huawei Mate 50 Pro ra mắt mang đến hàng loạt những tính năng mới, hiệu năng mạnh mẽ, cùng 4 tứ camera được tinh chỉnh bởi leica nhằm mang đến nhiếp ảnh thực thụ trên di động. Xứng đáng là một trong những chiếc điện thoại mạnh mẽ trong năm 2021.\r\n"
				+ "\r\n"
				+ "Thiết kế sáng tạo, thu hút ở mọi góc nhìn\r\n"
				+ "Được tạo ra bởi độ ngũ kỹ sư tâm huyết, điện thoại Huawei Mate 50 phiên bản Pro mang đến thiết kế đối xứng với 2 mặt kính cùng khung viền kim loại sáng bóng và cao cấp. Hệ thống camera Space Ring ở mặt lưng tạo điểm nhấn cho toàn bộ thiết kế của máy.\r\n"
				+ "\r\n"
				+ "Thiết kế sáng tạo, thu hút ở mọi góc nhìn\r\n"
				+ "\r\n"
				+ "Người dùng có thể lựa chọn hàng loạt các màu sắc khác nhau như Đen và Trắng tinh khiết, Bạc Mystic, Xanh Olive được phối màu hết sức hợp thời trang giúp định hình phong cách sử dụng của bạn.\r\n"
				+ "\r\n"
				+ "Màn hình tràn viền Horizen OLED Display\r\n"
				+ "Huawei Mate 50 Pro trang bị màn hình tràn viền với độ cong 88 độ mang tên Horizen OLED Display, mang đến khung hình ảnh sống động, các góc viền được bo cong giúp tăng trải nghiệm cầm nắm sử dụng.\r\n"
				+ "\r\n"
				+ "Màn hình tràn viền Horizen OLED Display\r\n"
				+ "\r\n"
				+ "Tần số quét màn hình được nâng cấp lên 144Hz cho thao tác cảm ứng gần như ngay lập tức, tự động tinh chỉnh độ sáng và màu sắc theo thời gian thực giúp bạn trải nghiệm nội dung một cách tuyệt vời.\r\n"
				+ "\r\n"
				+ "Khả năng xử lý vượt trội với Kirin 9000+\r\n"
				+ "Luôn đi tiên phong trong việc áp dụng các công nghệ mới vào trong sản phẩm, Huawei Mate 50 Pro tiếp tục trang bị vi xử lý dẫn đầu Kirin 9000+ được nâng cấp đáng kể về mặt hiệu năng xử lý, giúp xử lý nhanh chóng gần như ngay lập tức mọi phản hồi.\r\n"
				+ "\r\n"
				+ "Khả năng xử lý vượt trội với Kirin 9000+\r\n"
				+ "\r\n"
				+ "Nâng cấp CPU với tốc độ 3.13Ghz, kiến trúc 3 lớp cùng 8 nhân xử lý cải thiện tốc độ và khả năng tiêu thụ điện. GPU Mali-G78 với 24 nhân mang đến khả năng xử lý hình ảnh tuyệt vời, để bạn tận hưởng trải nghiệm gaming đỉnh cao trên di động.\r\n"
				+ "\r\n"
				+ "Mang đến tốc độ kết nối internet siêu tốc với Wi-Fi 6, mạng 5G\r\n"
				+ "Tốc độ nâng cao trải nghiệm người dùng, Huawei Mate 50 Pro tích hợp mạng di động 5G tốc độ cao, kết hợp cùng công nghệ 5G Super Uplink độc quyền giúp bạn upload, gửi hay chia sẻ mọi thứ qua 5G một cách nhanh chóng.\r\n"
				+ "\r\n"
				+ "Mang đến tốc độ kết nối internet siêu tốc với Wi-Fi 6, mạng 5G\r\n"
				+ "\r\n"
				+ "Chơi game với độ trễ thấp, stream nội dung chất lượng 4K nhanh chóng với Wi-Fi 6+. Đảm bảo Huawei Mate 50 Pro nhận được vùng phủ sóng rộng hợp, nhận tín hiệu mạnh hơn và đảm bảo một kết nối ổn định và xuyên suốt.\r\n"
				+ "\r\n"
				+ "Bảo mật được đặt lên hàng đầu với vân tay trong màn hình và nhận diện khuôn mặt 3D\r\n"
				+ "Huawei Mate 50 Pro hiểu rõ tầm quan trọng về bảo mật, trang bị vân tay trong màn hình thế hệ mới, giúp việc mở khóa mất chưa đầy 1 giây. Ngoài ra bạn còn có thể sử dụng mở khóa khuôn mặt 3D hoạt động tốt ở trong bất kỳ điều kiện nào.\r\n"
				+ "\r\n"
				+ "Bảo mật được đặt lên hàng đầu với vân tay trong màn hình và nhận diện khuôn mặt 3D\r\n"
				+ "\r\n"
				+ "2 phương thức mở khóa đều an toàn cho việc xác thực thanh toán điện tử, nên bạn có thể sử dụng 1 trong 2 cách để xác nhận thanh toán cho các giao dịch của mình, tiện lợi và vô cùng bảo mật.\r\n"
				+ "\r\n"
				+ "Bắt trọn từng khoảnh khắc với bộ tứ Camera tinh chỉnh bởi Leica\r\n"
				+ "Với Huawei, mỗi khoảnh khắc là một câu chuyện được kể. Huawei Mate 50 Pro với camera chính 50MP mang đến những bức ảnh sắc nét , camera góc siêu rộng chuẩn điện ảnh 20MP ghi lại mọi câu chuyện đậm chất điện ảnh.\r\n"
				+ "\r\n"
				+ "Bắt trọn từng khoảnh khắc với bộ tứ Camera tinh chỉnh bởi Leica\r\n"
				+ "\r\n"
				+ "Camera tele 12MP hỗ trợ zoom quang 5X, zoom hybrid 10x và zoom kỹ thuật số lên đến 50x cùng công nghệ ổn định hình ảnh OIS. Đem đến những chi tiết bị ẩn ra bên ngoài khung ảnh. Cảm biến camera laser nhận diện nhanh và lấy nét chính xác.\r\n"
				+ "\r\n"
				+ "Quay video chuẩn điện ảnh với XD Fusion HDR và Steady Shot\r\n"
				+ "Công nghệ XD Fusion HDR dựng từng khung hình với mức độ chi tiết, màu sắc, độ tương phản và độ sáng được tối ưu một cách trung thực. Chất lượng video được cải thiện đáng kể, ngay cả trong điện kiện thiếu sáng nhờ khả năng phơi sáng thông minh.\r\n"
				+ "\r\n"
				+ "Quay video chuẩn điện ảnh với XD Fusion HDR và Steady Shot\r\n"
				+ "\r\n"
				+ "Đem đến những chuyến phiêu lưu và hành trình sống đột mà không để một vài sự rung nhòe là hư hỏng video của bạn. Tính năng Steady Shot cải tiến giúp bạn quay được những thước phim ổn định hơn, kể cả khi bạn đang chạy hoặc trượt tuyết.\r\n"
				+ "\r\n"
				+ "Selfie ấn tượng với cụm camera selfie kép mạnh mẽ\r\n"
				+ "Camera selfie Ultra Vision kết hợp mạnh mẽ giữa camera góc siêu rộng và cảm biến chuyển động. Giờ đây, bạn có thể chụp ảnh selfie ở nhiều góc độ khác nhau, kết hợp các tính năng video thông minh cùng thao tác không chạm để mang đến các góc quay ấn tượng cùng bạn bè.\r\n"
				+ "\r\n"
				+ "Selfie ấn tượng với cụm camera selfie kép mạnh mẽ\r\n"
				+ "\r\n"
				+ "Khởi đầu Vlog với các thước phim độc đáo. Camera trước trên Huawei Mate 50 Pro giờ đây hỗ trợ quay video chất lượng cao 4K, quay video góc siêu rộng, quay video kép trước và sau và quay video siêu chậm.\r\n"
				+ "\r\n"
				+ "Đồng hành cùng bạn không ngừng nghỉ với viên pin 5000mAh, công nghệ sạc nhanh 66W\r\n"
				+ "Với viên pin 5000mAh, cùng khả năng tiết kiệm pin của CPU và giao diện EMUI bạn giờ đây đã có thể trải nghiệm chiếc điện thoại với thời lượng vô cùng ấn tượng.\r\n"
				+ "\r\n"
				+ "Đồng hành cùng bạn không ngừng nghỉ với viên pin 5000mAh, công nghệ sạc nhanh 66W\r\n"
				+ "\r\n"
				+ "Công nghệ sạc nhanh Huawei SuperCharge với công suất 66W cho bạn thời gian sạc đầy pin chỉ mất hơn 30 phút. Nếu bạn không thích sạc có dây thì có thể thử với sạc nhanh không dây 50W, việc cạn pin trên điện thoại giờ đây chỉ còn là dĩ vãng.");
		txt.setBounds(10, 440, 572, 292);
		txt.setLineWrap(true);
		contentPane.add(txt);
		txt.setEditable(false); //Ngăn chặn edit văn bản
		txt.setWrapStyleWord(true);//Gộp dòng văn bản
		
		JScrollPane scrollPane = new JScrollPane(txt);
		scrollPane.setBounds(10, 440, 572, 292);
		contentPane.add(scrollPane);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\huawei-200x200.jpg"));
		lblNewLabel_9.setBounds(199, 99, 200, 200);
		contentPane.add(lblNewLabel_9);
		
		JButton btnGiHng = new JButton("Giỏ hàng");
		btnGiHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new gioHang().setVisible(true);
			}
		});
		btnGiHng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGiHng.setBackground(Color.RED);
		btnGiHng.setBounds(681, 10, 94, 33);
		contentPane.add(btnGiHng);
		
		JPanel panel = new JPanel();
		panel.setBounds(679, 145, 244, 556);
		contentPane.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		
		setTitle("Sản phẩm");
	}

}
