package pack;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;

public class GUI1 {
	Bank bank;
	private JFrame frmAssignment;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
		
	private Object[][] dataAccounts;
	private Object[][] dataPersons;
	
	private String[] personColumnNames={"Person Name","Person ID"};
	private String[] accountColumnNames={"Account Money","Account ID","Type"};
	private JTable pTable;
	private JTable aTable;


	public GUI1() {
		bank= new Bank();
		if(FileOp.restoreBank()){
			bank.setRecords(FileOp.readBank());
		}
		initialize();
	}

	
	private void initialize() {
		frmAssignment = new JFrame();
		frmAssignment.setTitle("Assignment 4");
		frmAssignment.setBounds(100, 100, 840, 442);
		frmAssignment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAssignment.getContentPane().setLayout(null);
		
		JButton addSavingAccount = new JButton("addSavingAccount");
		addSavingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				SavingAccount a = new SavingAccount(Integer.parseInt(textField_2.getText()),Double.parseDouble(textField_3.getText()),"Saving");
				bank.addAccForPerson(p,a);
				FileOp.saveBank(bank.getRecords());
				//repaint table
			}
		});
		addSavingAccount.setBounds(10, 176, 121, 23);
		frmAssignment.getContentPane().add(addSavingAccount);
		
		JButton viewAccounts = new JButton("View Accounts");
		viewAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				displayAccountsTable(p);
				FileOp.saveBank(bank.getRecords());
			}
		});
		viewAccounts.setBounds(20, 231, 114, 23);
		frmAssignment.getContentPane().add(viewAccounts);
		
		JButton withdrawMoney = new JButton("Withdraw Money");
		withdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				SpendingAccount a = new SpendingAccount(Integer.parseInt(textField_2.getText()),Double.parseDouble(textField_3.getText()),"Saving");
				bank.withdrawMoney(a.money, a.accountID, p);
				FileOp.saveBank(bank.getRecords());
			}
		});
		withdrawMoney.setBounds(20, 279, 114, 23);
		frmAssignment.getContentPane().add(withdrawMoney);
		
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				bank.deleteAccount(Integer.parseInt(textField_2.getText()), p);
				FileOp.saveBank(bank.getRecords());
			}
		});
		deleteAccount.setBounds(20, 313, 114, 23);
		frmAssignment.getContentPane().add(deleteAccount);
		
		JButton addSpendingAccount = new JButton("Add Spending Account");
		addSpendingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				SpendingAccount a = new SpendingAccount(Integer.parseInt(textField_2.getText()),Double.parseDouble(textField_3.getText()),"Spending");
				bank.addAccForPerson(p,a);
				FileOp.saveBank(bank.getRecords());
			}
		});
		addSpendingAccount.setBounds(141, 176, 141, 23);
		frmAssignment.getContentPane().add(addSpendingAccount);
		
		JButton viewPersons = new JButton("View Persons");
		viewPersons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayPersonsTable();
				FileOp.saveBank(bank.getRecords());
			}
		});
		viewPersons.setBounds(144, 231, 114, 23);
		frmAssignment.getContentPane().add(viewPersons);
		
		JButton depositMoney = new JButton("Deposit Money");
		depositMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				SpendingAccount a = new SpendingAccount(Integer.parseInt(textField_2.getText()),Double.parseDouble(textField_3.getText()),"Spending");
				bank.depositMoney(a.money, a.accountID, p);
				FileOp.saveBank(bank.getRecords());
			}
		});
		depositMoney.setBounds(144, 279, 114, 23);
		frmAssignment.getContentPane().add(depositMoney);
		
		JButton deletePerson = new JButton("Delete Person");
		deletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person p = new Person(textField_1.getText(),Integer.parseInt(textField.getText()));
				bank.deletePerson(p);
				FileOp.saveBank(bank.getRecords());
			}
		});
		deletePerson.setBounds(144, 313, 114, 23);
		frmAssignment.getContentPane().add(deletePerson);
		
		textField = new JTextField();
		textField.setBounds(172, 11, 110, 20);
		frmAssignment.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 49, 110, 20);
		frmAssignment.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 93, 110, 20);
		frmAssignment.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 134, 110, 20);
		frmAssignment.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPersonId = new JLabel("Person ID");
		lblPersonId.setBounds(20, 14, 86, 14);
		frmAssignment.getContentPane().add(lblPersonId);
		
		JLabel lblPersonName = new JLabel("Person Name");
		lblPersonName.setBounds(20, 52, 86, 14);
		frmAssignment.getContentPane().add(lblPersonName);
		
		JLabel lblNewLabel = new JLabel("Account ID");
		lblNewLabel.setBounds(20, 96, 73, 14);
		frmAssignment.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Money");
		lblNewLabel_1.setBounds(26, 137, 46, 14);
		frmAssignment.getContentPane().add(lblNewLabel_1);
		
		
		//displayAccountTable(p);
		
		frmAssignment.setVisible(true);

	}
	public void displayPersonsTable(){
		
		 
		 
		int i=0;
		dataPersons= new Object[10][2];
		
		Collection <Person> persons=bank.getRecords().keySet();
		for(Person p1 : persons){
			dataPersons[i][0]=p1.getName();
			dataPersons[i][1]=p1.getPersonID();
			i++;
		}
		pTable = new JTable(dataPersons,personColumnNames);
		pTable.setBounds(390, 14, 209, 133);
		 //frmAssignment.getContentPane().add(personTable);
		 frmAssignment.getContentPane().add(pTable);
		 frmAssignment.setVisible(true);
		 
		 
	}
	
	public void displayAccountsTable(Person p){
		int i=0;
		dataAccounts= new Object[10][3];
		
		Set<Account> accounts = bank.getRecords().get(p);
		for(Account a:accounts){
			dataAccounts[i][0]=a.getMoney();
			dataAccounts[i][1]=a.getAccountID();
			dataAccounts[i][2]=a.getType();
			i++;
		}
		 aTable =new JTable(dataAccounts,accountColumnNames);
		 aTable.setBounds(390, 207, 209, 185);
		 frmAssignment.getContentPane().add(aTable);
		 frmAssignment.setVisible(true);
	}
}
