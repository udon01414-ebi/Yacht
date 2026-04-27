package yacht;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Game {		//画面描画のおおもと

	public static void main(String[] args) {
		Panel panel = new Panel();
		JFrame frame = new JFrame("ヨット");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(580, 800);
		frame.add(panel);
		frame.setLocation(700, 50);
		frame.setVisible(true);
		
		RulePanel rulePanel = new RulePanel();
		JFrame ruleFrame = new JFrame("得点ルール");
		JScrollPane scrollPane = new JScrollPane(rulePanel);
		ruleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ruleFrame.setSize(650, 900);
		ruleFrame.add(scrollPane);
		ruleFrame.getComponentAt(50, 100);
		ruleFrame.setVisible(true);
	}

}
