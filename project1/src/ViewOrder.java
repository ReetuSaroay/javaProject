import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ViewOrder extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterBetween;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrder frame = new ViewOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewOrder() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 519, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color myCol = new Color(240,240,250);
		contentPane.setBackground(myCol);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Order ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground (Color.black);
		txtEnterBetween = new JTextField();
	//	txtEnterBetween.setText("Enter Between 1 to 100");
		txtEnterBetween.setColumns(10);
		File fw = new File("OrderID.txt");
		Scanner fw1 = new Scanner(fw);
		String s1 = null ;
		while(fw1.hasNext())
		{
			s1 = fw1.nextLine();
		}
		int s2 = Integer.parseInt(s1);
		s2 = s2 - 1;
		if(s2==0)
		{
			txtEnterBetween.setText("No Order to show");
		}
		else
		txtEnterBetween.setText("Enter Between 1 to "+s2);
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(Color.white);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtEnterBetween.getText().contentEquals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter Correct ID");
				}
				else
				{
					String num = txtEnterBetween.getText();
					int num1 = Integer.parseInt(num);
				File file1 = new File(num1+".txt");
				Scanner inputFile1 = null;
				try {
					inputFile1 = new Scanner(file1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (inputFile1.hasNext())
				{
					System.out.println(inputFile1.nextLine());
				}
				
					
				}
				}
			
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.white);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage db = new HomePage();
				db.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel lblViewOrder = new JLabel("VIEW ORDER");
		lblViewOrder.setOpaque(true);
		Dimension size = lblViewOrder.getPreferredSize();
		lblViewOrder.setBounds(200, 200, size.width, size.height);
		lblViewOrder.setFont(new Font("CALIBRI", Font.BOLD, 30));
		lblViewOrder.setForeground(Color.red);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(135)
							.addComponent(btnNewButton)
							.addGap(98)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(lblNewLabel)
							.addGap(45)
							.addComponent(txtEnterBetween, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(183)
							.addComponent(lblViewOrder)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(lblViewOrder)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtEnterBetween, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
