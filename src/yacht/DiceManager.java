package yacht;
import java.util.Arrays;

public class DiceManager {

	public int value;

	public DiceManager(Dice dice,int mode) {
		//modeが1から6の時はvalueにDiceのgetDice()の返却値int[]の[0]から[5]までの値の中のmodeの値の合計を入れる
		//modeが9から14の時はvalueに、9:チョイス、10:フォーダイス、11:フルハウス、12:S.ストレート、13:B.ストレート、14:ヨットでいい感じにDiceのgetDice()から計算していれる
		
		int[] d = dice.getDice();
		value = calcScore(d, mode);
	}
	
	private int calcScore(int[] d, int mode) {	//スコア振り分け
		if(mode >= 1 && mode <= 6) {
			int sum = 0;
			for(int v : d) {
				if(v == mode) sum += v;
			}
			return sum;
		}
		switch(mode) {
			case 9: return calcChoice(d);		//チョイス
			case 10: return calcFourDice(d);		//フォーダイス
			case 11: return calcFullHouse(d);	//フルハウス
			case 12: return calcStraight(d,4); 	//4連続ストレート
			case 13: return calcStraight(d,5);	//5連続ストレート
			case 14: return calcYacht(d);		//ヨット
			default : return 0;
		}
	}
	
	private int calcChoice(int[] d) {
		int sum = 0;
		for(int v : d) sum += v;
		return sum;
	}
	
	private int calcFourDice(int[] d) {
		int[] count = new int[7];
		for(int v : d) {
			System.out.println("v=" + v);
			count[v]++;
		}
		for(int i = 1; i <= 6; i++) {
			System.out.println("count[" + i + "]=" + count[i]);
			if(count[i] >= 4) return calcChoice(d);
		}
		return 0;
	}
	
	private int calcFullHouse(int[] d) {
		int[] count = new int[7];
		for(int v : d) count[v]++;
		boolean hasThree = false, hasTwo = false;
		for(int i = 1; i <= 6; i++) {
			if(count[i] == 3) hasThree = true;
			if(count[i] == 2) hasTwo = true;
		}
		return (hasThree && hasTwo) ? calcChoice(d) : 0;
	}
	
	private int calcStraight(int[] d, int length) {
		//4連続で15点,5連続で30点
		int[] sorted = d.clone();
		Arrays.sort(sorted);
		
		//重複排除？教えてえろい人
		int[] unique = Arrays.stream(sorted).distinct().toArray();
		
		int consecutive = 1;
		for(int i = 1; i < unique.length; i++) {
			if(unique[i] == unique[i - 1] + 1) {
				consecutive++;
				if(consecutive >= length) return ( length == 4) ? 15 : 30;
			} else {
				consecutive = 1;
			}
		}
			return 0;
		
	}
		
		private int calcYacht(int[] d) {
			for(int i = 1; i < 5; i++) {
				if(d[i] != d[0]) return 0;
			}
			return 50;
		}
		
		public static void main(String[] args) {

	        // --- 任意の出目でテストしたい場合はここを変える ---
	        // Diceを使わず直接配列で試すためのヘルパー
	        testWithFace("エース(1)",        new int[]{1, 1, 3, 4, 1}, 1,  3);   // 期待値: 3
	        testWithFace("デュース(2)",      new int[]{2, 2, 3, 4, 5}, 2,  4);   // 期待値: 4
	        testWithFace("トレイ(3)",        new int[]{3, 3, 3, 4, 5}, 3,  9);   // 期待値: 9
	        testWithFace("フォー(4)",        new int[]{4, 4, 2, 1, 4}, 4, 12);   // 期待値: 12
	        testWithFace("ファイブ(5)",      new int[]{5, 5, 5, 5, 5}, 5, 25);   // 期待値: 25
	        testWithFace("シックス(6)",      new int[]{6, 1, 2, 3, 4}, 6,  6);   // 期待値: 6

	        testWithFace("チョイス(9)",      new int[]{1, 2, 3, 4, 5}, 9, 15);   // 期待値: 15
	        testWithFace("フォーダイス(10)", new int[]{3, 3, 3, 3, 5}, 10, 17);  // 期待値: 17
	        testWithFace("フォーダイス失敗", new int[]{1, 2, 3, 4, 5}, 10,  0);  // 期待値: 0
	        testWithFace("フルハウス(11)",   new int[]{2, 2, 3, 3, 3}, 11, 13);  // 期待値: 13
	        testWithFace("フルハウス失敗",   new int[]{1, 2, 3, 4, 5}, 11,  0);  // 期待値: 0
	        testWithFace("S.ストレート(12)", new int[]{1, 2, 3, 4, 6}, 12, 15);  // 期待値: 15
	        testWithFace("S.ストレート失敗", new int[]{1, 2, 3, 6, 6}, 12,  0);  // 期待値: 0
	        testWithFace("B.ストレート(13)", new int[]{1, 2, 3, 4, 5}, 13, 30);  // 期待値: 30
	        testWithFace("B.ストレート失敗", new int[]{1, 2, 3, 4, 6}, 13,  0);  // 期待値: 0
	        testWithFace("ヨット(14)",       new int[]{6, 6, 6, 6, 6}, 14, 50);  // 期待値: 50
	        testWithFace("ヨット失敗",       new int[]{6, 6, 6, 6, 5}, 14,  0);  // 期待値: 0

	        System.out.println("\n--- ランダムなダイスでの動作確認 ---");
	        Dice dice = new Dice();
	        int[] face = dice.getDice();
	        System.out.printf("出目: [%d, %d, %d, %d, %d]%n", face[0], face[1], face[2], face[3], face[4]);
	        for (int mode : new int[]{1,2,3,4,5,6,9,10,11,12,13,14}) {
	            int score = new DiceManager(dice, mode).value;
	            System.out.printf("  mode=%2d → %d%n", mode, score);
	        }
	    }

	    // 指定の出目を使ってDiceManagerをテストするヘルパー
	    static void testWithFace(String label, int[] face, int mode, int expected) {
	        // Diceのフィールドに直接セットするためサブクラスで上書き
	        Dice dice = new Dice() {
	            @Override
	            public int[] getDice() { return face; }
	        };
	        int result = new DiceManager(dice, mode).value;
	        String status = (result == expected) ? "OK" : "NG";
	        System.out.printf("[%s] %s: 出目=[%d,%d,%d,%d,%d] → %d (期待値:%d)%n",
	            status, label, face[0], face[1], face[2], face[3], face[4], result, expected);
	    }
 	
}
