package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.CarController;
import model.Car;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ImageIcon;

public class editCarMenuNew extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private DefaultTableModel model; 
	private ArrayList<Car> cars;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editCarMenuNew frame = new editCarMenuNew();
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
	public editCarMenuNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Brand");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(523, 531, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnCarModel = new JRadioButton("Model");
		rdbtnCarModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnCarModel.setBounds(523, 559, 103, 21);
		contentPane.add(rdbtnCarModel);
		
		JRadioButton rdbtnRatePerHour = new JRadioButton("Rate Per Hour");
		rdbtnRatePerHour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRatePerHour.setEnabled(false);
		rdbtnRatePerHour.setBounds(658, 531, 138, 21);
		contentPane.add(rdbtnRatePerHour);
		
		JRadioButton rdbtnStatus = new JRadioButton("Status");
		rdbtnStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnStatus.setEnabled(false);
		rdbtnStatus.setBounds(658, 559, 103, 21);
		contentPane.add(rdbtnStatus);
		
		JRadioButton rdbtnTransmission = new JRadioButton("Transmission");
		rdbtnTransmission.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTransmission.setEnabled(false);
		rdbtnTransmission.setBounds(523, 584, 133, 21);
		contentPane.add(rdbtnTransmission);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCarModel);
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnTransmission);
		group.add(rdbtnRatePerHour);
		group.add(rdbtnStatus);
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnTransmission.setEnabled(false);
		rdbtnRatePerHour.setEnabled(false);
		rdbtnStatus.setEnabled(false);
		rdbtnCarModel.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Car ID :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1.setBounds(54, 424, 128, 37);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(204, 428, 240, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Car ID :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(54, 495, 128, 37);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Car Brand :");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(54, 531, 128, 37);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Car Model :");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_3.setBounds(54, 568, 128, 37);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Car Transmission :");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_4.setBounds(27, 606, 179, 37);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Rate Per Hour :");
		lblNewLabel_1_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_5.setBounds(37, 639, 145, 37);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Car Status :");
		lblNewLabel_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_6.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_1_6.setBounds(54, 674, 128, 37);
		contentPane.add(lblNewLabel_1_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 500, 240, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 539, 240, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(204, 576, 240, 27);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(204, 611, 240, 27);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(204, 647, 240, 27);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(204, 686, 240, 27);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Attribute To Update ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		lblNewLabel_2.setBounds(523, 486, 263, 39);
		contentPane.add(lblNewLabel_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter The Car ID");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
				}
				else
				{
					int input  = JOptionPane.showConfirmDialog(null, "Do you Want To Update Record?");
					//0=yes,1=no,2=cancel
					if(input==0)
					{
						if(rdbtnNewRadioButton.isSelected()==true)
						{
							String carID=textField.getText().trim();
							String carBrand=textField_2.getText().trim();
							Car car=new Car();
							car.setCarBrand(carBrand);
							car.setCarID(carID);
							int success=-1;
							CarController carController=new CarController();
							try {
								success=carController.editCarBrand(car);
							}catch(ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();}
							if(success==-1)
							{
								JOptionPane.showMessageDialog(null,"Fail To Update");
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Successfully Updated");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								
								//reset The Field
								textField_2.setEditable(false);
								rdbtnNewRadioButton.setEnabled(false);
								rdbtnCarModel.setEnabled(false);
								rdbtnTransmission.setEnabled(false);
								rdbtnRatePerHour.setEnabled(false);
								rdbtnStatus.setEnabled(false);
								btnUpdate.setEnabled(false);
							}
							
						}
						else  if(rdbtnCarModel.isSelected()==true)
						{
							String carID=textField.getText().trim();
							String carModel=textField_3.getText().trim();
							Car car=new Car();
							car.setCarModel(carModel);
							car.setCarID(carID);
							int success=-1;
							CarController carController=new CarController();
							try {
								success=carController.editCarModel(car);
							}catch(ClassNotFoundException e1) {
								e1.printStackTrace();
							}catch(SQLException e1)
							{
								e1.printStackTrace();
							}
							if(success == -1)
							{
								JOptionPane.showMessageDialog(null,"Fail To Update");
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Successfully Updated");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								
								//reset The Field
								textField_3.setEditable(false);
								rdbtnNewRadioButton.setEnabled(false);
								rdbtnCarModel.setEnabled(false);
								rdbtnTransmission.setEnabled(false);
								rdbtnRatePerHour.setEnabled(false);
								rdbtnStatus.setEnabled(false);
								btnUpdate.setEnabled(false);
							
						}}
						else  if(rdbtnTransmission.isSelected()==true)
						{
							String carID=textField.getText().trim();
							String carTransmission=textField_4.getText().trim();
							Car car=new Car();
							car.setCarTransmission(carTransmission);
							car.setCarID(carID);
							int success=-1;
							CarController carController=new CarController();
							try {
								success=carController.editCarTransmission(car);
							}catch(ClassNotFoundException e1) {
								e1.printStackTrace();
							}catch(SQLException e1)
							{
								e1.printStackTrace();
							}
							if(success == -1)
							{
								JOptionPane.showMessageDialog(null,"Fail To Update");
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Successfully Updated");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								
								//reset The Field
								textField_4.setEditable(false);
								rdbtnNewRadioButton.setEnabled(false);
								rdbtnCarModel.setEnabled(false);
								rdbtnTransmission.setEnabled(false);
								rdbtnRatePerHour.setEnabled(false);
								rdbtnStatus.setEnabled(false);
								btnUpdate.setEnabled(false);
							
						}}
						else  if(rdbtnRatePerHour.isSelected()==true)
						{
							String carID=textField.getText().trim();
							String RatePerHour=textField_5.getText().trim();
							double RateDouble=Double.parseDouble(RatePerHour);
							Car car=new Car();
							car.setHourlyRate(RateDouble);
							car.setCarID(carID);
							int success=-1;
							CarController carController=new CarController();
							try {
								success=carController.editHourlyRate(car);
							}catch(ClassNotFoundException e1) {
								e1.printStackTrace();
							}catch(SQLException e1)
							{
								e1.printStackTrace();
							}
							if(success == -1)
							{
								JOptionPane.showMessageDialog(null,"Fail To Update");
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Successfully Updated");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								
								//reset The Field
								textField_5.setEditable(false);
								rdbtnNewRadioButton.setEnabled(false);
								rdbtnCarModel.setEnabled(false);
								rdbtnTransmission.setEnabled(false);
								rdbtnRatePerHour.setEnabled(false);
								rdbtnStatus.setEnabled(false);
								btnUpdate.setEnabled(false);
							
						}}
						else  if(rdbtnStatus.isSelected()==true)
						{
							String carID=textField.getText().trim();
							String carStatus=textField_6.getText().trim();
							Car car=new Car();
							car.setStatus(carStatus);
							car.setCarID(carID);
							int success=-1;
							CarController carController=new CarController();
							try {
								success=carController.editCarStatus(car);
							}catch(ClassNotFoundException e1) {
								e1.printStackTrace();
							}catch(SQLException e1)
							{
								e1.printStackTrace();
							}
							if(success == -1)
							{
								JOptionPane.showMessageDialog(null,"Fail To Update");
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Successfully Updated");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
								
								//reset The Field
								textField_6.setEditable(false);
								rdbtnNewRadioButton.setEnabled(false);
								rdbtnCarModel.setEnabled(false);
								rdbtnTransmission.setEnabled(false);
								rdbtnRatePerHour.setEnabled(false);
								rdbtnStatus.setEnabled(false);
								btnUpdate.setEnabled(false);
							
						}}
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(523, 685, 92, 27);
		contentPane.add(btnUpdate);
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Car ID");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
				}
				else
				{
					String carID=textField.getText().trim();
					Car car=new Car();
					car.setCarID(carID);
					CarController carController1=new CarController();
					Car car1=new Car();
					try {
						car1=carController1.SearchCarByID(car);
					}catch(ClassNotFoundException|SQLException e1)
					{
						e1.printStackTrace();					
					}
				if(car1!=null)
				{
					textField_1.setText((carID));
					textField_2.setText(car1.getCarBrand());
					textField_3.setText(car1.getCarModel());
					textField_4.setText(car1.getCarTransmission());
					double resultHour=car1.getHourlyRate();
					textField_5.setText(Double.toString(resultHour));
					textField_6.setText(car1.getStatus());
					rdbtnNewRadioButton.setEnabled(true);
					rdbtnCarModel.setEnabled(true);
					rdbtnTransmission.setEnabled(true);
					rdbtnRatePerHour.setEnabled(true);
					rdbtnStatus.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The Car Is Not Exist");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					rdbtnNewRadioButton.setEnabled(false);
					rdbtnCarModel.setEnabled(false);
					rdbtnTransmission.setEnabled(false);
					rdbtnRatePerHour.setEnabled(false);
					rdbtnStatus.setEnabled(false);
					btnUpdate.setEnabled(false);
				}
				}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(523, 429, 92, 27);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu frame= new AdminMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(640, 685, 92, 27);
		contentPane.add(btnBack);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setEnabled(true);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()==true)
				{
					btnUpdate.setEnabled(true);
					textField_1.setEditable(false);
					textField_2.setEditable(true);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					textField_5.setEditable(false);
					textField_6.setEditable(false);
					btnSelect.setEnabled(false);
				}
				if(rdbtnCarModel.isSelected()==true)
				{
					btnUpdate.setEnabled(true);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(true);
					textField_4.setEditable(false);
					textField_5.setEditable(false);
					textField_6.setEditable(false);
					btnSelect.setEnabled(false);
				}
				if(rdbtnTransmission.isSelected()==true)
				{
					btnUpdate.setEnabled(true);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(true);
					textField_5.setEditable(false);
					textField_6.setEditable(false);
					btnSelect.setEnabled(false);
				}
				if(rdbtnRatePerHour.isSelected()==true)
				{
					btnUpdate.setEnabled(true);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					textField_5.setEditable(true);
					textField_6.setEditable(false);
					btnSelect.setEnabled(false);
				}
				if(rdbtnStatus.isSelected()==true)
				{
					btnUpdate.setEnabled(true);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					textField_5.setEditable(false);
					textField_6.setEditable(true);
					btnSelect.setEnabled(false);
				}
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSelect.setBounds(523, 644, 92, 27);
		contentPane.add(btnSelect);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carID=textField.getText().trim();
				Car car=new Car();
				car.setCarID(carID);
				int success=-1;
				CarController carController=new CarController();
				try {
					success=carController.deleteCar(car);
				}catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				if(success == -1)
				{
					JOptionPane.showMessageDialog(null,"Fail To Delete");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Successfully Deleted");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setEnabled(true);
		btnDelete.setBounds(640, 648, 92, 27);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(82, 350, 738, -264);
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 841, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Car Id","Brand","Model","Transmission","Rate Per Hour","Status"}
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
		
		
		JLabel lblNewLabel = new JLabel("UPDATE CAR");
		scrollPane.setColumnHeaderView(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("UPDATE CAR");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 34));
		lblNewLabel_3.setBounds(297, 350, 359, 58);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblbg = new JLabel("");
		lblbg.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bg.jpg"));
		lblbg.setBounds(192, 246, 892, 489);
		contentPane.add(lblbg);
	
	CarController carController = new CarController();
		
		try {
			cars = new ArrayList<>();
			cars = carController.viewAllCar();
			System.out.println(cars.size());
			
			DefaultTableModel temp = (DefaultTableModel) table.getModel();
			
			for(Car car : cars ) {
		    	
		    	Object[] objs = {car.getCarID(), car.getCarBrand(), car.getCarModel(), car.getCarTransmission(), 
		    			car.getHourlyRate(), car.getStatus()};
		    	temp.addRow(objs);			
		    	
		    }	
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}	
}
