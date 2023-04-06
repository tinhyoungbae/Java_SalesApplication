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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

public class root_xoaHH extends JFrame {

	private JPanel contentPane;
	private JTextField idhh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					root_xoaHH frame = new root_xoaHH();
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
	public root_xoaHH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(422,478);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("XÓA SẢN PHẨM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(53, 26, 207, 42);
		contentPane.add(lblNewLabel);
		setTitle("Xóa hàng hóa");

		
		JLabel lblNewLabel_1 = new JLabel("Mã thiết bị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 149, 96, 42);
		contentPane.add(lblNewLabel_1);
		
		JButton delete = new JButton("X\u00D3A");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					String id_hh = idhh.getText();
					
					PreparedStatement del_gia = (PreparedStatement) conn.prepareStatement("delete from gia where id_tb=?");
					del_gia.setString(1, id_hh);
					del_gia.executeUpdate();
					
					PreparedStatement del_cpu = (PreparedStatement) conn.prepareStatement("delete from cpu where id_tb=?");
					del_cpu.setString(1, id_hh);
					del_cpu.executeUpdate();
					
					PreparedStatement del_hdh = (PreparedStatement) conn.prepareStatement("delete from hdh where id_tb=?");
					del_hdh.setString(1, id_hh);
					del_hdh.executeUpdate();
					
					PreparedStatement del_cam = (PreparedStatement) conn.prepareStatement("delete from camera where id_tb=?");
					del_cam.setString(1, id_hh);
					del_cam.executeUpdate();
					
					PreparedStatement del_mh = (PreparedStatement) conn.prepareStatement("delete from display where id_tb=?");
					del_mh.setString(1, id_hh);
					del_mh.executeUpdate();
					
					PreparedStatement del_bat = (PreparedStatement) conn.prepareStatement("delete from battery where id_tb=?");
					del_bat.setString(1, id_hh);
					del_bat.executeUpdate();
					
					PreparedStatement del_mem = (PreparedStatement) conn.prepareStatement("delete from mem where id_tb=?");
					del_mem.setString(1, id_hh);
					del_mem.executeUpdate();
					
					PreparedStatement del_tttb = (PreparedStatement) conn.prepareStatement("delete from thongtin_tb where id_tb=?");
					del_tttb.setString(1, id_hh);
					del_tttb.executeUpdate();
					
					PreparedStatement del_hh = (PreparedStatement) conn.prepareStatement("delete from thietbi where id_tb=?");
					del_hh.setString(1, id_hh);
					del_hh.executeUpdate();
					
					JOptionPane.showMessageDialog(root_xoaHH.this, "Xóa thiết bị thành công");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(root_xoaHH.this, "Xóa thiết bị thất bại");
				}
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		delete.setBounds(140, 275, 96, 33);
		delete.setBackground(Color.RED);
		contentPane.add(delete);
		
		JButton back = new JButton("Xong");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		back.setBounds(301, 62, 85, 32);
		back.setBackground(Color.GRAY);
		contentPane.add(back);
		
		idhh = new JTextField();
		idhh.setBounds(183, 159, 168, 28);
		contentPane.add(idhh);
		idhh.setColumns(10);
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		contentPane.add(un_b);
		
		JLabel lblNewLabel_2 = new JLabel("----------------------------------------------------------");
		lblNewLabel_2.setBounds(33, 56, 241, 22);
		contentPane.add(lblNewLabel_2);
	}
}
