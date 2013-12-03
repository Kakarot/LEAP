package gui.screens;

import gui.InputListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import banking.Owner;

public class OptionScreen extends JPanel implements InputListener{
	public JButton balance;
	public JButton savings;
	public JButton withdraw;
	public JButton end;
	
	private static OptionScreen instance;
	
	private OptionScreen() {
		setLayout(null);

		JLabel logos = new JLabel("");
		logos.setBounds(0, 0, 800, 71);
		logos.setIcon(new ImageIcon(StartScreen.class
				.getResource("/images/logos.png")));
		add(logos);
		JLabel gestures = new JLabel("");
		gestures.setIcon(new ImageIcon(PinScreen.class.getResource("/images/GestureGuide.png")));
		gestures.setBounds(350, 205, 450, 365);
		add(gestures);

		balance = new JButton("0) Check Balance");
		balance.setBounds(63, 114, 181, 53);
		add(balance);
		balance.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				Owner newOwner=new Owner();
				newOwner.getData();
				System.out.println(newOwner.getCheckingBalance());
				
			}
        });   
		
		savings = new JButton("1) Check Savings");
		savings.setBounds(63, 205, 181, 53);
		add(savings);
		savings.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				Owner newOwner=new Owner();
				newOwner.getData();
				System.out.println(newOwner.getSavingsBalance());
				
			}
        });   
		
		withdraw = new JButton("2) Withdraw");
		withdraw.setBounds(63, 289, 181, 53);
		add(withdraw);
		
		end = new JButton("3) End");
		end.setBounds(63, 382, 181, 53);
		add(end);
		
		JLabel lblPleaseUseThe = new JLabel("<html>Please use the pin pad or following gestures from the Gesture Guide to choose your next action.</html>");
		lblPleaseUseThe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPleaseUseThe.setBounds(382, 105, 379, 92);
		add(lblPleaseUseThe);
	}

	@Override
	public void onDigitEntered(String digit) {
		if (digit.equals("0")){
			balance.doClick();
		}
			else if(digit.equals("1")){
			savings.doClick();
		}
	else if(digit.equals("2")){
			withdraw.doClick();
		}else if(digit.equals("3")){
			end.doClick();
		}
		
	}
	
	public static OptionScreen getInstance() {
		if (instance == null) {
			synchronized (OptionScreen.class) {
				if (instance == null) {
					System.out.println("First Time OptionScreen was invoked");
					instance = new OptionScreen();
				}
			}
		}
		return instance;
	}
}
