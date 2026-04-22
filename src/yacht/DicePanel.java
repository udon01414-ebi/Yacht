package yacht;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel {

    private Dice dice;  // データはDiceから取得
    private JLabel countLabel;

    public DicePanel(Dice dice) {
        this.dice = dice;

        // クリックで選択（DicePanelが担当）
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] diceFace = dice.getDice();
                for (int i = 0; i < 5; i++) {
                    int x = 50 + i * 100;
                    int y = 50;
                    if (e.getX() >= x && e.getX() <= x + 60 &&
                        e.getY() >= y && e.getY() <= y + 60) {
                        dice.toggleSelect(i);
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] diceFace = dice.getDice();
        boolean[] selected = dice.getSelected();

        for (int i = 0; i < 5; i++) {
            int x = 50 + i * 100;
            int y = 50;

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
            case 1: drawDot(g, cx, cy); break;
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