package bigorsmall;

import java.util.Random;

public class Trump {



	private int[] flag = new int[52];

	Random r = new Random();

	Trump() {
		initFlag();

	}

	public void initFlag() {
		for (int i=0; i<flag.length; i++) {
				flag[i]=0;
		}
	}

	public int pick() {
		int pick_card = 0;
		int option = 0;
		for (int k=0; k<52; k++) {
			pick_card = r.nextInt(52);
			option = k;
			if (flag[pick_card] != 1) {
				flag[pick_card] = 1;
				break;
			}

		}
		if (option==51) {
			return -1;
		}

		return pick_card;
	}


}
