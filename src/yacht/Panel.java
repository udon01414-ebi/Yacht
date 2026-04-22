package yacht;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panel extends JPanel{
	public Panel() {
		setLayout(new BorderLayout());
		JPanel northContainer = new Dice();  //さいころ
		JPanel centerContainer = new PointGrid();   //得点表
		JPanel southContainer = new JPanel(new GridLayout(1, 3));   //テキスト等の表示

		add(northContainer, BorderLayout.NORTH);
		add(centerContainer, BorderLayout.CENTER);
		add(southContainer, BorderLayout.SOUTH);
	}
}