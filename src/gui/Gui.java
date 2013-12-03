package gui;

import gui.screens.DepositScreen;
import gui.screens.OptionScreen;
import gui.screens.PinScreen;
import gui.screens.StartScreen;
import gui.screens.WithdrawScreen;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import motionExample.TestListener;
import banking.Owner;

import com.leapmotion.leap.Controller;

public class Gui extends JFrame implements InputListener{
	private StartScreen start ;
	private PinScreen pin;
	private OptionScreen option;
	//private DepositScreen dep ;
	private WithdrawScreen with;

	private Owner newOwner;

	TestListener listener;
	Controller controller;
	static Gui guiInstance; 
	private Gui() {
		setPreferredSize(new Dimension(800, 600));
		setResizable(false);

		start = new StartScreen();
		pin = PinScreen.getInstance();
		option = OptionScreen.getInstance();
//		dep = new DepositScreen();
		with = new WithdrawScreen();


		start.begin.addActionListener(new PinListener());
		pin.enter.addActionListener(new OptionListener());
//		option.savings.addActionListener(new DepositListener());
		option.withdraw.addActionListener(new WithdrawListener());
		option.end.addActionListener(new ExitListener());
		add(start);

		listener = new TestListener();
		controller = new Controller();
		controller.addListener(listener);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(Gui.this,
						"Are you sure to close this window?",
						"Really Closing?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					// disconnect the tester
					controller.removeListener(listener);
					dispose();
					System.exit(0);
				}
			}
		});
		pack();
		setVisible(true);
	}

	public void changeToStart(JPanel screen) {
		remove(screen);
		add(start);
		pack();
	}

	public void changeToPin(JPanel screen) {
		remove(screen);
		add(pin);
		pack();

		// When user clicks begin, we pretend credit card was inserted and load
		// account data
		newOwner = new Owner();
		newOwner.getData();
		System.out.println("Welcome " + newOwner.getName());
	}

	public void changeToOption(JPanel screen) {
		remove(screen);
		add(option);
		pack();
	}

//	public void changeToDeposit(JPanel screen) {
//		dep = new DepositScreen();
//		dep.back.addActionListener(new OptionListener());
//		dep.exit.addActionListener(new ExitListener());
//		remove(screen);
//		add(dep);
//		pack();
//
//	}

	public void changeToWithdraw(JPanel screen) {
		with = new WithdrawScreen();
		with.back.addActionListener(new OptionListener());
		with.exit.addActionListener(new ExitListener());
		remove(screen);
		add(with);
		pack();
	}

	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeToStart((JPanel) ((JButton) e.getSource()).getParent());
			repaint();
		}
	}

	private class PinListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			
			changeToPin((JPanel) ((JButton) e.getSource()).getParent());
			repaint();
		
		}

	}

	private class OptionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//			controller.removeListener(listener);
			// Compare entered PIN with stored PIN
			//if (pinNumber == Short.parseShort(newOwner.getList().get(3))) {
			if(pin.pswd.length()>0 && Short.parseShort(pin.pswd)==pin.pinNumber){
				changeToOption((JPanel) ((JButton) e.getSource()).getParent());
				System.out.println("changed to Option window");
				repaint();
			} // end if
		
		} // end actionPerformed
	}// end OptionListener

	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeToStart((JPanel) ((JButton) e.getSource()).getParent());
			repaint();
		}
	}

//	private class DepositListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			changeToDeposit((JPanel) ((JButton) e.getSource()).getParent());
//			repaint();
//
//		}
//	}

	private class WithdrawListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			changeToWithdraw((JPanel) ((JButton) e.getSource()).getParent());
			repaint();
		}
	}

	public static Gui getInstance() {
		if (guiInstance == null) {
			synchronized (Gui.class) {
				if (guiInstance == null) {
					System.out.println("First Time Gui was invoked");
					guiInstance = new Gui();
				}
			}
		}
		return guiInstance;
	}

	@Override
	public void onDigitEntered(String digit) {

		Component component = ((JRootPane)getComponent(0)).getContentPane().getComponent(0);



		if (component.equals(pin)){
			pin.onDigitEntered(digit);
		}else if(component.equals(option)){
			option.onDigitEntered(digit);
		}else if(component.equals(start)){
			start.onDigitEntered(digit);
		}else if(component.equals(with)){
			with.onDigitEntered(digit);
		}
	}

	//	public void getPIN(){
	//		pin.
	//	}
}