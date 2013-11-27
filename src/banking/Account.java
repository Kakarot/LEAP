package banking;

import java.math.BigInteger;

/*
 * Interface that will be used for checking accounts and savings accounts
 */
public interface Account {

	/**
	 * Deposits money into user's account, increasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	public void deposit(BigInteger amount);
	
	/**
	 * Withdraws money from a user's account, decreasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	public void withdraw(BigInteger amount);
	
}
