package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.CarController;
import controller.UserController;
import model.Car;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class returnCar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DefaultTableModel model; 
	private ArrayList<User> users;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnCar frame = new returnCar();
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
	public returnCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(360, 393, 257, 27);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("RETURN CAR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 34));
		lblNewLabel.setBounds(308, 10, 284, 64);
		contentPane.add(lblNewLabel);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 76, 841, 247);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Customer ID","Car ID","Duration","Total Payment","Status"}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(0).setMinWidth(6);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(94);
		table.getColumnModel().getColumn(4).setPreferredWidth(282);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		scrollPane.setViewportView(table);
		//table_1.setBounds(70, 222, 403, -171);
		
		UserController userController = new UserController();
		
		try {
			users = new ArrayList<>();
			users = userController.viewCustomer();
			System.out.println(users.size());
			
			DefaultTableModel temp = (DefaultTableModel) table.getModel();
			
			for(User user : users ) {
		    	
		    	Object[] objs = {user.getId(), user.getCarID(), user.getDuration(), user.getTotalPayment(), 
		    			user.getStatusItem()};
		    	temp.addRow(objs);			
		    	
		    }	
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1.setBounds(206, 341, 144, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(360, 337, 257, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(new Color(0, 0, 0));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String custID=textField.getText().trim();
				String carID=textField_1.getText().trim();
				User user=new User();
				Car car=new Car();
				user.setId(custID);
				car.setCarID(carID);
				int success=-1;
				CarController carController=new CarController();
				UserController userController=new UserController();
				try {
					success=userController.returnCar(user);
					
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
		
				if(success == -1)
				{
					JOptionPane.showMessageDialog(null,"Fail To Return");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Successfully Return");
					textField.setText("");
					textField_1.setText("");
				}
				try {
					carController.returnCar1(car);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReturn.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnReturn.setBounds(308, 440, 98, 32);
		contentPane.add(btnReturn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Car ID :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(206, 391, 120, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu frame=new AdminMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnBack.setBounds(514, 440, 102, 32);
		contentPane.add(btnBack);
		
		JLabel lblbg = new JLabel("");
		lblbg.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bg.jpg"));
		lblbg.setBounds(-89, 0, 751, 488);
		contentPane.add(lblbg);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bg.jpg"));
		lblNewLabel_2.setBounds(0, 116, 609, 402);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblbg_1 = new JLabel("");
		lblbg_1.setBounds(171, -185, 751, 488);
		contentPane.add(lblbg_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\carred.jpeg"));
		lblNewLabel_3.setBounds(574, 298, 314, 232);
		contentPane.add(lblNewLabel_3);
		
	}
}
