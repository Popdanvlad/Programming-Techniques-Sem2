package dataAccess;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Client;

public class CustomerAcces {
	private String table = "`pt`.`customer`";
	private String columns = "(idcustomer, name)";
	private String values;
	
	public boolean addTheData(String id,String name){
		System.out.println("AICI");
		values = "values('" + id + "', '" + name + "')";
		String s = "insert into " + table + columns + values;
		try {
			DatabaseAcess.myStm.executeUpdate(s);		
			System.out.println("II BUENO");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("EROORORORORORO");
			//e.printStackTrace();
			return true;
		}
	}
	public boolean removeTheData(String id){
		String s = "delete from `pt`.`customer` where idcustomer ='"+id+"'";
		try {
			DatabaseAcess.myStm.executeUpdate(s);
			System.out.println("II BUENO");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("EROORORORORORO");
			return true;
		}
	}
	
	public boolean updateTheData(String id, String name){
		String s = "update `pt`.`customer` set name= '"+name+"' where idcustomer= '"+id+"'";
		try {
			DatabaseAcess.myStm.executeUpdate(s);
			System.out.println("II BUENO");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("EROORORORORORO");
			return true;
		}
	}
	
}
