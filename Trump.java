package bigorsmall;

import java.util.Random;

public class Trump {

	private int[][] num = new int[4][13];

	private int x =0;

	Random r = new Random();

	Trump() {
		setNum(0);

	}

	public void setNum(int x) {
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				num[i][j]=x;
			}
		}
	}

	public int[] pick() {
		int data[] = new int[2];
		for (int k=0; k<52; k++) {
			data[0] = r.nextInt(4);
			data[1] = r.nextInt(13);
			if (num[data[0]][data[1]] != 1) {
				num[data[0]][data[1]] = 1;
				break;
			}
		}

		return data;
	}

	public void show() {
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				System.out.println("count:"+x);
				System.out.println(num[i][j]);
				x++;
			}
		}
	}


}
