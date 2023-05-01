package in.quizbook.service;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class DashBoard extends JFrame {

	private JPanel contentPane,cPane,cppPane,javaPane,jsPane,myPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
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
	public DashBoard() {
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
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "CSE QuizBook app",JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			      dispose();
			    }
			}
		});
		ImageIcon icon3=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\close.png");
		Image vaccIcon3=icon3.getImage();
		Image vaccScale3=vaccIcon3.getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_SMOOTH);
		close.setIcon(new ImageIcon(vaccScale3));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 162, 442, 551);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(26, 59, 393, 441);
		panel.add(lblNewLabel);
		ImageIcon icon1=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\quiz.png");
		Image vaccIcon1=icon1.getImage();
		Image vaccScale1=vaccIcon1.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(vaccScale1));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(347, 50, 767, 647);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		cPane = new JPanel();
		cPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cPane.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				cPane.setBackground(new Color(65,105,225));
				cPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				cPane.setBackground(new Color(245, 245, 245));
				cPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				cPane.setBackground(new Color(240,255,255));
				cPane.getComponent(0).setForeground(new Color(0,0,139));
				CQuiz.main(null);
				setVisible(false);
			}
			public void mouseReleased(MouseEvent e)
			{
				cPane.setBackground(new Color(224,255,255));
				cPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		cPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(106, 90, 205), new Color(0, 0, 139), new Color(0, 0, 139)));
		cPane.setBackground(new Color(245, 245, 245));
		cPane.setBounds(179, 61, 518, 75);
		cPane.setBorder(BorderFactory.createDashedBorder(Color.gray, 3, 3, 3, true));  
		panel_1.add(cPane);
		cPane.setLayout(null);
		
		JTextArea txtrC_1 = new JTextArea();
		txtrC_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				cPane.setBackground(new Color(65,105,225));
				cPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				cPane.setBackground(new Color(245, 245, 245));
				cPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				cPane.setBackground(new Color(240,255,255));
				cPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mouseReleased(MouseEvent e)
			{
				cPane.setBackground(new Color(224,255,255));
				cPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		txtrC_1.setBounds(250, 10, 31, 44);
		cPane.add(txtrC_1);
		txtrC_1.setWrapStyleWord(true);
		txtrC_1.setText("C");
		txtrC_1.setOpaque(false);
		txtrC_1.setLineWrap(true);
		txtrC_1.setForeground(new Color(0, 0, 139));
		txtrC_1.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtrC_1.setEditable(false);
		
		JLabel cIcon = new JLabel("");
		cIcon.setBounds(201, 10, 39, 44);
		cPane.add(cIcon);
		ImageIcon cLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\c.png");
		Image cLblIcon1=cLblIcon.getImage();
		Image cLblScale=cLblIcon1.getScaledInstance(cIcon.getWidth(), cIcon.getHeight(), Image.SCALE_SMOOTH);
		cIcon.setIcon(new ImageIcon(cLblScale));
		
		cppPane = new JPanel();
		cppPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cppPane.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				cppPane.setBackground(new Color(65,105,225));
				cppPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				cppPane.setBackground(new Color(245, 245, 245));
				cppPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				cppPane.setBackground(new Color(240,255,255));
				cppPane.getComponent(0).setForeground(new Color(0,0,139));
				CppQuiz.main(null);
				setVisible(false);
			}
			public void mouseReleased(MouseEvent e)
			{
				cppPane.setBackground(new Color(224,255,255));
				cppPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		cppPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(106, 90, 205), new Color(0, 0, 139), new Color(0, 0, 139)));
		cppPane.setBackground(new Color(245, 245, 245));
		cppPane.setBorder(BorderFactory.createDashedBorder(Color.gray, 3, 3, 3, true));  
		cppPane.setBounds(179, 176, 518, 75);
		panel_1.add(cppPane);
		cppPane.setLayout(null);
		
		JTextArea txtrC = new JTextArea();
		txtrC.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				cppPane.setBackground(new Color(65,105,225));
				cppPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				cppPane.setBackground(new Color(245, 245, 245));
				cppPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				cppPane.setBackground(new Color(240,255,255));
				cppPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mouseReleased(MouseEvent e)
			{
				cppPane.setBackground(new Color(224,255,255));
				cppPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		txtrC.setBounds(247, 10, 64, 44);
		cppPane.add(txtrC);
		txtrC.setWrapStyleWord(true);
		txtrC.setText("C++");
		txtrC.setOpaque(false);
		txtrC.setLineWrap(true);
		txtrC.setForeground(new Color(0, 0, 139));
		txtrC.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtrC.setEditable(false);
		
		JLabel cppIcon = new JLabel("");
		cppIcon.setBounds(195, 10, 38, 44);
		ImageIcon cppLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\cpp.png");
		Image cppLblIcon1=cppLblIcon.getImage();
		Image cppLblScale=cppLblIcon1.getScaledInstance(cppIcon.getWidth(), cppIcon.getHeight(), Image.SCALE_SMOOTH);
		cppIcon.setIcon(new ImageIcon(cppLblScale));
		cppPane.add(cppIcon);
		
		javaPane = new JPanel();
		javaPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		javaPane.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				javaPane.setBackground(new Color(65,105,225));
				javaPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				javaPane.setBackground(new Color(245, 245, 245));
				javaPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				javaPane.setBackground(new Color(240,255,255));
				javaPane.getComponent(0).setForeground(new Color(0,0,139));
				JavaQuiz.main(null);
				setVisible(false);
			}
			public void mouseReleased(MouseEvent e)
			{
				javaPane.setBackground(new Color(224,255,255));
				javaPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		javaPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(106, 90, 205), new Color(0, 0, 139), new Color(0, 0, 139)));
		javaPane.setBackground(new Color(245, 245, 245));
		javaPane.setBorder(BorderFactory.createDashedBorder(Color.gray, 3, 3, 3, true));  
		javaPane.setBounds(179, 294, 518, 75);
		panel_1.add(javaPane);
		javaPane.setLayout(null);
		
		JTextArea txtrJava = new JTextArea();
		txtrJava.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				javaPane.setBackground(new Color(65,105,225));
				javaPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				javaPane.setBackground(new Color(245, 245, 245));
				javaPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				javaPane.setBackground(new Color(240,255,255));
				javaPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mouseReleased(MouseEvent e)
			{
				javaPane.setBackground(new Color(224,255,255));
				javaPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		txtrJava.setBounds(231, 20, 81, 44);
		javaPane.add(txtrJava);
		txtrJava.setWrapStyleWord(true);
		txtrJava.setText("JAVA");
		txtrJava.setOpaque(false);
		txtrJava.setLineWrap(true);
		txtrJava.setForeground(new Color(0, 0, 139));
		txtrJava.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtrJava.setEditable(false);
		
		JLabel jIcon = new JLabel("");
		jIcon.setBounds(176, 10, 49, 44);
		ImageIcon jLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\java.png");
		Image jLblIcon1=jLblIcon.getImage();
		Image jLblScale=jLblIcon1.getScaledInstance(jIcon.getWidth(), jIcon.getHeight(), Image.SCALE_SMOOTH);
		jIcon.setIcon(new ImageIcon(jLblScale));
		javaPane.add(jIcon);
		
		jsPane = new JPanel();
		jsPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jsPane.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				jsPane.setBackground(new Color(65,105,225));
				jsPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				jsPane.setBackground(new Color(245, 245, 245));
				jsPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				jsPane.setBackground(new Color(240,255,255));
				jsPane.getComponent(0).setForeground(new Color(0,0,139));
				JavaScriptQuiz.main(null);
				setVisible(false);
			}
			public void mouseReleased(MouseEvent e)
			{
				jsPane.setBackground(new Color(224,255,255));
				jsPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		jsPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(106, 90, 205), new Color(0, 0, 139), new Color(0, 0, 139)));
		jsPane.setBackground(new Color(245, 245, 245));
		jsPane.setBorder(BorderFactory.createDashedBorder(Color.gray, 3, 3, 3, true));  
		jsPane.setBounds(179, 411, 518, 75);
		panel_1.add(jsPane);
		jsPane.setLayout(null);
		
		JTextArea txtrJavascript = new JTextArea();
		txtrJavascript.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				jsPane.setBackground(new Color(65,105,225));
				jsPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				jsPane.setBackground(new Color(245, 245, 245));
				jsPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				jsPane.setBackground(new Color(240,255,255));
				jsPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mouseReleased(MouseEvent e)
			{
				jsPane.setBackground(new Color(224,255,255));
				jsPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		txtrJavascript.setBounds(191, 10, 191, 44);
		jsPane.add(txtrJavascript);
		txtrJavascript.setWrapStyleWord(true);
		txtrJavascript.setText("JavaScript");
		txtrJavascript.setOpaque(false);
		txtrJavascript.setLineWrap(true);
		txtrJavascript.setForeground(new Color(0, 0, 139));
		txtrJavascript.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtrJavascript.setEditable(false);
		
		JLabel jsIcon = new JLabel("");
		jsIcon.setBounds(137, 10, 50, 44);
		ImageIcon jsLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\js.png");
		Image jsLblIcon1=jsLblIcon.getImage();
		Image jsLblScale=jsLblIcon1.getScaledInstance(jsIcon.getWidth(), jsIcon.getHeight(), Image.SCALE_SMOOTH);
		jsIcon.setIcon(new ImageIcon(jsLblScale));
		jsPane.add(jsIcon);
		
		myPane = new JPanel();
		myPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myPane.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				myPane.setBackground(new Color(65,105,225));
				myPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				myPane.setBackground(new Color(245, 245, 245));
				myPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				myPane.setBackground(new Color(240,255,255));
				myPane.getComponent(0).setForeground(new Color(0,0,139));
				MyScore.main(null);
				setVisible(false);
				
			}
			public void mouseReleased(MouseEvent e)
			{
				myPane.setBackground(new Color(224,255,255));
				myPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		myPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(106, 90, 205), new Color(0, 0, 139), new Color(0, 0, 139)));
		myPane.setBackground(new Color(245, 245, 245));
		myPane.setBorder(BorderFactory.createDashedBorder(Color.gray, 3, 3, 3, true));  
		myPane.setBounds(179, 529, 518, 75);
		panel_1.add(myPane);
		myPane.setLayout(null);
		
		JTextArea txtrMyScore = new JTextArea();
		txtrMyScore.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				myPane.setBackground(new Color(65,105,225));
				myPane.getComponent(0).setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent e)
			{
				myPane.setBackground(new Color(245, 245, 245));
				myPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mousePressed(MouseEvent e)
			{
				myPane.setBackground(new Color(240,255,255));
				myPane.getComponent(0).setForeground(new Color(0,0,139));
			}
			public void mouseReleased(MouseEvent e)
			{
				myPane.setBackground(new Color(224,255,255));
				myPane.getComponent(0).setForeground(new Color(0,0,139));
			}
		});
		txtrMyScore.setWrapStyleWord(true);
		txtrMyScore.setText("My Score");
		txtrMyScore.setOpaque(false);
		txtrMyScore.setLineWrap(true);
		txtrMyScore.setForeground(new Color(0, 0, 139));
		txtrMyScore.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtrMyScore.setEditable(false);
		txtrMyScore.setBounds(214, 10, 155, 44);
		myPane.add(txtrMyScore);
		
		JLabel myIcon = new JLabel("");
		myIcon.setBounds(155, 10, 49, 44);
		ImageIcon myLblIcon=new ImageIcon("D:\\eclipse-workspace\\CSE quizbook application\\images\\profile.png");
		Image myLblIcon1=myLblIcon.getImage();
		Image myLblScale=myLblIcon1.getScaledInstance(myIcon.getWidth(), myIcon.getHeight(), Image.SCALE_SMOOTH);
		myIcon.setIcon(new ImageIcon(myLblScale));
		myPane.add(myIcon);
		
		
		JLabel lblQuizbook = new JLabel("QuizBook");
		lblQuizbook.setForeground(Color.WHITE);
		lblQuizbook.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblQuizbook.setBounds(25, 29, 561, 75);
		contentPane.add(lblQuizbook);
		
		JLabel lblApplication = new JLabel("Application");
		lblApplication.setForeground(Color.WHITE);
		lblApplication.setFont(new Font("Segoe Print", Font.BOLD, 30));
		lblApplication.setBounds(151, 80, 174, 54);
		contentPane.add(lblApplication);
		
		
	}
}
