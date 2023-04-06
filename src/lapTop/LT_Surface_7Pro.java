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

import javax.swing.ImageIcon;

public class LT_Surface_7Pro extends JFrame {

	private JPanel contentPane;

	
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
				new LT_Surface_7Pro().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='7Pro';");
				
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
						
						JOptionPane.showMessageDialog(LT_Surface_7Pro.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(LT_Surface_7Pro.this, "Đặt hàng thất bại");
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LT_Surface_7Pro frame = new LT_Surface_7Pro();
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
	public LT_Surface_7Pro() {
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
					gh.setString(2, "7Pro");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(LT_Surface_7Pro.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Surface 7 Pro");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 21,590,000");
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='7Pro' and display.id_tb='7Pro' and  camera.id_tb='7Pro' and hdh.id_tb='7Pro' and cpu.id_tb='7Pro' and mem.id_tb='7Pro' and battery.id_tb='7Pro' ;");
		
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
		txt.setText("Surface Pro 7 | Core i5 / RAM 8GB / SSD 128GB - Cấu hình được mua nhiều nhất năm\r\n"
				+ "Surface Pro 7 thế hệ Surface mới nhất của Microsoft mới cho ra mắt gần đây. Vẫn giống như những thế hệ trước chiếc máy tính bảng này được trang bị những thiết bị, cấu hình xử tốt nhất. Và từ khi cho ra mắt trên thị trường thì Surface Pro 7 Core i5 RAM 8GB SSD 128GB được đánh giá là chiếc máy được người dùng yêu thích và lựa chọn khá nhiều nhờ sự đẳng cấp, sáng tạo và sự tiện lợi mà thiết bị này mang lại.\r\n"
				+ "\r\n"
				+ "Vậy chiếc máy tính 2 trong 1 này có những đặc điểm gì nổi bật và nó đẳng cấp, sáng tạo như thế nào? Hãy cùng theo dõi bài viết dưới đây của Surface Pro để có thêm những thông tin chi tiết nhất về chiếc máy thông minh này nhé!\r\n"
				+ "\r\n"
				+ "Thiết kế ngoại hình sang trọng\r\n"
				+ "Surface Pro 7 vẫn sử dụng thiết kế vuông vắn, nam tính như những người đàn anh tiền nhiệm trước đó. Vẫn là thiết kế “kim tự tháp” - khi lật úp xuống thì phần màn hình sẽ to hơn và vát dần phần mặt lưng sẽ nhỏ hơn. Thiết bị được hoàn thiện bằng vật liệu hợp kim nhôm và magie - vật liệu này không chỉ mang đến một trọng lượng siêu nhẹ mà còn giúp việc cầm nắm chắc tay hơn rất nhiều.\r\n"
				+ "\r\n"
				+ "Theo đánh giá là thiết bị vẫn mang thiết kế cũ nhưng nó vẫn đem đến một số thay đổi như phần chân đế đa năng giúp máy trở nên linh hoạt hơn và sử dụng được nhiều chế độ khác nhau hơn. Sự thay đổi nữa là phần bezel được thiết kế gọn gàng hơn giúp thiết bị trở nên thanh thoát hơn rất nhiều so với thế hệ trước.\r\n"
				+ "\r\n"
				+ "Màn hình độ phân giải cực chất\r\n"
				+ "Surface Pro 7 được trang bị màn hình được đánh giá là không có đối thủ về chất lượng hiển thị mang đến cho người dùng những trải nghiệm thú vị và tuyệt vời nhất về hình ảnh. Thiết bị sở hữu màn hình 12.3 inch độ phân giải 3K, công nghệ PixelSense thế hệ thứ 2 giúp máy hiển thị chất lượng không thua gì những chiếc màn hình tivi chất lượng cao mang đến hình ảnh chân thực nhất, rõ nét nhất với màu sắc hài hòa nhất.\r\n"
				+ "\r\n"
				+ "Không chỉ thế công nghệ PixelSense mà Surface Pro 7 core i5 sở hữu còn giúp cho tấm nền IPS có màu đen sâu hơn như màn hình Amoled nhưng vẫn giữ được màu sắc trung thực và trong trẻo nhất.\r\n"
				+ "\r\n"
				+ "Nâng cấp cổng kết nối\r\n"
				+ "Surface Pro 7 thế hệ mới được trang bị công nghệ Dual far-field Studio Mics. Công nghệ này giúp ích khá nhiều cho giới doanh nghiệp trong các cuộc họp qua Skype. Ngoài ra ở thiết bị cũng đã bỏ đi cổng Mini DisplayPort - đây là mong ước của rất nhiều fan hâm mộ Surface. \r\n"
				+ "\r\n"
				+ "Thay vào đó thì nhà sản xuất đã trang bị thêm cho thiết bị cổng USB Type-C được xem là cổng kết nối mơ ước - người dùng có thể sở hữu cổng kết nối này để làm cổng sạc phụ, liên kết với một số dòng điện thoại hay thực hiện các thao tác truyền tải dữ liệu với tốc độ tối đa. \r\n"
				+ "\r\n"
				+ "Bên cạnh những công nghệ mới thì thiết bị này vẫn giữ lại cổng USb 3.1 và cổng  Surface Connect - ngoài chức năng sạc, cổng Surface Connect cũng giúp Surface Pro 7 ssd 128gb kết nối với một vài thiết bị ngoại vi.\r\n"
				+ "\r\n"
				+ "Phụ kiện thông minh, hiện đại \r\n"
				+ "Surface Pro 7 được trang bị bàn phím Type Cover đời mới cung cấp cảm giác di chuyển sâu hơn và đem đến cho người dùng cảm giác thoải mái hơn khi sử dụng. Bên cạnh đó thì Type Cover cũng vẫn có thể tháo rời, được bán riêng và được trang bị những màu sắc như xám, xanh nhạt, đỏ và đen để người dùng thoải mái lựa chọn.\r\n"
				+ "\r\n"
				+ "Với mỗi thế hệ Surface thì phụ kiện đi kèm không bao giờ có thể bỏ qua đó chính là Surface Pen - vừa là phụ kiện vừa mang lại tính thẩm mỹ và sự sáng tạo cho thiết bị. Sử dụng Surface Pen sẽ giúp việc ghi chú, phác thảo, thuyết trình,... của người dùng được dễ dàng hơn dưới ngòi bút tinh tế để mang đến cho người dùng những trải nghiệm tuyệt vời nhất như đang viết trên giấy.\r\n"
				+ "\r\n"
				+ "Cấu hình mạnh mẽ và ổn định\r\n"
				+ "Có thể nói cấu hình của Surface Pro 7 ram 8gb thuộc vào top những chiếc máy tính đáng sở hữu của năm 2019. Đó là Core i5-1035G4 Processor, vi xử lý thế hệ thứ 10, so với con Chip i5-8350U của Surface Pro 6 thì tốc độ hoạt động sẽ nhanh hơn một chút xíu nhưng cũng đủ để giúp người dùng có những trải nghiệm tốt nhất khi sử dụng.\r\n"
				+ "\r\n"
				+ "Surface Pro 7 còn được tích hợp đồ họa Intel Iris Plus mang đến cho người dùng những trải nghiệm thú vị và tuyệt vời nhất về những hình ảnh, video mà thiết bị xuất ra. \r\n"
				+ "\r\n"
				+ "Đối với Microsoft thì mục đích sử dụng làm việc là điều mà hãng hướng đến cho tất cả những chiếc Surface của mình và Surface Pro cũng thế. Và cũng giống như thiết bị tiền nhiệm trước đó thì thiết bị được tối ưu mọi thứ để dành cho công việc, từ sự mỏng nhẹ linh hoạt đến hệ điều hành mạnh mẽ Windows 10 giúp việc sử dụng Office một cách hiệu quả nhất.\r\n"
				+ "\r\n"
				+ "Ngoài ra nếu bạn để ý đến những review về các sản phẩm đời trước của Surface thì chúng ta sẽ hiểu được các thiết bị có Surface tốt như thế nào. Hiệu năng mạnh mẽ và khủng chỉ là một phần mà sự ổn định trong quá trình sử dụng mới chính là điểm mạnh nhất của các dòng máy 2 trong 1. Chính vì lý do này mà những chiếc Surface của Microsoft luôn luôn đắt giá.\r\n"
				+ "\r\n"
				+ "Surface Pro 7 có thời gian sử dụng pin được cải thiện đáng kể lên đến 10.5 giờ đồng hồ sử dụng cho một lần sạc. Đây là thời lượng pin thực tế và nó lớn hơn so với Surface Pro 6 chỉ đạt được từ 8-9 giờ đồng hồ. Thiết bị còn được trang bị kèm theo công nghệ sạc pin nhanh nên chỉ trong một giờ đồng hồ là máy đã có thể sạc được pin lên đến 80% và giữ được mức ổn định pin cho thiết bị.");
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
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Surface_300x200.jpg"));
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
