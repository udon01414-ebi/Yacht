package yacht;

public class Dice {

	int[] diceFace;
	private boolean[] selected;
	private int rerollCount = 0;

	public Dice() {
		diceFace = diceCycle();
		selected = new boolean[5];
	}

	private int[] diceCycle() {
		int[] dice = new int[5];
		for (int i = 0; i < 5; i++) {
			dice[i] = (int) (Math.random() * 6) + 1;
		}
		return dice;
	}

	// 全ダイスを振り直してリロール回数もリセット
	public void roll() {
		for (int i = 0; i < 5; i++) {
			diceFace[i] = (int) (Math.random() * 6) + 1;
			selected[i] = false;
		}
		rerollCount = 0;
	}

	public void reroll() {
		if (rerollCount >= 2)
			return;
		for (int i = 0; i < 5; i++) {
			if (selected[i]) {
				diceFace[i] = (int) (Math.random() * 6) + 1;
				selected[i] = false;
			}
		}
		rerollCount++;
	}

	// 選択トグル
	public void toggleSelect(int index) {
		selected[index] = !selected[index];
	}

	public int[] getDice() {
		return diceFace;
	}

	public boolean[] getSelected() {
		return selected;
	}

	public int getRerollCount() {
		return rerollCount;
	}
	
	public void setRerollCount(int rerollCount) {
		this.rerollCount = rerollCount;
	}

	public boolean canReroll() {
		return rerollCount < 2;
	}

	public void rePaint() {
		
	}
}
