package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

import java.sql.*;
import java.io.*;
import org.jfree.ui.*;

import controller.CarController;
import model.Car;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.*;
import org.jfree.data.jdbc.JDBCPieDataset;

public class AdminMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 749);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN MENU");
		lblNewLabel.setForeground(new Color(233, 196, 48));
		lblNewLabel.setBackground(new Color(233, 196, 48));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 36));
		lblNewLabel.setBounds(279, 33, 397, 79);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD CAR");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCarMenu frame = new AddCarMenu();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(95, 154, 319, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT UPDATE DELETE");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editCarMenuNew frame = new editCarMenuNew();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(78, 305, 353, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("RENT CAR");
		btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLoanCar frame = new userLoanCar();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_1.setBounds(486, 230, 319, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("RETURN CAR");
		btnNewButton_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnCar frame = new returnCar();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_2.setBounds(95, 230, 319, 48);
		contentPane.add(btnNewButton_1_2);
		
		
		
		JLabel lblbmw = new JLabel("New label");
		lblbmw.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\WhatsApp Image 2023-01-20 at 21.37.56.jpeg"));
		lblbmw.setBounds(133, 389, 788, 323);
		contentPane.add(lblbmw);
		
		JLabel lblbg = new JLabel("");
		lblbg.setIcon(new ImageIcon("C:\\Users\\oni\\Downloads\\Car_Rental (4)\\Car_Rental\\imaj\\28e238d7-2037-4344-8c41-239161c081a1.jpg"));
		lblbg.setBounds(-268, 214, 682, 532);
		contentPane.add(lblbg);
		
		JButton btnReport = new JButton("REPORT");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car car=new Car();
				CarController carController=new CarController();
			
				try
				{
					carController.pieChart(car);
				}catch(ClassNotFoundException|SQLException e1)
				{
					e1.printStackTrace();
				}
			
			}
		});
		btnReport.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnReport.setBounds(486, 154, 319, 48);
		contentPane.add(btnReport);
		
		JButton btnNewButton_1_1_1 = new JButton("LOG OUT");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin frame = new LoginAdmin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		btnNewButton_1_1_1.setBounds(486, 305, 319, 48);
		contentPane.add(btnNewButton_1_1_1);
		
	}
}
