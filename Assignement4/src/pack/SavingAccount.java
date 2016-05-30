package pack;
import java.io.Serializable;

public class SavingAccount extends Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int nrOfWithdraws;
	public SavingAccount(int accountID, double money,String type) {
		super(accountID, money,type);

		nrOfWithdraws=1;
	}

	public int getNrOfWithdraws() {
		return nrOfWithdraws;
	}

	public void setNrOfWithdraws(int nrOfWithdraws) {
		this.nrOfWithdraws = nrOfWithdraws;
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
		if(nrOfWithdraws>0){
			this.money=this.money-money;
			nrOfWithdraws--;
			setChanged();
			notifyObservers(money);
			notifyObservers(money+" Have been withdrawed from the account "+super.accountID);	
		}
		
	}

}
