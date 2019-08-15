import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.*;
import java.io.IOException;
import java.io.*;
import javax.imageio.*;

public class Login extends JFrame {

	private JPanel loginContentPanel;
	private JTextField userIDTextField;
	private JPasswordField keyPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 882, 613);
		loginContentPanel = new JPanel();
		loginContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginContentPanel.setLayout(new BorderLayout(0, 0));
		//loginContentPanel.setBackground(Color.blue);
		setContentPane(loginContentPanel);
		
		JPanel panel = new JPanel();
		//Color myCol = new Color(20, 0, 0);
		Color myCol = new Color(240,240,250);
		panel.setBackground(myCol);
		loginContentPanel.add(panel, BorderLayout.CENTER);
		
		JLabel lblInventoryManagementSystem = new JLabel("GOLDRUSH INVENTORY MANAGEMENT SYSTEM");
		lblInventoryManagementSystem.setOpaque(true);
		lblInventoryManagementSystem.setBackground(Color.WHITE);
		lblInventoryManagementSystem.setForeground (Color.red);
		lblInventoryManagementSystem.setFont(new Font("CALIBRI", Font.BOLD, 40));
		lblInventoryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbluserIDTextField = new JLabel("USER ID");
		lbluserIDTextField.setForeground (Color.red);
		lbluserIDTextField.setFont(new Font("CALIBRI", Font.BOLD, 20));
		userIDTextField = new JTextField();
		userIDTextField.setColumns(10);
		
		JLabel lblkeyPasswordFieldword = new JLabel("PASSWORD");
		lblkeyPasswordFieldword.setFont(new Font("CALIBRI", Font.BOLD, 20));
		lblkeyPasswordFieldword.setForeground (Color.red);
		lblkeyPasswordFieldword.setBackground(Color.BLUE);
		keyPasswordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnLogin.setBackground(Color.white);
		btnLogin.setForeground(Color.RED);
        btnLogin.setSize(1000,00);
		btnLogin.addActionListener(new ActionListener() {
			
			
	public void actionPerformed(ActionEvent arg0) {
	
	if(userIDTextField.getText().equals("user") && keyPasswordField.getText().equals("pass"))
	{
		HomePage db = new HomePage();
		db.setVisible(true);
		setVisible(false);
	}
	else
	{
		JOptionPane.showMessageDialog(null,"Incorrect username or keyPasswordFieldword");
	}
	
	}
		}
		);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnClear.setBackground(Color.white);
		btnClear.setForeground(Color.RED);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			userIDTextField.setText("");
			keyPasswordField.setText("");
			
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
		btnExit.setBackground(Color.white);
		btnExit.setForeground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			System.exit(0);
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblInventoryManagementSystem, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(70)
							.addComponent(lbluserIDTextField, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(70)
							.addComponent(lblkeyPasswordFieldword, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(130)
							.addComponent(btnLogin)))
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnClear)
							.addGap(40)
							.addComponent(btnExit))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(keyPasswordField)
							.addComponent(userIDTextField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInventoryManagementSystem, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbluserIDTextField)
						.addComponent(userIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblkeyPasswordFieldword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(keyPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnClear)
						.addComponent(btnExit))
					.addContainerGap(46, Short.MAX_VALUE))
		);
	
		panel.setLayout(gl_panel);
	}

}
