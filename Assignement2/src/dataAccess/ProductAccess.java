package dataAccess;

import java.sql.SQLException;

public class ProductAccess {

	private String table = "`pt`.`product`";
	private String columns = "(idproduct, product_name, available_unit, price_per_unit)";
	private String values;
	
	public boolean addTheData(String product_id, String product_name, String product_available_unit,
			String product_price_per_unit) {
		values = "values('" + product_id + "', '" + product_name + "', '" + product_available_unit + "', '" + product_price_per_unit + "')";
		String s = "insert into " + table + columns + values;
		System.out.println(s);
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

	public boolean removeTheData(String product_id) {
		String s = "delete from `pt`.`product` where idproduct ='"+product_id+"'";
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

	public boolean updateTheData(String product_id, String product_name, String product_available_unit,
			String product_price_per_unit) {
		String s = "update `pt`.`product` set product_name= '"+product_name+"' ,available_unit= '"+product_available_unit+"', price_per_unit= '"+product_price_per_unit+"' where idproduct= '"+product_id+"'";
		System.out.println(s);
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
