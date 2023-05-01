package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class CppQuiz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CppQuiz frame = new CppQuiz();
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
	public CppQuiz() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1140, 738);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
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
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(230, 230, 250), new Color(230, 230, 250), new Color(230, 230, 250), new Color(230, 230, 250)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(112, 151, 943, 534);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrTheTestContains = new JTextArea();
		txtrTheTestContains.setOpaque(false);
		txtrTheTestContains.setEditable(false);
		txtrTheTestContains.setWrapStyleWord(true);
		txtrTheTestContains.setLineWrap(true);
		txtrTheTestContains.setFont(new Font("Montserrat", Font.PLAIN, 18));
		txtrTheTestContains.setText("- The test contains 10 questions and there is no time limit.\r\n");
		txtrTheTestContains.setBounds(62, 51, 777, 32);
		panel.add(txtrTheTestContains);
		
		JTextArea txtrTheTest = new JTextArea();
		txtrTheTest.setOpaque(false);
		txtrTheTest.setEditable(false);
		txtrTheTest.setWrapStyleWord(true);
		txtrTheTest.setText("- The test is not official, it's just a nice way to see how much you know about C++.\r\n");
		txtrTheTest.setLineWrap(true);
		txtrTheTest.setFont(new Font("Montserrat", Font.PLAIN, 18));
		txtrTheTest.setBounds(62, 93, 757, 39);
		panel.add(txtrTheTest);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(105, 184, 724, 253);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Good Luck!");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblNewLabel.setBounds(67, 87, 169, 54);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start >>>");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(new CppQuizQuestions());
				panel.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("MS PGothic", Font.BOLD, 30));
		btnNewButton.setBounds(67, 151, 169, 54);
		panel_1.add(btnNewButton);
		
		JLabel lblStartTheQuiz = new JLabel("Start The Quiz");
		lblStartTheQuiz.setBounds(31, 23, 336, 41);
		panel_1.add(lblStartTheQuiz);
		lblStartTheQuiz.setFont(new Font("Kristen ITC", Font.PLAIN, 35));
		
		JLabel title = new JLabel();
		title.setText("C++ Programming Quiz");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Monospaced", Font.BOLD, 40));
		title.setBackground(new Color(0, 0, 205));
		title.setBorder(BorderFactory.createDashedBorder(Color.white, 3, 3, 3, true));  
		title.setBounds(271, 42, 629, 61);
		contentPane.add(title);
	}

}
