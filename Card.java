package bigorsmall;

import java.util.ArrayList;
import java.util.List;

public class Card {

    List<String> card_list = new ArrayList<String>() {
        {
          add("スペード13");
          add("ハート13");
          add("ダイヤ13");
          add("クラブ13");
          add("スペード12");
          add("ハート12");
          add("ダイヤ12");
          add("クラブ12");
          add("スペード11");
          add("ハート11");
          add("ダイヤ11");
          add("クラブ11");
          add("スペード10");
          add("ハート10");
          add("ダイヤ10");
          add("クラブ10");
          add("スペード9");
          add("ハート9");
          add("ダイヤ9");
          add("クラブ9");
          add("スペード8");
          add("ハート8");
          add("ダイヤ8");
          add("クラブ8");
          add("スペード7");
          add("ハート7");
          add("ダイヤ7");
          add("クラブ7");
          add("スペード6");
          add("ハート6");
          add("ダイヤ6");
          add("クラブ6");
          add("スペード5");
          add("ハート5");
          add("ダイヤ5");
          add("クラブ5");
          add("スペード4");
          add("ハート4");
          add("ダイヤ4");
          add("クラブ4");
          add("スペード3");
          add("ハート3");
          add("ダイヤ3");
          add("クラブ3");
          add("スペード2");
          add("ハート2");
          add("ダイヤ2");
          add("クラブ2");
          add("スペード1");
          add("ハート1");
          add("ダイヤ1");
          add("クラブ1");
        }
      };



	public void currentCard(int i) {
		System.out.println("現在のカード:"+card_list.get(i));
	}

	public void pickCard(int i) {
		System.out.println("引いたカード:"+card_list.get(i));

	}


	public void show(int card1, int card2) {
		int flag = bigorsmall(card1, card2);
		if (flag == 1) {
			System.out.println(card_list.get(card2)+"は"+card_list.get(card1)+"よりSmall");
		} else if (flag == 0) {
			System.out.println(card_list.get(card2)+"は"+card_list.get(card1)+"よりBig");
		}

	}


	public int bigorsmall(int card1, int card2) {
		//if card1 is big than card2, return 1.
		if (card1<card2) {
			return 1;
		}

		return 0;
	}

	public String choice(int i) {
		if (i == 0) {
			return "Big";
		}
		return "Small";
	}


}
