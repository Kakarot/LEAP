package save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveState {

	/**
	 * This saves the owner's account information
	 * @param name The owner's name
	 * @param checkingBalance string representation of checking account balance
	 * @param savingsBalance string representation of savings account balance
	 * @param pin string representation of pin number
	 */
	public static void storeState(String name, String checkingBalance, String savingsBalance, String pin)
			throws IOException{
		
		String file ="Balance.dat";
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter outFile = new PrintWriter(bw);
		
		outFile.println(name+"\n"+checkingBalance+"\n"+savingsBalance+"\n"+pin);
		outFile.close();
	}//end storeState class
	
}
