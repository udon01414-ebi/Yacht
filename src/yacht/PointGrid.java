package yacht;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PointGrid extends JPanel{
	JPanel eastContainer;
	JPanel westContainer;
	Dice dice;
	PointGrid(Dice dice) {
		this.dice = dice;
		setLayout(new GridLayout(1, 2));
		eastContainer = new HarfPointGrid(dice, 0);
		westContainer = new HarfPointGrid(dice, 1);
		
		add(eastContainer);
		add(westContainer);
	}
	
	public void pointUpdateDisplay() {
		((HarfPointGrid) eastContainer).updateDisplay(dice);
		((HarfPointGrid) westContainer).updateDisplay(dice);
	}
}
