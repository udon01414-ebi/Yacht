package yacht;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HarfPointGrid extends JPanel {
	int value1,value2,value3,value4,value5,value6;
	int value9,value10,value11,value12,value13,value14;
	
	HarfPointGrid() {
		setLayout(new GridLayout(15, 2));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel label1 = new JLabel("エース");
		JLabel label2 = new JLabel("デュース");
		JLabel label3 = new JLabel("トレイ");
		JLabel label4 = new JLabel("フォー");
		JLabel label5 = new JLabel("ファイブ");
		JLabel label6 = new JLabel("シックス");

		JLabel label7 = new JLabel("小計");
		JLabel label8 = new JLabel("ボーナス+35");
		
		JLabel label9 = new JLabel("チョイス");
		JLabel label10 = new JLabel("フォーダイス");
		JLabel label11 = new JLabel("フルハウス");
		JLabel label12 = new JLabel("S.ストレート");
		JLabel label13 = new JLabel("B.ストレート");
		JLabel label14 = new JLabel("ヨット");
		
		JLabel label15 = new JLabel("総合得点");
		
		JButton btn1 = new JButton();
		JButton btn2 = new JButton();
		JButton btn3 = new JButton();
		JButton btn4 = new JButton();
		JButton btn5 = new JButton();
		JButton btn6 = new JButton();

		JLabel shokeiL = new JLabel();
		JLabel bonusL = new JLabel();

		JButton btn9 = new JButton();
		JButton btn10 = new JButton();
		JButton btn11 = new JButton();
		JButton btn12 = new JButton();
		JButton btn13 = new JButton();
		JButton btn14 = new JButton();

		JLabel goukeiL = new JLabel();
		
		value1 = new DiceManager(1).value;
		value2 = new DiceManager(2).value;
		value3 = new DiceManager(3).value;
		value4 = new DiceManager(4).value;
		value5 = new DiceManager(5).value;
		value6 = new DiceManager(6).value;

		value9 = new DiceManager(9).value;
		value10 = new DiceManager(10).value;
		value11 = new DiceManager(11).value;
		value12 = new DiceManager(12).value;
		value13 = new DiceManager(13).value;
		value14 = new DiceManager(14).value;
		
		btn1 = new ButtonInitialize(value1);
		btn2 = new ButtonInitialize(value2);
		btn3 = new ButtonInitialize(value3);
		btn4 = new ButtonInitialize(value4);
		btn5 = new ButtonInitialize(value5);
		btn6 = new ButtonInitialize(value6);
		
		int shokei = checkShokei();
		shokeiL.setText(shokei + "/63");

		btn9 = new ButtonInitialize(value9);
		btn10 = new ButtonInitialize(value10);
		btn11 = new ButtonInitialize(value11);
		btn12 = new ButtonInitialize(value12);
		btn13 = new ButtonInitialize(value13);
		btn14 = new ButtonInitialize(value14);

		
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

	private int checkShokei() {
		return value1 + value2 + value3 + value4 + value5 + value6;
	}
}
