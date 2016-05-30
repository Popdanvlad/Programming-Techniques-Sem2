package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import pack.Bank;
import pack.Person;
import pack.SpendingAccount;

public class TestBank {
	private Bank bank = new Bank();
	private Person p= new Person("Jimmy",32);
	@Test
	public void testDepositMoney() {
		bank.addAccForPerson(p, new SpendingAccount(12,0,"Jimmy"));
		bank.depositMoney(25, 12, p);
		assertEquals(bank.currentSum(p, 12),25,2);
	}

}
