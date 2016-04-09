package bll;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataAccess.CustomerAcces;
import dataAccess.DatabaseAcess;
import model.Client;

public class ClientBll {
//	private String guiName;
//	private int guiID;
	private boolean ok;
	private int ID_customer=20;
	private String duplicate;
	private Client client;
	private CustomerAcces customerAcces;
	private boolean errorMsg;
	public boolean removeData(String id){
		ok=true;
		if(id.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select idcustomer from `pt`.`customer`");
			ok=false;
			while(myRs1.next()){
				if(id.equals(myRs1.getString("idcustomer"))){
					ok=true;
				}
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id==duplicate){
			ok=false;
		}
		if(ok){
			customerAcces= new CustomerAcces();
			System.out.println("ii bun");
			errorMsg=customerAcces.removeTheData(id);
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
	
	public boolean updateData(String id,String name){
		ok=true;
		if(name.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select idcustomer from `pt`.`customer`");
			ok=false;
			while(myRs1.next()){
				if(id.equals(myRs1.getString("idcustomer"))){
					ok=true;
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name==duplicate){
			ok=false;
		}
		try{
			//sID_customer=Integer.parseInt(id);
		}
		catch(NumberFormatException e){
			//ok=false;
			System.out.println("ERROR");
		}
		if(ok){
			customerAcces= new CustomerAcces();
			System.out.println("ii bun");
			errorMsg=customerAcces.updateTheData(id, name);
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
	
	public boolean addData(String id,String name){
		ok=true;
		if(name.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select name from `pt`.`customer`");
			while(myRs1.next()){
				if(name.equals(myRs1.getString("name"))){
					ok=false;
				}
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name==duplicate){
			ok=false;
		}
		try{
			//sID_customer=Integer.parseInt(id);
		}
		catch(NumberFormatException e){
			//ok=false;
			System.out.println("ERROR");
		}
		if(ok){
			customerAcces= new CustomerAcces();
			System.out.println("ii bun");
			errorMsg=customerAcces.addTheData(id, name);
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
			//System.out.println("ERROR");
		}
	}
	public boolean validUser(String id){
		ok=true;
		if(id.isEmpty()){
			ok=false;
		}
		try {
			ResultSet myRs1=DatabaseAcess.myStm.executeQuery("select idcustomer from `pt`.`customer`");
			ok=false;
			while(myRs1.next()){
				if(id.equals(myRs1.getString("idcustomer"))){
					ok=true;
				}
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
}
