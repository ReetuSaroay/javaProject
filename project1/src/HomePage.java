
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Window;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.JMenuBar;
	import javax.swing.JMenu;
	import javax.swing.JMenuItem;
	import java.awt.event.ActionListener;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.awt.event.ActionEvent;
	import javax.swing.JLabel;
	import java.awt.Font;

	public class HomePage extends JFrame {

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						HomePage frame = new HomePage();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}}
			});
		}
		public HomePage() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 620, 418);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnNew = new JMenu("Create");
			menuBar.add(mnNew);
			
			JMenuItem mntmRetailer = new JMenuItem("Add New Retailer");
			mntmRetailer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				Retailer nw = null;
				try {
					nw = new Retailer();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.setVisible(true);
				setVisible(false);
				
				}
			});
			mnNew.add(mntmRetailer);
			
			JMenuItem mntmProduct = new JMenuItem("Add New Product");
			mntmProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				Product np = null;
				try {
					np = new Product();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				np.setVisible(true);
				}
			});
			mnNew.add(mntmProduct);
			
			JMenuItem mntmOrder_1 = new JMenuItem("Create New Order");
			mntmOrder_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Order no =null;
			try {
				
				
		no = new Order();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				setVisible(false);
				no.setVisible(true);
				
				}
			});
			mnNew.add(mntmOrder_1);
			
			JMenu mnView = new JMenu("Display");
			menuBar.add(mnView);
			
			JMenuItem mntmRetailer_1 = new JMenuItem("Show Retailer Info");
			mntmRetailer_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRetailer vr = null;
					try {
						vr = new ViewRetailer();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vr.setVisible(true);
					setVisible(false);
				}
			});
			mnView.add(mntmRetailer_1);
			
			JMenuItem mntmProduct_1 = new JMenuItem("Show Product Info");
			mntmProduct_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewProduct vp = null;
					try {
						vp = new ViewProduct();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					vp.setVisible(true);
					setVisible(false);
				}
			});
			mnView.add(mntmProduct_1);
			
			JMenuItem mntmOrder = new JMenuItem("Show Order Info");
			mntmOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewOrder vo = null;
					try {
						vo = new ViewOrder();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vo.setVisible(true);
					setVisible(false);
				}
			});
			mnView.add(mntmOrder);
			
			JMenu mnExit = new JMenu("Close App");
			menuBar.add(mnExit);
			
			JMenuItem mntmQuit = new JMenuItem("Quit");
			mntmQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			mnExit.add(mntmQuit);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel panel = new JPanel();
			Color myCol = new Color(240,240,250);
			panel.setBackground(myCol);
			contentPane.add(panel, BorderLayout.CENTER);
			
			JLabel lblWelcome = new JLabel("GOLDRUSH INVENTORY MANAGEMENT SYSTEM");
			lblWelcome.setFont(new Font("CALIBRI", Font.BOLD, 27));
			lblWelcome.setForeground (Color.red);

			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.CENTER)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(22)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.CENTER)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(65)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(78, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
	}

