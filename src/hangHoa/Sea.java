package hangHoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import dienThoai.DT_11PM;
import dienThoai.DT_FindX3;
import dienThoai.DT_Mate50;
import dienThoai.DT_S22Ultra;
import khachHang.khachHang_Login;
import lapTop.LT_DELL_Inp15;
import lapTop.LT_HP_240G8;
import lapTop.LT_Macbook_AirM1;
import lapTop.LT_Surface_7Pro;
import mayTinhBang.MTB_HW_MatePad11;
import mayTinhBang.MTB_SS_TabS8;
import mayTinhBang.MTB_Xiaomi_Pad5;
import mayTinhBang.MTB_iPad_ProM1;
import root.root_xoaHH;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.SwingConstants;

public class Sea extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField tt1;
	private JTextField tt2;
	private JTextField tt3;
	private JTextField tt4;
	private JTextField tt5;
	private JTextField tt6;
	private JLabel lblNewLabel_1;
	public static JTextField ma;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sea frame = new Sea();
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
	public Sea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(550,606);
		setResizable(false);
		setTitle("Tìm kiếm");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("K\u1EBET QU\u1EA2 T\u00CCM KI\u1EBEM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(103, 30, 294, 57);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new hangHoa_All().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(426, 30, 85, 35);
		contentPane.add(btnNewButton);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		tt1 = new JTextField();
		tt1.setHorizontalAlignment(SwingConstants.CENTER);
		tt1.setBounds(25, 387, 175, 28);
		contentPane.add(tt1);
		tt1.setColumns(10);
		
		final JTable table = new JTable();
		
		table.setBounds(241, 110, 205, 79);
		contentPane.add(table);
		
		final Vector head = new Vector();
		final Vector dt = new Vector();
		
		head.add("Tên thiết bị");
		head.add("Mã thiết bị");
		head.add("Giá");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/sale";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		String se = hangHoa_All.searchtext.getText();
			//String se ="a";
		java.sql.Statement a = conn.createStatement();
		ResultSet user = a.executeQuery("select distinct ten_tb, thietbi.id_tb, gia_tb from thietbi, gia where ten_tb like '%"+se+"%' and thietbi.id_tb=gia.id_tb");
		while(user.next()) {
			Vector rows = new Vector();
			 int i=1;
             rows.add(user.getString(1));
             rows.add(user.getString(2));
             rows.add(user.getString(3));
             dt.add(rows);
		}
		}catch (Exception ex) {
			
		}	
		table.setModel(new DefaultTableModel(dt, head));
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				
				DefaultTableModel t = (DefaultTableModel)table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				String id = t.getValueAt(selectedRowIndex,  0).toString();
				String idtb = t.getValueAt(selectedRowIndex,  1).toString();
				String sl = t.getValueAt(selectedRowIndex,  2).toString();
				
				tt1.setText(id);
				tt2.setText(sl+"vnd");
				ma.setText(idtb);
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
				java.sql.Statement a = conn.createStatement();
				String id1 = ma.getText();
				ResultSet user = a.executeQuery("select cpu.id_tb, ten_hdh, ver_hdh ten_cpu, ram, rom, dungluong from cpu, mem, hdh, battery where cpu.id_tb=mem.id_tb and mem.id_tb=hdh.id_tb && mem.id_tb=battery.id_tb");
				while(user.next()) {
					if(id1.contains(user.getString("cpu.id_tb"))) {
					tt3.setText(user.getString(2) +" " + user.getString(3));
					tt4.setText(user.getString(4) + " GB");
					tt5.setText(user.getString(5) + " GB");
					tt6.setText(user.getString(6) + " mAh");
					}
				}
				}catch (Exception ex) {
					
				}	
				
			}
		});
		scrollPane.setBounds(25, 114, 463, 229);
		contentPane.add(scrollPane);
		
		tt2 = new JTextField();
		tt2.setHorizontalAlignment(SwingConstants.CENTER);
		tt2.setColumns(10);
		tt2.setBounds(25, 425, 175, 28);
		contentPane.add(tt2);
		
		tt3 = new JTextField();
		tt3.setHorizontalAlignment(SwingConstants.CENTER);
		tt3.setColumns(10);
		tt3.setBounds(25, 463, 175, 28);
		contentPane.add(tt3);
		
		tt4 = new JTextField();
		tt4.setHorizontalAlignment(SwingConstants.CENTER);
		tt4.setColumns(10);
		tt4.setBounds(313, 391, 175, 28);
		contentPane.add(tt4);
		
		tt5 = new JTextField();
		tt5.setHorizontalAlignment(SwingConstants.CENTER);
		tt5.setColumns(10);
		tt5.setBounds(313, 429, 175, 28);
		contentPane.add(tt5);
		
		tt6 = new JTextField();
		tt6.setHorizontalAlignment(SwingConstants.CENTER);
		tt6.setColumns(10);
		tt6.setBounds(313, 467, 175, 28);
		contentPane.add(tt6);
		
		JButton Link = new JButton("Truy cập sản phẩm");
		Link.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new hangHoa().setVisible(true);
			}
			
		});
		Link.setForeground(Color.RED);
		Link.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Link.setBounds(172, 524, 163, 35);
		contentPane.add(Link);
		
		lblNewLabel_1 = new JLabel("-----------------------------------------------------------------------------------------");
		lblNewLabel_1.setBounds(48, 74, 359, 13);
		contentPane.add(lblNewLabel_1);
		
		ma = new JTextField();
		ma.setBounds(0,0,0,0);
		contentPane.add(ma);
		ma.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Tên");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(210, 394, 38, 21);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Giá");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(210, 432, 38, 21);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("HĐH");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(210, 470, 38, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("RAM");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(265, 394, 38, 21);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("ROM");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(265, 432, 38, 21);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("PIN");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(265, 470, 38, 21);
		contentPane.add(lblNewLabel_7);
		
	
		

	}
}
