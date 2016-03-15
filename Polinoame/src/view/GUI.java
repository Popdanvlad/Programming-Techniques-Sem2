package view;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Polynom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	JFrame frame;
	
	JPanel mainPanel;
	JPanel firstPoly;
	JPanel secondPoly;
	JPanel resultPoly;
	JPanel operations;
	
	public JButton addButton;
	public JButton subButton;
	public JButton ok1Button;
	public JButton ok2Button;
	public JButton mulButton;
	public JButton divButton;
	public JButton deriveButton;
	public JButton integrateButton;
	public JButton valueAtButton;
	
	JLabel firstPolyLabel;
	JLabel secondPolyLabel;
	JLabel resultLabel;
	
	public JTextField polynome1;
	public JTextField polynome2;
	public JTextField result;
	
	private String poly1="";
	private String poly2="";
	private String res="";
	
	private boolean poly1Entered=false;
	private boolean poly2Entered=false;
	private int operationSelected=0;
	
	private Polynom p1;
	private Polynom p2;
	private Polynom r;
	
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public GUI(){
		frame= new JFrame("Polinom");
		frame.setSize(500, 400);
		mainPanel= new JPanel();
		
		firstPoly= new JPanel();
		secondPoly= new JPanel();
		resultPoly=new JPanel();
		operations= new JPanel();
		
		firstPolyLabel = new JLabel();
		secondPolyLabel = new JLabel();
		resultLabel = new JLabel();
		
		addButton = new JButton("ADD");
		subButton = new JButton("SUB");
		ok1Button = new JButton("OK");
		ok2Button = new JButton("OK");
		divButton = new JButton("DIV");
		mulButton = new JButton("MUL");
		deriveButton = new JButton("DERIVE");
		integrateButton = new JButton("INTEGRATE");
		valueAtButton = new JButton("VALUE");
		
		mainPanel.setLayout(new GridLayout(4,1));
		polynome1= new JTextField(20);
		polynome2= new JTextField(20);
		result= new JTextField(20);
		
		mainPanel.setBackground(Color.BLUE);
		frame.add(mainPanel);
		
		mainPanel.add(firstPoly);
		mainPanel.add(secondPoly);
		mainPanel.add(resultPoly);
		mainPanel.add(operations);
		
		firstPolyLabel.setText("Enter the first Polynome:");
		secondPolyLabel.setText("Enter the second Polynome:");
		resultLabel.setText("The resulted Polynome is:");
		
		firstPoly.add(firstPolyLabel);
		secondPoly.add(secondPolyLabel);
		resultPoly.add(resultLabel);
		firstPoly.add(polynome1);
		secondPoly.add(polynome2);
		resultPoly.add(result);
		firstPoly.add(ok1Button);
		secondPoly.add(ok2Button);
		
//		polynome1= new JTextField("");
//		polynome2= new JTextField("");
//		result= new JTextField("");
		
		operations.add(addButton);
		operations.add(subButton);
		operations.add(mulButton);
		//operations.add(divButton);
		operations.add(deriveButton);
		operations.add(integrateButton);
		operations.add(valueAtButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	public void setPolynome1(String poly1){
		this.poly1=poly1;
	}
	public void setPolynome2(String poly2){
		this.poly2=poly2;
	}
	public String getPolynome1(){
		return poly1;
	}
	public String getPolynome2(){
		return poly2;
	}
	public boolean isPoly1Entered() {
		return poly1Entered;
	}
	public void setPoly1Entered(boolean poly1Entered) {
		this.poly1Entered = poly1Entered;
	}
	public boolean isPoly2Entered() {
		return poly2Entered;
	}
	public void setPoly2Entered(boolean poly2Entered) {
		this.poly2Entered = poly2Entered;
	}
	public int isOperationSelected() {
		return operationSelected;
	}
	public void setOperationSelected(int operationSelected) {
		this.operationSelected = operationSelected;
	}
}
