package yacht;

import java.awt.Color;
import java.awt.Graphics;

public class DrawDice {

	public DrawDice(Graphics g, int x, int y, int value) {
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

}
