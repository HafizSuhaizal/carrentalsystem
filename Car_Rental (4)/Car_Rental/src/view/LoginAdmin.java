package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdminController;
import controller.UserController;
import model.Admin;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import view.AdminMenu;
import java.awt.Color;
import javax.swing.ImageIcon;
public class LoginAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN MENU");
		lblNewLabel.setForeground(new Color(233, 196, 48));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 34));
		lblNewLabel.setBounds(122, 41, 412, 74);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username    :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1.setBounds(32, 136, 132, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password     :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(32, 183, 132, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(163, 136, 190, 30);
		contentPane.add(txtUsername);
		
		JTextArea txtPassword = new JTextArea();
		txtPassword.setBounds(163, 189, 190, 30);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txtUsername.getText();
				String password=txtPassword.getText();
				Admin admin=new Admin();
				admin.setAdminUsername(username);
				admin.setAdminPassword(password);
				AdminController adminController =new AdminController();
				String level="";
				try {
					//String level=userController.doLogin(user);
					//Object btnOK;
					level=adminController.doLoginAdmin(admin);
					if(level=="-1")
					{
					
						JOptionPane.showMessageDialog(btnNewButton,"You are not Authorized");
						
					}
					else {
						
						adminController.checkAdmin(admin);
						JOptionPane.showMessageDialog(null,"Successfull");
						AdminMenu frame=new AdminMenu();
						frame.setVisible(true);
						dispose();
					}
						
				}catch(ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					/*.printStackTrace();
					JOptionPane.showMessageDialog(null,"Success!");
					txtUsername.setText("");
					txtPassword.setText("");
					dispose();*/
				}
			}
		});
		btnNewButton.setBounds(232, 260, 178, 38);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		btnCancel.setBounds(232, 334, 178, 38);
		contentPane.add(btnCancel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		btnBack.setBounds(232, 413, 178, 38);
		contentPane.add(btnBack);
		
		
		
		JLabel lblBmw = new JLabel("New label");
		lblBmw.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\WhatsApp Image 2023-01-20 at 21.37.56.jpeg"));
		lblBmw.setBounds(-16, 148, 730, 440);
		contentPane.add(lblBmw);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\28e238d7-2037-4344-8c41-239161c081a1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 630, 525);
		contentPane.add(lblNewLabel_2);
	}
}
