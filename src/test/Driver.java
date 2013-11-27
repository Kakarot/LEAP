
package test;


import java.math.BigInteger;

import banking.Owner;


/**
 * @author James Ruiz
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Owner newOwner =new Owner();
		
	     newOwner.getData();
		 System.out.println("\nName: "+newOwner.getName()+"\nChecking: "+newOwner.getCheckingBalance()+"\nSavings: "+
				 newOwner.getSavingsBalance());
		 System.out.println("\n\nName: "+newOwner.getList().get(0)+"\nChecking: "+newOwner.getList().get(1)+"\nSavings: "+
				 newOwner.getList().get(2)+"\nPIN: "+newOwner.getList().get(3));
		 
		 //adding twenty
		newOwner.addChecking(new BigInteger("77"));
		 

//		 newOwner.getData();
//		 System.out.println("\nName: "+newOwner.getName()+"\nChecking: "+newOwner.getCheckingBalance()+"\nSavings: "+
//				 newOwner.getSavingsBalance());
//		 System.out.println("\n\nName: "+newOwner.getList().get(0)+"\nChecking: "+newOwner.getList().get(1)+"\nSavings: "+
//				 newOwner.getList().get(2)+"\nPIN: "+newOwner.getList().get(3));
		 System.out.println(newOwner.getCheckingBalance());
	}

}