package gui.screens;

import gui.InputListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PinScreen extends JPanel implements InputListener{
	private JTextField txtPinHere;
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
	String pswd = "";
	
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
		
		seven.setBounds(0, 99, 97, 25);
		add(seven);
		
		nine.setBounds(193, 99, 97, 25);
		add(nine);
		
		six.setBounds(193, 153, 97, 25);
		add(six);
		
		five.setBounds(97, 153, 97, 25);
		add(five);
		
		four.setBounds(0, 153, 97, 25);
		add(four);
				
		one.setBounds(0, 205, 97, 25);
		add(one);
		
		two.setBounds(97, 205, 97, 25);
		add(two);
		
		three.setBounds(193, 205, 97, 25);
		add(three);
		
		zero.setBounds(97, 264, 97, 25);
		add(zero);
		
		clear.setBounds(193, 264, 97, 25);
		add(clear);
		
		enter.setBounds(0, 264, 97, 25);
		add(enter);
		
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

	@Override
	public void onDigitEntered(String digit) {
		if (Integer.parseInt(digit)== -1){
			enter.doClick();
			System.out.println("enter pressed");
			
		}else if (Integer.parseInt(digit)==-2){
			clear.doClick();
			txtPinHere.setText("PIN here");
			pswd="";
		}else{
			
			pswd+=digit;
			txtPinHere.setText(pswd);
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
}
