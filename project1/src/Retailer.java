
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Retailer extends JFrame {

	private JPanel contentPane;
	private JTextField retailerID;
	private JTextField name;
	private JTextField address;
	private JTextField Date;
	private JTextField mobile;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retailer frame = new Retailer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Retailer() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 653, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		Color myCol = new Color(240,240,250);
		panel.setBackground(myCol);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblRetailerInformation = new JLabel("RETAILER INFORMATION");
		lblRetailerInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRetailerInformation.setForeground (Color.red);

		lblRetailerInformation.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblRetailerId = new JLabel("Retailer ID");
		lblRetailerId.setFont(new Font("CALIBRI", Font.BOLD, 15));
		
		JLabel lblRetailerName = new JLabel("Name");
		lblRetailerName.setFont(new Font("CALIBRI", Font.BOLD, 15));
		
		JLabel lblAddres = new JLabel("Address");
		lblAddres.setFont(new Font("CALIBRI", Font.BOLD, 15));
		
		retailerID = new JTextField();
		retailerID.setEditable(false);
		retailerID.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("CALIBRI", Font.BOLD, 15));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		
		Date = new JTextField();
		Date.setEditable(false);
		Date.setText(dtf.format(localDate));
		Date.setColumns(10);
		
		JLabel lblMoblineNo = new JLabel("Mobile No.");
		lblMoblineNo.setFont(new Font("CALIBRI", Font.BOLD, 15));
		mobile = new JTextField();
		mobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email-Id");
		lblEmail.setFont(new Font("CALIBRI", Font.BOLD, 15));
		email = new JTextField();
		email.setColumns(10);
		
		File file = new File("RetailerID.txt");
		Scanner inputFile = new Scanner(file);
		String str = "";
		while (inputFile.hasNext())
		{
			str = inputFile.nextLine();
		}
		
		inputFile.close();
		retailerID.setText(str);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnSave.setForeground(Color.RED);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			FileWriter fw = null;
			try {
				fw = new FileWriter("RetailerList.txt",true);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("RetailerID :" + retailerID.getText());
			pw.println("Name :"+name.getText());
			pw.println("Address :"+address.getText());
			pw.println("MObile No. :"+mobile.getText());
			pw.println("Email ID :"+email.getText());
			pw.println("Date :"+Date.getText());
			pw.println();
			pw.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			pw.println();
			
			pw.close();
			
			 FileWriter fw1 = null;
	          try {
				fw1 = new FileWriter("retailerID.txt",true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          PrintWriter orderno = new PrintWriter(fw1);
	          int orderno1 = Integer.parseInt(retailerID.getText());
	          
	          orderno.println(orderno1+1);
	          orderno.close();
	          JOptionPane.showMessageDialog(null,"Retailer Added");
	          Retailer nr = null;
			try {
				nr = new Retailer();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          nr.setVisible(true);
	         
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnClear.setForeground(Color.RED);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				address.setText("");
				mobile.setText("");
				email.setText("");
				name.setText("");
			//	retailerID.setText("");
			}
		});
		
		JButton btnExit = new JButton("Back");
		btnExit.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnExit.setForeground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage db = new HomePage();
				db.setVisible(true);
				setVisible(false);
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(103)
							.addComponent(lblRetailerInformation, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblRetailerId, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(lblRetailerName, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddres, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEmail)
								.addComponent(lblMoblineNo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
											.addComponent(retailerID, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addGap(138)
											.addComponent(lblDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(name, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(Date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(mobile, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(email, Alignment.LEADING)
									.addComponent(address, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addComponent(btnSave)
										.addGap(50)
										.addComponent(btnClear)
										.addGap(50)
										.addComponent(btnExit))))))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblRetailerInformation, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRetailerId)
						.addComponent(retailerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate)
						.addComponent(Date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRetailerName)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddres)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMoblineNo)
						.addComponent(mobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnExit)
						.addComponent(btnClear))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

}

