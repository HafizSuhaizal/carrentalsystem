package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//date
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import controller.CarController;
import controller.UserController;

import javax.swing.JTable;

import database.BasicJDBC;
import model.Car;
import model.User;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class userLoanCar extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtDuration;
	private JTextField txtCarID;
	private JTable table_1;
	private DefaultTableModel model; 
	private ArrayList<Car> cars;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userLoanCar frame = new userLoanCar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	

	/**
	 * Create the frame.
	 */
	public userLoanCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 692);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Car ID :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1.setBounds(52, 414, 154, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("RENT CAR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(577, 429, 202, 45);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 34));
		contentPane.add(lblNewLabel);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setBounds(232, 362, 241, 27);
		contentPane.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer ID :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(52, 362, 154, 33);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duration :");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(52, 457, 154, 33);
		contentPane.add(lblNewLabel_1_2);
		
		txtDuration = new JTextField();
		txtDuration.setColumns(10);
		txtDuration.setBounds(232, 460, 241, 27);
		contentPane.add(txtDuration);
		
		txtCarID = new JTextField();
		txtCarID.setColumns(10);
		txtCarID.setBounds(232, 417, 241, 27);
		contentPane.add(txtCarID);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 36, 815, 296);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Car Id","Brand","Model","Transmission","Rate Per Hour","Status"}
				));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(29);
		table_1.getColumnModel().getColumn(0).setMinWidth(6);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(2).setMinWidth(30);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(94);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(282);
		table_1.getColumnModel().getColumn(4).setMinWidth(100);
		scrollPane.setViewportView(table_1);
	
	CarController carController = new CarController();
		
		try {
			cars = new ArrayList<>();
			cars = carController.viewCar();
			System.out.println(cars.size());
			
			DefaultTableModel temp = (DefaultTableModel) table_1.getModel();
			
			for(Car car : cars ) {
		    	
		    	Object[] objs = {car.getCarID(), car.getCarBrand(), car.getCarModel(), car.getCarTransmission(), 
		    			car.getHourlyRate(), car.getStatus()};
		    	temp.addRow(objs);			
		    	
		    }	
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	

		
		JButton btnLoan = new JButton("Loan");
		btnLoan.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CustomerID=txtCustomerID.getText().trim();
				String CarID=txtCarID.getText().trim();
				double Duration=Double.parseDouble(txtDuration.getText());
				//double totalPayment=Double.parseDouble(txtTotalPayment.getText());
				User user=new User();
				UserController userController=new UserController();
				
				double totalPayment = 0;
				Car car=new Car();
				user.setId(CustomerID);
				user.setCarID(CarID);
				user.setDuration(Duration);
				
				try {
					double hour =userController.hourlyRate(user) ;
					System.out.print(hour);
					totalPayment=(Duration*hour);
					System.out.print(totalPayment);
					
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 user.setTotalPaymemt(totalPayment);
				int success=-1;
				
				String level="";
				CarController carController=new CarController();
				try {
					success=carController.loanCar(user);
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				if(success == -1)
				{
					JOptionPane.showMessageDialog(null,"Car is not available");
				}
				else
				{
				
				try {
					
					userController.userLoan(user);
					JOptionPane.showMessageDialog(null,"Successfully Loan");
				
						txtCustomerID.setText("");
						txtCarID.setText("");
						txtDuration.setText("");
				
					
				}catch(ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"The User Is Already Exist!");
					txtCustomerID.setText("");
					txtCarID.setText("");
					txtDuration.setText("");
				

				}
			
			}}
		});
		btnLoan.setBounds(223, 525, 101, 27);
		contentPane.add(btnLoan);
	
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu frame=new AdminMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(412, 525, 101, 27);
		contentPane.add(btnBack);
		
		JLabel lblbg = new JLabel("");
		lblbg.setBackground(new Color(0, 0, 0));
		lblbg.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bg.jpg"));
		lblbg.setBounds(151, 193, 722, 585);
		contentPane.add(lblbg);
		//table_1.setBounds(70, 222, 403, -171);
		
	}}
