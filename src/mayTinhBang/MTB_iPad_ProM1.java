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

public class MTB_iPad_ProM1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTB_iPad_ProM1 frame = new MTB_iPad_ProM1();
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
				new MTB_iPad_ProM1().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='ProM1';");
				
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
						
						JOptionPane.showMessageDialog(MTB_iPad_ProM1.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(MTB_iPad_ProM1.this, "Đặt hàng thất bại");
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
	public MTB_iPad_ProM1() {
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
					gh.setString(2, "ProM1");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(MTB_iPad_ProM1.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("iPad M1 Pro");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 29,990,000");
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='ProM1' and display.id_tb='ProM1' and  camera.id_tb='ProM1' and hdh.id_tb='ProM1' and cpu.id_tb='ProM1' and mem.id_tb='ProM1' and battery.id_tb='ProM1' ;");
		
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
		txt.setText("Apple gây ấn tượng khi cho ra mắt dòng laptop MacBook trang bị chip Apple M1, đem đến một hiệu năng xử lý vượt trội. Giờ đây nó đã xuất hiện trên chiếc máy tính bảng iPad Pro M1 11 inch Wifi 256GB (2021) chắc chắn sẽ tiếp nối sự thành công từ dòng laptop ra mắt trước đó.\r\n"
				+ "Đem hiệu năng laptop hàng đầu xuống một chiếc máy tính bảng\r\n"
				+ "Nếu bạn là một tín đồ của quả táo khuyết thì chắc chắn sẽ không lạ lẫm với vi xử lý Apple M1, con chip được trang bị trên các dòng MacBook đắt tiền giờ đây đã xuất hiện trên iPad Pro phiên bản 2021.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Hiệu năng mạnh mẻ với vi xử lý Apple M1\r\n"
				+ "\r\n"
				+ "Chipset M1 của iPad Pro M1 được trang bị 8 nhân CPU, 8 nhân GPU và 16 nhân xử lý AI đem đến hiệu xuất nhanh hơn 50% và khả năng đồ hoạ là 40% so với thế hệ iPad cũ.\r\n"
				+ "\r\n"
				+ "Máy được trang bị dung lượng RAM 8 GB và bộ nhớ lưu trữ lên tới 256 GB, tốc độ xử lý tuyệt vời cho bạn làm việc với cả những công việc chuyên nghiệp, tác vụ nặng.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | RAM 8 GB và bộ nhớ lưu trữ lên tới 256 GB\r\n"
				+ "\r\n"
				+ "Ngoài ra, máy tính bảng iPad Pro 2021 còn được trang bị hệ thống wifi 6 mang lại khả năng kết nối siêu nhanh, truyền tải với tốc độ vượt trội.\r\n"
				+ "\r\n"
				+ "Thiết kế sang trọng, thu hút từ mọi ánh nhìn\r\n"
				+ "iPad Pro 11 inch 2021 sở hữu ngoại hình mang nhiều điểm tương tự về ngoại hình với chiếc iPad Pro trước đó khi sử dụng màn hình Liquid Retina kích thước 11 inch với độ phân giải 1.668 x 2.388 mang đến chất lượng hiển thị tuyệt đẹp. \r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Màn hình 11 inch\r\n"
				+ "\r\n"
				+ "Tuy không được trang bị nhiều công nghệ nổi bật như người anh em iPad Pro M1 12.9 inch Wifi 256GB (2021) nhưng chắc chắn iPad Pro 11 inch vẫn sẽ mang đến cho bạn những trải nghiệm xem phim, chơi game cực đã.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Mang đến cho bạn những trải nghiệm xem phim, chơi game cực đã\r\n"
				+ "\r\n"
				+ "Màn hình trên iPad Pro 11 256GB còn hỗ trợ các tính năng nổi bật như ProMotion, True Tone và gam màu rộng P3 cho bạn đắm chìm trong không gian giải trí bất tận. \r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Hỗ trợ các tính năng nổi bật như ProMotion, True Tone và gam màu rộng P3\r\n"
				+ "\r\n"
				+ "Hơn thế nữa, được trang bị hệ thống 4 loa Dolby Atmos mang đến âm thanh chất lượng như trong rạp hát, người dùng có thể thoải mái trải nghiệm nghe nhạc, xem phim với chất lượng âm thanh sống động.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Hệ thống 4 loa Dolby Atmos mang đến âm thanh chất lượng \r\n"
				+ "\r\n"
				+ "Hỗ trợ Apple Pencil cùng hệ điều hành iPadOS mượt mà\r\n"
				+ "iPad Pro 2021 được cài đặt sẵn hệ điều hành iPadOS 15 (12/2021) do chính Apple sản xuất sở hữu kho ứng dụng vô cùng phong phú với hơn 1 triệu ứng dụng khác nhau trên AppStore, vừa cho khả năng xử lý một cách mượt mà vừa thực hiện thao tác như dán và sao chép cũng được thực hiện một cách dễ dàng hơn.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Hệ điều hành iPadOS 14 mượt mà\r\n"
				+ "\r\n"
				+ "Bên cạnh đó, máy tính bảng iPad Pro 2021 có thể kết nối với Apple Pencil giúp người dùng sử dụng ghi chú tốt hơn, khả năng gắn từ tính cùng đầu bút có độ nghiêng và độ nhạy cao, tối ưu cho trải nghiệm người dùng.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Hỗ trợ Apple Pencil\r\n"
				+ "\r\n"
				+ "Ngoài ra, iPad Pro 2021 cũng tương thích với phụ kiện Magic Keyboard mang lại trải nghiệm đánh máy tốt hơn với các phím có đèn nền và thiết kế nổi.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Tương thích với phụ kiện Magic Keyboard mang lại trải nghiệm đánh máy tốt hơn\r\n"
				+ "\r\n"
				+ "Lưu ý: Bút Apple Pencil, Magic Keyboard sẽ không đi kèm trong hộp máy.\r\n"
				+ "\r\n"
				+ "Cụm camera kép cho hình ảnh chất lượng\r\n"
				+ "Nổi bật ở mặt sau của máy tính bảng iPad Pro 2021 là cụm camera hình vuông đặt ở góc trái bao gồm: Camera chính 12 MP kết hợp cùng camera góc rộng 10 MP với góc chụp 125 độ cuối cùng là máy quét LiDAR và đèn LED flash. \r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Cụm camera kép cho hình ảnh chất lượng\r\n"
				+ "\r\n"
				+ "Bộ đôi camera này kết hợp cùng bộ xử lý hình ảnh ISP trên con chip M1 và máy quét LiDAR giúp máy lấy nét hình ảnh nhanh và chính xác hơn, cải thiện khả năng xử lý tín hiệu hình ảnh (IPS) và giúp cho ra những hình ảnh có chất lượng vượt trội hơn.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Bộ đôi camera này kết hợp cùng bộ xử lý hình ảnh ISP giúp lấy nét nhanh\r\n"
				+ "\r\n"
				+ "Với camera TrueDepth 12 MP ở phía trước của iPad Pro 2021 có tính năng đặc biệt là Center Stage, tính năng này có thể tự động căn chỉnh khung hình và thay đổi góc quay khi phát hiện đối tượng di chuyển khỏi khung hình, rất hữu ích cho những cuộc gọi video. \r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Camera TrueDepth 12 MP \r\n"
				+ "\r\n"
				+ "Ngoài ra, camera trước này còn giúp bạn mở khoá khuôn mặt trên iPad Pro 2021 nữa đấy nhé, với tốc độ nhận diện nhanh và chính xác.\r\n"
				+ "\r\n"
				+ "Thời lượng pin ấn tượng hỗ trợ sạc nhanh qua cổng Type-C\r\n"
				+ "Mang trên mình viên pin dung lượng lớn khoảng 7538 mAh, Apple tuyên bố iPad Pro mới có thời lượng pin cả ngày, lên đến khoảng 10 giờ duyệt web và xem video ở chế độ Wifi.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Viên pin dung lượng lớn 7538 mAh\r\n"
				+ "\r\n"
				+ "Bên cạnh đó, máy tính bảng iPad Pro 2021 còn hỗ trợ sạc nhanh công suất 20 W qua cổng Type-C giúp máy có thể sạc dễ dàng và đầy pin nhanh chóng.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Hỗ trợ sạc nhanh công suất 20 W qua cổng Type-C\r\n"
				+ "\r\n"
				+ "Hơn thế nữa, với chuẩn Thunderbolt giúp máy trở nên linh hoạt hơn, mở ra khả năng kết nối với hệ sinh thái khổng lồ bao gồm các phụ kiện hiệu suất cao, như: Bộ nhớ ngoài hay xuất hình ảnh qua màn hình ngoài độ phân giải 6K đầy đủ.\r\n"
				+ "\r\n"
				+ "iPad Pro M1 11 inch WiFi 256GB (2021) | Kết nối Thunderbolt giúp máy trở nên linh hoạt hơn\r\n"
				+ "\r\n"
				+ "Với những nâng cấp và cải tiến mạnh mẽ từ cấu hình hiệu năng và camera, chắc chắn iPad Pro M1 11 inch Wifi 256GB (2021) sẽ là một chiếc máy tính bảng rất được quan tâm và được nhiều người săn đón. ");
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
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\ipad_200x200.jpeg"));
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
