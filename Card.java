package bigorsmall;

public class Card {
	private int x;
	private int y;

	private String[][] card = {
		{"スペード1","スペード2","スペード3","スペード4","スペード5","スペード6","スペード7","スペード8","スペード9","スペード10","スペード11","スペード12","スペード13"},
		{"ハート1","ハート2","ハート3","ハート4","ハート5","ハート6","ハート7","ハート8","ハート9","ハート10","ハート11","ハート12","ハート13"},
		{"ダイヤ1","ダイヤ2","ダイヤ3","ダイヤ4","ダイヤ5","ダイヤ6","ダイヤ7","ダイヤ8","ダイヤ9","ダイヤ10","ダイヤ11","ダイヤ12","ダイヤ13"},
		{"クラブ1","クラブ2","クラブ3","クラブ4","クラブ5","クラブ6","クラブ7","クラブ8","クラブ9","クラブ10","クラブ11","クラブ12","クラブ13"}
	};



	Card() {
		setX(0);
		setY(0);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}



	public void currentCard(int i, int j) {
		System.out.println("現在のカード:"+card[i][j]);
	}

	public void pickCard(int i, int j) {
		System.out.println("引いたカード:"+card[i][j]);

	}

	public String show(int i, int j) {
		return card[i][j];
	}


}
