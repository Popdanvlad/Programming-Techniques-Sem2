package pack;
import java.io.Serializable;
import java.util.Observable;

public abstract class Account extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double money;
	protected int accountID;
	protected String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Account(int accountID,double money,String type){
		this.money=money;
		this.accountID=accountID;
		this.type=type;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public abstract void addMoney(double money);
	public abstract void withdrawMoney(double money);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [money=" + money + ", accountID=" + accountID + "]";
	}
	
}
