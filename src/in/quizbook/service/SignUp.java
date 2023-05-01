package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import in.quizbook.dao.DatabaseOp;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField ei;
	private JPasswordField pwd1;
	private JPasswordField pwd2;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String CAPITAL = "^[^A-Z]";
	private static final String SMALL = "^[^a-z]";
	private static final String NUMBERS = "^[^0-9]";
	
	private static final String PWD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
	Border bName, bEi, bPwd1, bPwd2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setUndecorated(true);
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 680, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(59, 215, 558, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		name = new JTextField();
		name.setFont(new Font("Dialog", Font.PLAIN, 18));
		name.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(0, 0, 205), new Color(0, 0, 205)), "NAME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		name.setBounds(43, 29, 476, 50);
		panel.add(name);
		 bName = name.getBorder();
		
		ei = new JTextField();
		ei.setFont(new Font("Dialog", Font.PLAIN, 18));
		ei.setColumns(10);
		ei.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(0, 0, 205), new Color(0, 0, 205)), "E-MAIL ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		ei.setBounds(43, 106, 476, 50);
		panel.add(ei);
		 bEi = ei.getBorder();
		
		pwd1 = new JPasswordField();
		pwd1.setFont(new Font("Dialog", Font.PLAIN, 18));
		pwd1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(0, 0, 255), new Color(0, 0, 255)), "CREATE PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		pwd1.setBounds(43, 189, 476, 50);
		panel.add(pwd1);
		 bPwd1 = pwd1.getBorder();
		
		pwd2 = new JPasswordField();
		pwd2.setFont(new Font("Dialog", Font.PLAIN, 18));
		pwd2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(0, 0, 255), new Color(0, 0, 255)), "CONFIRM PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		pwd2.setBounds(43, 263, 476, 50);
		panel.add(pwd2);
		 bPwd2 = pwd2.getBorder();
		
		JButton submit = new JButton("SUBMIT");
		submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// name validation
				if(name.getText().equals("")|| name.getText().isBlank()) {
					name.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "enter name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				}else {
					name.setBorder(bName);
				}
				//email validation
				if(!ei.getText().matches(EMAIL_PATTERN) || ei.getText().length()==0) {
					ei.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "invalid email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				}else { 
					ei.setBorder(bEi);
				}
				//create pwd validation
				String password = new String (pwd1.getPassword());
				if(!password.matches(PWD)) {
					char ch;
				    boolean capitalFlag = false;
				    boolean lowerCaseFlag = false;
				    boolean numberFlag = false;
				    for(int i=0; i < password.length();i++) {
				        ch = password.charAt(i);
				        if( Character.isDigit(ch)) {
				            numberFlag = true;
				        }else if (Character.isUpperCase(ch)) {
				            capitalFlag = true;
				        }else if (Character.isLowerCase(ch)) {
				            lowerCaseFlag = true;
				        }   
				    }
				    if(password.length()==0) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "enter password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    }
				    else if(numberFlag == false) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "atleast one number is required", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    }else if(capitalFlag == false) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "atleast one capital letter required", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    }else if(lowerCaseFlag == false) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "atleast one small letter required", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    } else if(password.length() <=8) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "password must be greater than 8 characters", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    } else if(numberFlag == false && capitalFlag == false) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "password should contain number and capital letters", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    }else if (capitalFlag == false && lowerCaseFlag == false) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "password should contain lower and capital letters", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    }else if (lowerCaseFlag == false && numberFlag == false) {
						pwd1.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "password should contain lower letters and number", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				    }
					
				}else { 
					pwd1.setBorder(bPwd1);
				}
				//confirm pwd validation
				if(!(new String(pwd2.getPassword()) ).equals(new String(pwd1.getPassword()) ) || new String(pwd2.getPassword()).equals("")) {
					pwd2.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "invalid password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				}else { 
					pwd2.setBorder(bPwd2);
				}
				
				if(name.getBorder() == bName && ei.getBorder()==bEi && pwd1.getBorder()==bPwd1 && pwd2.getBorder()==bPwd2) {
					ArrayList al = new ArrayList();
					al.add(name.getText());
					al.add(ei.getText());
					al.add(new String(pwd1.getPassword()));
					int rows=0;
					try {
						DatabaseOp db = new DatabaseOp();
						rows = db.insertIntoRegistration(al);  //throws exception due to duplicate email ids 
						if(rows > 0 ) {
							JOptionPane.showMessageDialog(null, "Account created successfully..!");
							SignIn.main(null);
							setVisible(false);
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Account already exists..!\nPlease do SignIn !");
						SignIn.main(null);
						setVisible(false);
					}
				}
			}
		});
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("Arial Black", Font.BOLD, 23));
		submit.setBorderPainted(false);
		submit.setBackground(new Color(0, 0, 139));
		submit.setBounds(74, 361, 407, 50);
		panel.add(submit);
		
		JLabel title = new JLabel("Create An Account");
		title.setOpaque(true);
		title.setBackground(new Color(0, 0, 139));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Arial Black", Font.BOLD, 32));
		title.setBounds(121, 99, 459, 66);
		contentPane.add(title);
		
		JLabel close = new JLabel("New label");
		close.setBounds(653, 10, 17, 24);
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
