package pack;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Bank implements BankI{
	private Map<Person,Set<Account>> records;
	public Bank(){
		records= new HashMap<Person,Set<Account>>();
	}
	@Override
	public void addAccForPerson(Person p, Account assocAcc){
		assert p!=null: "The person must not be NULL";
		assert isWellFormed(): "Not well Formed!";
		int preSize;
		if(records.containsKey(p)){
			Set<Account> accounts = records.get(p);
			preSize= records.get(p).size();
			records.get(p).add(assocAcc);
		}
		else{
			Set<Account> accounts = new HashSet<Account>();
			preSize=0;
			accounts.add(assocAcc);
			records.put(p, accounts);
		}
		int postSize=records.get(p).size();
		assert preSize!=postSize-1:"Account not added";
		assocAcc.addObserver(p);
	}
	
	public void depositMoney(double sum,int accID, Person p){
		double initialSum=currentSum(p,accID);
		assert sum!=0:"Suma 0";
		assert p!=null:"persoana invalida";
		assert isWellFormed(): "Not well Formed!";
		if(records.containsKey(p)){
			Set<Account> accounts = records.get(p);
			for(Account a:accounts){
				if(a.getAccountID()==accID){
					a.addMoney(sum);
				}
			}
		}
		else{
			System.out.println("NU EXISTA");
		}
		assert currentSum(p,accID)==initialSum+sum;
	}
	public void withdrawMoney(double sum,int accID, Person p){
		double initialSum=currentSum(p,accID);
		assert sum!=0:"Suma 0";
		assert p!=null:"persoana invalida";
		assert isWellFormed(): "Not well Formed!";
		if(records.containsKey(p)){
			Set<Account> accounts = records.get(p);
			for(Account a:accounts){
				if(a.getAccountID()==accID){
					a.withdrawMoney(sum);
				}
			}
		}
		else{
			System.out.println("NU EXISTA");
		}
		assert currentSum(p,accID)==initialSum-sum;
	}
	
	public boolean isWellFormed(){
		for(Entry<Person, Set<Account>> entry:records.entrySet()){
			if(entry.getValue()==null||entry.getValue().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Bank [records=" + records + "]";
	}
	@Override
	public void deleteAccount(int accountID, Person p) {
		assert p!=null:"persoana invalida";
		assert isWellFormed(): "Not well Formed!";
		if(records.containsKey(p)){
			Set<Account> accounts = records.get(p);
			for(Account a:accounts){
				if(a.getAccountID()==accountID){
					records.get(p).remove(a);
				}
			}
		}
		else{
			System.out.println("NU EXISTA");
		}
		
	}
	@Override
	public void deletePerson(Person p) {
		assert p!=null:"persoana invalida";
		assert isWellFormed(): "Not well Formed!";
		if(records.containsKey(p)){
			records.remove(p);
		}
		else{
			System.out.println("Person not existing");
		}
		assert records.containsKey(p):"Person not deleted";
	}
	@Override
	public List<Person> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Account> findAllAccountsForPerson(Person p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double currentSum(Person p,int accId){
		Collection <Person> persons=records.keySet();
		for(Person p1 : persons){
			if(p1.equals(p)){
				Set<Account> accounts = records.get(p);
				for(Account a:accounts){
					if(a.getAccountID()==accId){
						return a.getMoney();
					}
				}
			}
		}
		return 0;
	}
	public Map<Person, Set<Account>> getRecords() {
		return records;
	}
	public void setRecords(Map<Person, Set<Account>> records) {
		this.records = records;
	}
	
}
