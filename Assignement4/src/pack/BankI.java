package pack;
import java.util.List;
import java.util.Set;

public interface BankI {
	/**
	 * 
 * @preCondition p!=null  && account!=null
 * @postCondition preSize accounts= postSize accounts -1
	 * @param p
	 * @param acc
	 */
	public void addAccForPerson(Person p, Account assocAcc);
	
	/*
	 * @preCondition sum!=0 && p!=null
	 * PostCondition currentSum(p,accID)==@preContidion currentSum(p,accID)+sum
	 */
	
	public void depositMoney(double sum,int accID,Person p);
	/*
	 * @preCondition sum!=0 && p!=null
	 * PostCondition currentSum(p,accID)==@preContidion currentSum(p,accID)-sum
	 */
	
	public void withdrawMoney(double sum,int accID,Person p);
	public void deleteAccount(int accountID,Person p);
	public void deletePerson(Person p);
	/**
	 * 
	 * @return
	 */
	public List<Person> findAllPersons();
	public Set<Account> findAllAccountsForPerson(Person p);
	
}
