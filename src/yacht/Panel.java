package yacht;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
	HarfPointGrid westGrid;
	HarfPointGrid eastGrid;

	public Panel() {
		setLayout(new BorderLayout());

		Dice dice = new Dice();

		DicePanel dicePanel = new DicePanel(dice);
		westGrid = new HarfPointGrid(dicePanel, 0);
		eastGrid = new HarfPointGrid(dicePanel, 1);
		dicePanel.setGrids(westGrid, eastGrid);
		JPanel centerContainer = new JPanel(new GridLayout(1, 2));
		centerContainer.add(westGrid);
		centerContainer.add(eastGrid);
		
		dicePanel.setPreferredSize(new Dimension(600, 160));

		// ボタン＋ラベルパネル
		JPanel buttonPanel = new JPanel(new FlowLayout());

		JLabel countLabel = new JLabel("リロール残り: " + Dice.MAX_REROLL + "回");

		/* ダイスを振るボタン
		JButton rollButton = new JButton("ダイスを振る");
		rollButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dice.reroll(); // 全ダイスを振り直す
				dicePanel.repaint();
				((PointGrid) centerContainer).pointUpdateDisplay();
				countLabel.setText("リロール残り: " + Dice.MAX_REROLL + "回");
			}
		});*/

		// リロールボタン
		JButton rerollButton = new JButton("リロール");
		rerollButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dice.canReroll()) {
					dice.reroll();
					westGrid.updateDisplay(dicePanel);
					eastGrid.updateDisplay(dicePanel);
					dicePanel.repaint();
					int remaining = Dice.MAX_REROLL - dice.getRerollCount();
					countLabel.setText("リロール残り: " + remaining + "回");
					if (!dice.canReroll()) {
						rerollButton.setEnabled(false);
					}
				}
			}
		});

		JLabel tebanLabel = new JLabel("手番:左プレイヤー");
		westGrid.updateDisplay(dicePanel);
		eastGrid.updateDisplay(dicePanel);

		buttonPanel.add(tebanLabel);
		//buttonPanel.add(rollButton);
		buttonPanel.add(rerollButton);
		buttonPanel.add(countLabel);

		add(dicePanel, BorderLayout.NORTH);
		add(centerContainer, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH); // ボタンを下部に追加
	}
}