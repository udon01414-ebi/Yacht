package yacht;

import java.awt.Color;
import java.awt.Font;
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
		goukeiL.setFont(new Font("MS ゴシック", Font.PLAIN, 24));
		goukeiL.setOpaque(true);
		goukeiL.setBackground(Color.BLACK);
		goukeiL.setForeground(Color.WHITE);
		goukeiL.setHorizontalAlignment(JLabel.CENTER);

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
		btn.setBackground(Color.LIGHT_GRAY);

		//集計を更新
		updateTotals();

		//押されたら手番変える
		dicePanel.teban = dicePanel.teban == 1 ? 0 : 1;
		//手番変えた時の処理
		dicePanel.resetTurn();
		//ゲーム終了してるかどうか
		dicePanel.checkGameFinished();
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
		updateTotals();
	}

	private void updateTotals() { //小計、合計の集計
		//小計のみ
		int shokei = 0;
		for (int i = 0; i < 6; i++) {
			if (!btns[i].isEnabled()) {
				shokei += Integer.parseInt(btns[i].getText());
			}
		}
		shokeiL.setText(shokei + "/63");

		// ボーナス（小計63以上で+35）
		int bonus = (shokei >= 63) ? 35 : 0;
		bonusL.setText(String.valueOf(bonus));

		// 総合得点（確定済みの下段も含めて合計）
		int goukei = shokei + bonus;
		for (int i = 8; i < 14; i++) {
			if (!btns[i].isEnabled()) {
				goukei += Integer.parseInt(btns[i].getText());
			}
		}
		goukeiL.setText(String.valueOf(goukei));
	}

	public boolean isFinished() {//すべてのボタンが埋まったか
		for (int i = 0; i < 14; i++) {
			if (i != 6 && i != 7 && btns[i].isEnabled()) {
				return false;
			}
		}
		return true;
	}
}