package main;

import dataAccess.DatabaseAcess;
import gui.GUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseAcess data= new DatabaseAcess();
		data.database();
		Controller controller = new Controller();
	}

}
