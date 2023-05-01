package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import in.quizbook.dao.DatabaseOp;
import in.quizbook.dao.Database_dash;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField ei;
	private JPasswordField pwd;
	public static String USERNAME;
	Border bEi, bPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 680, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("LOGIN");
		title.setOpaque(true);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial Black", Font.BOLD, 33));
		title.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(245, 255, 250), new Color(245, 255, 250)));
		title.setBackground(new Color(0, 0, 139));
		title.setBounds(119, 131, 459, 71);
		contentPane.add(title);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(73, 242, 541, 351);
		contentPane.add(panel);
		
		ei = new JTextField();
		ei.setFont(new Font("Dialog", Font.PLAIN, 18));
		ei.setColumns(10);
		ei.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(0, 0, 205), new Color(0, 0, 205)), "USERNAME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		ei.setBounds(60, 55, 421, 50);
		panel.add(ei);
		 bEi = ei.getBorder();
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("Dialog", Font.PLAIN, 18));
		pwd.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(0, 0, 255), new Color(0, 0, 255)), "PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		pwd.setBounds(60, 143, 421, 50);
		panel.add(pwd);
		 bPwd = pwd.getBorder();
		
		JButton login = new JButton("Login");
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ei.getText().length()==0 || ei.getText().equals("Enter Username")) {
					ei.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "invalid email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				}else { 
					ei.setBorder(bEi);				
				}
									
				//password validation
				if(pwd.getPassword().length==0 || new String(pwd.getPassword()).equals("Enter Password")) {
					pwd.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "invalid password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				}else { 
					pwd.setBorder(bPwd);
				}
				
				if(ei.getBorder()==bEi && pwd.getBorder()==bPwd) {
					DatabaseOp db = new DatabaseOp();
					ResultSet rs = db.selectFromRegistration(ei.getText(), new String(pwd.getPassword()));
					try {
						if(rs.next()) {
							USERNAME = ei.getText();
							JOptionPane.showMessageDialog(null, "LogIn Successfull..!");
							Database_dash dash = new Database_dash();
							dash.insertUserInQuizresults(USERNAME);
							setVisible(false);
							DashBoard.main(null);
						}else {
							ei.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "INVALID USERNAME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
							pwd.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "INVALID PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Arial Black", Font.BOLD, 23));
		login.setBorderPainted(false);
		login.setBackground(new Color(0, 0, 139));
		login.setBounds(71, 262, 407, 50);
		panel.add(login);
		
		JLabel close = new JLabel("New label");
		close.setBounds(647, 10,17, 24);
		contentPane.add(close);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Homepage.main(null);
				setVisible(false);
			}
		});
		ImageIcon icon3=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\close1.png");
		Image vaccIcon3=icon3.getImage();
		Image vaccScale3=vaccIcon3.getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_SMOOTH);
		close.setIcon(new ImageIcon(vaccScale3));
	}

}
