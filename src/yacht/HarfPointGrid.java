package yacht;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HarfPointGrid extends JPanel {	
	JButton btns[] = new JButton[15];
	JLabel shokeiL = new JLabel("0/63");
	JLabel bonusL = new JLabel("0");
	JLabel goukeiL = new JLabel("0");
	
	
	HarfPointGrid(Dice dice) {
		setLayout(new GridLayout(15, 2));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel[] labels = new JLabel[15];
		
		labels[0] = new JLabel("エース");
		labels[1] = new JLabel("デュース");
		labels[2] = new JLabel("トレイ");
		labels[3] = new JLabel("フォー");
		labels[4] = new JLabel("ファイブ");
		labels[5] = new JLabel("シックス");

		labels[6] = new JLabel("小計");
		labels[7] = new JLabel("ボーナス+35");
		
		labels[8] = new JLabel("チョイス");
		labels[9] = new JLabel("フォーダイス");
		labels[10] = new JLabel("フルハウス");
		labels[11] = new JLabel("S.ストレート");
		labels[12] = new JLabel("B.ストレート");
		labels[13] = new JLabel("ヨット");
		
		labels[14] = new JLabel("総合得点");
		
		for (int i = 0; i < 15; i++) {
			add(labels[i]);
			
			if(i < 6) {
				btns[i] = new JButton("0");
				add(btns[i]);
			} else if (i == 6) {
				add(shokeiL);
			} else if (i == 7) {
				add(bonusL);
			} else if (i < 14) {
				btns[i] = new JButton("0");
				add(btns[i]);
			} else {
				add(goukeiL);
			}
		}
		
		updateDisplay(dice);
	}

	public void updateDisplay(Dice dice) {
		
		for (int i = 0; i < 6; i++) {
			int val = new DiceManager(dice, i + 1).value;
			btns[i].setText(String.valueOf(val));
		}
		
		for (int i = 8; i < 14; i++) {
			int val = new DiceManager(dice, i + 1).value;
			btns[i].setText(String.valueOf(val));
		}
	}
}
