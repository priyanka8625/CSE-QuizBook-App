package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1140, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(548, 0, 592, 738);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(10, 234, 572, 401);
		panel.add(img1);
		ImageIcon icon1=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\hp1.png");
		Image vaccIcon1=icon1.getImage();
		Image vaccScale1=vaccIcon1.getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
		img1.setIcon(new ImageIcon(vaccScale1));
		
		JButton signin = new JButton("SignIn");
		signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn.main(null);
				setVisible(false);
			}
		});
		signin.setForeground(new Color(255, 255, 255));
		signin.setBorderPainted(false);
		signin.setFont(new Font("Arial Black", Font.BOLD, 25));
		signin.setBackground(new Color(0, 0, 139));
		signin.setBounds(396, 121, 145, 59);
		panel.add(signin);
		
		JButton signup = new JButton("SignUp");
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp.main(null);
				setVisible(false);
			}
		});
		signup.setForeground(Color.WHITE);
		signup.setFont(new Font("Arial Black", Font.BOLD, 25));
		signup.setBorderPainted(false);
		signup.setBackground(new Color(0, 0, 139));
		signup.setBounds(226, 121, 145, 59);
		panel.add(signup);
		
		
		JLabel title = new JLabel("CSE ");
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(44, 45, 87, 64);
		contentPane.add(title);
		title.setFont(new Font("Segoe Print", Font.BOLD, 36));
		
		JLabel lblQuizbook = new JLabel("QuizBook");
		lblQuizbook.setForeground(new Color(255, 255, 255));
		lblQuizbook.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblQuizbook.setBounds(103, 96, 242, 64);
		contentPane.add(lblQuizbook);
		
		JLabel lblApplication = new JLabel("Application");
		lblApplication.setForeground(new Color(255, 255, 255));
		lblApplication.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblApplication.setBounds(278, 150, 206, 64);
		contentPane.add(lblApplication);
		
		JLabel lblNewLabel_2 = new JLabel("_________________________");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_2.setBounds(10, 193, 540, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel img2 = new JLabel("");
		img2.setBounds(147, 259, 230, 110);
		contentPane.add(img2);
		ImageIcon icon2=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\rise.png");
		Image vaccIcon2=icon2.getImage();
		Image vaccScale2=vaccIcon2.getScaledInstance(img2.getWidth(), img2.getHeight(), Image.SCALE_SMOOTH);
		img2.setIcon(new ImageIcon(vaccScale2));
		
		JLabel close = new JLabel("New label");
		close.setBounds(565, 10, 17, 24);
		panel.add(close);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "CSE QuizBook app",JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      dispose();
				    }
			}
		});
		ImageIcon icon3=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\close1.png");
		Image vaccIcon3=icon3.getImage();
		Image vaccScale3=vaccIcon3.getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_SMOOTH);
		close.setIcon(new ImageIcon(vaccScale3));
	}
}
