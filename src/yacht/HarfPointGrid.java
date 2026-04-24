package yacht;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HarfPointGrid extends JPanel { //得点表（半分）
	JButton btns[] = new JButton[15];
	JLabel shokeiL = new JLabel("0/63");	
	JLabel bonusL = new JLabel("0");	
	JLabel goukeiL = new JLabel("0");
	int player = 0;

	HarfPointGrid(DicePanel dicePanel, int player) {
		this.player = player;
		setLayout(new GridLayout(15, 2));
		setBorder(new EmptyBorder(10, 10, 10, 10));

		//得点表（ラベル）
		JLabel[] labels = new JLabel[15];

		labels[0] = new JLabel("エース");
		labels[1] = new JLabel("デュース");
		labels[2] = new JLabel("トレイ");
		labels[3] = new JLabel("フォー");
		labels[4] = new JLabel("ファイブ");
		labels[5] = new JLabel("シックス");

		labels[6] = new JLabel("小計");
		labels[7] = new JLabel("ボーナス+35");

		labels[8] = new JLabel("チョイス");
		labels[9] = new JLabel("フォーダイス");
		labels[10] = new JLabel("フルハウス");
		labels[11] = new JLabel("S.ストレート");
		labels[12] = new JLabel("B.ストレート");
		labels[13] = new JLabel("ヨット");

		labels[14] = new JLabel("総合得点");

		//得点表（ボタン）の作成と全体の描画
		for (int i = 0; i < 15; i++) {
			int ii = i;
			add(labels[i]);

			if (i < 6) {
				btns[i] = new JButton("0");
				add(btns[i]);
				btns[i].addActionListener(e -> actionListener(btns[ii], dicePanel, player));
			} else if (i == 6) {
				add(shokeiL);
			} else if (i == 7) {
				add(bonusL);
			} else if (i < 14) {
				btns[i] = new JButton("0");
				add(btns[i]);
				btns[i].addActionListener(e -> actionListener(btns[ii], dicePanel, player));
			} else {
				add(goukeiL);
			}
		}
	}

	//得点ボタンが押された時の挙動
	private void actionListener(JButton btn, DicePanel dicePanel, int player) {
		//手番の方の表じゃなかったら何もしない
		if (dicePanel.teban != player) {
			return;
		}
		//押されたらボタン無効
		btn.setEnabled(false);
		//押されたら手番変える
		dicePanel.teban = dicePanel.teban == 1 ? 0 : 1;
		//手番変えた時の処理
		dicePanel.resetTurn();
	}

	//ボタン内の数字の更新
	public void updateDisplay(DicePanel dicePanel) {
		for (int i = 0; i < 14; i++) {
			//インデックスが使われてない6か7or押されているボタンの時、何もしない
			if (i == 6 || i == 7 || !btns[i].isEnabled()) {
				continue;
			}

			//手番の表か確認
			if (dicePanel.teban == player) {
				//さいころの値を計算して数字を更新
				int val = new DiceManager(dicePanel.dice, i + 1).value;
				btns[i].setText(String.valueOf(val));
			} else {
				//手番の表じゃない未確定ボタンを0にする
				if (btns[i].isEnabled()) {
					btns[i].setText("0");					
				}
			}
		}
	}
}
