package yacht;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RulePanel extends JPanel{
	JLabel label1 = new JLabel("<html><br>●エース・デュース・トレイ・フォー・ファイブ・シックス（１〜６）"
			+ "<br>該当の役が出た数だけ得点になる"
			+ "<br>例：エースが3個出た→3点"
			+ "<br>トレイが2個出た→6点"
			+ "<br>※エース〜シックスの合計得点が63点を超えたら、ボーナス35点が追加される<html>"
			);
	JLabel label2 = new JLabel(	"<html><br>●フォーダイス"
			+ "<br>同じ目が４つ揃うこと"
			+ "<br>例：ファイブのフォーダイス（＋トレイ）→５×４+３＝23点<html>"
			);
	JLabel label3 = new JLabel(	"<html><br>●フルハウス"
			+ "<br>同じ目が２つと３つになること"
			+ "<br>例：フォーとシックスのフルハウス→4×2＋6×3＝26点"
			+ "<br>※4×3＋6×2＝24点の場合もあり<html>"
			);
	JLabel label4 = new JLabel( "<html><br>●S.ストレート\n"
			+ "<br>４つの目が数字順につながっていること\n"
			+ "<br>例：エース〜フォー、トレイ〜シックス→15点<html>\n"
			);
	JLabel label5 = new JLabel(	"<html><br>●B.ストレート\n"
			+ "<br>５つの目が順に揃っていること\n"
			+ "<br>エース〜ファイブ、デュース〜シックス→30点<html>\n"
			);
	JLabel label6 = new JLabel(	"<html><br>●ヨット\n"
			+ "<br>同じ目が５つ揃うこと\"\n"
			+ "<br>例：デュースが５個出た→50点<html>\n"
			);
	JLabel label7 = new JLabel(  "<html><br>●チョイス\n"
			+ "<br>出た目の合計数がそのまま得点になること\n"
			+ "<br>例：エース×2個、トレイ、ファイブ、シックス→16点<html>");
	public RulePanel() {
		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
		
		//説明用のさいころ描画
		DicePanel dicePanel1 = new DicePanel(100, 10, 1);
		DicePanel dicePanel2 = new DicePanel(100, 10, 2);
		DicePanel dicePanel3 = new DicePanel(100, 10, 3);
		DicePanel dicePanel4 = new DicePanel(100, 10, 4);
		DicePanel dicePanel5 = new DicePanel(100, 10, 5);
		DicePanel dicePanel6 = new DicePanel(100, 10, 6);
		DicePanel dicePanel7 = new DicePanel(100, 10, 7);

		dicePanel1.setPreferredSize(new Dimension(100, 80));
		dicePanel2.setPreferredSize(new Dimension(100, 80));
		dicePanel3.setPreferredSize(new Dimension(100, 80));
		dicePanel4.setPreferredSize(new Dimension(100, 80));
		dicePanel5.setPreferredSize(new Dimension(100, 80));
		dicePanel6.setPreferredSize(new Dimension(100, 80));
		dicePanel7.setPreferredSize(new Dimension(100, 80));
		
		label1.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		label2.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		label3.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		label4.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		label5.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		label6.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		label7.setFont(new Font("MS ゴシック", Font.PLAIN, 16));
		
		add(label1);
		add(dicePanel1);
		add(label2);
		add(dicePanel2);
		add(label3);
		add(dicePanel3);
		add(label4);
		add(dicePanel4);
		add(label5);
		add(dicePanel5);
		add(label6);
		add(dicePanel6);
		add(label7);
		add(dicePanel7);
	}
}
