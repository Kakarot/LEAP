package gui.screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

public class WithdrawScreen extends JPanel {
	private JTextField amt;
	public JButton back;
	public JButton exit;
	public WithdrawScreen() {
		setLayout(null);
		
		JLabel logos = new JLabel("");
		logos.setIcon(new ImageIcon(WithdrawScreen.class.getResource("/images/logos.png")));
		logos.setBounds(0, 0, 800, 71);
		add(logos);
		
		JRadioButton savings = new JRadioButton("Savings Account");
		savings.setSelected(true);
		savings.setBounds(78, 142, 175, 25);
		add(savings);
		
		JRadioButton checking = new JRadioButton("Checking Account");
		checking.setSelected(true);
		checking.setBounds(78, 112, 175, 25);
		add(checking);
		
		back = new JButton("Back");
		back.setBounds(47, 529, 97, 25);
		add(back);
		
		exit = new JButton("Exit");
		exit.setBounds(167, 529, 97, 25);
		add(exit);
		
		JButton withdraw = new JButton("Withdraw");
		withdraw.setBounds(491, 253, 97, 25);
		add(withdraw);
		
		amt = new JTextField();
		amt.setText("0.00");
		amt.setColumns(10);
		amt.setBounds(363, 254, 116, 22);
		add(amt);
		
		JLabel amtToW = new JLabel("Amount to Withdraw: $");
		amtToW.setBounds(219, 257, 142, 16);
		add(amtToW);
		
		JLabel lblOrPressOne = new JLabel("Or press one of these amounts:");
		lblOrPressOne.setBounds(219, 286, 195, 16);
		add(lblOrPressOne);
		
		JButton twenty = new JButton("$20");
		twenty.setBounds(198, 332, 97, 25);
		add(twenty);
		
		JButton fifty = new JButton("$50");
		fifty.setBounds(307, 332, 97, 25);
		add(fifty);
		
		JButton hund = new JButton("$100");
		hund.setBounds(416, 332, 97, 25);
		add(hund);
		
		JButton thou = new JButton("$1000");
		thou.setBounds(416, 377, 97, 25);
		add(thou);
		
		JButton fiveHund = new JButton("$500");
		fiveHund.setBounds(307, 377, 97, 25);
		add(fiveHund);
		
		JButton twoHund = new JButton("$200");
		twoHund.setBounds(198, 377, 97, 25);
		add(twoHund);
	}
}
