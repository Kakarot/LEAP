package banking;

import java.math.BigInteger;

public class BankAccount implements Account {

	
	
private BigInteger balance;
	
	public BankAccount(){
		balance=new BigInteger("0");
	}
	
	public BankAccount(String initialAmount){
		balance=new BigInteger(initialAmount);
	}

	/**
	 * Deposits money into user's account, increasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	@Override
	public void deposit(BigInteger amount) {
		balance=balance.add(amount);

	}

	/**
	 * Withdraws money from a user's account, decreasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	@Override
	public void withdraw(BigInteger amount) {
		balance=balance.subtract(amount);

	}
	
	/**
	 * Getter method for balance
	 * 
	 * @return BigInteger returns BigInteger object representation of balance
	 */
	public BigInteger getBalance(){
		return balance;
		
	}

}
