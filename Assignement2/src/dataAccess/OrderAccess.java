package dataAccess;

import java.sql.SQLException;

public class OrderAccess {

	private String table = "`pt`.`order`";
	private String columns = "(order_id, customer_id, product_id, number_of_items)";
	private String values;
	
	public boolean addTheData(String order_id, String order_customer_id, String order_product_id,
			String order_number_of_items) {
		values = "values('" + order_id + "', '" + order_customer_id + "', '" + order_product_id + "', '" + order_number_of_items + "')";
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

	public boolean removeTheData(String order_id) {
		String s = "delete from `pt`.`order` where order_id ='"+order_id+"'";
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

	public boolean updateTheData(String order_id, String order_customer_id, String order_product_id,
			String order_number_of_items) {
		String s = "update `pt`.`product` set product_name= '"+order_customer_id+"' ,available_unit= '"+order_product_id+"', price_per_unit= '"+order_number_of_items+"' where idproduct= '"+order_id+"'";
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
