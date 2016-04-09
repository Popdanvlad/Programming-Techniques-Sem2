package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAcess {
	private String idText;
	private String productText;
	public static Statement myStm;
	private String table = "`store`.`products`";
	private String columns = "(idProducts, product)";
	private String values;

	public static Connection myConn;

	//public void database(String s1, String s2) {
	public void database() {
		try {
			// Get a connection to the DB
			
			myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root");
			System.out.println("***");
			// Create a statement
			myStm = myConn.createStatement();
			
			ResultSet myRs=myStm.executeQuery("select * from `pt`.`customer`");
			
			while(myRs.next()){
				System.out.println(myRs.getString("idcustomer")+ "  " +myRs.getString("name"));
			}
			// execute an sql Query
		/*	values = "values('" + s1 + "', '" + s2 + "')";
			String s = "insert into " + table + columns + values;
			insertUpdateData(s);

			String su = "update `store`.`products` set product= 'TALISMAN' where idProducts= 'A50'";
			insertUpdateData(su);

			String sd = "delete from `store`.`products` where idProducts ='78'";
			insertUpdateData(sd);

			showData();
			System.out.println("     ");
			System.out.println("     ");
			showComplexData();
*/
		} catch (Exception exc) {
			exc.printStackTrace();
		
		}
	}

	public void showData() throws SQLException {
		ResultSet myRez = myStm.executeQuery("select idProducts, product  from `store`.`products`order by idProducts");

		// process the result
		while (myRez.next()) {
			String name = myRez.getString("product");
			String ID = myRez.getString("idProducts");
			System.out.println(ID + "    " + name);
		}
	}

	public void showComplexData() throws SQLException {
		ResultSet myRez = myStm
				.executeQuery("SELECT idProducts, product, price, nrInStock, shops FROM `store`.`products`"
						+ "JOIN `store`.`price` ON `products`.`idProducts` = `price`.`idProduct`"
						+ "JOIN `store`.`stock` ON `products`.`idProducts` = `stock`.`idProduct`"
						+ "JOIN `store`.`shops` ON `stock`.`shop` = `shops`.`idShops`" + "order by idProducts");

		while (myRez.next()) {
			String ID = myRez.getString("idProducts");
			String name = myRez.getString("product");
			String price = myRez.getString("price");
			String nr = myRez.getString("nrInStock");
			String shop = myRez.getString("shops");
			System.out.println(ID + "  " + name + "  " + shop + "  " + nr + "  " + price + "  ");
		}
	}

	public void insertUpdateData(String s) throws SQLException {
		myStm.executeUpdate(s);
	}

	public void insertText(String id, String product) {
		idText = id;
		productText = product;
	//	database(idText, productText);
	}

}
