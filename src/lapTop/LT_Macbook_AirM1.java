package lapTop;

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

public class LT_Macbook_AirM1 extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LT_Macbook_AirM1 frame = new LT_Macbook_AirM1();
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
				new LT_Macbook_AirM1().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='AirM1';");
				
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
						
						JOptionPane.showMessageDialog(LT_Macbook_AirM1.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(LT_Macbook_AirM1.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
			
			
		}
		
	
	public LT_Macbook_AirM1() {
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
					gh.setString(2, "AirM1");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(LT_Macbook_AirM1.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Macbook Air M1");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 28,090,000");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(267, 298, 94, 25);
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='AirM1' and display.id_tb='AirM1' and  camera.id_tb='AirM1' and hdh.id_tb='AirM1' and cpu.id_tb='AirM1' and mem.id_tb='AirM1' and battery.id_tb='AirM1' ;");
		
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
		txt.setText("Laptop Apple MacBook Air M1 2020 thuộc dòng laptop cao cấp sang trọng có cấu hình mạnh mẽ, chinh phục được các tính năng văn phòng lẫn đồ hoạ mà bạn mong muốn, thời lượng pin dài, thiết kế mỏng nhẹ sẽ đáp ứng tốt các nhu cầu làm việc của bạn.\r\n"
				+ "Chip Apple M1 tốc độ xử lý nhanh gấp 3.5 lần thế hệ trước\r\n"
				+ "Chiếc MacBook này được trang bị con chip Apple M1 được sản xuất độc quyền bởi Nhà Táo trên tiến trình 5 nm, 8 lõi bao gồm 4 lõi tiết kiệm điện và 4 lõi hiệu suất cao, mang đến một hiệu năng kinh ngạc, xử lý mọi tác vụ văn phòng một cách mượt mà như Word, Excel, Powerpoint,... thực hiện tốt các nhiệm vụ chỉnh sửa hình ảnh, kết xuất 2D trên các phần mềm Photoshop, AI,... máy còn hỗ trợ tiết kiệm được điện năng cao.\r\n"
				+ "\r\n"
				+ "Đi cùng CPU là Card đồ họa tích hợp 7 nhân GPU có hiệu năng vượt trội sau nhiều bài thử nghiệm hiệu năng đồ họa của benchmark, bạn có thể sử dụng nhiều phần mềm đồ họa chuyên nghiệp, thoả sức sáng tạo nội dung, render video ổn định với chất lượng hình ảnh cao.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - CPU\r\n"
				+ "\r\n"
				+ "Máy được trang bị RAM 8 GB cho khả năng đa nhiệm cao, bạn có thể mở cùng lúc nhiều cửa sổ hoặc ứng dụng để phục vụ cho công việc, giải trí của mình ví dụ như vừa mở Chrome tra cứu thông tin vừa mở Word để làm việc cực kỳ tiện lợi mà không cần lo lắng là máy sẽ bị đơ.\r\n"
				+ "\r\n"
				+ "MacBook sở hữu ổ cứng SSD 256 GB cho tốc độ xử lý nhanh chóng, thao tác cuộn trong Safari cực mượt, đánh thức máy đang trong chế độ ngủ chỉ mất vài giây và đem đến không gian lưu trữ rộng rãi bạn cứ thoải mái lưu lại những bộ phim hay mà không lo nó sẽ chiếm chỗ của các tệp tài liệu công việc.\r\n"
				+ "\r\n"
				+ "aptop Apple MacBook Air M1 2020 (MGN63SA/A)  - SSD\r\n"
				+ "\r\n"
				+ "Bên cạnh sử dụng con chip mới Apple còn ra mắt phiên bản hệ điều hành macOS Big Sur với giao diện hoàn hảo hơn, các chuyển động cuộn, phóng to và chuyển tiếp màn hình mượt mà. Ngoài đổi mới giao diện macOS Big Sur còn mang đến khả năng phản hồi nhanh chóng và kho ứng dụng khổng lồ.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - Hệ điều hành\r\n"
				+ "\r\n"
				+ "Xem thêm: Danh sách ứng dụng chạy được trên Macbook chip Apple M1.\r\n"
				+ "\r\n"
				+ "Thiết kế sang trọng, tinh tế\r\n"
				+ "MacBook Air M1 256GB 2020 không những thừa hưởng thiết kế mỏng nhẹ, hiện đại của các thế hệ trước mà còn học hỏi thêm phong cách hiện đại của các dòng Macbook Pro. Trọng lượng máy chỉ vỏn vẹn 1.29 kg và mỏng của thân máy là 16.1 mm có tính cơ động cao, dễ đem theo xử lý công việc.\r\n"
				+ "\r\n"
				+ "Vỏ máy được thiết kế nguyên khối từ nguyên liệu nhôm tái chế 100% vừa góp phần bảo vệ môi trường vừa cho độ bền cao, chịu va đập tốt bảo vệ các linh kiện bên trong an toàn nếu có xảy ra va chạm mạnh.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - Thiết kế\r\n"
				+ "\r\n"
				+ "Magic Keyboard có hành trình phím 1 mm mang lại trải nghiệm gõ nhạy, thoải mái và yên tĩnh, bàn phím còn được trang bị thêm đèn nền vừa tạo cảm giác sang trọng vừa hỗ trợ bạn gõ phím chính xác hơn trong môi trường thiếu sáng.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - Bàn phím\r\n"
				+ "\r\n"
				+ "Laptop được trang bị 2 cổng kết nối Thunderbolt 3 với tốc độ truyền tải lên đến 40 Gb/s cho tốc độ truyền tải nhanh gấp 2 lần so với thế hệ Thunderbolt 2 trước đây. Bên cạnh Thunderbolt 3 máy còn được trang bị thêm kết nối không dây là Wi-Fi 6 cho tốc độ truyền tải dữ liệu nhanh chóng lên đến 10.000 Mbps cao hơn Wi-Fi 5 chỉ có 7.000 Mbps và Bluetooth v5.0 có tốc độ tối đa là 50 Mbps cho bạn trải nghiệm mượt mà hơn.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - Kết nối\r\n"
				+ "\r\n"
				+ "Apple trang bị cho chiếc Macbook M1 này bảo mật vân tay giúp bạn mở khóa nhanh chóng chỉ với một cái chạm nhẹ. Bên cạnh đó, vân tay của bạn sẽ được tích hợp vào việc xác nhận thông tin khi mua sắm online hay truy cập vào các tài liệu có bảo mật mà không cần phải nhập mật khẩu cực kỳ tiện lợi.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - ID\r\n"
				+ "\r\n"
				+ "Màu sắc chân thực, hình ảnh sắc nét \r\n"
				+ "Laptop sở hữu màn hình Retina 13.3 inch cao cấp cho hình ảnh sắc nét màu sắc tự nhiên. Kết hợp cùng công nghệ True Tone giúp điều chỉnh cân bằng sắc trắng cũng như độ sáng để màu sắc hình ảnh hiển thị chính xác nhất.\r\n"
				+ "\r\n"
				+ "Ngoài ra, góc nhìn của máy cũng được mở rộng hơn nhờ có công nghệ IPS đem lại trải nghiệm nhìn đã mắt, dù bạn nhìn màn hình bằng góc nghiêng.\r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - Màn hình\r\n"
				+ "\r\n"
				+ "MacBook Air M1 được trang bị camera FaceTime HD giúp bạn gọi video cho người thân, bạn bè với chất lượng hiển thị cao. Tích hợp dãy 3 micro giúp truyền tải giọng nói của bạn chính xác hơn. \r\n"
				+ "\r\n"
				+ "Apple Macbook Air M1 (MGN73SA/A) - Camera \r\n"
				+ "\r\n"
				+ "Laptop Apple MacBook Air M1 2020 với hiệu năng mạnh mẽ đáp ứng tốt mọi công việc, thiết kế cực mỏng sẽ là sự lựa chọn tuyệt vời dành cho bạn.");
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
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Macbook_300x200.jpg"));
		lblNewLabel_9.setBounds(139, 91, 300, 200);
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
