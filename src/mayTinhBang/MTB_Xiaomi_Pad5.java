package mayTinhBang;

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

import dienThoai.DT_11PM;
import dienThoai.DT_FindX3;
import hangHoa.donHang_LichSu;
import hangHoa.gioHang;
import hangHoa.hangHoa_All;
import khachHang.khachHang_Login;
import lapTop.LT_Surface_7Pro;

public class MTB_Xiaomi_Pad5 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTB_Xiaomi_Pad5 frame = new MTB_Xiaomi_Pad5();
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
				new MTB_Xiaomi_Pad5().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='Pad5';");
				
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
						
						JOptionPane.showMessageDialog(MTB_Xiaomi_Pad5.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(MTB_Xiaomi_Pad5.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
			
			
		}
		
	/**
	 * Create the frame.
	 */
	public MTB_Xiaomi_Pad5() {
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
					gh.setString(2, "Pad5");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(MTB_Xiaomi_Pad5.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Xiaomi Pad 5");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 10,490,000");
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='Pad5' and display.id_tb='Pad5' and  camera.id_tb='Pad5' and hdh.id_tb='Pad5' and cpu.id_tb='Pad5' and mem.id_tb='Pad5' and battery.id_tb='Pad5' ;");
		
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
		txt.setText("Xiaomi đã mang dòng máy tính bảng quay trở lại sau một thời gian dài vắng bóng bằng việc ra mắt Xiaomi Pad 5. Sản phẩm này được trang bị một thiết kế hiện đại cùng hàng loạt nâng cấp về cấu hình và các tính năng hữu ích.\r\n"
				+ "Trải nghiệm không gian không giới hạn\r\n"
				+ "Màn hình lớn 11 inch có độ hiển thị siêu rõ nét với độ phân giải cao và hỗ trợ HDR10 giúp cho mọi chi tiết đều trở nên bắt mắt. Màn hình có khả năng hiển thị lên đến 1 tỷ màu sẽ khôi phục lại màu sắc rực rỡ nhất của cuộc sống xung quanh ngay trên màn hình.\r\n"
				+ "\r\n"
				+ "Màn hình 11 inch cực sắc nét - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Sản phẩm này được trang bị tấm nền IPS LCD giúp hiển thị hình ảnh tốt, mang đến cho người dùng những trải nghiệm hình ảnh vô cùng chân thực cùng độ chi tiết ấn tượng.\r\n"
				+ "\r\n"
				+ "Trang bị tấm nền IPS LCD - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Khả năng chống ánh sáng xanh của Xiaomi Pad 5 đã đạt chứng nhận của Rheinland giúp việc đọc, sử dụng trên máy tính bảng thời gian dài trở nên tự nhiên và thoải mái hơn, mang lại cảm giác đọc gần với sách giấy. Cùng cảm biến ánh sáng kép sẽ tự động điều chỉnh độ sáng thích hợp tránh kích thích ánh sáng mạnh để chăm sóc đôi mắt của bạn.\r\n"
				+ "\r\n"
				+ "Đạt chứng nhận khả năng bảo vệ mắt - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Tần số quét 120 Hz mang lại cảm giác mượt mà và trơn tru hơn khi thao tác trên màn hình. Kết hợp cùng bút cảm ứng Xiaomi phản hồi cực nhạy và đầu bút mềm mại, đem tới trải nghiệm viết, vẽ, ghi chú tự nhiên như bạn đang dùng bút thường, sáng tạo nội dung bất tận không thua kém gì laptop.\r\n"
				+ "\r\n"
				+ "Tần số 120 Hz cho mọi chuyển động mượt mà - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Thiết kế cứng cáp, hệ thống camera chất lượng\r\n"
				+ "Với trọng lượng 511 gam, mỏng chỉ 6.85 mm bạn có thể sử dụng thiết bị một cách khá linh hoạt, có thể cầm bằng một tay nhẹ nhàng dễ dàng di chuyển mọi lúc mọi nơi. Khung được được làm bằng kim loại cứng cáp và thanh lịch cùng phần viền thiết kế bo cong mềm mại ở các góc, mang lại sự tinh tế, sang trọng khi mang theo bên mình.\r\n"
				+ "\r\n"
				+ "Kiểu dáng thời trang và thanh lịch - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Hệ thống âm thanh 4 loa hỗ trợ công nghệ Dolby Atmos tạo hiệu ứng không gian sống động, âm bổng rõ ràng, ổn định và xuất sắc, mang lại trải nghiệm âm thanh phong phú, tận hưởng giai điệu tuyệt đẹp của thế giới âm thanh một cách chân thực nhất.\r\n"
				+ "\r\n"
				+ "Công nghệ âm thanh Dolby Atmos - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Về khả năng chụp ảnh, Xiaomi Pad 5 có camera đơn 13 MP ở mặt lưng với khả năng quay video 4K giúp bạn ghi lại khoảnh khắc đáng nhớ hàng ngày. Chế độ tự động lấy nét sẽ giúp chụp những cảnh thú vị thoáng qua có nội dung rõ ràng hơn, bạn có thể lấy nét ngay khi nhấc máy ảnh lên. Chế độ chụp toàn cảnh cho bạn trở thành các nhiếp ảnh gia làm chủ được mọi khung hình và tạo nên những tác phẩm độc đáo.\r\n"
				+ "\r\n"
				+ "Camera 13 MP ở mặt lưng - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Máy ảnh selfie 8 MP ở mặt trước mang đến những tấm ảnh khá chi tiết và còn hỗ trợ mở khoá bằng khuôn mặt cho người dùng.\r\n"
				+ "\r\n"
				+ "Mở khóa khuôn mặt - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Hiệu năng vượt trội\r\n"
				+ "Cấu hình mạnh mẽ với Snapdragon 860 8 nhân, tốc độ xử lý cao nhất có thể đạt 2.96 GHz giúp xử lý nhanh gọn và mượt mà các tác vụ đồ họa chuyên nghiệp hay các game phổ biến hiện nay như Liên Quân, PUBG Mobile,… Ngoài việc chơi game, thì với cấu hình này cũng sẽ giúp bạn làm việc, học tập với các tác vụ nặng như xử lý đồ họa 3D, chỉnh sửa video chất lượng cao một cách trơn tru nhất. \r\n"
				+ "\r\n"
				+ "Máy tính bảng Xiaomi Pad 5 - Chip Snapdragon 860\r\n"
				+ "\r\n"
				+ "Không chỉ tốc độ được nâng cao, GPU Adreno 640 còn cải thiện đáng kể về khả năng xử lý đồ họa khi xem phim có độ phân giải cao hay những tựa game yêu cầu đồ họa cao, tăng độ chân thực cho các hình ảnh, video mang đến trải nghiệm hình ảnh tốt nhất cho người dùng. \r\n"
				+ "\r\n"
				+ "Khả năng đồ họa ấn tượng - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Dung lượng lưu trữ 128 GB bộ nhớ trong, bạn có thể dễ dàng lưu nhiều bộ phim truyền hình dài tập và những tệp nặng hằng ngày. Bên cạnh đó, RAM 6 GB giúp xử lý đa nhiệm liên tục, mạnh mẽ trong mọi công việc cũng như giải trí.\r\n"
				+ "\r\n"
				+ "Dung lượng bộ nhớ - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Xiaomi Pad 5 có thể chia màn hình thành hai phần giúp người dùng mở nhiều ứng dụng, đa nhiệm cùng lúc mà không làm ảnh hưởng đến nhau.\r\n"
				+ "\r\n"
				+ "Năng lượng dồi dào\r\n"
				+ "Để đáp ứng cho nhu cầu giải trí, học tập và làm việc liên tục Xiaomi Pad 5 trang bị viên pin lớn 8720 mAh. Ngoài ra Xiaomi Pad 5 có khả năng sạc nhanh 33 W giúp phục hồi năng lượng nhanh chóng, không phải lo lắng về việc hết pin cho cả ngày di chuyển. \r\n"
				+ "\r\n"
				+ "Dung lượng pin lớn 8720 mAh - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Tuy nhiên hãng chỉ cung cấp củ sạc 22.5 W trong hộp, để tận dụng tối đa khả năng sạc nhanh của máy thì bạn phải mua riêng.\r\n"
				+ "\r\n"
				+ "Hỗ trợ sach nhanh 33 W - Xiaomi Pad 5\r\n"
				+ "\r\n"
				+ "Với những đột phá trong thiết kế, cấu hình và hiệu năng cực kỳ mạnh mẽ. Xiaomi Pad 5 là một siêu phẩm rất đáng để mua, chắc chắn sẽ làm hài lòng bất kỳ các khách hàng khó tính nhất.");
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
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\xiaomi_200x200.jpg"));
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
