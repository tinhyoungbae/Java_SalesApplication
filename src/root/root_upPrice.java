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

public class root_upPrice extends JFrame {

	private JPanel up;
	private JTextField giatb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					root_upPrice frame = new root_upPrice();
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
	public root_upPrice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(369,461);
		setResizable(false);
		setLocationRelativeTo(null);
		up = new JPanel();
		up.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(up);
		up.setLayout(null);
		JLabel lblNewLabel = new JLabel("CẬP NHẬT GIÁ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(44, 26, 207, 42);
		up.add(lblNewLabel);
		setTitle("Cập nhật giá");

		
		JLabel lblNewLabel_1 = new JLabel("Mã thiết bị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 127, 96, 42);
		up.add(lblNewLabel_1);
		
		final JTextField idtb = new JTextField();
		idtb.setBounds(173, 137, 140, 28);
		up.add(idtb);
		idtb.setColumns(10);
		
		JButton delete = new JButton("Cập Nhật");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbURL = "jdbc:mysql://localhost:3306/sale";
					String username = "root";
					String password = "";
					Connection conn = DriverManager.getConnection(dbURL, username, password);
					String id_tb = idtb.getText();
					String gia_tb = giatb.getText();

					PreparedStatement del_hh = (PreparedStatement) conn.prepareStatement("update gia set gia_tb=? where id_tb=?");
					del_hh.setString(1, gia_tb);
					del_hh.setString(2, id_tb);
					del_hh.executeUpdate();
					JOptionPane.showMessageDialog(root_upPrice.this, "Cập nhật giá thành công");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(root_upPrice.this, "Cập nhật giá thất bại");
				}
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 17));
		delete.setBounds(124, 284, 109, 33);
		delete.setBackground(Color.RED);
		up.add(delete);
		
		JButton back = new JButton("Xong");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		back.setBounds(260, 37, 85, 32);
		back.setBackground(Color.GRAY);
		up.add(back);
		
		
		
		JButton un_b = new JButton("New button");
		un_b.setBounds(0, 0, 0, 0);
		up.add(un_b);
		
		giatb = new JTextField();
		giatb.setColumns(10);
		giatb.setBounds(173, 214, 140, 28);
		up.add(giatb);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá mới");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(44, 204, 96, 42);
		up.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("-----------------------------------------------------");
		lblNewLabel_2.setBounds(22, 66, 215, 13);
		up.add(lblNewLabel_2);
	}
}
