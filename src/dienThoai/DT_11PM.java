package dienThoai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import hangHoa.donHang_LichSu;
import hangHoa.gioHang;
import hangHoa.hangHoa_All;
import hangHoa.order;
import khachHang.khachHang_Login;
import khachHang.khachHang_ThongTin;
import khachHang.khachHang_Update;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class DT_11PM extends JFrame {

	private JPanel contentPane;
	public static String a = "0";
	public static int b = 1;
	public static JLabel dt;
	private JTextField get_id;
	private JTextField get_a;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DT_11PM frame = new DT_11PM();
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
				new DT_11PM().setVisible(true);
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
		
		get_id = new JTextField();
		get_id.setBounds(10, 10, 10, 10);
		contentPane.add(get_id);
		get_id.setColumns(10);
		get_id.setText("aaa");
		
		get_a = new JTextField();
		get_a.setBounds(636, 78, 33, 19);
		contentPane.add(get_a);
		get_a.setColumns(10);
		
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='iPhone14,5';");
				
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
						JOptionPane.showMessageDialog(DT_11PM.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(DT_11PM.this, "Đặt hàng thất bại");
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.BLACK);
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton_1.setBounds(147, 488, 107, 36);
			contentPane.add(btnNewButton_1);
			
			
		}
		

	public DT_11PM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 779);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setTitle("Sản phẩm");
		contentPane.setBorder(null);
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
		btnNewButton.setBounds(829, 20, 85, 40);
		contentPane.add(btnNewButton);
		
		JButton order_1 = new JButton("\u0110\u1EB7t mua");
		order_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order();
			}
		});
		order_1.setBackground(Color.RED);
		order_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		order_1.setBounds(182, 347, 94, 33);
		contentPane.add(order_1);
		
		JButton btnNewButton_2 = new JButton("Thêm");
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
					gh.setString(2, "iPhone14,5");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(DT_11PM.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel dt = new JLabel("iPhone 11 Pro Max");
		dt.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		dt.setBounds(167, 22, 349, 75);
		contentPane.add(dt);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 16,590,000");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(264, 298, 94, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u00F4ng s\u1ED1 k\u1EF9 thu\u1EADt");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(718, 97, 161, 38);
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='iPhone14,5' and display.id_tb='iPhone14,5' and  camera.id_tb='iPhone14,5' and hdh.id_tb='iPhone14,5' and cpu.id_tb='iPhone14,5' and mem.id_tb='iPhone14,5' and battery.id_tb='iPhone14,5' ;");
		
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
		
		JLabel m_h = new JLabel("M\u00E0n h\u00ECnh");
		m_h.setForeground(Color.BLUE);
		m_h.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		m_h.setBounds(595, 138, 74, 20);
		contentPane.add(m_h);
		
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
		
		JLabel lblNewLabel_8 = new JLabel("Chi ti\u1EBFt s\u1EA3n ph\u1EA9m");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(31, 402, 122, 33);
		contentPane.add(lblNewLabel_8);
		
		JTextArea txt = new JTextArea();
		txt.setBackground(new Color(240, 240, 240));
		txt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt.setText("Trong năm 2019 thì chiếc smartphone được nhiều người mong muốn sở hữu trên tay và sử dụng nhất không ai khác chính là iPhone 11 Pro Max 64GB tới từ nhà Apple.\r\n"
				+ "Camera được cải tiến mạnh mẽ\r\n"
				+ "Chắc chắn lý do lớn nhất mà bạn muốn nâng cấp lên iPhone 11 Pro Max chính là cụm camera mới được Apple nâng cấp rất nhiều.\r\n"
				+ "\r\n"
				+ "iPhone 11 Pro Max 64GB | Cụm ba camera sau ấn tượng\r\n"
				+ "\r\n"
				+ "Lần đầu tiên chúng ta sẽ có một chiếc iPhone với 3 camera ở mặt sau và cả 3 camera này đều có độ phân giải là 12 MP.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Giao diện chụp ảnh camera\r\n"
				+ "\r\n"
				+ "Chúng ta sẽ có một camera góc thường, một camera góc rộng và một camera tele đáp ứng đầy đủ nhu cầu chụp ảnh hàng ngày của người dùng.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Ảnh chụp chân dung bằng camera sau\r\n"
				+ "\r\n"
				+ "Ảnh chụp bằng camera sau trên iPhone 11 Pro Max\r\n"
				+ "\r\n"
				+ "Một cải tiến nữa cũng rất đáng chú ý chính là chế độ Night Mode mới sẽ giúp bạn cải thiện rất nhiều chất lượng ảnh chụp đêm trên iPhone.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Ảnh chụp bằng camera sau\r\n"
				+ "\r\n"
				+ "Ảnh chụp bằng camera sau trên iPhone 11 Pro Max\r\n"
				+ "\r\n"
				+ "Tùy thuộc vào điều kiện môi trường bạn chụp mà iPhone sẽ đưa ra những thông số phù hợp để bạn có thể có cho mình được một bức ảnh ưng ý nhất.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Chế độ Night Mode mới\r\n"
				+ "\r\n"
				+ "Chế độ Night Mode mới\r\n"
				+ "\r\n"
				+ "Chế độ chân dung không chỉ tốt hơn trong việc lấy nét vào đối tượng muốn chụp, mà còn hoạt động được ở khoảng cách 'bình thường' nhờ sự trợ giúp của cảm biến độ sâu.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Ảnh chụp bằng chế độ Night Mode\r\n"
				+ "\r\n"
				+ "Ảnh chụp với chế độ Night Mode trên iPhone 11 Pro Max\r\n"
				+ "\r\n"
				+ "So với người anh em iPhone Xs Max thì với việc được tích hợp thêm một camera góc rộng người dùng iPhone giờ đây sẽ có được cho mình những khung hình độc đáo hơn.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Ảnh chụp chế độ thường bằng camera sau\r\n"
				+ "\r\n"
				+ "Ảnh chụp chế độ cơ bản bình thường với camera chính\r\n"
				+ "\r\n"
				+ "Bạn muốn chụp một tòa nhà cao tầng, bạn muốn ghi lại khung cảnh thiên nhiên hùng vĩ mà mình nhìn thấy thì camera góc siêu rộng sẽ làm rất tốt trong những điều kiện này.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Ảnh chụp ngược sáng với HDR\r\n"
				+ "\r\n"
				+ "Camera trước cũng mang lại sự khác biệt\r\n"
				+ "Không chỉ có camera chính mà camera selfie trên iPhone 11 Pro Max cũng được cải thiện rất nhiều.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Trải nghiệm selfie\r\n"
				+ "\r\n"
				+ "Ảnh selfie trên iPhone 11 Pro Max\r\n"
				+ "\r\n"
				+ "Đầu tiên chúng ta có thể kể tới là độ phân giải giờ đây đã được nâng lên thành 12 MP thay vì 7 MP như trên thế hệ trước.\r\n"
				+ "\r\n"
				+ "Tiếp theo chúng ta sẽ có công nghệ quay video độ phân giải 4K ngay trên camera trước một điều mà những chiếc iPhone trước đây chưa thể làm được.\r\n"
				+ "\r\n"
				+ "Ngoài ra bạn cũng có thể dùng camera trước để quay video slow motion (quay chậm) giúp bạn có được những video thú vị và vui vẻ với bạn bè.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Giao diện chụp ảnh chế độ zoom quang học\r\n"
				+ "\r\n"
				+ "Một tính năng mới cũng được Apple tích hợp trên iPhone mới đó chính là khả năng tự động nhận diện để thay đổi góc chụp giúp bạn lấy được nhiều chi tiết hơn.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Ảnh chụp chế độ slofie\r\n"
				+ "\r\n"
				+ "Ví dụ khi bạn để điện thoại ở chế độ chụp dọc thì máy sẽ chụp ở góc bình thường, còn khi bạn xoay điện thoại nằm ngang thì máy tự động sẽ điều chỉnh để bạn có được một góc chụp rộng hơn.\r\n"
				+ "\r\n"
				+ "Xem thêm: Đánh giá chi tiết iPhone 11 Pro Max: Chiếc smartphone đỉnh nhất 2019?\r\n"
				+ "\r\n"
				+ "Hiệu năng \"đè bẹp\" mọi đối thủ\r\n"
				+ "Mỗi năm ra mắt iPhone mới thì Apple lại nâng cấp con chip của mình để máy có thể đạt được một hiệu năng tốt nhất và với iPhone 11 Pro Max năm nay cũng không phải là một ngoại lệ.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Giao diện màn hình chính\r\n"
				+ "\r\n"
				+ "Chiếc iPhone mới này chạy trên con chip Apple A13 Bionic, con chip mạnh mẽ nhất dành cho những chiếc iPhone trong năm 2019 giúp điện thoại chơi game dễ dàng với mọi thể loại game nặng nhẹ ở mức cấu hình max setting.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Điểm hiệu năng Antutu Benchmark\r\n"
				+ "\r\n"
				+ "Bên cạnh đó bạn vẫn sẽ có cho mình 4 GB RAM và 64 GB bộ nhớ trong thoải mái cho bạn cài đặt game và ứng dụng.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Trải nghiệm chơi game\r\n"
				+ "\r\n"
				+ "Tất nhiên máy cũng sẽ chạy trên phiên bản iOS 13 mới nhất với nhiều cải tiến giúp tối ưu hóa hiệu năng đem lại trải nghiệm mượt mà hơn cho người dùng.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Giao diện iOS 13 mới\r\n"
				+ "\r\n"
				+ "Những tính năng trên iOS 13 mới\r\n"
				+ "\r\n"
				+ "Mọi game và ứng dụng trên iPhone 11 Pro Max hoạt động rất mượt mà và ổn định, bạn hầu như sẽ không thấy bất cứ độ trễ nào trong quá trình sử dụng.\r\n"
				+ "\r\n"
				+ "Năm nay Face ID cũng được cải thiện để có thể nhận dạng ở nhiều góc khác nhau mang lại trải nghiệm mở khóa tốt hơn.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Công nghệ Haptic Engine mới \r\n"
				+ "\r\n"
				+ "Công nghệ Haptic Engine mới sẽ dựa trên thời gian ấn và giữ icon để hiện lên những menu chức năng khác nhau thay vì dựa vào lực ấn như 3D Touch.\r\n"
				+ "\r\n"
				+ "Dung lượng pin 'trâu'\r\n"
				+ "Apple đã tuyên bố rằng iPhone 11 Pro Max có thời lượng pin lâu hơn 5 giờ so với iPhone Xs Max.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Thời lượng pin tốt\r\n"
				+ "\r\n"
				+ "Và nếu bạn chưa biết thì iPhone 11 Pro Max là chiếc iPhone có dung lượng pin lớn nhất từ trước tới nay mà Apple từng sản xuất.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Thời lượng sử dụng pin trên iOS 13\r\n"
				+ "\r\n"
				+ "Bạn có thể sử dụng máy thoải mái từ sáng tới tối mà không cần phải bận tâm về việc nạp năng lượng cho máy giữa chừng.\r\n"
				+ "\r\n"
				+ "Tin vui là năm nay Apple đã trang bị củ sạc nhanh 18W đi kèm bên trong hộp của chiếc iPhone mới này.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Cổng sạc trên máy\r\n"
				+ "\r\n"
				+ "Tất nhiên bạn vẫn sẽ có công nghệ sạc không dây và thậm chí là sạc nhanh không dây để bạn có thể sử dụng hàng ngày.\r\n"
				+ "\r\n"
				+ "Những thay đổi về thiết kế và màn hình\r\n"
				+ "Để phân biệt iPhone 11 Pro Max và iPhone Xs Max thì bạn bắt buộc phải nhìn vào mặt lưng nơi sẽ có cụm camera to bản hơn cũng như phần kính được hoàn thiện kính mờ thay vì bóng như trên thế trước.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Thiết kế mặt lưng nổi bật cụm camera sau\r\n"
				+ "\r\n"
				+ "Thiết kế mới này của Apple giúp hạn chế mồ hôi và bụi bẩn bám lại sau quá trình sử dụng, giúp thiết bị luôn luôn có được sự sang trọng và bóng bẩy.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Khay sim\r\n"
				+ "\r\n"
				+ "Ngoài ra logo Apple quen thuộc năm nay đã được đặt ở chính giữa mặt lưng thay vì đặt lệch về phía cạnh trên như những chiếc iPhone trước đó.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Thiết kế viền màn hình\r\n"
				+ "\r\n"
				+ "Một trong những điểm quan trọng được nâng cấp trong màn hình của iPhone mới đó là khả năng phát nội dung Dolby Vision.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Trải nghiệm xem phim\r\n"
				+ "\r\n"
				+ "Nhờ đó, trải nghiệm xem phim sẽ cho hình ảnh chi tiết hơn và mang đến những thước phim điện ảnh hơn nhiều.\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Màn hình\r\n"
				+ "\r\n"
				+ "iPhone thường đạt được độ sáng 800 nits, nhưng với Dolby Vision mọi thứ thậm chí còn ấn tượng hơn (lên tới 1200 nits, theo Apple).\r\n"
				+ "\r\n"
				+ "Điện thoại iPhone 11 Pro Max 64GB | Khả năng hiển thị màn hình\r\n"
				+ "\r\n"
				+ "Với những nâng cấp khá nhiều đặc biệt là về mặt camera và hiệu năng thì iPhone 11 Pro Max năm nay hứa hẹn sẽ lại đem về thành công lớn cho Apple.");
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
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\iphone_200x200.jpg"));
		lblNewLabel_9.setBounds(200, 100, 200, 200);
		contentPane.add(lblNewLabel_9);
		
		JButton btnGiHng = new JButton("Giỏ hàng");
		btnGiHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new gioHang().setVisible(true);
			}
		});
		btnGiHng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGiHng.setBackground(Color.RED);
		btnGiHng.setBounds(679, 20, 94, 40);
		contentPane.add(btnGiHng);
		
		JPanel panel = new JPanel();
		panel.setBounds(679, 145, 244, 556);
		contentPane.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		
	
		
	
	}
}
