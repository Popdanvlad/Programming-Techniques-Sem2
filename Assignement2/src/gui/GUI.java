package gui;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import dataAccess.DatabaseAcess;

public class GUI {
	private JFrame jframe;
	private JFrame jframe1;
	private JFrame jframe2;
	private JFrame jframe3;
	private JFrame jframeLogin;
	private JFrame jframeUser;
	
	public JTextField text;
	public JTextField text1;
	
	JLabel idcustomerLabel;
	JLabel cutomernameLabel;
	
	
	public JTextField idcustomer;
	public JTextField customername;
	
	JLabel order_idLabel;
	JLabel customer_idLabel;
	JLabel product_idLabel;
	JLabel number_of_items_idLabel;
	
	public JTextField order_id;
	public JTextField customer_id;
	public JTextField product_id;
	public JTextField number_of_items;
	
	JLabel idproductLabel;
	JLabel productnameLabel;
	JLabel available_unitLabel;
	JLabel price_per_unitLabel;
	
	public JTextField idproduct;
	public JTextField productname;
	public JTextField available_unit;
	public JTextField price_per_unit;
	
	public JTextField userTextField;
	public JTextField passwordTextField;
	
	public JButton customerButton;
	public JButton orderButton;
	public JButton productButton;
	public JButton addcustomerButton;
	public JButton removecustomerButton;
	public JButton updatecustomerButton;
	public JButton addproductButton;
	public JButton removeproductButton;
	public JButton updateproductButton;
	public JButton addorderButton;
	public JButton removeorderButton;
	public JButton updateorderButton;
	public JButton backButton1;
	public JButton backButton2;
	public JButton backButton3;
	public JButton loginButton;
	
	
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JPanel buttonPanel1;
	private JPanel tablePanel1;
	private JPanel buttonPanel2;
	private JPanel tablePanel2;
	private JPanel buttonPanel3;
	private JPanel tablePanel3;
	private JPanel buttonPanelUser;
	private JPanel tablePanelUser;

	private JLabel idproductUserLabel;
	private JLabel amountUserLabel;
	
	public JTextField idproductUser;
	public JTextField amountUser;
	
	public JButton addCommandUserButton;
	
	private String clientID;
	private String clientName;
	
	private String orderID;
	private String order_clientID;
	private String order_productID;
	private String order_number;
	
	private String productID;
	private String productName;
	private String product_availableItems;
	private String product_PricePerUnit;
	
	private String[] customerColumnNames={"idcustomer","name"};
	private String[] productColumnNames={"idproduct","product_name","available_unit","price_per_unit"};
	private String[] orderColumnNames={"order_id","customer_id","product_id","number_of_items"};
	
	private Object[][] dataCustomer;
	private Object[][] dataProduct;
	private Object[][] dataOrder;
	
	private JTable customerTable;
	private JTable productTable;
	private JTable orderTable;
	
	public GUI() {
		loginMenu();
		initMainMenu();
		customerTableInterface();
		productTableInterface();
		orderTableInterface();
		userMenu();
	}
	
	public void userMenu(){
		int i=0;
		jframeUser = new JFrame();
		jframeUser.setFocusable(true);
		jframeUser.setLayout(new GridLayout(1,2));
		buttonPanelUser = new JPanel();
		tablePanelUser = new JPanel();

		idproductUserLabel = new JLabel("ID");
		amountUserLabel= new JLabel("NUMBER");
		
		idproductUser = new JTextField(20);
		amountUser = new JTextField(20);
		
		addCommandUserButton= new JButton("ADD COMMAND");
		
		dataProduct= new Object[10][4];
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select * from `pt`.`product`");
			while(myRs1.next()){
			
				dataProduct[i][0]=myRs1.getString("idproduct");
				dataProduct[i][1]=myRs1.getString("product_name");
				dataProduct[i][2]=myRs1.getString("available_unit");
				dataProduct[i][3]=myRs1.getString("price_per_unit");
				i++;
				//System.out.println(myRs1.getString("idcustomer")+ "  " +myRs1.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productTable= new JTable(dataProduct,productColumnNames);
		
		jframeUser.add(buttonPanelUser);
		jframeUser.add(tablePanelUser);
		
		buttonPanelUser.setLayout(new FlowLayout());
		buttonPanelUser.setLayout(new FlowLayout());
		buttonPanelUser.add(idproductUserLabel);
		buttonPanelUser.add(idproductUser);
		buttonPanelUser.add(amountUserLabel);
		buttonPanelUser.add(amountUser);
		buttonPanelUser.add(addCommandUserButton);
		tablePanelUser.add(productTable);
		jframeUser.setSize(600, 400);
		jframeUser.setTitle("Table Select");
		jframeUser.setLocationRelativeTo(null);
		jframeUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void loginMenu(){
		jframeLogin = new JFrame();
		jframeLogin.setFocusable(true);
		jframeLogin.setLayout(new FlowLayout());
		loginButton = new JButton("LOGIN");
		userLabel= new JLabel("USER");
		passwordLabel= new JLabel("PASSWORD");
		userTextField= new JTextField(20);
		passwordTextField= new JTextField(20);
		jframeLogin.add(userLabel);
		jframeLogin.add(userTextField);
		jframeLogin.add(passwordLabel);
		jframeLogin.add(passwordTextField);
		jframeLogin.add(loginButton);
		jframeLogin.setSize(400, 200);
		jframeLogin.setTitle("Table Select");
		jframeLogin.setLocationRelativeTo(null);
		jframeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframeLogin.setVisible(true);
		
	}
	public void initMainMenu(){
		jframe = new JFrame();
		jframe.setFocusable(true);
		jframe.setLayout(new FlowLayout());
		customerButton = new JButton("CUSTOMER");
		orderButton = new JButton("ORDER");
		productButton = new JButton("PRODUCTS");
		addproductButton = new JButton("ADD ");
		removeproductButton = new JButton("REMOVE ");
		updateproductButton = new JButton("UPDATE");
		addcustomerButton = new JButton("ADD ");
		removecustomerButton = new JButton("REMOVE ");
		updatecustomerButton = new JButton("UPDATE");
		addorderButton = new JButton("ADD ");
		removeorderButton = new JButton("REMOVE ");
		updateorderButton = new JButton("UPDATE");
		backButton1 = new JButton("BACK");
		backButton2 = new JButton("BACK");
		backButton3 = new JButton("BACK");
		jframe.add(customerButton);
		jframe.add(productButton);
		jframe.add(orderButton);
		jframe.setSize(400, 200);
		jframe.setTitle("Table Select");
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe.setVisible(true);
	}
	public void showMainMenu(){
		jframeLogin.setVisible(false);
		jframe1.setVisible(false);
		jframe2.setVisible(false);
		jframe3.setVisible(false);
		jframe.setVisible(true);
	}
	public void showUserMenu(){
		jframeLogin.setVisible(false);
		jframe1.setVisible(false);
		jframe2.setVisible(false);
		jframe3.setVisible(false);
		jframe.setVisible(false);
		jframeUser.setVisible(true);
	}
	public void showCustomerTableInterface(){
		jframe.setVisible(false);
		jframe1.setVisible(true);
	}
	public void showProductTableInterface(){
		jframe.setVisible(false);
		jframe2.setVisible(true);
	}
	public void showOrderTableInterface(){
		jframe.setVisible(false);
		jframe3.setVisible(true);
	}
	public void customerTableInterface(){
		//jframe.dispose();
		//jframe.setVisible(false);
		int i=0;
		jframe1 = new JFrame();
		jframe1.setFocusable(true);
		jframe1.setLayout(new GridLayout(1,2));
		buttonPanel1 = new JPanel();
		tablePanel1 = new JPanel();
		idcustomerLabel= new JLabel("ID");
		cutomernameLabel= new JLabel("NAME");
		idcustomer = new JTextField(20);
		customername = new JTextField(20);
		dataCustomer= new Object[100][2];
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select * from `pt`.`customer`");
			while(myRs1.next()){
			
				dataCustomer[i][0]=myRs1.getString("idcustomer");
				dataCustomer[i][1]=myRs1.getString("name");
				i++;
				//System.out.println(myRs1.getString("idcustomer")+ "  " +myRs1.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerTable= new JTable(dataCustomer,customerColumnNames);
		jframe1.add(buttonPanel1);
		jframe1.add(tablePanel1);
		buttonPanel1.setLayout(new FlowLayout());
		buttonPanel1.setLayout(new FlowLayout());
		buttonPanel1.add(addcustomerButton);
		buttonPanel1.add(removecustomerButton);
		buttonPanel1.add(updatecustomerButton);
		buttonPanel1.add(idcustomerLabel);
		buttonPanel1.add(idcustomer);
		buttonPanel1.add(cutomernameLabel);
		buttonPanel1.add(customername);
		buttonPanel1.add(backButton1);
		tablePanel1.add(customerTable);
		jframe1.setSize(600, 400);
		jframe1.setTitle("Table Select");
		jframe1.setLocationRelativeTo(null);
		jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe1.setVisible(true);
	}
	public void orderTableInterface(){
		//jframe.dispose();
		int i=0;
		jframe3 = new JFrame();
		jframe3.setFocusable(true);
		jframe3.setLayout(new GridLayout(1,2));
		buttonPanel3 = new JPanel();
		tablePanel3 = new JPanel();
		
		order_idLabel = new JLabel("ID");
		customer_idLabel= new JLabel("CUSTOMER_ID");
		product_idLabel= new JLabel("PRODUCT_ID");
		number_of_items_idLabel= new JLabel("NUMBER");
			
		order_id = new JTextField(20);
		customer_id = new JTextField(20);
		product_id = new JTextField(20);
		number_of_items = new JTextField(20);
		
		dataOrder= new Object[100][4];
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("SELECT order_id,name, product_name, number_of_items from `pt`.`order` JOIN `pt`.`customer`"+
"on `customer`.`idcustomer`=`order`.`customer_id` JOIN `pt`.`product` "+
"on `product`.`idproduct`=`order`.`product_id`");
			while(myRs1.next()){
			
				dataOrder[i][0]=myRs1.getString("order_id");
				dataOrder[i][1]=myRs1.getString("name");
				dataOrder[i][2]=myRs1.getString("product_name");
				dataOrder[i][3]=myRs1.getString("number_of_items");
				i++;
				//System.out.println(myRs1.getString("idcustomer")+ "  " +myRs1.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderTable= new JTable(dataOrder,orderColumnNames);
		
		jframe3.add(buttonPanel3);
		jframe3.add(tablePanel3);
		
		buttonPanel3.setLayout(new FlowLayout());
		buttonPanel3.setLayout(new FlowLayout());
		buttonPanel3.add(addorderButton);
		buttonPanel3.add(removeorderButton);
		buttonPanel3.add(updateorderButton);
		buttonPanel3.add(order_idLabel);
		buttonPanel3.add(order_id);
		buttonPanel3.add(customer_idLabel);
		buttonPanel3.add(customer_id);
		buttonPanel3.add(product_idLabel);
		buttonPanel3.add(product_id);
		buttonPanel3.add(number_of_items_idLabel);
		buttonPanel3.add(number_of_items);
		buttonPanel3.add(backButton3);
		tablePanel3.add(orderTable);
		
		jframe3.setSize(600, 400);
		jframe3.setTitle("Order Table");
		jframe3.setLocationRelativeTo(null);
		jframe3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe2.setVisible(true);
	}
	public void productTableInterface(){
		
		int i=0;
		jframe2 = new JFrame();
		jframe2.setFocusable(true);
		jframe2.setLayout(new GridLayout(1,2));
		buttonPanel2 = new JPanel();
		tablePanel2 = new JPanel();

		idproductLabel = new JLabel("ID");
		productnameLabel= new JLabel("NAME");
		available_unitLabel= new JLabel("AVAILABLE");
		price_per_unitLabel= new JLabel("PRICE");
		
	
		idproduct = new JTextField(20);
		productname = new JTextField(20);
		available_unit = new JTextField(20);
		price_per_unit = new JTextField(20);
		
		dataProduct= new Object[10][4];
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select * from `pt`.`product`");
			while(myRs1.next()){
			
				dataProduct[i][0]=myRs1.getString("idproduct");
				dataProduct[i][1]=myRs1.getString("product_name");
				dataProduct[i][2]=myRs1.getString("available_unit");
				dataProduct[i][3]=myRs1.getString("price_per_unit");
				i++;
				//System.out.println(myRs1.getString("idcustomer")+ "  " +myRs1.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productTable= new JTable(dataProduct,productColumnNames);
		
		jframe2.add(buttonPanel2);
		jframe2.add(tablePanel2);
		
		buttonPanel2.setLayout(new FlowLayout());
		buttonPanel2.setLayout(new FlowLayout());
		buttonPanel2.add(addproductButton);
		buttonPanel2.add(removeproductButton);
		buttonPanel2.add(updateproductButton);
		buttonPanel2.add(idproductLabel);
		buttonPanel2.add(idproduct);
		buttonPanel2.add(productnameLabel);
		buttonPanel2.add(productname);
		buttonPanel2.add(available_unitLabel);
		buttonPanel2.add(available_unit);
		buttonPanel2.add(price_per_unitLabel);
		buttonPanel2.add(price_per_unit);
		buttonPanel2.add(backButton2);
		tablePanel2.add(productTable);
		jframe2.setSize(600, 400);
		jframe2.setTitle("Table Select");
		jframe2.setLocationRelativeTo(null);
		jframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
