package yacht;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PointGrid extends JPanel{
	PointGrid() {
		setLayout(new BorderLayout());
		JPanel eastContainer = new HarfPointGrid();
		JPanel westContainer = new HarfPointGrid();
		
		add(eastContainer, BorderLayout.EAST);
		add(westContainer, BorderLayout.WEST);
	}
}
