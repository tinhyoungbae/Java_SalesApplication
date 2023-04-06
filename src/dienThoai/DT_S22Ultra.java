package dienThoai;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.mysql.jdbc.PreparedStatement;

import hangHoa.donHang_LichSu;
import hangHoa.gioHang;
import hangHoa.hangHoa_All;
import khachHang.khachHang_Login;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DT_S22Ultra extends JFrame {

	private JPanel contentPane;
	private JTextField txtMnHnh;
	private JTextField txtPhnGii;
	private JTextField textField_2;
	private JTextField txtCameraTrc;
	private JTextField txtCameraSau;
	private JTextField txtHiuHnh;
	private JTextField txtChipXL;
	private JTextField txtTcCpu;
	private JTextField txtGpu;
	private JTextField txtRam;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtRom;
	private JLabel lblNewLabel_7;
	private JTextField txtXxxmah;
	private JLabel lblNewLabel_8;
	final public static String id = "S22_Ultra";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DT_S22Ultra frame = new DT_S22Ultra();
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
				new DT_S22Ultra().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='S22_Ultra';");
				
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
						
						JOptionPane.showMessageDialog(DT_S22Ultra.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(DT_S22Ultra.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
			
			
		}
		
	public DT_S22Ultra() {
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
					gh.setString(2, "S22_Ultra");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(DT_S22Ultra.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("SAMSUNG Galaxy S22 ULtra");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 36,990,000");
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='S22_Ultra' and display.id_tb='S22_Ultra' and  camera.id_tb='S22_Ultra' and hdh.id_tb='S22_Ultra' and cpu.id_tb='S22_Ultra' and mem.id_tb='S22_Ultra' and battery.id_tb='S22_Ultra' ;");
		
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
		txt.setText("Samsung Galaxy S22 Ultra 5G 512 GB là một \"siêu phẩm\" với bút S Pen nhanh hơn được tích hợp sẵn, nhiều cải tiến về camera, màn hình sáng hơn và sạc 45 W nhanh hơn.\r\n"
				+ "Những bức ảnh chụp đêm hoàn hảo với Nightography Camera - Mắt Thần Bóng Đêm\r\n"
				+ "Galaxy S22 Ultra trang bị cảm biến điểm ảnh 2.4 um lớn hơn để thu nhiều ánh sáng và dữ liệu hơn, cùng ống kính Super Clear Glass để quay video ban đêm mà không bị lóa. Ngoài ra chúng ta còn có ống kính siêu rộng 12 MP, camera tele 10 MP kép kết hợp để cung cấp khả năng thu phóng quang học 10x và thu phóng không gian 100x.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - Camera\r\n"
				+ "Máy trang bị khả năng chụp ảnh chân dung ban đêm, trong điều kiện thiếu sáng ấn tượng với bộ xử lý hình ảnh AI kết hợp với camera góc rộng 108 MP mang lại bức ảnh ban đêm sáng rõ. Vậy nên S22 Ultra là lựa chọn hoàn hảo để lưu giữ những khoảnh khắc trong các buổi tiệc tối. Ngay cả khi không chọn chế độ chụp đêm, những tấm ảnh được chụp trong điều kiện ánh sáng yếu cũng đều rõ ràng và sáng hơn, đầy đủ chi tiết và không bị nhiễu.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - Chụp ảnh\r\n"
				+ "Không chỉ mạnh về phần chụp ảnh, S22 Ultra còn mang lại khả năng quay video sắc nét lên đến 8K ở tốc độ 24 khung hình/giây, và có thể giữ cho cảnh quay của bạn trông siêu ổn định nhờ khả năng chống rung và công nghệ AI. Giải pháp siêu chụp đêm nhờ vi xử lý 4 nm khử nhiễu hiệu quả mang đến trải nghiệm quay phim giàu chi tiết từ bình minh tới đêm khuya đầy ấn tượng.\r\n"
				+ "\r\n"
				+ "Tích hợp S Pen phản hồi nhanh hơn\r\n"
				+ "Bằng cách giảm độ trễ xuống 70% (từ 9 ms xuống còn khoảng 2.8 ms) và kết hợp với công nghệ AI để dự đoán chuyển động tay nên cảm giác cầm S Pen viết, vẽ trên Galaxy S22 Ultra mượt mà như bút viết trên giấy.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - S Pen\r\n"
				+ "Một số cải tiến đáng chú ý khác của S Pen mà mình đã trải nghiệm đó là chuyển đổi chữ viết tay thành văn bản có độ chính xác cao hơn, cũng như khả năng nhanh chóng lưu ghi chú trong tài liệu và email trên Outlook.\r\n"
				+ "\r\n"
				+ "Thiết kế đậm chất riêng, dễ dàng nổi bật giữa đám đông\r\n"
				+ "Galaxy S22 Ultra nghiêng về phong cách thiết kế đơn giản nhưng đồng thời cũng tuyệt đẹp với các góc cạnh sắc nết, vuông vắn. Đặc biệt là cụm camera không viền, rất độc đáo và khác biệt. Cảm giác cầm nắm S22 Ultra trên tay rất chắc chắn và bền bỉ nhờ máy được gia cố bằng khung nhôm bọc giáp và mặt kính cường lực Gorilla Glass Victus +.\r\n"
				+ "\r\n"
				+ "Một điểm nhấn khác không thể không nhắc đến đó là cả Galaxy S22 Ultra và S Pen đều đạt chuẩn kháng nước, bụi IP68 để đảm bảo cho trải nghiệm của bạn luôn tốt nhất trong mọi hoàn cảnh.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - Thiết kế\r\n"
				+ "Màn hình có độ sáng cao nhất là 1750 nits cùng với tính năng Vision Booster mới - có thể điều chỉnh độ sáng của màn hình một cách nhanh chóng suốt cả ngày giúp bạn sử dụng xuyên suốt ngay cả ở ngoài trời nắng gắt mà không phải điều chỉnh nhiều lần.\r\n"
				+ "\r\n"
				+ "Màn hình 6.8 inch được bo cong nhẹ nhàng nên tăng thêm phần thẩm mỹ mà không dẫn đến tình trạng cấn màn hình. Bên cạnh đó thì trải nghiệm về mặt hình ảnh hiển thị trên S22 Ultra thì thật sự tuyệt với với độ phân giải 2K trên tấm nền Dynamic AMOLED 2X, vuốt chạm cực kì mượt mà nhờ tần số quét 120 Hz.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - Màn hình\r\n"
				+ "Một trong những điện thoại đầu tiên được trang bị bộ vi xử lý Snapdragon 8 Gen 1 của Qualcomm\r\n"
				+ "Phiên bản Galaxy S22 Ultra 5G RAM 8 GB cho cảm giác siêu mượt mà khi mở và đóng ứng dụng và bộ nhớ trong 512 GB cho bạn thoải mái lưu trữ những khung hình, thước phim chất lượng cao. Snapdragon 8 Gen 1 của Qualcomm 4 nm hứa hẹn cho hiệu năng CPU và đồ họa tốt hơn đồng thời mang lại hiệu quả tốt hơn.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - Chơi game\r\n"
				+ "Galaxy S22 Ultra sử dụng giao diện OneUI 4.1 của Samsung chạy trên nền tảng Android 12. Giao diện này trực quan và hữu ích hơn các phiên bản trước, đồng thời có bẩng điều khiển quyền riêng tư mới.\r\n"
				+ "\r\n"
				+ "Pin 5000 mAh cùng sạc 45 W nhanh hơn\r\n"
				+ "Samsung trang bị cho S22 Ultra công nghệ AI cải tiến tối ưu hóa dung lượng pin 5000 mAh (tiêu chuẩn) giúp pin thích ứng với thói quen sử dụng của người dùng. Kết hợp hỗ trợ sạc nhanh tối đa 45 W để nạp đầy năng lượng trong thời gian ngắn hơn.\r\n"
				+ "\r\n"
				+ "Với việc sử dụng đa tác vụ thường ngày từ chơi game, lướt web, mạng xã hội, xem phim,... liên tục thì S22 Ultra có thời gian sử dụng lên đến 9 tiếng 18 phút, và chỉ mất khoảng 1 tiếng 11 phút để nạp đầy 100% pin.*\r\n"
				+ "\r\n"
				+ "Lưu ý: Thời gian sử dụng và thời gian sạc có thể thay đổi tùy theo nhu cầu/tác vụ sử dụng.\r\n"
				+ "\r\n"
				+ "Galaxy S22 Ultra 5G 512GB - Thời gian sử dụng pin\r\n"
				+ "\r\n"
				+ "Bảng test thời gian sử dụng pin của Samsung Galaxy S22 Ultra.Galaxy S22 Ultra 5G 512GB - Thời gian sạc pin\r\n"
				+ "\r\n"
				+ "Bảng đo thời gian sạc pin của Samsung Galaxy S22 Ultra.\r\n"
				+ "\r\n"
				+ "Có thể nói Galaxy S22 Ultra như một phép cộng của dòng Galaxy Note và Galaxy S - kết hợp những gì tốt nhất trong thiết kế của cả hai. Nếu bạn đã là fan của Galaxy Note và chiếc S Pen thì S22 Ultra chính là lựa chọn hoàn hảo dành cho bạn.");
		txt.setBounds(10, 440, 572, 292);
		txt.setLineWrap(true);
		contentPane.add(txt);
		txt.setEditable(false); //Ngăn chặn edit văn bản
		txt.setWrapStyleWord(true); //Gộp dòng văn bản
		
		//table.setModel(new DefaultTableModel(dt, head));
		JScrollPane scrollPane = new JScrollPane(txt);
		scrollPane.setBounds(10, 440, 572, 292);
		contentPane.add(scrollPane);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\s22_200x200.jpg"));
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
