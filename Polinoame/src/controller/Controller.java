package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ParseString;
import model.Polynom;
import operations.Operations;
import view.GUI;
import view.GUI;
public class Controller {
	private GUI gui;
	private ParseString parse;
	private String polynom1;
	private String polynom2;
	private String result;
	private Polynom p1;
	private Polynom p2;
	private Polynom r;
	private Operations op;
	private boolean exit = false;

	public Controller() {
		gui = new GUI();
		parse = new ParseString();
		op = new Operations();
		button1ActionListener();
		button2ActionListener();
		operationsButtonActionListener();
	}

	public void button1ActionListener() {

		gui.ok1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polynom1 = (gui.polynome1.getText());
				p1 = parse.convertToPolynom(polynom1);
				p1.displayPolynom();
			}
		});
	}
	public void button2ActionListener() {
		gui.ok2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polynom2 = (gui.polynome2.getText());
				p2 = parse.convertToPolynom(polynom2);
				p2.displayPolynom();
			}
		});
	}
	public void operationsButtonActionListener() {
		gui.addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r = op.addition(p1, p2);
				result = parse.convertToString(r);
				gui.result.setText(result);
			}
		});
	gui.subButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			r = op.substraction(p1, p2);
			result = parse.convertToString(r);
			gui.result.setText(result);
		}
	});
	gui.mulButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			r = op.multiplication(p1, p2);
			result = parse.convertToString(r);
			gui.result.setText(result);
		}
	});
	gui.divButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
		}
	});
	gui.deriveButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			r = op.derive(p1);
			result = parse.convertToString(r);
			gui.result.setText(result);
		}
	});
	gui.integrateButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			r = op.integrate(p1);
			result = parse.convertToString(r);
			gui.result.setText(result);
		}
	});
	gui.valueAtButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			result = op.value(p1,p2);
			gui.result.setText(result);
		}
	});
}
}
