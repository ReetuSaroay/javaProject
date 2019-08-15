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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Font;

public class ViewRetailer extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterBetween;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRetailer frame = new ViewRetailer();
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
	public ViewRetailer() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color myCol = new Color(240,240,250);
		contentPane.setBackground(myCol);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Retailer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground (Color.black);
		
		
		
		txtEnterBetween = new JTextField();
		txtEnterBetween.setColumns(10);
		
		
		File fw = new File("RetailerID.txt");
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
			txtEnterBetween.setText("No Product to show");
		}
		else
		txtEnterBetween.setText("Enter between 1 to "+ s2);
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
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
				File file1 = new File("RetailerList.txt");
				Scanner inputFile1 = null;
				try {
					inputFile1 = new Scanner(file1);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String str1 = "";
				String arr11[] = new String[1000];
				int wi=0;
				String str2 = txtEnterBetween.getText() ;
				while (inputFile1.hasNext())
				{
					str1 = inputFile1.nextLine();
					arr11[wi] = str1;
					
					wi = wi + 1;
				}
				int num3 = Integer.parseInt(str2);
				if(num3*9<=wi+1)
				{
					num3 -= 1;
					num3 = num3*9;
					for(int k=0;k<6;k++)
					{
						System.out.println(arr11[num3+k]);
					}
				}
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.white);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage db = new HomePage();
				db.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel lblViewRetailer = new JLabel("VIEW RETAILER");
		lblViewRetailer.setOpaque(true);
		lblViewRetailer.setFont(new Font("CALIBRI", Font.BOLD,25));
		lblViewRetailer.setBackground(Color.white);
		lblViewRetailer.setForeground(Color.RED);
		lblViewRetailer.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(124)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(114))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addComponent(lblNewLabel)
					.addGap(45)
					.addComponent(txtEnterBetween, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(lblViewRetailer)
					.addGap(133))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblViewRetailer)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtEnterBetween, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

