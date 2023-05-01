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

public class JavaScriptQuizQuestions extends JPanel {
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
		JavaScriptQuizQuestions home = new JavaScriptQuizQuestions();
	}
	public JavaScriptQuizQuestions() {
		setBorder(new BevelBorder(BevelBorder.RAISED, new Color(230, 230, 250), new Color(230, 230, 250), new Color(230, 230, 250), new Color(230, 230, 250)));
		setVisible(true);
		setBackground(new Color(255, 255, 255));
		setBounds(112, 151, 943, 534);
		setLayout(null);
		quesNo=1;
		opGroup = new ButtonGroup();
		score=0;
		Database_dash dash = new Database_dash();
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 177, 825, 261);
		add(panel);
		panel.setLayout(null);
		
		op1 = new JRadioButton("<scripting>");
		op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op1.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op1.setBounds(35, 6, 784, 40);
		op1.setActionCommand("op1");
		panel.add(op1);
		
		op2 = new JRadioButton("<javascript>");
		op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op2.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op2.setBounds(35, 72, 784, 40);
		op2.setActionCommand("op2");
		panel.add(op2);
		
		op3 = new JRadioButton("<Script>");
		op3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op3.setFont(new Font("Ubuntu", Font.PLAIN, 20));
		op3.setBounds(35, 134, 784, 40);
		op3.setActionCommand("op3");
		panel.add(op3);
		
		op4 = new JRadioButton("<script>");
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
		ques.setText("Inside which HTML element do we put the JavaScript?");
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
						if(opGroup.getSelection().getActionCommand() == "op4") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion2();
					}
					else if(quesNo==2) {
						if(opGroup.getSelection().getActionCommand() == "op4") {
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
						if(opGroup.getSelection().getActionCommand() == "op1") {
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
						if(opGroup.getSelection().getActionCommand() == "op2") {
							score++;
						}
						quesNo++;
						opGroup.clearSelection();
						setQuestion7();
					}
					else if(quesNo==7) {
						if(opGroup.getSelection().getActionCommand() == "op4") {
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
						if(opGroup.getSelection().getActionCommand() == "op2") {
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
		nxtBtn.setBackground(new Color(255, 215, 0));
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
							dash.updateJsScore(score, SignIn.USERNAME);
							ResultPopUp result = new ResultPopUp("javascipt");
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
		submitBtn.setBackground(new Color(255, 215, 0));
		submitBtn.setBounds(692, 459, 147, 54);
		add(submitBtn);
		
	}
	public void setQuestion2() {
		ques.setText("What is the correct JavaScript syntax to change the content of the HTML element below?\r\n"
				+ "<p id=\"demo\">This is a demonstration.</p>");
		op1.setText("document.getElement(\"p\").innerHTML = \"Hello World!\"");
		op2.setText("#demo.innerHTML = \"Hello World!\"");
		op3.setText("document.getElementByName(\"p\").innerHTML = \"Hello World!\"");
		op4.setText("document.getElementById(\"demo\").innerHTML = \"Hello World!\"");
	}
	public void setQuestion3() {
		ques.setText("Where is the correct place to insert a JavaScript?");
		op1.setText("Both <head> and <body> sections are correct");
		op2.setText("<head>");
		op3.setText("<body>");
		op4.setText("none of the above");
	}
	public void setQuestion4() {
		ques.setText("What is the correct syntax for referring to an external script called \"xxx.js\"?");
		op1.setText("<script src=\"xxx.js\">");
		op2.setText("<script href=\\\"xxx.js\\\">");
		op3.setText("<script name=\\\"xxx.js\\\">");
		op4.setText("all of the above");
	}
	public void setQuestion5() {
		ques.setText("The external JavaScript file must contain the <script> tag.");
		op1.setText("true");
		op2.setText("false");
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion6() {
		ques.setText("How do you create a function in JavaScript?");
		op1.setText("function : myFunction()");
		op2.setText("function myFunction()");
		op3.setVisible(true);
		op3.setText("function = myFunction()");
		op4.setVisible(true);
		op4.setText("None of the above");
	}
	public void setQuestion7() {
		ques.setText("What is the correct way to write a JavaScript array?");
		op1.setText("var colors = \"red\",\"green\",\"blue\"");
		op2.setText("var colors = 1:\"red\",2:\"green\",3:\"blue\"");
		op3.setText("var colors = 1=\"red\",2=\"green\",3=\"blue\"");
		op4.setText("var colors = [\"red\",\"green\",\"blue\"]");
	}
	public void setQuestion8() {
		ques.setText("JavaScript is the same as Java.");
		op1.setText("true");
		op2.setText("false");
		op3.setVisible(false);
		op4.setVisible(false);
	}
	public void setQuestion9() {
		ques.setText("How can you detect the client's browser name?");
		op1.setText("browser.name");
		op2.setText("navigator.appName");
		op3.setVisible(true);
		op3.setText("client.navName");
		op4.setVisible(true);
		op4.setText("none of the above");
	}
	public void setQuestion10() {
		ques.setText("Which event occurs when the user clicks on an HTML element?");
		op1.setText("onclick");
		op2.setText("onmouseover");
		op3.setText("onload");
		op4.setText("onblur");
	}
}
