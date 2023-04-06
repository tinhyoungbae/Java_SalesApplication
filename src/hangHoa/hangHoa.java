package hangHoa;

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
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import hangHoa.donHang_LichSu;
import hangHoa.gioHang;
import hangHoa.hangHoa_All;
import khachHang.khachHang_Login;
import khachHang.khachHang_ThongTin;
import khachHang.khachHang_Update;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class hangHoa extends JFrame {

	private JPanel contentPane;
	private JLabel mh;
	private JLabel dpg;
	private JLabel camt;
	private JLabel hdh;
	private JLabel cams;
	private JLabel gia_dt;
	private JLabel rom;
	private JLabel tt_dt;
	private JLabel pin;
	private JLabel ten_dt;
	private JLabel ram;
	private JLabel cpu;
	private JLabel chip;
	private JLabel gpu;
	public static String a = "0";
	public static int b = 1;
	public static JLabel dt;
	public static String id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hangHoa frame = new hangHoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */	

	public hangHoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 779);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setTitle("Sản phẩm");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(818, 10, 85, 33);
		contentPane.add(btnNewButton);
		
		JButton order_1 = new JButton("\u0110\u1EB7t mua");
		order_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new order().setVisible(true);
			}
		});
		order_1.setBackground(Color.RED);
		order_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		order_1.setBounds(182, 347, 94, 33);
		contentPane.add(order_1);
		
		JButton btnNewButton_2 = new JButton("Gi\u1ECF h\u00E0ng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String id = Sea.ma.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					PreparedStatement gh = (PreparedStatement) conn.prepareStatement("insert into giohang values(?, ?, ?);");
					gh.setString(1, khachHang_Login.kh_us.getText());
					gh.setString(2, id);
					gh.setString(3, "1");
					gh.executeUpdate();
				JOptionPane.showMessageDialog(hangHoa.this, "Thêm thành công");
				} catch (Exception ex) {
				}
				
			
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(337, 347, 102, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel ten_dt = new JLabel("");
		ten_dt.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		ten_dt.setBounds(167, 22, 349, 75);
		contentPane.add(ten_dt);
		
		JLabel gia_dt = new JLabel("");
		gia_dt.setHorizontalAlignment(SwingConstants.CENTER);
		gia_dt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		gia_dt.setBounds(256, 309, 102, 25);
		contentPane.add(gia_dt);
		
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
		
		JLabel pic = new JLabel("");
		pic.setBounds(200, 91, 300, 200);
		contentPane.add(pic);
		
		JTextArea tt_dt = new JTextArea();
		tt_dt.setBackground(new Color(240, 240, 240));
		tt_dt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tt_dt.setBounds(10, 440, 572, 292);
		tt_dt.setLineWrap(true);
		contentPane.add(tt_dt);
		tt_dt.setText("Đang cập nhật");
		tt_dt.setEditable(false); //Ngăn chặn edit văn bản
		tt_dt.setWrapStyleWord(true);//Gộp dòng văn bản
		
		JScrollPane scrollPane = new JScrollPane(tt_dt);
		scrollPane.setBounds(10, 440, 572, 292);
		contentPane.add(scrollPane);
		
		String id = Sea.ma.getText();
		//Oppo Find X3
		if(id.contains("find_x3")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\oppo_200x200.jpg"));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		java.sql.Statement a = conn.createStatement();
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='find_x3' and display.id_tb='find_x3' and  camera.id_tb='find_x3' and hdh.id_tb='find_x3' and cpu.id_tb='find_x3' and mem.id_tb='find_x3' and battery.id_tb='find_x3' and gia.id_tb='find_x3' and thongtin_tb.id_tb='find_x3';");
		
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
			gia_dt.setText(detail.getString(13) + "vnd");
			ten_dt.setText(detail.getString(12));
			tt_dt.setText(detail.getString(14));
		}
		}catch (Exception ex) {
		}
		}
		
		if(id.contains("S22_Ultra")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\s22_200x200.jpg"));
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='S22_Ultra' and display.id_tb='S22_Ultra' and  camera.id_tb='S22_Ultra' and hdh.id_tb='S22_Ultra' and cpu.id_tb='S22_Ultra' and mem.id_tb='S22_Ultra' and battery.id_tb='S22_Ultra' and gia.id_tb='S22_Ultra' and thongtin_tb.id_tb='S22_Ultra';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//iPhone 13
		if(id.contains("iPhone14,5")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\iphone_200x200.jpg"));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		java.sql.Statement a = conn.createStatement();
		ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='iPhone14,5' and display.id_tb='iPhone14,5' and  camera.id_tb='iPhone14,5' and hdh.id_tb='iPhone14,5' and cpu.id_tb='iPhone14,5' and mem.id_tb='iPhone14,5' and battery.id_tb='iPhone14,5' and gia.id_tb='iPhone14,5' and thongtin_tb.id_tb='iPhone14,5';");
		
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
			gia_dt.setText(detail.getString(13) + "vnd");
			ten_dt.setText(detail.getString(12));
			tt_dt.setText(detail.getString(14));
		}
		}catch (Exception ex) {
		}
		}
		
		//Huawei Mate 50
		if(id.contains("Mate_50")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\dienThoai\\huawei-200x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='Mate_50' and display.id_tb='Mate_50' and  camera.id_tb='Mate_50' and hdh.id_tb='Mate_50' and cpu.id_tb='Mate_50' and mem.id_tb='Mate_50' and battery.id_tb='Mate_50' and gia.id_tb='Mate_50' and thongtin_tb.id_tb='Mate_50';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//Laptop dell
		if(id.contains("Inp15")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Dell_300x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='Inp15' and display.id_tb='Inp15' and  camera.id_tb='Inp15' and hdh.id_tb='Inp15' and cpu.id_tb='Inp15' and mem.id_tb='Inp15' and battery.id_tb='Inp15' and gia.id_tb='Inp15' and thongtin_tb.id_tb='Inp15';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//Laptop HP
		if(id.contains("240G8")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\HP_300x200.png"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='240G8' and display.id_tb='240G8' and  camera.id_tb='240G8' and hdh.id_tb='240G8' and cpu.id_tb='240G8' and mem.id_tb='240G8' and battery.id_tb='240G8' and gia.id_tb='240G8' and thongtin_tb.id_tb='240G8';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//Macbook
		if(id.contains("AirM1")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Macbook_300x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='AirM1' and display.id_tb='AirM1' and  camera.id_tb='AirM1' and hdh.id_tb='AirM1' and cpu.id_tb='AirM1' and mem.id_tb='AirM1' and battery.id_tb='AirM1' and gia.id_tb='AirM1' and thongtin_tb.id_tb='AirM1';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//7Pro
		if(id.contains("7Pro")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\lapTop\\Surface_300x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='7Pro' and display.id_tb='7Pro' and  camera.id_tb='7Pro' and hdh.id_tb='7Pro' and cpu.id_tb='7Pro' and mem.id_tb='7Pro' and battery.id_tb='7Pro' and gia.id_tb='7Pro' and thongtin_tb.id_tb='7Pro';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//MTB Huawei
		if(id.contains("MatePad11")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\huawei_200x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='MatePad11' and display.id_tb='MatePad11' and  camera.id_tb='MatePad11' and hdh.id_tb='MatePad11' and cpu.id_tb='MatePad11' and mem.id_tb='MatePad11' and battery.id_tb='MatePad11' and gia.id_tb='MatePad11' and thongtin_tb.id_tb='MatePad11';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//MTB iPad
		if(id.contains("ProM1")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\ipad_200x200.jpeg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='ProM1' and display.id_tb='ProM1' and  camera.id_tb='ProM1' and hdh.id_tb='ProM1' and cpu.id_tb='ProM1' and mem.id_tb='ProM1' and battery.id_tb='ProM1' and gia.id_tb='ProM1' and thongtin_tb.id_tb='ProM1';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		//MTB Tab S8
		if(id.contains("TabS8")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\Tabs8_200x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='TabS8' and display.id_tb='TabS8' and  camera.id_tb='TabS8' and hdh.id_tb='TabS8' and cpu.id_tb='TabS8' and mem.id_tb='TabS8' and battery.id_tb='TabS8' and gia.id_tb='TabS8' and thongtin_tb.id_tb='TabS8';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
		}
		
		// Xiaomi Pad 5
		if(id.contains("Pad5")) {
			pic.setIcon(new ImageIcon("C:\\Users\\tinhh\\eclipse-workspace\\Sale_Project\\src\\mayTinhBang\\huawei_200x200.jpg"));

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/sale";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			java.sql.Statement a = conn.createStatement();
			ResultSet detail = a.executeQuery("select  distinct ten_display, dophangiai, front_cam, rear_cam, ten_hdh, ten_cpu, tocdo_cpu, gpu, ram, rom, dungluong, ten_tb, gia_tb, txt from display, camera, hdh, cpu, mem, battery, thietbi, gia, thongtin_tb where thietbi.id_tb='Pad5' and display.id_tb='Pad5' and  camera.id_tb='Pad5' and hdh.id_tb='Pad5' and cpu.id_tb='Pad5' and mem.id_tb='Pad5' and battery.id_tb='Pad5' and gia.id_tb='Pad5' and thongtin_tb.id_tb='Pad5';");
			
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
				gia_dt.setText(detail.getString(13) + "vnd");
				ten_dt.setText(detail.getString(12));
				tt_dt.setText(detail.getString(14));
			}
			}catch (Exception ex) {
			}
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
		
		JLabel lblNewLabel_8 = new JLabel("Chi ti\u1EBFt s\u1EA3n ph\u1EA9m");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(31, 402, 122, 33);
		contentPane.add(lblNewLabel_8);
		
		
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
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
		
	}
	
	
}