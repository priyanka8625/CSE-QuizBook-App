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

public class CQuizQuestions extends JPanel {
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
		CQuizQuestions home = new CQuizQuestions();
	}
	public CQuizQuestions() {
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
		ques.setText("What is a correct syntax to output \"Hello World\" in C?\r\n");
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
						if(opGroup.getSelection().getActionCommand() == "op1") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion3();
					}
					else if(quesNo==3) {
						if(opGroup.getSelection().getActionCommand() == "op2") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion4();
					}
					else if(quesNo==4) {
						if(opGroup.getSelection().getActionCommand() == "op4") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion5();
					}
					else if(quesNo==5) {
						if(opGroup.getSelection().getActionCommand() == "op2") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion6();
					}
					else if(quesNo==6) {
						if(opGroup.getSelection().getActionCommand() == "op1") {
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
						if(opGroup.getSelection().getActionCommand() == "op3") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion9();
					}
					else if(quesNo==9) {
						if(opGroup.getSelection().getActionCommand() == "op1") {
							score++;
						}
						quesNo++;
						setQuestion10();
						nxtBtn.setVisible(false);
						submitBtn.setVisible(true);
						opGroup.clearSelection();
					}
					dash.updateCScore(score, SignIn.USERNAME);
				}
			}
		});
		nxtBtn.setForeground(Color.WHITE);
		nxtBtn.setFont(new Font("MS PGothic", Font.BOLD, 30));
		nxtBtn.setBorderPainted(false);
		nxtBtn.setBackground(new Color(0, 0, 205));
		nxtBtn.setBounds(83, 459, 147, 54);
		add(nxtBtn);
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(opGroup.getSelection() != null) {
						if(quesNo==10) {
							if(opGroup.getSelection().getActionCommand() == "op2") {
								score++;
							}
							quesNo++;
							opGroup.clearSelection();
							dash.updateCScore(score, SignIn.USERNAME);
							ResultPopUp result = new ResultPopUp("c");
							result.setVisible(true);
							submitBtn.setEnabled(false);
						}
					}
				
			}
		});
		submitBtn.setVisible(false);
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setFont(new Font("MS PGothic", Font.BOLD, 30));
		submitBtn.setBorderPainted(false);
		submitBtn.setBackground(new Color(0, 0, 205));
		submitBtn.setBounds(692, 459, 147, 54);
		add(submitBtn);
		
	}
	public void setQuestion2() {
		ques.setText("When a variable is created in C, a memory address is assigned to the variable.");
		op1.setText("true");	//
		op2.setText("false");   
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion3() {
		ques.setText("In C, code statements must end with a semicolon (;)");
		op1.setText("false");
		op2.setText("true");   //
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion4() {
		ques.setText("How can you create a variable with the numeric value 5?");
		op1.setText("num = 5 int");
		op2.setText("val num = 5");
		op3.setVisible(true);
		op3.setText("num = 5");
		op4.setVisible(true);
		op4.setText("int num = 5");   //
	}
	public void setQuestion5() {
		ques.setText("Which operator can be used to find the memory size (in bytes) of a data type or variable?");
		op1.setText("The sizer property");
		op2.setText("The sizeof property");     //
		op3.setText("The length property");
		op4.setText("The len property");
	}
	public void setQuestion6() {
		ques.setText("What do we call the following? int myNumbers[] = {25, 50, 75, 100};");
		op1.setText("An array");         //
		op2.setText("A pointer");
		op3.setText("A class");
		op4.setText("None of the above");
	}
	public void setQuestion7() {
		ques.setText("Which of the following statement shows the correct implementation of nested conditional operation by finding greatest number out of three numbers?");
		op1.setText("max = a>b ? a>c?a:c:b>c?b:c");       //
		op2.setText("a=b ? c=30;");
		op3.setText("a>b : c=30 : c=40;");
		op4.setText("return (a>b)?(a:b) ?a:c:b");
	}
	public void setQuestion8() {
		ques.setText("Which of the following header file can be used to define the NULL macro?");
		op1.setText("time.h, wchar.h, math.h, locale.h,");
		op2.setText("stddef.h, locale.h, math.h, stdlib.h, string.h,");
		op3.setText("stdio.h, locale.h, stddef.h, stdlib.h, string.h,");      //
		op4.setText("math.h");
	}
	public void setQuestion9() {
		ques.setText("If two strings are identical, then strcmp() function returns");
		op1.setText("0");       //
		op2.setText("1");
		op3.setText("-1");
		op4.setText("none of the above");
	}
	public void setQuestion10() {
		ques.setText("Array passed as an argument to a function is interpreted as");
		op1.setText("values of the first elements of the array.");
		op2.setText("address of the first element of the array.");    //
		op3.setText("address of the array.");
		op4.setText("number of element of the array.");
	}
}
