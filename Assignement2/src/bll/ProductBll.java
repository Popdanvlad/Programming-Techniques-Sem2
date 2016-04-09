package bll;

import java.sql.ResultSet;
import java.sql.SQLException;


import dataAccess.DatabaseAcess;
import dataAccess.ProductAccess;
import model.Client;

public class ProductBll {

	private boolean ok;
	private int ID_product=20;
	private String duplicate;
	private Client client;
	private ProductAccess productAcces;
	private boolean errorMsg;
	
	public boolean addData(String product_id, String product_name, String product_available_unit,
			String product_price_per_unit) {
		ok=true;
		if(product_id.isEmpty()){
			ok=false;
			//System.out.println("1");
		}
		if(product_name.isEmpty()){
			System.out.println("1");
			ok=false;
		}
		if(product_available_unit.isEmpty()){
			System.out.println("1");
			ok=false;
		}
		if(product_price_per_unit.isEmpty()){
			System.out.println("1");
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select product_name from `pt`.`product`");
			while(myRs1.next()){
				if(product_name.equals(myRs1.getString("product_name"))){
					ok=false;
				}
			}
			}
		catch (SQLException e) {
			System.out.println("2");
			// TODO Auto-generated catch block
			ok=false;
		}
//		if(name==duplicate){
//			ok=false;
//		}
		try{
			ID_product=Integer.parseInt(product_id);
		}
		catch(NumberFormatException e){
			ok=false;
			System.out.println("3");
			//System.out.println("ERROR");
		}
		if(ok){
			productAcces= new ProductAccess();
			System.out.println("ii bun");
			errorMsg=productAcces.addTheData(product_id,product_name,product_available_unit,product_price_per_unit);
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

	public boolean removeData(String product_id) {
		ok=true;
		if(product_id.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select idproduct from `pt`.`product`");
			ok=false;
			while(myRs1.next()){
				if(product_id.equals(myRs1.getString("idproduct"))){
					ok=true;
				}
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(product_id==duplicate){
			ok=false;
		}
		if(ok){
			productAcces= new ProductAccess();
			System.out.println("ii bun");
			errorMsg=productAcces.removeTheData(product_id);
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

	public boolean updateData(String product_id, String product_name, String product_available_unit,
			String product_price_per_unit) {
		ok=true;
		if(product_id.isEmpty()){
			ok=false;
		}
		if(product_name.isEmpty()){
			ok=false;
		}
		if(product_available_unit.isEmpty()){
			ok=false;
		}
		if(product_price_per_unit.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select idproduct from `pt`.`product`");
			ok=false;
			while(myRs1.next()){
				if(product_id.equals(myRs1.getString("idproduct"))){
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
			productAcces= new ProductAccess();
			System.out.println("ii bun");
			errorMsg=productAcces.updateTheData(product_id,product_name,product_available_unit,product_price_per_unit);
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
}

