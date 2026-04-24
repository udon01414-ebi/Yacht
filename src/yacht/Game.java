package yacht;

import javax.swing.JFrame;

public class Game {		//画面描画のおおもと

	public static void main(String[] args) {
		Panel panel = new Panel();
		JFrame frame = new JFrame("ヨット");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 800);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		RulePanel rulePanel = new RulePanel();
		JFrame ruleFrame = new JFrame("ルール");
		ruleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ruleFrame.setSize(700, 600);
		ruleFrame.add(rulePanel);
		ruleFrame.getComponentAt(50, 100);
		ruleFrame.setVisible(true);
	}

}
