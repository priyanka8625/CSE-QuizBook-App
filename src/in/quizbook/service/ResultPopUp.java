package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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



public class ResultPopUp extends JFrame {

	private JPanel contentPane;
	private JLabel decor;
	static String score="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultPopUp frame = new ResultPopUp("javascipt");
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
	public ResultPopUp(String quizName) {
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 270, 502, 318);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 502, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel pop = new JLabel(new ImageIcon("D:\\eclipse-workspace\\images\\success.gif"));
		pop.setBounds(0, 0, 502, 318);
		
		panel.add(pop);
		
		JLabel ok = new JLabel("Ok");
		pop.add(ok);
		ok.setBackground(Color.WHITE);
		ok.setForeground(new Color(30, 144, 255));
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ok.setForeground(Color.blue);
				decor.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				decor.setForeground(new Color(30, 144, 255));
				ok.setForeground(new Color(30, 144, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				decor.setForeground(new Color(0, 0, 255));
				ok.setForeground(new Color(0, 0, 255));
				setVisible(false);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				decor.setForeground(new Color(153,50,204));
				ok.setForeground(new Color(153,50,204));
			}
		});
		ok.setFont(new Font("Monospaced", Font.PLAIN, 32));
		ok.setBounds(450, 270, 67, 36);
		
	    decor = new JLabel("________");
	    pop.add(decor);
	    decor.setBackground(Color.WHITE);
	    decor.setForeground(new Color(30, 144, 255));
	    decor.setBounds(450, 295, 100, 13);
	    
	    JLabel msg = new JLabel("Test Submitted Successfully !");
	    pop.add(msg);
	    msg.setForeground(Color.BLACK);
	    msg.setFont(new Font("Century Gothic", Font.PLAIN, 20));
	    msg.setBackground(Color.WHITE);
	    msg.setBounds(112, 0, 369, 36);
	    
	    
	    JLabel scoreMsg = new JLabel("Your Score : "+ setScore(quizName));
	    scoreMsg.setForeground(Color.BLACK);
	    scoreMsg.setFont(new Font("Century Gothic", Font.BOLD, 20));
	    scoreMsg.setBackground(Color.WHITE);
	    scoreMsg.setBounds(159, 282, 191, 36);
	    pop.add(scoreMsg);
	}
	public static String setScore(String quizName) {
		Database_dash dash = new Database_dash();
		ResultSet rs = dash.fetchQuizResults(SignIn.USERNAME);
		try {
			if(rs.next()) {
				score = rs.getString(quizName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}
}
