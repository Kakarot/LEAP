package gui.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.InputListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PinScreen extends JPanel implements InputListener{
	public JTextField txtPinHere;
	public short pinNumber =1234;
	public JButton zero = new JButton("0");
	public JButton one = new JButton("1");
	public JButton two = new JButton("2");
	public JButton three = new JButton("3");
	public JButton four = new JButton("4");
	public JButton five = new JButton("5");
	public JButton six = new JButton("6");
	public JButton seven = new JButton("7");
	public JButton eight = new JButton("8");
	public JButton nine = new JButton("9");
	public JButton clear = new JButton("clear");
	public JButton enter = new JButton("enter");
	//public JButton[] buttons = { zero, one, two, three, four, five, six, seven, eight, nine, clear, enter };
	
	static PinScreen instance;
	public String pswd = "";
	
	private PinScreen() {
		
		setLayout(null);
	
		
		JLabel gestures = new JLabel("");
		gestures.setIcon(new ImageIcon(PinScreen.class.getResource("/images/GestureGuide.png")));
		gestures.setBounds(350, 205, 450, 365);
		add(gestures);
		
		txtPinHere = new JTextField();
		txtPinHere.setText("PIN here");
		txtPinHere.setBounds(91, 334, 116, 22);
		add(txtPinHere);
		txtPinHere.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PinScreen.class.getResource("/images/logos.png")));
		label.setBounds(0, 0, 800, 71);
		add(label);
		
		eight.setBounds(97, 99, 97, 25);
		add(eight);
		eight.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Eight");
				pswd+="8";
				txtPinHere.setText(pswd);
				}
				
			}
        });   
		
		
		seven.setBounds(0, 99, 97, 25);
		add(seven);
		seven.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Seven");
				pswd+="7";
				txtPinHere.setText(pswd);
				}
				
			}
        });   
		
		
		nine.setBounds(193, 99, 97, 25);
		add(nine);
		nine.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Nine");
				pswd+="9";
				txtPinHere.setText(pswd);
				}
				
			}
        });   
		
		six.setBounds(193, 153, 97, 25);
		add(six);
		six.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Six");
				pswd+="6";
				txtPinHere.setText(pswd);
				}
			}
        });   
		
		five.setBounds(97, 153, 97, 25);
		add(five);
		five.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Five");
				pswd+="5";
				txtPinHere.setText(pswd);
				}
			}
        });   
		
		four.setBounds(0, 153, 97, 25);
		add(four);
		four.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Four");
				if(pswd.length()<4){
				pswd+="4";
				txtPinHere.setText(pswd);
				}
			}
        });   
				
		one.setBounds(0, 205, 97, 25);
		add(one);
		one.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("One");
				pswd+="1";
				txtPinHere.setText(pswd);
				}
			}
        });   
		
		two.setBounds(97, 205, 97, 25);
		add(two);
		two.addActionListener(new PinButtonListener(2));
	    
//		two.addActionListener(new ActionListener() {
//			 
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(pswd.length()<4){
//				System.out.println("Two");
//				pswd+="2";
//				txtPinHere.setText(pswd);
//				}
//			}
//        });   
		
		three.setBounds(193, 205, 97, 25);
		add(three);
		three.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Three");
				pswd+="3";
				txtPinHere.setText(pswd);
				}
			}
        });   
		
		zero.setBounds(97, 264, 97, 25);
		add(zero);
		zero.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()<4){
				System.out.println("Zero");
				pswd+="0";
				txtPinHere.setText(pswd);
				}
			}
        });   
		
		clear.setBounds(193, 264, 97, 25);
		add(clear);
		clear.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pin Field has been cleared!");
				pswd="";
				txtPinHere.setText(pswd);
				
			}
        });   
		
		enter.setBounds(0, 264, 97, 25);
		add(enter);
		enter.addActionListener(new ActionListener() {
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pswd.length()>0 && Short.parseShort(pswd)==pinNumber){
					//enter.doClick();
					
					System.out.println("enter pressed");
					}
				//	System.out.println("Incorret PIN, please try again!");
				
			}
        });   
		
		JLabel lblPleaseEnterThe = new JLabel("<html>Please enter the correct pin using the pin pad or the associated gestures from the Gesture Guide below:</html>");
		lblPleaseEnterThe.setBounds(365, 103, 405, 96);
		add(lblPleaseEnterThe);
		
		/*TestListener test_lit = new TestListener();
		Controller controller = new Controller();
		controller.addListener(test_lit);
		System.out.println("Press Enter to quit.");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		controller.removeListener(test_lit);*/
	}

	/**
	 * This is the method that passes the digits parsed via the LEAP Motion sensor (Controller)
	 * to the PIN screen logic (and text area).
	 */
	
	@Override
	public void onDigitEntered(String digit) {
		if (Integer.parseInt(digit)== -1){
			//I check for a String bigger than zero to avoid comparison error
			//I check for the pinNumber to equal the password
			if(pswd.length()>0 && Short.parseShort(pswd)==pinNumber){
			enter.doClick();
			System.out.println("enter pressed");
			}else{
			System.out.println("Incorret PIN, please try again!");
			}
		}else if (Integer.parseInt(digit)==-2){
			clear.doClick();
			txtPinHere.setText("PIN here");
			pswd="";
		}else{
			
			if(pswd.length()<4){
			pswd+=digit;
			txtPinHere.setText(pswd);
			}//end if statement
		}
		
		
		
	}
	
	public static PinScreen getInstance() {
		if (instance == null) {
			synchronized (PinScreen.class) {
				if (instance == null) {
					System.out.println("First Time Pinscreen was invoked");
					instance = new PinScreen();
				}
			}
		}
		return instance;
	}
	private class PinButtonListener implements ActionListener{
		int pinNum;
		
		public PinButtonListener(int pinNum){
			this.pinNum=pinNum;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(pswd.length()<4){
				pswd+=pinNum;
				txtPinHere.setText(pswd);
			}
			
		}
		
	}//end
	
	
}
