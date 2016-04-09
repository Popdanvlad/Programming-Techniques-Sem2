package bll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataAccess.DatabaseAcess;
import dataAccess.OrderAccess;
import dataAccess.ProductAccess;
import model.Client;

public class OrderBll {

	private boolean ok;
	private int ID_product=20;
	private String duplicate;
	private Client client;
	private OrderAccess orderAcces;
	private boolean errorMsg;
	
	public boolean addData(String order_id, String order_customer_id, String order_product_id,
			String order_number_of_items) {
		ok=true;
		if(order_product_id.isEmpty()){
			ok=false;
		}
		if(order_id.isEmpty()){
			ok=false;
		}
		if(order_product_id.isEmpty()){
			ok=false;
		}
		if(order_number_of_items.isEmpty()){
			ok=false;
		}
		try{
			ID_product=Integer.parseInt(order_id);
		}
		catch(NumberFormatException e){
			ok=false;
			System.out.println("3");
			//System.out.println("ERROR");
		}
		try{
			ID_product=Integer.parseInt(order_product_id);
		}
		catch(NumberFormatException e){
			ok=false;
			System.out.println("3");
			//System.out.println("ERROR");
		}
		try{
			ID_product=Integer.parseInt(order_customer_id);
		}
		catch(NumberFormatException e){
			ok=false;
			System.out.println("3");
			//System.out.println("ERROR");
		}
		
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select available_unit from `pt`.`product` where idproduct='"+order_product_id+"'");
			while(myRs1.next()){
				int av_unit,req_unit;
				req_unit=Integer.parseInt(order_number_of_items);
				av_unit=Integer.parseInt(myRs1.getString("available_unit"));
				if(av_unit<req_unit){
					ok=false;
				}
			}
			}
		catch (SQLException e) {
			System.out.println("2");
			// TODO Auto-generated catch block
			ok=false;
		}
		if(ok){
			orderAcces= new OrderAccess();
			System.out.println("ii bun");
			errorMsg=orderAcces.addTheData(order_id,order_customer_id,order_product_id,order_number_of_items);
			if(errorMsg==true){
				System.out.println("4");
				return true;
			}
			else
			{
				return false;
			}
		}
		else{
			System.out.println("5");
			return true;
		}
	}

	public boolean removeData(String order_id) {
		ok=true;
		if(order_id.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select order_id from `pt`.`order`");
			ok=false;
			while(myRs1.next()){
				if(order_id.equals(myRs1.getString("order_id"))){
					ok=true;
				}
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			ok=false;
		}
		if(order_id==duplicate){
			ok=false;
		}
		if(ok){
			orderAcces= new OrderAccess();
			System.out.println("ii bun");
			errorMsg=orderAcces.removeTheData(order_id);
			if(errorMsg==true){
				return true;
			}
			else
			{
				return false;
			}
		}
		else{
			return true;
		}
	}

	public boolean updateData(String order_id, String order_customer_id, String order_product_id,
			String order_number_of_items) {
		ok=true;
		if(order_product_id.isEmpty()){
			ok=false;
		}
		if(order_id.isEmpty()){
			ok=false;
		}
		if(order_product_id.isEmpty()){
			ok=false;
		}
		if(order_number_of_items.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select order_id from `pt`.`order`");
			ok=false;
			while(myRs1.next()){
				if(order_id.equals(myRs1.getString("order_id"))){
					ok=true;
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			ok=false;
		}
//		if(product_name==duplicate){
//			ok=false;
//		}
//		try{
//			//sID_product=Integer.parseInt(id);
//		}
//		catch(NumberFormatException e){
//			//ok=false;
//			System.out.println("ERROR");
//		}
		if(ok){
			orderAcces= new OrderAccess();
			System.out.println("ii bun");
			errorMsg=orderAcces.updateTheData(order_id,order_customer_id,order_product_id,order_number_of_items);
			if(errorMsg==true){
				return true;
			}
			else
			{
				return false;
			}
		}
		else{
			return true;
		}
	}
	public boolean receipt(String order_id, String client_id,String product_id, String amount){
		PrintWriter writer;
		String client_name="";
		String product_name="";
		String product_value="";
		int quantity;
		int value;
		int totalvalue;
		//System.out.println("select name from `pt`.`customer` where idcustomer=`"+client_id+"`");
		boolean ok=true;
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select name from `pt`.`customer` where idcustomer='"+client_id+"'");
			
			ok=false;
			while(myRs1.next()){
				client_name=myRs1.getString("name");
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			ok=false;
		}
		
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select product_name from `pt`.`product` where idproduct='"+product_id+"'");
			
			ok=false;
			while(myRs1.next()){
				product_name=myRs1.getString("product_name");
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			ok=false;
		}
		
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select price_per_unit from `pt`.`product` where idproduct='"+product_id+"'");
			
			ok=false;
			while(myRs1.next()){
				product_value=myRs1.getString("price_per_unit");
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			ok=false;
		}
		value=Integer.parseInt(product_value);
		quantity=Integer.parseInt(amount);
		totalvalue=value*quantity;
		
		try {
			writer = new PrintWriter("the-file-name.txt", "UTF-8");
			writer.println("Order id: "+order_id);
			writer.println("Client name: "+client_name);
			writer.println("Product name: "+product_name);
			writer.println("Amount: "+amount);
			writer.println("Total price: "+totalvalue);
			writer.close();
		} catch (FileNotFoundException e) {
			return false;
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		return true;
	}

}
