package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdminController;
import controller.CarController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import model.Admin;
import model.Car;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AddCarMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCarID;
	private JTextField txtCarBrand;
	private JTextField txtCarModel;
	private JTextField txtCarTransmission;
	private JTextField txtHour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCarMenu frame = new AddCarMenu();
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
	public AddCarMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD CAR    ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(240, 54, 263, 71);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 37));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Car ID                      :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(53, 173, 177, 20);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Car Brand               :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(53, 221, 177, 20);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Car Model               :");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setBounds(53, 268, 177, 20);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Car Transsmision :");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setBounds(53, 311, 184, 32);
		lblNewLabel_1_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Hourly Rate            :");
		lblNewLabel_1_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_3.setBounds(53, 360, 177, 32);
		lblNewLabel_1_1_3.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1_1_3);
		
		txtCarID = new JTextField();
		txtCarID.setBounds(240, 170, 276, 27);
		contentPane.add(txtCarID);
		txtCarID.setColumns(10);
		
		txtCarBrand = new JTextField();
		txtCarBrand.setBounds(240, 218, 276, 28);
		txtCarBrand.setColumns(10);
		contentPane.add(txtCarBrand);
		
		txtCarModel = new JTextField();
		txtCarModel.setBounds(240, 265, 276, 27);
		txtCarModel.setColumns(10);
		contentPane.add(txtCarModel);
		
		txtCarTransmission = new JTextField();
		txtCarTransmission.setBounds(240, 314, 276, 27);
		txtCarTransmission.setColumns(10);
		contentPane.add(txtCarTransmission);
		
		txtHour = new JTextField();
		txtHour.setBounds(240, 363, 276, 27);
		txtHour.setColumns(10);
		contentPane.add(txtHour);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		btnNewButton.setBounds(187, 443, 115, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin=new Admin();
				String CarID=txtCarID.getText().trim();
				//String adminID=admin.getId();
				String CarBrand=txtCarBrand.getText().trim();
				String CarModel=txtCarModel.getText().trim();
				String CarTransmission=txtCarTransmission.getText().trim();
				double hourlyRate=Double.parseDouble(txtHour.getText());
				
				Car car=new Car();
				
				car.setCarID(CarID);
				//admin.setId(adminID);
				car.setCarBrand(CarBrand);
				car.setCarModel(CarModel);
				car.setCarTransmission(CarTransmission);
				car.setHourlyRate(hourlyRate);
				
				int success=-1;
				CarController carController=new CarController();
				try {
					success=carController.insertCar(car);
					if(success==-1)
					{
						JOptionPane.showMessageDialog(null, "car is already added");
						txtCarID.setText("");
						txtCarBrand.setText("");
						txtCarModel.setText("");
						txtCarTransmission.setText("");
						txtHour.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "car is already added");
						txtCarID.setText("");
						txtCarBrand.setText("");
						txtCarModel.setText("");
						txtCarTransmission.setText("");
						txtHour.setText("");
					}
					
				}catch(ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			
			}}
		});
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bahnschrift", Font.BOLD, 19));
		btnBack.setBounds(378, 443, 101, 37);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu frame=new AdminMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\bg.jpg"));
		lblNewLabel_2.setBounds(0, -2, 702, 561);
		contentPane.add(lblNewLabel_2);
	}
}
