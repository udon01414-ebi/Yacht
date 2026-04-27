package yacht;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RulePanel extends JPanel{
	//パネルトラベルを保持する配列
	DicePanel[] dicePanels = new DicePanel[7];
	JLabel[] labels = {
			new JLabel("<html><br>●エース・デュース・トレイ・フォー・ファイブ・シックス（１〜６）"
			+ "<br>該当の役が出た数だけ得点になる"
			+ "<br>例：エースが3個出た→3点"
			+ "<br>トレイが2個出た→6点"
			+ "<br>※エース〜シックスの合計得点が63点を超えたら、ボーナス35点が追加される<html>"),
			new JLabel("<html><br>●フォーダイス"
			+ "<br>同じ目が４つ揃うこと"
			+ "<br>例：ファイブのフォーダイス（＋トレイ）→５×４+３＝23点<html>"),
			new JLabel("<html><br>●フルハウス"
			+ "<br>同じ目が２つと３つになること"
			+ "<br>例：フォーとシックスのフルハウス→4×2＋6×3＝26点"
			+ "<br>※4×3＋6×2＝24点の場合もあり<html>"),
			new JLabel("<html><br>●S.ストレート\n"
			+ "<br>４つの目が数字順につながっていること\n"
			+ "<br>例：エース〜フォー、トレイ〜シックス→15点<html>\n"),
			new JLabel("<html><br>●B.ストレート\n"
			+ "<br>５つの目が順に揃っていること\n"
			+ "<br>エース〜ファイブ、デュース〜シックス→30点<html>\n"),
			new JLabel("<html><br>●ヨット\n"
			+ "<br>同じ目が５つ揃うこと\"\n"
			+ "<br>例：デュースが５個出た→50点<html>\n"),
			new JLabel("<html><br>●チョイス\n"
			+ "<br>出た目の合計数がそのまま得点になること\n"
			+ "<br>例：エース×2個、トレイ、ファイブ、シックス→16点<html>")
			};
	
	public RulePanel() {	
		//レイアウトは縦
		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
		
		//フォントとサイズのテンプレ作成
		Font font = new Font("MS ゴシック", Font.PLAIN, 16);
		Dimension size = new Dimension(100, 90);
		
		//ルールパネルの描画
		for (int i = 0; i < 7; i++) {
			//さいころパネルの生成
			dicePanels[i] = new DicePanel(i + 1);
			dicePanels[i].setPreferredSize(size);
			
			//解説文ラベルの設定
			labels[i].setFont(font);
			
			add(labels[i]);
			add(dicePanels[i]);
		}
	}
}
