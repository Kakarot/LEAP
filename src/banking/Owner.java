package banking;

import java.util.List;
import java.io.IOException;
import java.math.BigInteger;


import save.LoadState;
import save.SaveState;
import security.Verification;

public class Owner {

	static String name="Kakarot";
	private short pin; // PINS are 4 digits for ATM compatibility amongst banks
	// private Verification verify;

	//	private boolean login = false;

	BankAccount savings;
	BankAccount checking;
	List<String> data;
	
	
	
	/**
	 * Loads the owner's checking, savings, and pin. Emulates retrieving banking information from bank.
	 */
	public void getData(){

		try {
			data=LoadState.readSave();
		} catch (IOException e) {

			e.printStackTrace();
		}

		name=data.get(0);
		checking=new BankAccount(data.get(1));
		savings= new BankAccount(data.get(2));
		pin=Short.parseShort(data.get(3));


	}

	/**
	 * Deposits money to the owners checking account, increasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	public void addChecking(BigInteger amount){
		checking.deposit(amount);
		try {
			SaveState.storeState(name,getCheckingBalance(),getSavingsBalance(), data.get(3));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Withdraws money from the owners checking account, decreasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	public void subtractChecking(BigInteger amount){
		checking.withdraw(amount);
		try {
			SaveState.storeState(name,getCheckingBalance(),getSavingsBalance(),data.get(3));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Deposits money to the owners savings account, increasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	public void addSavings(BigInteger amount){
		savings.deposit(amount);
		try {
			SaveState.storeState(name,getCheckingBalance(),getSavingsBalance(), data.get(3));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	/**
	 * Withdraws money from the owners savings account, decreasing their balance
	 * 
	 * @param amount 
	 * @return void
	 */
	public void subtractSavings(BigInteger amount){
		savings.withdraw(amount);
		try {
			SaveState.storeState(name,getCheckingBalance(),getSavingsBalance(),data.get(3));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	/**
	 * Getters and setters, names are self-explanatory
	 */
	public short getPin(){
		return pin;
	}

	public void changePin(short pin){
		this.pin=pin;
	}

	public String getCheckingBalance(){
		return checking.getBalance().toString();
	}
	public String getSavingsBalance(){
		return savings.getBalance().toString();
	}

	public String getName(){
		return name;
	}
	public List<String> getList(){
		return data;
	}

}
