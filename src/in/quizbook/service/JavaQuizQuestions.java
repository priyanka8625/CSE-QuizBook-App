package in.quizbook.service;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import in.quizbook.dao.Database_dash;
import in.quizbook.service.SignIn;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class JavaQuizQuestions extends JPanel {
	static JTextArea ques;
	static JRadioButton op1, op2, op3, op4;
	static int score=0;
	static int quesNo=1;
	static String studAns;
	static ButtonGroup opGroup;
	static JButton nxtBtn;
	static JButton submitBtn;
	/**
	 * Create the panel.
	 */
	public static void main(String args[]) {
		JavaQuizQuestions home = new JavaQuizQuestions();
	}
	public JavaQuizQuestions() {
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(230, 230, 250), new Color(230, 230, 250), new Color(230, 230, 250), new Color(230, 230, 250)));
		setVisible(true);
		setBackground(new Color(255, 255, 255));
		setBounds(112, 151, 943, 534);
		setLayout(null);
		quesNo=1;
		score=0;
		opGroup = new ButtonGroup();
		Database_dash dash = new Database_dash();
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 177, 825, 261);
		add(panel);
		panel.setLayout(null);
		
		op1 = new JRadioButton("printf(\"Hello World\");");
		op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op1.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op1.setBounds(35, 6, 784, 40);
		op1.setActionCommand("op1");
		panel.add(op1);
		
		op2 = new JRadioButton("System.out.println(\"Hello World\");");
		op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op2.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op2.setBounds(35, 72, 784, 40);
		op2.setActionCommand("op2");
		panel.add(op2);
		
		op3 = new JRadioButton("cout<<\"Hello World\";");
		op3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op3.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op3.setBounds(35, 134, 784, 40);
		op3.setActionCommand("op3");
		panel.add(op3);
		
		op4 = new JRadioButton("Console.WriteLine(\"Hello World\");");
		op4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op4.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op4.setBounds(35, 195, 784, 40);
		op4.setActionCommand("op4");
		panel.add(op4);
		
		opGroup.add(op1);
		opGroup.add(op2);
		opGroup.add(op3);
		opGroup.add(op4);
		
		ques = new JTextArea();
		ques.setEditable(false);
		ques.setText("What is a correct syntax to output \"Hello World\" in Java?");
		ques.setFont(new Font("Century Gothic", Font.BOLD, 22));
		ques.setLineWrap(true);
		ques.setWrapStyleWord(true);
		ques.setBounds(53, 70, 825, 97);
		add(ques);
		
		nxtBtn = new JButton("Next >>");
		nxtBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nxtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opGroup.getSelection() != null) {
					if(quesNo==1) {
						if(opGroup.getSelection().getActionCommand() == "op1") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion2();
					}
					else if(quesNo==2) {
						if(opGroup.getSelection().getActionCommand() == "op2") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion3();
					}
					else if(quesNo==3) {
						if(opGroup.getSelection().getActionCommand() == "op1") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion4();
					}
					else if(quesNo==4) {
						if(opGroup.getSelection().getActionCommand() == "op2") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion5();
					}
					else if(quesNo==5) {
						if(opGroup.getSelection().getActionCommand() == "op3") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion6();
					}
					else if(quesNo==6) {
						if(opGroup.getSelection().getActionCommand() == "op4") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion7();
					}
					else if(quesNo==7) {
						if(opGroup.getSelection().getActionCommand() == "op1") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion8();
					}
					else if(quesNo==8) {
						if(opGroup.getSelection().getActionCommand() == "op1") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion9();
					}
					else if(quesNo==9) {
						if(opGroup.getSelection().getActionCommand() == "op4") {
							score++;
						}
						quesNo++;
						setQuestion10();
						nxtBtn.setVisible(false);
						submitBtn.setVisible(true);
						opGroup.clearSelection();
					}
				}
			}
		});
		nxtBtn.setForeground(Color.WHITE);
		nxtBtn.setFont(new Font("MS PGothic", Font.BOLD, 30));
		nxtBtn.setBorderPainted(false);
		nxtBtn.setBackground(new Color(138, 43, 226));
		nxtBtn.setBounds(83, 459, 147, 54);
		add(nxtBtn);
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(opGroup.getSelection() != null) {
						if(quesNo==10) {
							if(opGroup.getSelection().getActionCommand() == "op1") {
								score++;
							}
							quesNo++;
							opGroup.clearSelection();
							dash.updateJavaScore(score, SignIn.USERNAME);
							ResultPopUp result = new ResultPopUp("java");
							submitBtn.setEnabled(false);
						}
					}
				
			}
		});
		submitBtn.setVisible(false);
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setFont(new Font("MS PGothic", Font.BOLD, 30));
		submitBtn.setBorderPainted(false);
		submitBtn.setBackground(new Color(138, 43, 226));
		submitBtn.setBounds(692, 459, 147, 54);
		add(submitBtn);
		
	}
	public void setQuestion2() {
		ques.setText("Java is short for \"JavaScript\".");
		op1.setText("true");
		op2.setText("false");
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion3() {
		ques.setText("The value of a string variable can be surrounded by single quotes.");
		op1.setText("false");
		op2.setText("true");
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion4() {
		ques.setText("What are the major components of the JDBC?");
		op1.setText("DriverManager, Statement and ResultSet");
		op2.setText("DriverManager, Driver, Connection, Statement, ResultSet");
		op3.setVisible(true);
		op3.setText("DriverManager, Connection, Statement and ResultSet");
		op4.setVisible(true);
		op4.setText("DriverManager, Driver, Statement and ResultSet");
	}
	public void setQuestion5() {
		ques.setText("Which of the following is not a java feature ?");
		op1.setText("object oriented");
		op2.setText("abstraction");
		op3.setText("use of pointers");
		op4.setText("dynamic");
	}
	public void setQuestion6() {
		ques.setText("What is true about a final class?");
		op1.setText("class declared final is a final class.");
		op2.setText("final class methods cannot be overridden.");
		op3.setText("It can't be inherited.");
		op4.setText("All of the above.");
	}
	public void setQuestion7() {
		ques.setText("java.util.Collections is a:");
		op1.setText("Class");
		op2.setText("Interface");
		op3.setText("Object");
		op4.setText("None of the above");
	}
	public void setQuestion8() {
		ques.setText("Which of the following would compile without error?");
		op1.setText("int a = Math.abs(-5);");
		op2.setText("int b = Math.abs(5.0);");
		op3.setText("int c = Math.abs(5.5F);");
		op4.setText("int d = Math.abs(5L);");
	}
	public void setQuestion9() {
		ques.setText("You want a class to have access to members of another class in the same package. Which is the most restrictive access that accomplishes this objective?");
		op1.setText("public");
		op2.setText("private");
		op3.setText("protected");
		op4.setText("default access");
	}
	public void setQuestion10() {
		ques.setText("Which is a valid declaration within an interface?");
		op1.setText("public static short stop = 23;");
		op2.setText("protected short stop = 23;");
		op3.setText("transient short stop = 23;");
		op4.setText("final void madness(short stop);");
	}
}
