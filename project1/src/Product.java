
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

public class Product extends JFrame {

	private JPanel contentPane;
	private JTextField proID;
	private JTextField proDesc;
	private JTextField warranty;
	private JTextField unitprice;
	private JTextField quantity;
	private JTextField Date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
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
	public Product() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		Color myCol = new Color(240,240,250);
		panel.setBackground(myCol);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblProductInformation = new JLabel("PRODUCT INFORMATION");
		lblProductInformation.setOpaque(true);
		lblProductInformation.setBackground(Color.WHITE);
		lblProductInformation.setForeground (Color.red);
		lblProductInformation.setFont(new Font("CALIBRI", Font.BOLD, 40));
		lblProductInformation.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 12));
		proID = new JTextField();
		proID.setEditable(false);
		proID.setColumns(10);
		File file = new File("ProductID.txt");
		Scanner inputFile = new Scanner(file);
		String str = "";
		while (inputFile.hasNext())
		{
			str = inputFile.nextLine();
		}
		
		inputFile.close();
		proID.setText(str);
		
		JLabel lblProDesc = new JLabel("Pro Desc");
		lblProDesc.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		proDesc = new JTextField();
		proDesc.setColumns(10);
		
		JLabel lblWarranty = new JLabel("Warranty");
		lblWarranty.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		warranty = new JTextField();
		warranty.setColumns(10);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		unitprice = new JTextField();
		unitprice.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		quantity = new JTextField();
		quantity.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnSave.setBackground(Color.white);
		btnSave.setForeground(Color.RED);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			FileWriter fw = null;
			FileWriter il = null;
			try {
				il = new FileWriter("ItemList.txt",true);
				fw = new FileWriter("ProductList.txt",true);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			PrintWriter pw= null;
			PrintWriter ilw = null;
			
			ilw = new PrintWriter(il);
			pw = new PrintWriter(fw);
			
			ilw.println(proDesc.getText()+"@"+unitprice.getText());
			ilw.close();
			pw.println("Product ID :"+proID.getText());
			pw.println("Product Name :"+proDesc.getText());
			pw.println("Warranty :"+warranty.getText());
			pw.println("Unit Price :"+unitprice.getText());
			pw.println("Quantity :"+quantity.getText());
			pw.println("Date :"+Date.getText());
			pw.println();
			pw.println("--------------------------------------------------");
			pw.println();
			pw.close();
			 FileWriter fw1 = null;
	          try {
				fw1 = new FileWriter("ProductID.txt",true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          PrintWriter orderno = new PrintWriter(fw1);
	          int orderno1 = Integer.parseInt(proID.getText());
	          
	          orderno.println(orderno1+1);
	          orderno.close();
	          JOptionPane.showMessageDialog(null,"Product Added");
	          Product np = null;
			try {
				np = new Product();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          np.setVisible(true);
	          
			
			}
		});
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		Date = new JTextField();
		Date.setEditable(false);
		Date.setText(dtf.format(localDate));
		Date.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnClear.setBackground(Color.white);
		btnClear.setForeground(Color.RED);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//	proID.setText("");
			proDesc.setText("");
			warranty.setText("");
			unitprice.setText("");
			quantity.setText("");
			
			}
		});
		
		
		JButton btnQuit = new JButton("Back");
		btnQuit.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnQuit.setBackground(Color.white);
		btnQuit.setForeground(Color.RED);
		btnQuit.addActionListener(new ActionListener() {
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
							.addGap(3)
							.addComponent(lblProductInformation, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblProDesc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblProductId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
								.addComponent(lblWarranty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblQuantity, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(warranty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(29)
										.addComponent(lblUnitPrice, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(unitprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(proID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(40)
										.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(proDesc))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(68)
							.addComponent(btnSave)
							.addGap(81)
							.addComponent(btnClear)
							.addGap(77)
							.addComponent(btnQuit)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(lblProductInformation, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductId)
						.addComponent(proID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate)
						.addComponent(Date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProDesc)
						.addComponent(proDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWarranty)
						.addComponent(warranty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUnitPrice)
						.addComponent(unitprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnClear)
						.addComponent(btnQuit))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

}
