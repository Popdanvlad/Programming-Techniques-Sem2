package pack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileOp {

	/**
	 * Save a tree in a serialized txt file "order.txt"
	 * 
	 * @param t of type Tree
	 */
	public static void saveBank(Map<Person, Set<Account>> t) {
		try {
			FileOutputStream file = new FileOutputStream("bank.txt");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			obj.writeObject(t);
			obj.close();
		} catch (Exception e) {
			System.out.println("err" + e.toString());
		}
	}

	/**
	 * Read a tree from a serialized txt file
	 * @return a tree in case of success
	 * @return null in case of ERROR
	 */
	public static Map<Person, Set<Account>> readBank() {
		try {
			FileInputStream file = new FileInputStream("bank.txt");
			Map<Person, Set<Account>> t = (Map<Person, Set<Account>>) new ObjectInputStream(file).readObject();
			return t;
		} catch (Exception e) {
			System.out.println("err" + e.toString());
			return null;
		}
	}

	/**
	 * Restore a tree from a serialized txt file
	 * @return true if the tree can be read
	 * @return false if the read function encounters an error
	 */
	public static boolean restoreBank() {
		Map<Person, Set<Account>> tr = new HashMap<Person, Set<Account>>();
		if (readBank() != null) {
			tr = readBank();
			return true;
		} else {
			return false;
		}
	}
}
