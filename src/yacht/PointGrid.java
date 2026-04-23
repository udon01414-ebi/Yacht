package yacht;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PointGrid extends JPanel{
	PointGrid(Dice dice) {
		setLayout(new GridLayout(1, 2));
		JPanel eastContainer = new HarfPointGrid(dice);
		JPanel westContainer = new HarfPointGrid(dice);
		
		add(eastContainer);
		add(westContainer);
	}
}
