package yacht;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dice extends JPanel {
	
	private int[] diceFace;  	//面
	private boolean[] selected;  //選択状態
	private int rerollCount = 0; //リロール状態
	private static final int MAX_REROLL = 2;	//最大リロール
	
    public int[] getDice() {		//取り出し用
        return diceFace;
    }
	
	public Dice() {
		diceFace = diceCycle();
		selected = new boolean[5];
		setLayout(null);
	
		//クリックで選択
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i < 5; i++) {
					int x = 50 + i * 100;
					int y = 50;
					
					if(e.getX() >= x && e.getX() <= x + 60 &&
					e.getY() >= y && e.getY() <= y + 60) {
						selected[i] = !selected[i];
						repaint();
					}
				}
			}
		});
	}
	
	private int[] diceCycle() {		//サイコロ設定
        int[] dice = new int[5]; 

        for (int i = 0; i < 5; i++) {
            dice[i] = (int)(Math.random() * 6) + 1;
        }
        return dice;
    }
	
	public void reroll() {
		if(rerollCount >= MAX_REROLL) return;
		
		for(int i = 0; i < 5; i++) {
			if(selected[i]) {
				diceFace[i] = (int)(Math.random() * 6) + 1;
				selected[i] = false;
			}
		}
		rerollCount++;
		repaint();
	}
	
	public int getRerollCount() {
		return rerollCount;
	}
	
	public boolean canReroll() {
		return rerollCount < MAX_REROLL;
	}
	
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int i = 0; i < 5; i++) {			//横並び設定
				int x = 50 + i * 100;
				int y = 50;
				
				if(selected[i]) {
					g.setColor(Color.YELLOW);
					g.fillRect(x - 4, y - 4, 68, 68);
				}
				
				drawDice(g, x, y, diceFace[i]);
			}			
		}
		
		private void drawDice(Graphics g, int x, int y, int value) {
			//外枠描画
			g.setColor(Color.WHITE);
			g.fillRect(x,  y, 60, 60);
			
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 60, 60);
			
			//点描画
			int cx = x + 30;
			int cy = y + 30;
			int offset = 15;
			
			//サイコロ面描画
			switch (value) {
				case 1 :
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
	    

	    /*動作確認用
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Dice");
	        frame.setLayout(new BorderLayout());

	        Dice panel = new Dice();
	        panel.setPreferredSize(new java.awt.Dimension(600, 160));

	        // 下部パネル（ボタン＋残り回数ラベル）
	        JPanel bottomPanel = new JPanel(new FlowLayout());

	        JLabel countLabel = new JLabel("リロール残り: " + MAX_REROLL + "回");

	        JButton rerollButton = new JButton("リロール");
	        rerollButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (panel.canReroll()) {
	                    panel.reroll();
	                    int remaining = MAX_REROLL - panel.getRerollCount();
	                    countLabel.setText("リロール残り: " + remaining + "回");
	                    if (!panel.canReroll()) {
	                        rerollButton.setEnabled(false);  // 2回使ったら無効化
	                    }
	                }
	            }
	        });

	        bottomPanel.add(rerollButton);
	        bottomPanel.add(countLabel);

	        frame.add(panel, BorderLayout.CENTER);
	        frame.add(bottomPanel, BorderLayout.SOUTH);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
		
}


