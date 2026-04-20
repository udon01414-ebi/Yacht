package yacht;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HarfPointGrid extends JPanel {
	HarfPointGrid() {
		setLayout(new GridLayout(15, 2));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel label1 = new JLabel("エース");
		JLabel label2 = new JLabel("エース");
		JLabel label3 = new JLabel("エース");
		JLabel label4 = new JLabel("エース");
		JLabel label5 = new JLabel("エース");
		JLabel label6 = new JLabel("エース");

		JLabel label7 = new JLabel("エース");
		JLabel label8 = new JLabel("エース");
		
		JLabel label9 = new JLabel("エース");
		JLabel label10 = new JLabel("エース");
		JLabel label11 = new JLabel("エース");
		JLabel label12 = new JLabel("エース");
		JLabel label13 = new JLabel("エース");
		JLabel label14 = new JLabel("エース");
		
		JLabel label15 = new JLabel("エース");

		
		add(label1);
		add(btn1);
		add(label2);
		add(btn2);
		add(label3);
		add(btn3);
		add(label4);
		add(btn4);
		add(label5);
		add(btn5);
		add(label6);
		add(btn6);
		
		add(label7);
		add(shokeiL);
		add(label8);
		add(bonusL);
		
		add(label9);
		add(btn9);
		add(label10);
		add(btn10);
		add(label11);
		add(btn11);
		add(label12);
		add(btn12);
		add(label13);
		add(btn13);
		add(label14);
		add(btn14);
		add(label15);
		add(goukeiL);
	}
}
