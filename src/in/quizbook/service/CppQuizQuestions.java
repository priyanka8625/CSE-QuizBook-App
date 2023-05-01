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

public class CppQuizQuestions extends JPanel {
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
		CppQuizQuestions home = new CppQuizQuestions();
	}
	public CppQuizQuestions() {
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
		
		op1 = new JRadioButton("volatile");
		op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op1.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op1.setBounds(35, 6, 784, 40);
		op1.setActionCommand("op1");
		panel.add(op1);
		
		op2 = new JRadioButton("friend");
		op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op2.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op2.setBounds(35, 72, 784, 40);
		op2.setActionCommand("op2");
		panel.add(op2);
		
		op3 = new JRadioButton("extends");
		op3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op3.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op3.setBounds(35, 134, 784, 40);
		op3.setActionCommand("op3");
		panel.add(op3);
		
		op4 = new JRadioButton("this");
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
		ques.setText(" Which of the following is not the keyword in C++?");
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
						if(opGroup.getSelection().getActionCommand() == "op3") {
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
						if(opGroup.getSelection().getActionCommand() == "op2") {
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
						if(opGroup.getSelection().getActionCommand() == "op3") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion8();
					}
					else if(quesNo==8) {
						if(opGroup.getSelection().getActionCommand() == "op2") {
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
		nxtBtn.setBackground(new Color(65, 105, 225));
		nxtBtn.setBounds(83, 459, 147, 54);
		add(nxtBtn);
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(opGroup.getSelection() != null) {
						if(quesNo==10) {
							if(opGroup.getSelection().getActionCommand() == "op3") {
								score++;
							}
							quesNo++;
							opGroup.clearSelection();
							dash.updateCppScore(score, SignIn.USERNAME);
							ResultPopUp result = new ResultPopUp("cpp");
							submitBtn.setEnabled(false);
						}
					}
				
			}
		});
		submitBtn.setVisible(false);
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setFont(new Font("MS PGothic", Font.BOLD, 30));
		submitBtn.setBorderPainted(false);
		submitBtn.setBackground(new Color(65, 105, 225));
		submitBtn.setBounds(692, 459, 147, 54);
		add(submitBtn);
		
	}
	public void setQuestion2() {
		ques.setText("Pick up the valid declaration for overloading ++ in postfix form where T is the class name.");
		op1.setText("T operator++();");
		op2.setText("T operator++(int);");
		op3.setText("T& operator++();");
		op4.setText("T& operator++();");
	}
	public void setQuestion3() {
		ques.setText("We can use this pointer in static member function of the class.");
		op1.setText("true");
		op2.setText("false");
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion4() {
		ques.setText("Objects created using new operator are stored in __ memory.");
		op1.setText("Cache");
		op2.setText("Heap");
		op3.setVisible(true);
		op3.setText("Stack");
		op4.setVisible(true);
		op4.setText("None of the above");
	}
	public void setQuestion5() {
		ques.setText("With respective to streams >> (operator) is called as");
		op1.setText("Insertion operator");
		op2.setText("Extraction operator");
		op3.setText("Right shift operator");
		op4.setText("Left shift operator");
	}
	public void setQuestion6() {
		ques.setText("i) Exception handling technically provides multi branching.\r\n"
				+ "\r\n"
				+ "ii) Exception handling can be mimicked using ‘goto’ construct.");
		op1.setText("Only (i) is true");
		op2.setText("Only (ii) is true");
		op3.setText("Both (i) & (ii) are true");
		op4.setText("Both (i) && (ii) are false");
	}
	public void setQuestion7() {
		ques.setText("Special symbol permitted with in the identifier name.");
		op1.setText("$");
		op2.setText("@");
		op3.setText("_");
		op4.setText("-");
	}
	public void setQuestion8() {
		ques.setText("The function strlen() computes:");
		op1.setText("the number of non-whitespace characters in a string");
		op2.setText("the length of a string, not including the null terminator");
		op3.setText("the number of alphabetical characters in a string");
		op4.setText("the length of a string, including the null terminator");
	}
	public void setQuestion9() {
		ques.setText("In C++, cout is found in which library file?");
		op1.setText("ctype.h");
		op2.setText("stdlib.h");
		op3.setText("math.h");
		op4.setText("iostream.h");
	}
	public void setQuestion10() {
		ques.setText("The standard identifier cin is used for:");
		op1.setText("a compiler flag");
		op2.setText("standard output");
		op3.setText("standard input");
		op4.setText("the integer -1");
	}
}
