package gui.screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositScreen extends JPanel {
	private JTextField amt;
	public JButton exit;
	public JButton back;
	public DepositScreen() {
		setLayout(null);
		
		JLabel logos = new JLabel("");
		logos.setIcon(new ImageIcon(DepositScreen.class.getResource("/images/logos.png")));
		logos.setBounds(0, 0, 800, 71);
		add(logos);
		
		JRadioButton checking = new JRadioButton("Checking Account");
		checking.setSelected(true);
		checking.setBounds(78, 112, 175, 25);
		add(checking);
		
		JRadioButton savings = new JRadioButton("Savings Account");
		savings.setSelected(true);
		savings.setBounds(78, 142, 175, 25);
		add(savings);
		
		amt = new JTextField();
		amt.setText("0.00");
		amt.setBounds(363, 254, 116, 22);
		add(amt);
		amt.setColumns(10);
		
		JLabel amtToD = new JLabel("Amount to Deposit: $");
		amtToD.setBounds(233, 257, 128, 16);
		add(amtToD);
		
		back = new JButton("Back");
		back.setBounds(47, 529, 97, 25);
		add(back);
		
		exit = new JButton("Exit");
		exit.setBounds(167, 529, 97, 25);
		add(exit);
		
		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		deposit.setBounds(373, 281, 97, 25);
		add(deposit);
	}
	
}
