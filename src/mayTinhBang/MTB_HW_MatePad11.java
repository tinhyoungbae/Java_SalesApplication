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

public class MTB_HW_MatePad11 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTB_HW_MatePad11 frame = new MTB_HW_MatePad11();
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
				new MTB_HW_MatePad11().setVisible(true);
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
				ResultSet detail = a.executeQuery("select ten_tb from thietbi where id_tb='MatePad11';");
				
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
						
						JOptionPane.showMessageDialog(MTB_HW_MatePad11.this, "Đặt hàng thành công");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(MTB_HW_MatePad11.this, "Đặt hàng thất bại");
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
	public MTB_HW_MatePad11() {
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
					gh.setString(2, "MatePad11");
					gh.setString(3, "1");
					gh.executeUpdate();
					JOptionPane.showMessageDialog(MTB_HW_MatePad11.this, "Thêm thành công");
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Huawei MatePad 11");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 22, 349, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1: 13,990,000");
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
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb from display, camera, hdh, cpu, mem, battery, thietbi where thietbi.id_tb='MatePad11' and display.id_tb='MatePad11' and  camera.id_tb='MatePad11' and hdh.id_tb='MatePad11' and cpu.id_tb='MatePad11' and mem.id_tb='MatePad11' and battery.id_tb='MatePad11' ;");
		
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
		txt.setText("MatePad 11 - chiếc máy tính bảng đến từ nhà Huawei với lối thiết kế tối giản nhưng vẫn toát lên vẻ sang trọng, sở hữu trong mình cấu hình mạnh mẽ, màn hình lớn cùng một viên pin trâu có thể đáp ứng được hầu hết các tác vụ làm việc, học tập hay giải trí. \r\n"
				+ "Thiết kế tối giản, màu sắc thanh lịch\r\n"
				+ "MatePad 11 mang cho mình điểm ấn tượng đầu tiên là về trọng lượng vì máy chỉ mỏng khoảng 7.25 mm và trọng lượng 485 gam nên khi cầm trên tay, nó mang lại một cảm giác thoải mái, không quá nặng. Đây là một con số cực kỳ lý tưởng cho một chiếc máy tính bảng để mình có thể mang nó theo bất kì đâu một cách dễ dàng.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Thiết kế tối giản, dễ cầm nắm\r\n"
				+ "\r\n"
				+ "MatePad 11 vẫn mang lối thiết kế cổ điển phủ một lớp màu xám, nó thu hút mọi người bởi kiểu dáng mỏng, các góc cạnh được bo tròn đều nhau giúp cho tổng thể hài hòa hơn, tạo cảm giác mềm mại, nhẹ nhàng và sang trọng.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Thiết kế cổ điển, sang trọng\r\n"
				+ "\r\n"
				+ "Máy tính bảng không sử dụng jack tai nghe 3.5 mm, mà nó tích hợp chung với khe cắm sạc Type-C với nhau được đặt ở dưới thân máy, còn các phím nguồn và tăng giảm âm lượng thì đặt ở 2 bên cạnh viền máy như các chiếc máy khác.\r\n"
				+ "\r\n"
				+ "Màn hình IPS LCD cho chất lượng hiển thị tốt\r\n"
				+ "MatePad 11 sở hữu màn hình 10.9 inch tỷ lệ 16:9 có độ phân giải là 2K, sử dụng tấm nền IPS LCD, hỗ trợ công nghệ HDR. MatePad có xu hướng hơi đẩy tone màu lên một chút, mang lại cảm giác màu sắc tươi và nịnh mắt hơn. Mình nghĩ chiếc máy này sẽ rất phù hợp cho các bạn với nhu cầu là giải trí, xem phim.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Màn hình IPS LCD sắc nét\r\n"
				+ "\r\n"
				+ "Điểm mạnh trên chiếc Matepad 11 là nó được trang bị tần số quét 120 Hz tạo nên trải nghiệm cực kỳ mượt mà trong các thao tác vuốt chạm, các hình ảnh hiển thị khi chơi game giải trí cũng sướng hơn rất là nhiều. Khi chơi các tựa game tốc độ cao, nó giúp hạn chế được tình trạng xé màn hình.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Tần số 120 Hz cho trải nghiệm mượt mà\r\n"
				+ "\r\n"
				+ "Đồng thời, đi kèm máy là chiếc bút cảm ứng, sẽ rất là phù hợp với những bạn đam mê hội họa, theo ngành thiết kế hoặc là chỉ muốn ghi chú thông tin, phác thảo ý tưởng, phục vụ tốt khi mà các bạn muốn vẽ vời, đối với mình thì có một chiếc bút như này sẽ rất là tiện.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Bút cảm ứng đi kèm tiện lợi\r\n"
				+ "\r\n"
				+ "Còn nói về loa thì em này có tổng cộng là 4 loa, âm thanh được tinh chỉnh bởi Harman Kardon thực sự mang lại chất lượng khá tốt. Các dải âm thanh tách bạch, bass nằm ở mức tốt và khi các bạn bật ở max âm lượng thì hiện tượng vỡ âm thanh cũng không bị xảy ra. Nhìn chung, con này để mà xem phim thì phải nói quá tuyệt vời.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Âm thanh được tinh chỉnh bởi Harman Kardon\r\n"
				+ "\r\n"
				+ "Hiệu năng mạnh mẽ đến từ chip nhà Snapdragon\r\n"
				+ "Matepad 11 trang bị con chip Snapdragon 865, để biết rõ về hiệu năng hơn thì mình có kiểm tra qua Geekbench, thì thấy được các điểm số mang lại rất là cao với điểm đơn nhân là 918 còn đa nhân 3307, chứng tỏ rằng là đây là một mức cấu hình được coi là ổn áp trong thời điểm hiện nay (2021).\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Hiệu năng mạnh mẽ đến từ chip Snapdragon 865\r\n"
				+ "\r\n"
				+ "Bộ nhớ RAM 6 GB có khả năng đa nhiệm thoải mái, bộ nhớ trong 128 GB khá lớn để mình lưu trữ được nhiều bức ảnh, video, người dùng còn có thể mở rộng thêm dung lượng thông qua thẻ nhớ MicroSD để có thể chứa cả một kho game cho việc giải trí bất tận.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - RAM 6 GB, ROM 128 GB \r\n"
				+ "\r\n"
				+ "Cá nhân mình cũng đã có trải nghiệm qua thử với tựa game PUBG Mobile và Liên quân thì nó mang lại mức FPS khá là cao tầm khoảng 59 - 60fps, về nhiệt độ mặt trước mặt sau thì sau khi mình chơi được khoảng 15 phút thì máy có nóng lên nhưng không quá nhiều, vẫn đủ cho các bạn có thể sử dụng, cầm nắm thoải mái.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Kiểm tra qua thử với tựa game Pubg Mobile\r\n"
				+ "\r\n"
				+ "Còn đối với loại nhu cầu học tập online hay các công việc văn phòng, sử dụng các phần mềm Office thì đây là một chiếc máy tính bảng cực kỳ phù hợp bởi vì nó đáp ứng đầy đủ. Tuy nhiên nếu đáp ứng về các công việc chuyên ngành cần những phần mềm đặc thù như là kiến trúc, xây dựng, IT,... thì máy tính bảng này sẽ không phù hợp cho lắm.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Đáp ứng nhu cầu học tập - văn phòng\r\n"
				+ "\r\n"
				+ "Nhưng mà đối với những bạn theo những ngành như là Marketing, kinh doanh, thiết kế hoặc là content creator như mình thì mọi người hoàn toàn có thể cân nhắc một chiếc máy tính bảng như thế này.\r\n"
				+ "\r\n"
				+ "Đáp ứng tác vụ tốt hơn nhờ hệ điều hành HarmonyOS 2.0\r\n"
				+ "Huawei MatePad 11 được chạy trên HarmonyOS 2.0 và có điểm đặc biệt mà mình thấy nó khá thú vị đó là nếu như các bạn sử dụng hệ sinh thái của Huawei như là Laptop hoặc là smartphone thì chúng ta có thể đồng bộ từ A -> Z. Thật vậy khi dùng chung một hệ sinh thái thì mình thấy rằng tính năng phối hợp đa màn hình của nó rất là tiện lợi khi mà chúng ta có thể chuyển qua chuyển lại giữa các thiết bị một cách nhanh chóng.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Chia sẻ màn hình nhiều thiết bị\r\n"
				+ "\r\n"
				+ "Bạn có thể biến một chiếc điện thoại thành màn hình phụ thứ 2 hoặc nếu như các bạn có màn hình Huawei Mate View thì có thể sử dụng nó để trình chiếu lên với một không gian rộng hơn rất là nhiều. \r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Chia sẻ màn hình với điện thoại\r\n"
				+ "\r\n"
				+ "Tuy nhiên có một điểm trừ nhỏ đó là kho ứng dụng vẫn chưa được hỗ trợ nhiều, sẽ có một vài app sẽ ko được đưa lên App Gallery và các bạn sẽ phải tải nó thông qua các file apk cho nên điều này sẽ hơi bất tiện một chút.\r\n"
				+ "\r\n"
				+ "Đáp ứng tốt nhu cầu chụp ảnh cơ bản\r\n"
				+ "Vì là một chiếc máy tính bảng nên có chút đáng tiếc là Matepad 11 có vẻ không được chăm chút nhiều về phần camera, nhưng nó vẫn được trang bị camera sau có độ phân giải 13 MP hỗ trợ công nghệ lấy nét tự động, chạm lấy nét cho bạn tự điều chỉnh được vùng nét theo ý muốn của riêng mình.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Camera sau 13 MP đáp ứng nhu cầu chụp ảnh cơ bản\r\n"
				+ "\r\n"
				+ "Còn về máy ảnh trước có cảm biến 8 MP, chất lượng ổn, mang đến những tấm ảnh khá chi tiết, đi kèm đó là tính năng hẹn giờ chụp, bạn có thể thoải mái tạo dáng mà không nhất thiết phải cầm máy, tránh tình trạng rung tay làm nhòe ảnh.\r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Camera trước 8 MP hỗ trợ quay video FullHD\r\n"
				+ "\r\n"
				+ "Ngoài ra, máy còn hỗ trợ quay video Full HD tuy tốn nhiều dung lượng hơn nhưng bù lại bạn có được một video chất lượng rất cao, bên cạnh đó bạn có thể lưu trữ và chỉnh sửa lại video khi cần, hứa hẹn sẽ mang lại những thước phim sắc nét, cao cấp hơn.\r\n"
				+ "\r\n"
				+ "Viên pin lớn, sử dụng cả ngày dài\r\n"
				+ "Cuối cùng thứ mà mình thích ở những chiếc máy tính bảng này đó là về thời lượng sử dụng. Với viên pin 7250 mAh thì MatePad 11 có khả năng sử dụng từ 10 - 12h mà ko cần phải lo sạc, thoải mái giải trí, tha hồ lướt web hay thỏa thích xem phim, gọi điện không bị gián đoạn, phải nói là cực kỳ trâu so với một chiếc laptop cùng phân khúc giá. \r\n"
				+ "\r\n"
				+ "Máy tính bảng Huawei MatePad 11 - Viên pin lớn, sử dụng cả ngày\r\n"
				+ "\r\n"
				+ "Không chỉ ấn tượng về lượng pin khủng, mà máy còn có khả năng sạc nhanh tối đa 18 W rút ngắn thời gian chờ đáng kể, tuy nhiên rất tiếc rằng sạc kèm theo máy chỉ 10 W.\r\n"
				+ "\r\n"
				+ "Tóm lại, với màn hình lớn, cấu hình mạnh mẽ MatePad 11 là chiếc máy tính bảng đáp ứng tốt hầu hết nhu cầu bạn cần ở một thiết bị di động, cùng mức giá tốt chính là yếu tố được nhiều người tin tưởng và chọn lựa làm các công việc sáng tạo hay dùng để giải trí với trọng lượng gọn nhẹ có thể mang đi, sẵn sàng sử dụng bất cứ lúc nào.");
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
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\huawei_200x200.jpg"));
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
