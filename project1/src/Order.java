import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Scrollable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Order extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Order() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 839, 823);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		Color myCol = new Color(240,240,250);
		panel.setBackground(myCol);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setFont(new Font("CALIBRI", Font.BOLD, 14));
		
		File file = new File("OrderID.txt");
		Scanner inputFile = new Scanner(file);
		String str = "";
		while (inputFile.hasNext())
		{
			str = inputFile.nextLine();
		}
		int orderCount = Integer.parseInt(str);
		
		orderCount += 1;
		inputFile.close();
	
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setText(str);
		
		JLabel lblRetailerId = new JLabel("Customer Name");
		lblRetailerId.setFont(new Font("CALIBRI", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setText(dtf.format(localDate));
		

		DefaultListModel model = new DefaultListModel();
		JList list_1 = new JList(model);
		
		File file1 = new File("ItemList.txt");
		Scanner inputFile1 = new Scanner(file1);
		String str1 = "";
		String arr11[] = new String[1000];
		int wi=0;
		while (inputFile1.hasNext())
		{
			str1 = inputFile1.nextLine();
			arr11[wi] = str1;
			wi = wi + 1;
		}
		JList list = new JList(arr11);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
		btnAdd.setBackground(Color.white);
		btnAdd.setForeground(Color.RED);
		btnAdd.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("ADD")) {
	            int index = list.getSelectedIndex();
	            String s = (String)list.getSelectedValue();
	            String[] s1 = s.split("@");
	           
	            model.add(0,s);
	            String amount1 = textField_8.getText();
	            
	            int amount = Integer.parseInt(s1[1]);
	            int amount2 = Integer.parseInt(amount1);
	            amount += amount2;
	            amount1 = Integer.toString(amount);
	            textField_8.setText(amount1);
		
			}
			}
		});
		double disc,amoun;
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
		btnRemove.setBackground(Color.white);
		btnRemove.setForeground(Color.RED);
		btnRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("REMOVE")) {
		            int index = list_1.getSelectedIndex();
		            String s = (String)list_1.getSelectedValue();
		            String[] s1 = s.split("@");
		            model.remove(index);
		            String amount1 = textField_8.getText();
		            
		            int amount = Integer.parseInt(s1[1]);
		            int amount2 = Integer.parseInt(amount1);
		            amount2 -= amount;
		            amount1 = Integer.toString(amount2);
		            textField_8.setText(amount1);
		
				}
				}
			});
		
		JLabel lblNewLabel = new JLabel("List of Items");
		lblNewLabel.setFont(new Font("CALIBRI", Font.BOLD, 14));	
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new java.awt.Font("Arial", Font.BOLD, 15));
		btnOk.setBackground(Color.white);
		btnOk.setForeground(Color.RED);
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//if (e.getActionCommand().equals("OK")) {
				String ds = textField.getText();
				PrintWriter orderid = null;
				try {
					orderid = new PrintWriter(ds+".txt");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
		          orderid.println("Date : "+ textField_2.getText());
		          orderid.println("Order Number : "+ textField.getText());
		          orderid.println("Customer Name : "+ textField_1.getText());
		          orderid.println("Customer Address : "+ textField_4.getText());
		          orderid.println("Customer Contact No. : "+ textField_5.getText());
		          orderid.println("Customer Email ID : "+ textField_6.getText());
		          orderid.println("Amount : "+ textField_8.getText());
		         // orderid.println("Total : "+ textField_8.getText());
		          orderid.println();
		          orderid.println("----------------------------------------------------------------------");
		          String[] myArray = new String[100];
		          orderid.println("Items Purchased By You");
		          orderid.println();
		          orderid.print("Items Name\t\t\t");
		          orderid.println("Rate");
		          orderid.println();
		          for (int i = 0; i < list_1.getModel().getSize(); i++) {
	                   myArray[i] = String.valueOf(list_1.getModel().getElementAt(i));
	                   String s = myArray[i];
	                   String[] s1 = s.split("@");
	                   orderid.print(s1[0]);
	                   int i1 = s1[0].length();
	                   int i2 = 34 - i1;
	                   for (int i3=2;i3<i2;i3++)
	                   {
	                	   orderid.print(" ");
	                   }
	                   orderid.println(s1[1]);
	              }
		          orderid.println();
		          orderid.close();
		          
		          
		          FileWriter fw1 = null;
		          try {
					fw1 = new FileWriter("OrderID.txt",true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		          PrintWriter orderno = new PrintWriter(fw1);
		          int orderno1 = Integer.parseInt(textField.getText());
		          
		          orderno.println(orderno1+1);
		          orderno.close();
		          JOptionPane.showMessageDialog(null,"Product Ordered");
		          HomePage db = new HomePage();
					db.setVisible(true);
					setVisible(false);
		          
		          
		          
			//	}
				}
			});
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("CALIBRI", Font.BOLD, 14));	
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contact No.");
		lblNewLabel_1.setFont(new Font("CALIBRI", Font.BOLD, 14));	

		
		JLabel lblNewLabel_2 = new JLabel("Email ID");
		lblNewLabel_2.setFont(new Font("CALIBRI", Font.BOLD, 14));	

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setFont(new Font("CALIBRI", Font.BOLD, 14));	

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setText("0");
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new java.awt.Font("Arial", Font.BOLD,15));
		btnCancel.setBackground(Color.white);
		btnCancel.setForeground(Color.RED);
		btnCancel.addActionListener(new ActionListener(){
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
					.addContainerGap()
					.addComponent(lblAddress)
					.addContainerGap(753, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(69)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(655, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnAdd)
									.addGap(66))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnRemove)
									.addGap(53)))
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRetailerId)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
											.addComponent(lblDate)
											.addGap(29)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_4, 402, 402, 402)))
								.addComponent(lblOrderId, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
					.addGap(67)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addComponent(btnOk)
							.addGap(42))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(39)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(16, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrderId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRetailerId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAddress)
							.addGap(29)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))))
					.addGap(52)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(28)
							.addComponent(btnRemove)
							.addGap(318))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
									.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(0)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk)
								.addComponent(btnCancel))
							.addGap(24))))
		);
		
		
		panel.setLayout(gl_panel);
	}


}
