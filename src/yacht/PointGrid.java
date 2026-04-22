package yacht;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PointGrid extends JPanel{
	PointGrid() {
		setLayout(new GridLayout(1, 2));
		JPanel eastContainer = new HarfPointGrid();
		JPanel westContainer = new HarfPointGrid();
		
		add(eastContainer);
		add(westContainer);
	}
}
