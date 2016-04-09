package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import bll.ClientBll;
import bll.OrderBll;
import bll.ProductBll;
import gui.GUI;
import model.Client;
import model.Order;
import model.Product;

public class Controller {
	private GUI gui;
	private Client client;
	private Order order;
	private Product product;
	private ClientBll clientBll;
	private OrderBll orderBll;
	private ProductBll productBll;
	private String sIntermediar;
	private int iIntermediar;
	private String customer_id;
	private String customer_name;
	private String product_id;
	private String product_name;
	private String product_available_unit;
	private String product_price_per_unit;
	private String order_id;
	private String order_customer_id;
	private String order_product_id;
	private String order_number_of_items;
	private String userName;
	private String password;
	
	
	public Controller() {
		gui = new GUI();
		client= new Client();
		order= new Order();
		product= new Product();
		clientBll= new ClientBll();
		productBll = new ProductBll();
		orderBll= new OrderBll();
		selectActionListener();
		selectOperation();
		selectUser();
		
	}
	public void selectUser(){
		gui.loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName=gui.userTextField.getText();
				password=gui.passwordTextField.getText();
				if(userName.equals("admin")){
					if(password.equals("admin")){
						gui.showMainMenu();
					}
					else{
						JOptionPane.showMessageDialog(gui.loginButton, "Invalid User or password");
					}
				}
				else{
					if(clientBll.validUser(userName)){
						gui.showUserMenu();
					}
					else{
						JOptionPane.showMessageDialog(gui.loginButton, "Invalid User or password");
					}
						
				}
			}
		});
		
		gui.addCommandUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_id=gui.idproductUser.getText();
				order_number_of_items=gui.amountUser.getText();	
				Random randomGenerator = new Random();
				 int randomInt = randomGenerator.nextInt(1000);
				 order_id=""+randomInt;
				if(orderBll.addData(order_id,userName,product_id,order_number_of_items)==true){
					JOptionPane.showMessageDialog(gui.addcustomerButton, "Cannot Execute Command");
				}
				else{
					orderBll.receipt(order_id, userName, product_id, order_number_of_items);
				}
			}
		});
		
	}
	public void selectOperation(){
		gui.addcustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_id=gui.idcustomer.getText();
				customer_name=gui.customername.getText();				
				if(clientBll.addData(customer_id,customer_name)==true){
					JOptionPane.showMessageDialog(gui.addcustomerButton, "Cannot Execute Command");
				}
			}
		});
		gui.removecustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_id=gui.idcustomer.getText();
				if(clientBll.removeData(customer_id)==true){
					JOptionPane.showMessageDialog(gui.removecustomerButton, "Cannot Execute Command");
				}
					
			}
		});
		gui.updatecustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_id=gui.idcustomer.getText();
				customer_name=gui.customername.getText();				
				if(clientBll.updateData(customer_id,customer_name)==true){
					JOptionPane.showMessageDialog(gui.updatecustomerButton, "Cannot Execute Command");
				}
			}
		});
		gui.addproductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_id=gui.idproduct.getText();
				product_name=gui.productname.getText();
				product_available_unit=gui.available_unit.getText();
				product_price_per_unit=gui.price_per_unit.getText();
				if(productBll.addData(product_id,product_name,product_available_unit,product_price_per_unit)==true){
					JOptionPane.showMessageDialog(gui.addproductButton, "Cannot Execute Command");
				}
			}
		});
		gui.removeproductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_id=gui.idproduct.getText();
				if(productBll.removeData(product_id)==true){
					JOptionPane.showMessageDialog(gui.removeproductButton, "Cannot Execute Command");
				}
			}
		});
		gui.updateproductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product_id=gui.idproduct.getText();
				product_name=gui.productname.getText();
				product_available_unit=gui.available_unit.getText();
				product_price_per_unit=gui.price_per_unit.getText();
				if(productBll.updateData(product_id,product_name,product_available_unit,product_price_per_unit)==true){
					JOptionPane.showMessageDialog(gui.updateproductButton, "Cannot Execute Command");
				}
			}
		});
		gui.addorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order_id=gui.order_id.getText();
				order_product_id=gui.product_id.getText();
				order_customer_id=gui.customer_id.getText();
				order_number_of_items=gui.number_of_items.getText();
				if(orderBll.addData(order_id,order_customer_id,order_product_id,order_number_of_items)==true){
					JOptionPane.showMessageDialog(gui.addorderButton, "Cannot Execute Command");
				}
			}
		});
		gui.removeorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order_id=gui.order_id.getText();
				if(orderBll.removeData(order_id)==true){
					JOptionPane.showMessageDialog(gui.removeorderButton, "Cannot Execute Command");
				}
			}
		});
		gui.updateorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order_id=gui.order_id.getText();
				order_product_id=gui.product_id.getText();
				order_customer_id=gui.customer_id.getText();
				order_number_of_items=gui.number_of_items.getText();
				if(orderBll.updateData(order_id,order_customer_id,order_product_id,order_number_of_items)==true){
					JOptionPane.showMessageDialog(gui.updateorderButton, "Cannot Execute Command");
				}
			}
		});
	}
	public void selectActionListener(){
		gui.customerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showCustomerTableInterface();
			}
		});
		gui.productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showProductTableInterface();
			}
		});
		gui.orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showOrderTableInterface();
			}
		});
		gui.backButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showMainMenu();
			}
		});
		gui.backButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showMainMenu();
			}
		});
		gui.backButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.showMainMenu();
			}
		});
	}
}
