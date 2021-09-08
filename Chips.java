package bigorsmall;

public class Chips {
	private int ten;
	private int one;

	Chips(){
		setChips(0,0);
	}

	public void setChips(int ten, int one) {
		this.ten = ten;
		this.one = one;
	}

	public int[] toCash(int ten, int one) {
		int[] cash = new int[2];
		while (one>9) {
			one-=10;
			ten++;
		}
		cash[0] = ten;
		cash[1] = one;
		return cash;
	}

	public void show(int ten, int one) {
		int[] cash = new int[2];
		int sum;
		cash = toCash(ten,one);
		ten = cash[0];
		one = cash[1];
		sum = sum(ten,one);
		System.out.println("総計: "+sum+" ([10]:"+ten+"枚, [1]:"+one+"枚)");
	}

	public int sum(int ten, int one) {
		return ten*10+one;
	}
}
