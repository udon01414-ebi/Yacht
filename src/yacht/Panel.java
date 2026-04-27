package yacht;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
	HarfPointGrid westGrid;
	HarfPointGrid eastGrid;

	public Panel() {	//パネル管理
		//上と中央と下に分割
		setLayout(new BorderLayout());

		//さいころを作成
		Dice dice = new Dice();

		//さいころパネルを作成
		DicePanel dicePanel = new DicePanel(dice);
		
		//得点表を右プレイヤーと左プレイヤーに分けて作成
		westGrid = new HarfPointGrid(dicePanel, 0);
		eastGrid = new HarfPointGrid(dicePanel, 1);
		
		//さいころパネルに得点表の情報をあげる
		dicePanel.setGrids(westGrid, eastGrid);
		
		//中央パネルの管理
		JPanel centerContainer = new JPanel(new GridLayout(1, 2));
		//中央パネルに得点表を追加
		centerContainer.add(westGrid);
		centerContainer.add(eastGrid);
		
		//さいころパネルのサイズ決定
		dicePanel.setPreferredSize(new Dimension(600, 160));

		//リロールのパネル作成
		JPanel buttonPanel = new JPanel(new FlowLayout());
		//リロールのラベル作成
		JLabel countLabel = new JLabel("リロール残り: " + 2 + "回");
		dicePanel.setCountLabel(countLabel);
		// リロールボタンの作成
		JButton rerollButton = new JButton("リロール");
		dicePanel.setRerollButton(rerollButton);
		
		//リロールボタンが押されたときの挙動
		rerollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//リロールができるなら
				if (dice.canReroll()) {
					//リロールをする
					dice.reroll();
					//得点表の数字を更新
					westGrid.updateDisplay(dicePanel);
					eastGrid.updateDisplay(dicePanel);
					dicePanel.repaint();
					
					//リロール回数の計算＆ラベル更新
					int remaining = 2 - dice.getRerollCount();
					countLabel.setText("リロール残り: " + remaining + "回");
					//もしリロールができなくなったら
					if (!dice.canReroll()) {
						//リロールボタンを無効化
						rerollButton.setEnabled(false);
					}
				}
			}
		});

		//手番表示のラベル
		JLabel tebanLabel = new JLabel("　手番:左プレイヤー　");
		tebanLabel.setFont(new Font("MS ゴシック", Font.PLAIN, 24));
		tebanLabel.setOpaque(true);
		tebanLabel.setBackground(Color.GRAY);
		tebanLabel.setForeground(Color.WHITE);
		//さいころパネルに手番ラベルを渡す
		dicePanel.setTebanLabel(tebanLabel);
		westGrid.updateDisplay(dicePanel);
		eastGrid.updateDisplay(dicePanel);

		//下部のパネルに色々追加
		buttonPanel.add(tebanLabel);
		buttonPanel.add(rerollButton);
		buttonPanel.add(countLabel);

		//全体のパネルに色々追加
		add(dicePanel, BorderLayout.NORTH);
		add(centerContainer, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH); // ボタンを下部に追加
	}
}