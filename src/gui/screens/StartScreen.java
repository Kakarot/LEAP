package gui.screens;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JPanel {
	public JButton begin;
	public StartScreen() {
		setLayout(null);
		
		JLabel logos = new JLabel("");
		logos.setBounds(0, 0, 800, 71);
		logos.setIcon(new ImageIcon(StartScreen.class.getResource("/images/logos.png")));
		add(logos);
		
		JLabel gif = new JLabel("");
		gif.setIcon(new ImageIcon(StartScreen.class.getResource("/images/gif.gif")));
		gif.setBounds(28, 97, 331, 444);
		add(gif);
		
		JLabel cardGraphic = new JLabel("");
		cardGraphic.setIcon(new ImageIcon(StartScreen.class.getResource("/images/card.png")));
		cardGraphic.setBounds(445, 317, 324, 224);
		add(cardGraphic);
		
		begin = new JButton("Press To Begin");
		begin.setBounds(512, 171, 181, 53);
		add(begin);
	}
}
