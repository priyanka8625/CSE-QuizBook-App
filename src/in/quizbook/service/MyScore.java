package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import in.quizbook.dao.Database_dash;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Component;

public class MyScore extends JFrame {

	private JPanel contentPane;
	static JLabel title,cScoreLbl,cppScoreLbl,javaScoreLbl,jsScoreLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyScore frame = new MyScore();
					frame.setVisible(true);
					frame.setScores();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyScore() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1140, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel close = new JLabel("New label");
		close.setBounds(1107, 10, 23, 30);
		contentPane.add(close);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DashBoard.main(null);
				dispose();
			}
		});
		ImageIcon icon3=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\close.png");
		Image vaccIcon3=icon3.getImage();
		Image vaccScale3=vaccIcon3.getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_SMOOTH);
		close.setIcon(new ImageIcon(vaccScale3));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(117, 88, 931, 605);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel profileLbl = new JLabel("");
		profileLbl.setBounds(85, 39, 97, 135);
		ImageIcon icon4=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\star.png");
		Image vaccIcon4=icon4.getImage();
		Image vaccScale4=vaccIcon4.getScaledInstance(profileLbl.getWidth(), profileLbl.getHeight(), Image.SCALE_SMOOTH);
		profileLbl.setIcon(new ImageIcon(vaccScale4));
		panel.add(profileLbl);
		
		title = new JLabel("Hello,");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setFont(new Font("Ubuntu", Font.BOLD, 36));
		title.setBounds(192, 53, 707, 82);
		panel.add(title);
		
		JPanel cPane = new JPanel();
		cPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		cPane.setBackground(new Color(230, 230, 250));
		cPane.setBounds(300, 202, 362, 71);
		panel.add(cPane);
		
		JPanel cppPane = new JPanel();
		cppPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		cppPane.setBackground(new Color(230, 230, 250));
		cppPane.setBounds(300, 294, 362, 71);
		panel.add(cppPane);
		
		JPanel javaPane = new JPanel();
		javaPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		javaPane.setBackground(new Color(230, 230, 250));
		javaPane.setBounds(300, 387, 362, 71);
		panel.add(javaPane);
		
		JPanel jsPane = new JPanel();
		jsPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		jsPane.setBackground(new Color(230, 230, 250));
		jsPane.setBounds(300, 481, 362, 71);
		panel.add(jsPane);
		cPane.setLayout(null);
		
		cScoreLbl = new JLabel("");
		cScoreLbl.setFont(new Font("Segoe Print", Font.BOLD, 25));
		cScoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cScoreLbl.setBounds(82, 10, 212, 51);
		cPane.add(cScoreLbl);
		ImageIcon cLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\c.png");
		Image cLblIcon1=cLblIcon.getImage();
		ImageIcon cppLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\cpp.png");
		Image cppLblIcon1=cppLblIcon.getImage();
		cppPane.setLayout(null);
		
		cppScoreLbl = new JLabel("");
		cppScoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cppScoreLbl.setFont(new Font("Segoe Print", Font.BOLD, 25));
		cppScoreLbl.setBounds(81, 10, 212, 51);
		cppPane.add(cppScoreLbl);
		ImageIcon jLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\java.png");
		Image jLblIcon1=jLblIcon.getImage();
		javaPane.setLayout(null);
		
		javaScoreLbl = new JLabel("");
		javaScoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		javaScoreLbl.setFont(new Font("Segoe Print", Font.BOLD, 25));
		javaScoreLbl.setBounds(76, 10, 212, 51);
		javaPane.add(javaScoreLbl);
		ImageIcon jsLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\js.png");
		Image jsLblIcon1=jsLblIcon.getImage();
		jsPane.setLayout(null);
		
		jsScoreLbl = new JLabel("");
		jsScoreLbl.setHorizontalAlignment(SwingConstants.CENTER);
		jsScoreLbl.setFont(new Font("Segoe Print", Font.BOLD, 25));
		jsScoreLbl.setBounds(75, 10, 212, 51);
		jsPane.add(jsScoreLbl);
		
		JLabel cIcon = new JLabel("");
		cIcon.setBounds(238, 212, 39, 44);
		panel.add(cIcon);
		Image cLblScale=cLblIcon1.getScaledInstance(cIcon.getWidth(), cIcon.getHeight(), Image.SCALE_SMOOTH);
		cIcon.setIcon(new ImageIcon(cLblScale));
		
		JLabel cppIcon = new JLabel("");
		cppIcon.setBounds(239, 306, 38, 44);
		panel.add(cppIcon);
		Image cppLblScale=cppLblIcon1.getScaledInstance(cppIcon.getWidth(), cppIcon.getHeight(), Image.SCALE_SMOOTH);
		cppIcon.setIcon(new ImageIcon(cppLblScale));
		
		JLabel jIcon = new JLabel("");
		jIcon.setBounds(228, 398, 49, 44);
		panel.add(jIcon);
		Image jLblScale=jLblIcon1.getScaledInstance(jIcon.getWidth(), jIcon.getHeight(), Image.SCALE_SMOOTH);
		jIcon.setIcon(new ImageIcon(jLblScale));
		
		JLabel jsIcon = new JLabel("");
		jsIcon.setBounds(227, 491, 50, 44);
		panel.add(jsIcon);
		Image jsLblScale=jsLblIcon1.getScaledInstance(jsIcon.getWidth(), jsIcon.getHeight(), Image.SCALE_SMOOTH);
		jsIcon.setIcon(new ImageIcon(jsLblScale));
		
		JPanel cPane_1 = new JPanel();
		cPane_1.setBounds(310, 213, 362, 71);
		panel.add(cPane_1);
		cPane_1.setLayout(null);
		cPane_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		cPane_1.setBackground(new Color(65, 105, 225));
		
		JLabel cScoreLbl_1 = new JLabel("");
		cScoreLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		cScoreLbl_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		cScoreLbl_1.setBounds(82, 10, 212, 51);
		cPane_1.add(cScoreLbl_1);
		
		JPanel cPane_1_1 = new JPanel();
		cPane_1_1.setBounds(310, 306, 362, 71);
		panel.add(cPane_1_1);
		cPane_1_1.setLayout(null);
		cPane_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		cPane_1_1.setBackground(new Color(65, 105, 225));
		
		JLabel cScoreLbl_1_1 = new JLabel("");
		cScoreLbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		cScoreLbl_1_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		cScoreLbl_1_1.setBounds(82, 10, 212, 51);
		cPane_1_1.add(cScoreLbl_1_1);
		
		JPanel cPane_1_2 = new JPanel();
		cPane_1_2.setBounds(310, 400, 362, 71);
		panel.add(cPane_1_2);
		cPane_1_2.setLayout(null);
		cPane_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		cPane_1_2.setBackground(new Color(65, 105, 225));
		
		JLabel cScoreLbl_1_2 = new JLabel("");
		cScoreLbl_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		cScoreLbl_1_2.setFont(new Font("Segoe Print", Font.BOLD, 25));
		cScoreLbl_1_2.setBounds(82, 10, 212, 51);
		cPane_1_2.add(cScoreLbl_1_2);
		
		JPanel cPane_1_3 = new JPanel();
		cPane_1_3.setBounds(310, 491, 362, 71);
		panel.add(cPane_1_3);
		cPane_1_3.setLayout(null);
		cPane_1_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 139), new Color(0, 0, 139), new Color(65, 105, 225), new Color(65, 105, 225)));
		cPane_1_3.setBackground(new Color(65, 105, 225));
		
		JLabel cScoreLbl_1_3 = new JLabel("");
		cScoreLbl_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		cScoreLbl_1_3.setFont(new Font("Segoe Print", Font.BOLD, 25));
		cScoreLbl_1_3.setBounds(82, 10, 212, 51);
		cPane_1_3.add(cScoreLbl_1_3);
		
		JLabel decor = new JLabel("________________");
		decor.setForeground(new Color(0, 0, 139));
		decor.setFont(new Font("Bookman Old Style", Font.BOLD, 48));
		decor.setBounds(259, 102, 384, 58);
		panel.add(decor);
	}
	public void setScores() {
		Database_dash dash = new Database_dash();
		ResultSet r1 = dash.fetchReg(SignIn.USERNAME);
		try {
			if(r1.next()) {
				ResultSet r2 = dash.fetchQuizResults(SignIn.USERNAME);
				if(r2.next()) {
					if(r2.getString("c").equals("")) {
						cScoreLbl.setText("-");
					}else {
						cScoreLbl.setText(r2.getString("c"));
					}
					if(r2.getString("cpp").equals("")) {
						cppScoreLbl.setText("-");
					}else {
						cppScoreLbl.setText(r2.getString("cpp"));
					}
					if(r2.getString("java").equals("")) {
						javaScoreLbl.setText("-");
					}else {
						javaScoreLbl.setText(r2.getString("java"));
					}
					if(r2.getString("javascipt").equals("")) {
						jsScoreLbl.setText("-");
					}else {
						jsScoreLbl.setText(r2.getString("javascipt"));
					}
					title.setText("Hello, "+r1.getString("name"));
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
