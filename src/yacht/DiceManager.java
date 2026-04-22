package yacht;
import java.util.*;

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
		for(int i = 1; i <= 6; i++) {
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
		for(int  = 1; i < unique.length; i++) {
			if(unique[i] == unique{[i - 1] + 1) {
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
 	
}
