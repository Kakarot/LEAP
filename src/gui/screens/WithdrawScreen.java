package gui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

import banking.Owner;
import gui.Gui;

public class WithdrawScreen extends JPanel {
	private JTextField amt;
	private String amount ="0";
	public JButton back;
	public JButton exit;
	public JButton withdraw;
	public JRadioButton savings;
	public JRadioButton checking;
	public JButton twenty;
	public JButton fifty;
	public JButton hund;
	public JButton thou; 
	public JButton fiveHund;
	public JButton twoHund;
	public Owner newOwner;
	public JLabel currentBalanceLabel;
	public int checkingBalance,savingsBalance;
    
	
	
	public WithdrawScreen() {
		newOwner =new Owner();
		newOwner.getData();
		checkingBalance=Integer.parseInt(newOwner.getCheckingBalance());
		savingsBalance=Integer.parseInt(newOwner.getSavingsBalance());
		setLayout(null);
		
		JLabel logos = new JLabel("");
		logos.setIcon(new ImageIcon(WithdrawScreen.class.getResource("/images/logos.png")));
		logos.setBounds(0, 0, 800, 71);
		add(logos);
		
		savings = new JRadioButton("Savings Account    [Gesture 8]");
		savings.setSelected(false);
		savings.setBounds(78, 142, 228, 25);
		add(savings);
		savings.addActionListener(new OnlyOneListener(false));
		
		checking = new JRadioButton("Checking Account [Gesture 7]");
		checking.setSelected(true);
		checking.setBounds(78, 112, 248, 25);
		add(checking);
		checking.addActionListener(new OnlyOneListener(true));
		
		back = new JButton("Back");
		back.setBounds(47, 529, 97, 25);
		add(back);
		
		exit = new JButton("Exit");
		exit.setBounds(167, 529, 97, 25);
		add(exit);
		
		withdraw = new JButton("0) Withdraw");
		withdraw.setBounds(491, 253, 116, 25);
		add(withdraw);
		withdraw.addActionListener(new WithdrawalButtonListener());
		
		amt = new JTextField();
		amt.setText("0");
		amt.setColumns(10);
		amt.setBounds(363, 254, 116, 22);
		add(amt);
		
		JLabel amtToW = new JLabel("Amount to Withdraw $");
		amtToW.setBounds(219, 257, 142, 16);
		add(amtToW);
		
		JLabel lblOrPressOne = new JLabel("Or press one of these amounts:");
		lblOrPressOne.setBounds(219, 286, 206, 16);
		add(lblOrPressOne);
		
		twenty = new JButton("1) $20");
		twenty.setBounds(198, 332, 97, 25);
		add(twenty);
		twenty.addActionListener(new AmountButtonListener(20));
		
		fifty = new JButton("2) $50");
		fifty.setBounds(307, 332, 97, 25);
		add(fifty);
		fifty.addActionListener(new AmountButtonListener(50));
		
		hund = new JButton("3) $100");
		hund.setBounds(416, 332, 97, 25);
		add(hund);
		hund.addActionListener(new AmountButtonListener(100));
		
		thou = new JButton("6) $1000");
		thou.setBounds(416, 377, 97, 25);
		add(thou);
		thou.addActionListener(new AmountButtonListener(1000));
		
		fiveHund = new JButton("5) $500");
		fiveHund.setBounds(307, 377, 97, 25);
		add(fiveHund);
		fiveHund.addActionListener(new AmountButtonListener(500));
		
		twoHund = new JButton("4) $200");
		twoHund.setBounds(198, 377, 97, 25);
		add(twoHund);
		
		JLabel lblCheckingBalance = new JLabel("Available Balance: $");
		lblCheckingBalance.setBounds(198, 458, 128, 16);
		add(lblCheckingBalance);
		
		currentBalanceLabel = new JLabel(newOwner.getCheckingBalance());
		currentBalanceLabel.setBounds(338, 458, 61, 16);
		add(currentBalanceLabel);
		twoHund.addActionListener(new AmountButtonListener(200));

	}
	
	private class AmountButtonListener implements ActionListener{

		int withdrawalAmount;
		
		public  AmountButtonListener(int withdrawalAmount){
			this.withdrawalAmount=withdrawalAmount;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			amount=String.valueOf(withdrawalAmount);

			
			amt.setText(String.valueOf(amount));
			
		}
		
	} //end AmountButtonListener class

	private class WithdrawalButtonListener implements ActionListener{

		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(checking.isSelected()==true){
				
				//newOwner= new Owner();
				newOwner.getData();
				//System.out.println("Before subtract "+newOwner.getCheckingBalance());
				//newOwner.subtractChecking(new BigInteger(amount));
				//System.out.println("After subtract "+newOwner.getCheckingBalance());
				//currentBalanceLabel.setText(newOwner.getCheckingBalance());
				if(checkingBalance-Integer.valueOf(amount)>=0){
				checkingBalance-=Integer.valueOf(amount);
				currentBalanceLabel.setText(String.valueOf(checkingBalance));
				newOwner.subtractChecking(new BigInteger(amount));
				}
			}//end if statement
			else {
			//	newOwner= new Owner();
				newOwner.getData();
				
//				System.out.println("Before subtract "+newOwner.getSavingsBalance());
//				newOwner.subtractSavings(new BigInteger(amount));
//				System.out.println("After subtract "+newOwner.getSavingsBalance());
//				currentBalanceLabel.setText(newOwner.getSavingsBalance());
				if(savingsBalance-Integer.valueOf(amount)>=0){
				savingsBalance-=Integer.valueOf(amount);
				currentBalanceLabel.setText(String.valueOf(savingsBalance));
				newOwner.subtractSavings(new BigInteger(amount));
				}
			}
			
		}
		
	} //end WithdrawalButtonListener class
	
	private class OnlyOneListener implements ActionListener{

		boolean isChecking;
		
		public  OnlyOneListener(boolean isChecking){
			this.isChecking=isChecking;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(isChecking==true){
				checking.setSelected(true);
				savings.setSelected(false);
				currentBalanceLabel.setText(String.valueOf(checkingBalance));
			}
			else{
				checking.setSelected(false);
				savings.setSelected(true);
				currentBalanceLabel.setText(String.valueOf(savingsBalance));
			}
			
		}
		
	} //end AmountButtonListener class

	public void onDigitEntered(String digit) {
		if (Integer.parseInt(digit)== -1){
			back.doClick();
		}else if (Integer.parseInt(digit)== -2){
			exit.doClick();
		}else if (Integer.parseInt(digit)== 1){
			twenty.doClick();
		}else if (Integer.parseInt(digit)== 2){
			fifty.doClick();
		}else if (Integer.parseInt(digit)== 3){
			hund.doClick();
		}else if (Integer.parseInt(digit)== 4){
			twoHund.doClick();
		}else if (Integer.parseInt(digit)== 5){
			fiveHund.doClick();
		}else if (Integer.parseInt(digit)== 6){
			thou.doClick();
		}else if (Integer.parseInt(digit)== 0){
			withdraw.doClick();
		}else if (Integer.parseInt(digit)== 7){
			checking.doClick();
		}else if (Integer.parseInt(digit)== 8){
			savings.doClick();
		}
		
	} //end onDigitEntered
}
