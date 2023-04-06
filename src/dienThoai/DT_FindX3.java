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

import hangHoa.donHang_LichSu;
import hangHoa.gioHang;
import hangHoa.hangHoa_All;
import khachHang.khachHang_Login;

public class DT_FindX3 extends JFrame {

	private JPanel contentPane;
	public static JLabel oppo;
	final public static String id="find_x3";
	private JTextField getid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DT_FindX3 frame = new DT_FindX3();
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
		setTitle("Sản phẩm");
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
				new DT_FindX3().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='find_x3';");
				
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
						
						JOptionPane.showMessageDialog(DT_FindX3.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(DT_FindX3.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
			
			
		}
		

	
	public DT_FindX3() {
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
					gh.setString(2, "find_x3");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(DT_FindX3.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		final JLabel oppo = new JLabel("OPPO Find X3");
		oppo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		oppo.setBounds(167, 22, 349, 75);
		contentPane.add(oppo);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 18,790,000");
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='find_x3' and display.id_tb='find_x3' and  camera.id_tb='find_x3' and hdh.id_tb='find_x3' and cpu.id_tb='find_x3' and mem.id_tb='find_x3' and battery.id_tb='find_x3' ;");
		
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
		txt.setText("OPPO đã làm khuynh đảo thị trường smartphone khi cho ra đời chiếc điện thoại OPPO Find X3 Pro 5G. Đây là một sản phẩm có thiết kế độc đáo, sở hữu cụm camera khủng, cấu hình thuộc top đầu trong thế giới Android.\r\n"
				+ "Kết quả của sự sáng tạo không ngừng\r\n"
				+ "Nếu nhìn qua mặt lưng của OPPO Find X3 Pro 5G thì bạn sẽ bất ngờ ngay với cụm camera sau, được tạo hình giống như miệng núi lửa, thiết kế này đã ngốn rất nhiều thời gian và công sức của nhà sản xuất để mang đến cho người dùng sự khác biệt mới lạ.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Thiết kế cụm camera tạo hình giống như miệng núi lửa độc đáo\r\n"
				+ "\r\n"
				+ "OPPO trang bị cho Find X3 Pro 5G cả hai mặt bằng kính cường lực giúp mang lại sự bền bỉ và sang trọng, khung viền cấu tạo từ hợp kim cao cấp và được gia công tỉ mỉ làm chiếc điện thoại trở nên mỏng, nhẹ và đẹp mắt hơn rất nhiều.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Thiết kế cạnh viền\r\n"
				+ "\r\n"
				+ "Thiết kế màn hình tràn viền cũng làm nổi bật mặt trước của Find X3 Pro 5G, chỉ bằng những quan sát đầu tiên ta đã có thể thấy sự đẳng cấp và sang trọng của chiếc điện thoại này.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Thiết kế màn hình đục lỗ\r\n"
				+ "\r\n"
				+ "Mạnh mẽ hàng đầu với Snapdragon 888\r\n"
				+ "OPPO Find X3 Pro 5G mang hiệu năng hàng đầu trong thế giới điện thoại Android khi sở hữu con chip Snapdragon 888 8 nhân mới nhất của Qualcomm (05/2021) được sản xuất trên tiến trình 5 nm mang lại tốc độ xử lý nhanh hơn, AI thông minh hơn và tiết kiệm năng lượng hơn so với thế hệ trước. \r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Sở hữu con chip Snapdragon 888 8 nhân mới nhất của Qualcomm\r\n"
				+ "\r\n"
				+ "Snapdragon 888 có xung nhịp tối đa lên đến 2.84 GHz, đi kèm 12 GB RAM cho máy hoạt động mượt mà, đa nhiệm không giật lag để người dùng cảm nhận trọn vẹn từng khung giờ giải trí cao cấp.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Khay sim\r\n"
				+ "\r\n"
				+ "Bên cạnh đó, Find X3 Pro 5G cung cấp đến người dùng dung lượng bộ nhớ trong 256 GB, mang lại không gian lớn nhằm thỏa mãn nhu cầu lưu trữ hình ảnh, thông tin và ứng dụng yêu thích một cách thả ga.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Kết nối 5G mang đến thế giới giải trí mượt mà\r\n"
				+ "\r\n"
				+ "Ngoài cung cấp một hiệu năng cực kỳ mạnh mẽ, Snapdragon 888 còn sử dụng modem 5G tích hợp giúp giảm diện tích cho máy mỏng và nhẹ hơn. Kết nối 5G mang đến thế giới giải trí mượt mà, đa dạng trải nghiệm đỉnh cao cho người dùng. Hãy cùng tận hưởng những giây phút sống động trên những tựa game đồ họa cao và phim chất lượng mà không phải chờ đợi.\r\n"
				+ "\r\n"
				+ "Công nghệ màn hình AMOLED\r\n"
				+ "OPPO Find X3 Pro 5G sử dụng màn hình AMOLED với độ phủ 100% gam màu P3 chuẩn điện ảnh, sự đa dạng sắc màu đem đến những hình ảnh sống động, rực rỡ, khả năng hiển thị sắc nét.\r\n"
				+ "\r\n"
				+ "Màn hình của máy có độ quang phổ rộng gồm 1.07 tỷ màu, sở hữu độ sâu màu 10 bit giúp bạn chụp, lưu giữ và trải nghiệm thị giác với sản phẩm một cách tuyệt vời nhất.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Sử dụng màn hình AMOLED với gam màu rộng, kích thước khá lớn với 6.7 inch\r\n"
				+ "\r\n"
				+ "Màn hình có kích thước khá lớn với 6.7 inch, tần số quét 120 Hz và tốc độ lấy mẫu cảm ứng là 240 Hz cho mọi thao tác lướt tay của bạn trên máy uyển chuyển và nhẹ nhàng.\r\n"
				+ "\r\n"
				+ "Máy có độ sáng tiêu chuẩn là 500 nits, ngoài ra độ sáng được đo lường khi mở sáng dần có thể lên đến 800 nits, hơn nữa độ sáng được đo lường khi chỉ mở sáng một phẩn có thể lên đến 1300 nits cho khả năng hiển thị tốt nội dung dù ở môi trường ánh sáng phức tạp hoặc nội dung HDR.\r\n"
				+ "\r\n"
				+ "Máy ảnh xuất sắc từ ngoài vào trong\r\n"
				+ "OPPO Find X3 Pro 5G được ưu ái bởi dàn camera và hiệu năng khủng, trang bị camera hiển vi cho khả năng chụp gần một chi tiết đến bất ngờ, cả những chi tiết mắt thường khó nhìn thấy. Sở hữu camera chính độ phân giải 50 MP, camera góc rộng 50 MP, camera tele 13 MP và cuối cùng là 3 MP cho camera macro.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Sở hữu dàn camera và hiệu năng khủng, cho ra đời những bức ảnh rực rỡ và lung linh nhất\r\n"
				+ "\r\n"
				+ "Sản phẩm tập trung khá nhiều vào phần hiệu năng máy ảnh, tính năng Al camera được nâng cấp cho phép camera của Find X3 Pro 5G tự động xác định và cân chỉnh tông màu phù hợp với tùng không gian riêng hứa hẹn sẽ cho ra đời những bức ảnh rực rỡ và lung linh nhất.\r\n"
				+ "\r\n"
				+ "Chế độ chụp cảnh đêm siêu đẹp đã có mặt tại Find X3 Pro 5G hỗ trợ thêm ánh sáng và bắt mọi khung cảnh một cách rõ ràng sống động bất kể không gian của đêm tối. Camera siêu cận đưa người dùng đến khám phá một thế giới chi tiết hơn của những cảnh đẹp lộng lẫy đầy đắm chìm.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Cụm 4 camera sau với nhiều tính năng chỉnh sửa ảnh tự động\r\n"
				+ "\r\n"
				+ "Bật tung sáng tạo của bạn bằng các thước phim ổn định mượt mà với tính năng chống rung OIS, giờ đây người dùng có thể thỏa sức quay video chất lượng cao chuyên nghiệp và tràn đầy thú vị ngay trên smartphone.\r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Ảnh chụp từ camera trước\r\n"
				+ "\r\n"
				+ "Camera selfie có độ phân giải 32 MP cho khả năng chụp ảnh rõ ràng và sắc nét. Hỗ trợ các tính năng làm đẹp và quay phim chất lượng. Bạn chỉ cần tạo kiểu, còn lại bạn hãy để Find X3 Pro 5G chăm chút cho từng đường nét của mình. \r\n"
				+ "\r\n"
				+ "Trang bị viên pin thông minh \r\n"
				+ "OPPO Find X3 Pro 5G sử dụng viên pin đi kèm nhiều chức năng hỗ trợ để có được hiệu suất tốt nhất đến người dùng. Dung lượng pin 4500 mAh khá ổn trong thời điểm hiện tại, cung cấp năng lượng phục vụ nhu cầu người dùng thoải mái cả ngày dài. \r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Dung lượng pin 4500 mAh\r\n"
				+ "\r\n"
				+ "Find X3 Pro 5G hỗ trợ sạc nhanh công suất đến 65 W, cho khả năng sạc được 40% chỉ trong vòng 10 phút. Củ sạc nhanh khiến biết bao khách hàng yêu thích sự giải trí, với một viên pin chất lượng kết hợp với một hiệu năng xuất sắc. \r\n"
				+ "\r\n"
				+ "OPPO Find X3 Pro 5G | Hỗ trợ sạc nhanh công suất đến 65 W\r\n"
				+ "\r\n"
				+ "OPPO lần này đã cho ra mắt một sản phẩm cao cấp cả về kiểu dáng ấn tượng lẫn hiệu năng tuyệt vời. OPPO Find X3 Pro 5G hứa hẹn đưa tên tuổi OPPO đến nhiều người dùng với thiết kế độc đáo, đậm chất riêng và chất lượng phần mềm mạnh mẽ.");
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
		
		JLabel oppo1 = new JLabel("New label");
		oppo1.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\oppo_200x200.jpg"));
		oppo1.setBounds(199, 99, 200, 200);
		contentPane.add(oppo1);
		
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
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(679, 145, 244, 556);
		contentPane.add(panel1);
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setLayout(null);
		
		setTitle("Sản phẩm");
	}

}
