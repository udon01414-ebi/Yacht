package yacht;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DicePanel extends JPanel {
	int xx, yy;
	int teban = 0;
	Dice dice;
	private HarfPointGrid westGrid;
	private HarfPointGrid eastGrid;
	private JLabel tebanLabel;
	private JButton rerollButton;
	private JLabel countLabel;

	public DicePanel(Dice dice) {
		this.dice = dice;

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 5; i++) {
					int x = 50 + i * 100;
					int y = 20;
					if (e.getX() >= x && e.getX() <= x + 60 &&
							e.getY() >= y && e.getY() <= y + 60) {
						dice.toggleSelect(i);
						repaint();
					}
				}
			}
		});
	}

	public DicePanel(int a) {
		this.dice = new Dice();
		for (int i = 0; i < 5; i++) {
			switch (a) {
			case 1:
				if (i < 3) {
					this.dice.diceFace[i] = 1;					
				} else {
					this.dice.diceFace[i] = 2;
				}
				break;
			case 2:
				if (i != 4) {
					this.dice.diceFace[i] = 5;
				} else {
					this.dice.diceFace[i] = 3;
				}
				break;
			case 3:
				if (i < 2) {
					this.dice.diceFace[i] = 4;
				} else {
					this.dice.diceFace[i] = 6;
				}
				break;
			case 4:
				if (i < 4) {
					this.dice.diceFace[i] = i + 1;
				} else {
					this.dice.diceFace[i] = 3;
				}
				break;
			case 5:
				this.dice.diceFace[i] = i + 2;
				break;
			case 6:
				this.dice.diceFace[i] = 2;
				break;
			case 7:
				if (i < 2) {
					this.dice.diceFace[i] = 1;
				} else if (i == 2) {
					this.dice.diceFace[i] = 2;
				} else if (i == 3) {
					this.dice.diceFace[i] = 5;
				} else {
					this.dice.diceFace[i] = 6;
				}
				break;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] diceFace = dice.getDice();
		boolean[] selected = dice.getSelected();

		for (int i = 0; i < 5; i++) {
			int x = 50 + i * 100;
			int y = 20;

			if (selected[i]) {
				g.setColor(Color.YELLOW);
				g.fillRect(x - 4, y - 4, 68, 68);
			}
			drawDice(g, x, y, diceFace[i]);
		}
	}

	private void drawDice(Graphics g, int x, int y, int value) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 60, 60);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 60, 60);

		int cx = x + 30;
		int cy = y + 30;
		int offset = 15;

		switch (value) {
		case 1:
			drawDot(g, cx, cy);
			break;
		case 2:
			drawDot(g, cx - offset, cy - offset);
			drawDot(g, cx + offset, cy + offset);
			break;
		case 3:
			drawDot(g, cx, cy);
			drawDot(g, cx - offset, cy - offset);
			drawDot(g, cx + offset, cy + offset);
			break;
		case 4:
			drawDot(g, cx - offset, cy - offset);
			drawDot(g, cx + offset, cy - offset);
			drawDot(g, cx - offset, cy + offset);
			drawDot(g, cx + offset, cy + offset);
			break;
		case 5:
			drawDot(g, cx, cy);
			drawDot(g, cx - offset, cy - offset);
			drawDot(g, cx + offset, cy - offset);
			drawDot(g, cx - offset, cy + offset);
			drawDot(g, cx + offset, cy + offset);
			break;
		case 6:
			drawDot(g, cx - offset, cy - offset);
			drawDot(g, cx + offset, cy - offset);
			drawDot(g, cx - offset, cy);
			drawDot(g, cx + offset, cy);
			drawDot(g, cx - offset, cy + offset);
			drawDot(g, cx + offset, cy + offset);
			break;
		}
	}

	private void drawDot(Graphics g, int x, int y) {
		g.fillOval(x - 5, y - 5, 10, 10);
	}

	public void resetTurn() {
		dice.setRerollCount(0);
		dice.roll();
		westGrid.updateDisplay(this);
		eastGrid.updateDisplay(this);
		rerollButton.setEnabled(true);
		countLabel.setText("リロール残り: " + 2 + "回");
		String LR = teban == 0 ? "左" : "右";
		tebanLabel.setText("　手番:" + LR + "プレイヤー　");
		repaint();
	}
	
	public void checkGameFinished() {
		//もしゲームが終わってたら
		if (westGrid.isFinished() && eastGrid.isFinished()) {
			int westScore = Integer.parseInt(westGrid.goukeiL.getText());
			int eastScore = Integer.parseInt(eastGrid.goukeiL.getText());
			
			//結果を表示
			String result;
			if (westScore > eastScore) {
				result = "左プレイヤーの勝ち！";
			} else if (eastScore > westScore) {
				result = "右プレイヤーの勝ち！";
			} else {
				result = "引き分け！";
			}
			JOptionPane.showMessageDialog(this, result);
		}
	}

	public void setGrids(HarfPointGrid westGrid, HarfPointGrid eastGrid) {
		this.westGrid = westGrid;
		this.eastGrid = eastGrid;
	}

	public void setTebanLabel(JLabel tebanLabel) {
		this.tebanLabel = tebanLabel;
	}

	public void setRerollButton(JButton rerollButton) {
		this.rerollButton = rerollButton;
	}

	public void setCountLabel(JLabel countLabel) {
		this.countLabel = countLabel;
	}
}