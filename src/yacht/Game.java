package yacht;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		Panel panel = new Panel();
		JFrame frame = new JFrame("ヨット");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);       //サイズは仮
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
