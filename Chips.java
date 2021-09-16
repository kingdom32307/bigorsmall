package bigorsmall;

public class Chips {

	Card card = new Card();

	// chips replace ten and one
	public int[] toTenOne(int chips) {
		int[] tenone = {0,0};

		while (chips>9) {
			chips-=10;
			tenone[0]++;
		}
		tenone[1] = chips;
		return tenone;
	}


	// show current chips
	public void show_(int chips) {
		int[] tenone = new int[2];
		tenone = toTenOne(chips);
		System.out.println("総計: "+chips+" ([10]:"+tenone[0]+"枚, [1]:"+tenone[1]+"枚)");
	}
	// show current chips
	public void current_chips(int chips) {
		System.out.println("*****現在のチップ枚数*****");
		show_(chips);
		System.out.println("****************************");
	}
	// show current chips and card
	public void current_chips_card(int chips, int card1) {
		System.out.println("*****チップ枚数とカード*****");
		show_(chips); // show current chips
		card.currentCard(card1);
		System.out.println("****************************");
		System.out.println("");
	}
	// show current state
	public void current_state(int input, int choice, int card1) {
		System.out.println("********Big or Small********");
		System.out.println("BET数:"+input);
		System.out.println("あなたの選択:" + card.choice(choice));
		card.currentCard(card1);
	}
}
