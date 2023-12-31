package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdminController;
import model.Admin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegisterAdminView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIDNum;
	private JTextField txtFullName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtPhoneNo;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterAdminView frame = new RegisterAdminView();
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
	public RegisterAdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Admin ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 36));
		lblNewLabel.setBounds(160, 0, 331, 83);
		contentPane.add(lblNewLabel);
		
		JLabel ID = new JLabel("ID Number :");
		ID.setForeground(new Color(255, 255, 255));
		ID.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		ID.setBounds(71, 109, 123, 22);
		contentPane.add(ID);
		
		JLabel FullName = new JLabel("Full Name  :");
		FullName.setForeground(new Color(255, 255, 255));
		FullName.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		FullName.setBounds(71, 137, 123, 22);
		contentPane.add(FullName);
		
		JLabel AdminUsername = new JLabel("User Name :");
		AdminUsername.setForeground(new Color(255, 255, 255));
		AdminUsername.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		AdminUsername.setBounds(71, 169, 155, 22);
		contentPane.add(AdminUsername);
		
		JLabel Password = new JLabel("Password  :");
		Password.setForeground(new Color(255, 255, 255));
		Password.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		Password.setBounds(71, 201, 123, 22);
		contentPane.add(Password);
		
		JLabel PhoneNo = new JLabel("Phone No   :");
		PhoneNo.setForeground(new Color(255, 255, 255));
		PhoneNo.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		PhoneNo.setBounds(71, 233, 123, 22);
		contentPane.add(PhoneNo);
		
		JLabel Address = new JLabel("Address     :");
		Address.setForeground(new Color(255, 255, 255));
		Address.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		Address.setBounds(71, 271, 98, 22);
		contentPane.add(Address);
		
		txtIDNum = new JTextField();
		txtIDNum.setBounds(236, 111, 240, 19);
		contentPane.add(txtIDNum);
		txtIDNum.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(236, 140, 240, 19);
		contentPane.add(txtFullName);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(236, 171, 240, 19);
		contentPane.add(txtUserName);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(236, 205, 240, 19);
		contentPane.add(txtPassword);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setBounds(236, 234, 240, 19);
		contentPane.add(txtPhoneNo);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(236, 272, 240, 22);
		contentPane.add(txtAddress);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AdminID=txtIDNum.getText().trim();
				String AdminFullName=txtFullName.getText().trim();
				String Adminusername=txtUserName.getText().trim();
				String Adminpassword=txtPassword.getText().trim();
				String phoneNo=txtPhoneNo.getText().trim();
				String address=txtAddress.getText().trim();
				Admin admin=new Admin();
				admin.setId(AdminID);
				admin.setAdminName(AdminFullName);
				admin.setAdminUsername(Adminusername);
				admin.setAdminPassword(Adminpassword);
				admin.setAdminPhoneNo(phoneNo);
				admin.setAdminAddress(address);
				int success=-1;
				AdminController adminController=new AdminController();
				try {
					success=adminController.insertAdmin(admin);
					if(success==-1)
					{
						JOptionPane.showMessageDialog(null,"This User Is Already  Exist!");
					}
					else
					{
						
						adminController.checkAdmin(admin);
					}
						txtIDNum.setText("");
						txtFullName.setText("");
						txtUserName.setText("");
						txtPassword.setText("");
						txtPhoneNo.setText("");
						txtAddress.setText("");
					
				}catch(ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"The User Is Already Exist!");
					txtIDNum.setText("");
					txtFullName.setText("");
					txtUserName.setText("");
					txtPassword.setText("");
					txtPhoneNo.setText("");
					txtAddress.setText("");

				}
			}
				
			
		});
		register.setBounds(123, 353, 85, 21);
		contentPane.add(register);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDNum.setText("");
				txtFullName.setText("");
				txtUserName.setText("");
				txtPassword.setText("");
				txtPhoneNo.setText("");
				txtAddress.setText("");
				dispose();
			}
		});
		Cancel.setBounds(261, 353, 85, 21);
		contentPane.add(Cancel);
		
		JButton Back = new JButton("Back");
		Back.setBounds(406, 353, 85, 21);
		contentPane.add(Back);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bmw.jpeg"));
		lblNewLabel_1.setBounds(81, 169, 696, 370);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bg.jpg"));
		lblBG.setBounds(-55, 10, 683, 509);
		contentPane.add(lblBG);
		
	
	}
}
