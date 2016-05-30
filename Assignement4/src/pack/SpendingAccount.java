package pack;
import java.io.Serializable;

public class SpendingAccount extends Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpendingAccount(int accountID, double money, String type) {
		super(accountID, money,type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMoney(double money) {
		this.money=this.money+money;
		setChanged();
		notifyObservers(money);
		notifyObservers(money+" Have been added to the account "+super.accountID);
		
	}

	@Override
	public void withdrawMoney(double money) {
		this.money=this.money-money;
		setChanged();
		notifyObservers(money+" Have been withdrawed from the account "+super.accountID);
		
	}
	
}
