package root;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class root_themHH extends JFrame {

	private JPanel contentPane;
	private JTextField tencpu;
	private JTextField cpuspeed;
	private JTextField gpu;
	private JTextField tenhdh;
	private JTextField idcpu;
	private JTextField phienban;
	private JTextField giatb;
	private JTextField idmh;
	private JTextField tenmh;
	private JTextField loaimh;
	private JTextField camtruoc;
	private JTextField camsau;
	private JTextField dpg;
	private JTextField rom;
	private JTextField dosang;
	private JTextField tenpin;
	private JTextField dl;
	private JTextField tocdosac;
	private JTextField ram;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					root_themHH frame = new root_themHH();
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
	public root_themHH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000,825);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("THÊM SẢN PHẨM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(372, 21, 243, 42);
		contentPane.add(lblNewLabel);
		setTitle("Thêm hàng hóa");
		
		JLabel User = new JLabel("M\u00E3 thi\u1EBFt b\u1ECB");
		User.setHorizontalAlignment(SwingConstants.CENTER);
		User.setFont(new Font("Tahoma", Font.PLAIN, 15));
		User.setBounds(10, 130, 96, 21);
		contentPane.add(User);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn thi\u1EBFt b\u1ECB");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 185, 96, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Lo\u1EA1i");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 240, 96, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 295, 96, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ng\u00E0y s\u1EA3n xu\u1EA5t");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 350, 96, 21);
		contentPane.add(lblNewLabel_5);
		
		final JTextField idtb = new JTextField();
		idtb.setHorizontalAlignment(SwingConstants.CENTER);
		idtb.setBounds(129, 130, 169, 24);
		contentPane.add(idtb);
		idtb.setColumns(10);
		
		final JTextField ten_tb = new JTextField();
		ten_tb.setHorizontalAlignment(SwingConstants.CENTER);
		ten_tb.setBounds(129, 185, 169, 24);
		contentPane.add(ten_tb);
		ten_tb.setColumns(10);
		
		final JTextField loai_tb = new JTextField();
		loai_tb.setHorizontalAlignment(SwingConstants.CENTER);
		loai_tb.setBounds(129, 240, 169, 24);
		contentPane.add(loai_tb);
		loai_tb.setColumns(10);

		final JTextField sl = new JTextField();
		sl.setHorizontalAlignment(SwingConstants.CENTER);
		sl.setBounds(129, 295, 169, 24);
		contentPane.add(sl);
		sl.setColumns(10);
		
		final JTextField ngay_sx = new JTextField();
		ngay_sx.setHorizontalAlignment(SwingConstants.CENTER);
		ngay_sx.setBounds(129, 350, 169, 24);
		contentPane.add(ngay_sx);
		ngay_sx.setColumns(10);
		
		final JTextArea tt = new JTextArea();
		tt.setForeground(SystemColor.desktop);
		tt.setBackground(SystemColor.controlHighlight);
		tt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tt.setBounds(390, 429, 241, 245);
		contentPane.add(tt);
		tt.setLineWrap(true);
		contentPane.add(tt);
		tt.setWrapStyleWord(true);//Gộp dòng văn bản

		
		JScrollPane scrollPane = new JScrollPane(tt);
		scrollPane.setBounds(327, 429, 340, 245);
		contentPane.add(scrollPane);
		
		JButton reset = new JButton("ĐẶT LẠI");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtb.setText("");
				ten_tb.setText("");
				loai_tb.setText("");
				sl.setText("");
				ngay_sx.setText("");
			}
		});
		reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reset.setBounds(304, 720, 119, 40);
		reset.setBackground(Color.RED);
		contentPane.add(reset);
		
		JButton create = new JButton("THÊM");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					//Thiết bị
					PreparedStatement thietbi = (PreparedStatement) conn.prepareStatement("insert into thietbi values(?, ?, ?, ?, ?)");
					thietbi.setString(1, idtb.getText());
					thietbi.setString(2, ten_tb.getText());
					thietbi.setString(3, loai_tb.getText());
					thietbi.setString(4, sl.getText());
					thietbi.setString(5, ngay_sx.getText());
					thietbi.executeUpdate();
					// Giá
					
					PreparedStatement gia = (PreparedStatement) conn.prepareStatement("insert into gia values(?, ?)");
					gia.setString(1, idtb.getText());
					gia.setString(2, giatb.getText());
					gia.executeUpdate();
					// CPU
					PreparedStatement cpu = (PreparedStatement) conn.prepareStatement("insert into cpu values(?, ?, ?, ?, ?)");
					cpu.setString(1, idtb.getText());
					cpu.setString(2, idcpu.getText());
					cpu.setString(3, tencpu.getText());
					cpu.setString(4, cpuspeed.getText());
					cpu.setString(5, gpu.getText());
					cpu.executeUpdate();
					// Hệ điều hành
					PreparedStatement hdh = (PreparedStatement) conn.prepareStatement("insert into hdh values(?, ?, ?)");
					hdh.setString(1, tenhdh.getText());
					hdh.setString(2, phienban.getText());
					hdh.setString(3, idtb.getText());
					hdh.executeUpdate();
					// Camera
					PreparedStatement camera = (PreparedStatement) conn.prepareStatement("insert into camera values(?, ?, ?)");
					camera.setString(1, camtruoc.getText());
					camera.setString(2, camsau.getText());
					camera.setString(3, idtb.getText());
					camera.executeUpdate();
					
					// Màn hình
					PreparedStatement manhinh = (PreparedStatement) conn.prepareStatement("insert into display values(?, ?, ?, ?, ?, ?)");
					manhinh.setString(1, idmh.getText());
					manhinh.setString(2, tenmh.getText());
					manhinh.setString(3, loaimh.getText());
					manhinh.setString(4, dpg.getText());
					manhinh.setString(5, dosang.getText());
					manhinh.setString(6, idtb.getText());
					manhinh.executeUpdate();
					/*
					// PIN
					PreparedStatement pin = (PreparedStatement) conn.prepareStatement("insert into battery values(?, ?, ?, ?)");
					pin.setString(1, tenpin.getText());
					pin.setString(2, dl.getText());
					pin.setString(3, tocdosac.getText());
					pin.setString(4, idtb.getText());
					pin.executeUpdate();
					// Bộ nhớ
					PreparedStatement bonho = (PreparedStatement) conn.prepareStatement("insert into mem values(?, ?, ?)");
					bonho.setString(1, ram.getText());
					bonho.setString(2, rom.getText());
					bonho.setString(3, idtb.getText());
					bonho.executeUpdate();
					// Thông tin
					PreparedStatement thongtin = (PreparedStatement) conn.prepareStatement("insert into thongtin_tb values(?, ?)");
					thongtin.setString(1, idtb.getText());
					thongtin.setString(2, tt.getText());
					thongtin.executeUpdate();
					*/
					JOptionPane.showMessageDialog(root_themHH.this, "Thêm thiết bị thành công");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(root_themHH.this, "Thêm thiết bị thất bại");
				}
			}
		});
		create.setFont(new Font("Tahoma", Font.PLAIN, 20));
		create.setBounds(510, 720, 119, 40);
		create.setBackground(Color.RED);
		contentPane.add(create);
		
		JButton back = new JButton("Xong");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 15));
		back.setBounds(891, 10, 85, 40);
		back.setBackground(Color.GRAY);
		contentPane.add(back);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_1 = new JLabel("--------------------------------------------------------------");
		lblNewLabel_1.setBounds(356, 62, 259, 13);
		contentPane.add(lblNewLabel_1);
		
		tencpu = new JTextField();
		tencpu.setHorizontalAlignment(SwingConstants.CENTER);
		tencpu.setColumns(10);
		tencpu.setBounds(487, 185, 169, 24);
		contentPane.add(tencpu);
		
		cpuspeed = new JTextField();
		cpuspeed.setHorizontalAlignment(SwingConstants.CENTER);
		cpuspeed.setColumns(10);
		cpuspeed.setBounds(487, 240, 169, 24);
		contentPane.add(cpuspeed);
		
		gpu = new JTextField();
		gpu.setHorizontalAlignment(SwingConstants.CENTER);
		gpu.setColumns(10);
		gpu.setBounds(487, 295, 169, 24);
		contentPane.add(gpu);
		
		tenhdh = new JTextField();
		tenhdh.setHorizontalAlignment(SwingConstants.CENTER);
		tenhdh.setColumns(10);
		tenhdh.setBounds(807, 430, 169, 24);
		contentPane.add(tenhdh);
		
		idcpu = new JTextField();
		idcpu.setHorizontalAlignment(SwingConstants.CENTER);
		idcpu.setColumns(10);
		idcpu.setBounds(487, 130, 169, 24);
		contentPane.add(idcpu);
		
		phienban = new JTextField();
		phienban.setHorizontalAlignment(SwingConstants.CENTER);
		phienban.setColumns(10);
		phienban.setBounds(807, 485, 169, 24);
		contentPane.add(phienban);
		
		giatb = new JTextField();
		giatb.setHorizontalAlignment(SwingConstants.CENTER);
		giatb.setColumns(10);
		giatb.setBounds(807, 650, 169, 24);
		contentPane.add(giatb);
		
		idmh = new JTextField();
		idmh.setHorizontalAlignment(SwingConstants.CENTER);
		idmh.setColumns(10);
		idmh.setBounds(129, 430, 169, 24);
		contentPane.add(idmh);
		
		tenmh = new JTextField();
		tenmh.setHorizontalAlignment(SwingConstants.CENTER);
		tenmh.setColumns(10);
		tenmh.setBounds(129, 485, 169, 24);
		contentPane.add(tenmh);
		
		loaimh = new JTextField();
		loaimh.setHorizontalAlignment(SwingConstants.CENTER);
		loaimh.setColumns(10);
		loaimh.setBounds(129, 540, 169, 24);
		contentPane.add(loaimh);
		
		camtruoc = new JTextField();
		camtruoc.setHorizontalAlignment(SwingConstants.CENTER);
		camtruoc.setColumns(10);
		camtruoc.setBounds(807, 540, 169, 24);
		contentPane.add(camtruoc);
		
		camsau = new JTextField();
		camsau.setHorizontalAlignment(SwingConstants.CENTER);
		camsau.setColumns(10);
		camsau.setBounds(807, 595, 169, 24);
		contentPane.add(camsau);
		
		dpg = new JTextField();
		dpg.setHorizontalAlignment(SwingConstants.CENTER);
		dpg.setColumns(10);
		dpg.setBounds(129, 595, 169, 24);
		contentPane.add(dpg);
		
		rom = new JTextField();
		rom.setHorizontalAlignment(SwingConstants.CENTER);
		rom.setColumns(10);
		rom.setBounds(807, 350, 169, 24);
		contentPane.add(rom);
		
		dosang = new JTextField();
		dosang.setHorizontalAlignment(SwingConstants.CENTER);
		dosang.setColumns(10);
		dosang.setBounds(129, 650, 169, 24);
		contentPane.add(dosang);
		
		JLabel gia_l = new JLabel("Giá");
		gia_l.setHorizontalAlignment(SwingConstants.CENTER);
		gia_l.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gia_l.setBounds(701, 649, 96, 21);
		contentPane.add(gia_l);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mã màn hình");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(10, 430, 96, 21);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Tên màn hình");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(10, 485, 96, 21);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Mã cpu");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_5.setBounds(372, 130, 96, 21);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Tên cpu");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_6.setBounds(372, 185, 96, 21);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Tốc độ cpu");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_7.setBounds(372, 240, 96, 21);
		contentPane.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("GPU");
		lblNewLabel_3_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_8.setBounds(372, 295, 96, 21);
		contentPane.add(lblNewLabel_3_8);
		
		JLabel h = new JLabel("Hệ điều hành");
		h.setHorizontalAlignment(SwingConstants.CENTER);
		h.setFont(new Font("Tahoma", Font.PLAIN, 15));
		h.setBounds(669, 430, 128, 21);
		contentPane.add(h);
		
		JLabel lblNewLabel_3_11 = new JLabel("Phiên bản");
		lblNewLabel_3_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_11.setBounds(688, 484, 96, 21);
		contentPane.add(lblNewLabel_3_11);
		
		JLabel lblNewLabel_3_12 = new JLabel("Camera trước");
		lblNewLabel_3_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_12.setBounds(688, 539, 96, 21);
		contentPane.add(lblNewLabel_3_12);
		
		JLabel lblNewLabel_3_13 = new JLabel("Camera sau");
		lblNewLabel_3_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_13.setBounds(699, 594, 85, 21);
		contentPane.add(lblNewLabel_3_13);
		
		JLabel lblNewLabel_3_14 = new JLabel("Loại màn hình");
		lblNewLabel_3_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_14.setBounds(10, 540, 96, 21);
		contentPane.add(lblNewLabel_3_14);
		
		JLabel lblNewLabel_3_15 = new JLabel("Độ phân giải");
		lblNewLabel_3_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_15.setBounds(10, 595, 96, 21);
		contentPane.add(lblNewLabel_3_15);
		
		JLabel lblNewLabel_3_16 = new JLabel("Độ sáng");
		lblNewLabel_3_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_16.setBounds(10, 650, 96, 21);
		contentPane.add(lblNewLabel_3_16);
		
		tenpin = new JTextField();
		tenpin.setHorizontalAlignment(SwingConstants.CENTER);
		tenpin.setColumns(10);
		tenpin.setBounds(807, 130, 169, 24);
		contentPane.add(tenpin);
		
		dl = new JTextField();
		dl.setHorizontalAlignment(SwingConstants.CENTER);
		dl.setColumns(10);
		dl.setBounds(807, 185, 169, 24);
		contentPane.add(dl);
		
		tocdosac = new JTextField();
		tocdosac.setHorizontalAlignment(SwingConstants.CENTER);
		tocdosac.setColumns(10);
		tocdosac.setBounds(807, 240, 169, 24);
		contentPane.add(tocdosac);
		
		ram = new JTextField();
		ram.setHorizontalAlignment(SwingConstants.CENTER);
		ram.setColumns(10);
		ram.setBounds(807, 295, 169, 24);
		contentPane.add(ram);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên PIN");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(688, 130, 96, 21);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_10 = new JLabel("Dung lượng");
		lblNewLabel_3_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_10.setBounds(701, 185, 96, 21);
		contentPane.add(lblNewLabel_3_10);
		
		JLabel lblNewLabel_3_17 = new JLabel("Tốc độ sạc");
		lblNewLabel_3_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_17.setBounds(699, 240, 85, 21);
		contentPane.add(lblNewLabel_3_17);
		
		JLabel lblNewLabel_3_18 = new JLabel("RAM");
		lblNewLabel_3_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_18.setBounds(712, 295, 65, 21);
		contentPane.add(lblNewLabel_3_18);
		
		JLabel lblNewLabel_3_19 = new JLabel("ROM");
		lblNewLabel_3_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_19.setBounds(712, 350, 72, 21);
		contentPane.add(lblNewLabel_3_19);
		

		
		JLabel lblNewLabel_3_19_1 = new JLabel("Thông tin sản phẩm");
		lblNewLabel_3_19_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_19_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_19_1.setBounds(412, 395, 143, 21);
		contentPane.add(lblNewLabel_3_19_1);
	}
}
