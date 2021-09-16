package bigorsmall;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BigorSmall {
	Card card = new Card();
	Trump trump = new Trump();
	Chips chips = new Chips();
	Scanner scanner = new Scanner(System.in);
	private int card1; //picked card before user decide Big or Small
	private int card2 = -1; //picked card after user decide Big or Small
	private int chips_ = 100; // initialized chips
	private int input; // number of betting chips
	private int choice; // choice that user decide Big or Small
	private int outcome; // return 1 or 0 whether card2 is bigger than card1 or not
	private int flag = 0;
	private int game = 0;

	BigorSmall(){
		trump.initFlag();
	}


	public void start() {
		// if game is 1, this game is over
		while (game == 0) {
			game(); //game method start
			chips.current_chips(chips_); // show current chips
			while (true){
				try{
					System.out.println("[ゲームを続けますか？]: 0:Yes 1:No");
					game = scanner.nextInt();
					throwZeroOne(game); // throw error
					System.out.println("");
					break;
				}catch(InputMismatchException ex) {
					System.out.println("半角数字を入力してください。");
					scanner.next();
				}catch(MyException ex) {
					System.out.println(ex.getMessage());
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}

			// game is over if chips is less than 1
			if (0 >= chips_) {
				System.out.println("チップが0枚になりました．");
				break;
			}
			// if game is 0 and chips is more than 1, game method still continue
			if (game == 0) {
				// trump card is initialized
				trump.initFlag();
				flag = 0;
			}

		}

		System.out.println("");
		System.out.println("END");


	}

	public void game() {
		card1 = trump.pick(); // card1 is picked
		// show current chips and card
		chips.current_chips_card(chips_, card1);

		bet(); // bet method start
		// if flag is 1, this method is over
		while (flag == 0) {

			bigorsmall(); // bigorsmall method start. User choose Big or Small
			play(); // play method start

			if (flag == 1) break;

			// user select game continue or not
			while (true){
				try{
					System.out.println("[獲得したチップ"+input+"枚でBig or Smallを続けますか？]: 0:Yes 1:No");
					flag = scanner.nextInt();
					throwZeroOne(flag);
					System.out.println("");
					break;
				}catch(InputMismatchException ex) {
					System.out.println("半角数字を入力してください。");
					scanner.next();
				}catch(MyException ex) {
					System.out.println(ex.getMessage());
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}

		}

		// betted chips added total chips
		chips_+=input;

	}

	public void bet() {
	System.out.println("■BET枚数選択");
	while (true){
		try{
			System.out.println("BETするチップ数を入力して下さい(最低1～最大20)");
			input = scanner.nextInt();

			throwInput(input);
			//total chips is subtracted by betted chips
			chips_-=input;
			System.out.println("");
			break;
		}catch(InputMismatchException ex) {
			System.out.println("半角数字を入力してください。");
			scanner.next();
		}catch(MyException ex) {
			System.out.println(ex.getMessage());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	}

	// User choose Big or Small
	public void bigorsmall() {
		System.out.println("■Big or Small選択");
		card.currentCard(card1); // show current card
		while (true){
			try{
				System.out.println("[Big or Small]: 0:BIg 1:Small");
				choice = scanner.nextInt();
				throwZeroOne(choice); // throw error
				System.out.println("");
				break;
			}catch(InputMismatchException ex) {
				System.out.println("半角数字を入力してください。");
				scanner.next();
			}catch(MyException ex) {
				System.out.println(ex.getMessage());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public void play() {
		// show current state
		chips.current_state(input, choice, card1);
		// pick second card. if picked all card, trump card will be initialized
		card2 = trump.pick();
		if (card2 == -1) {
			System.out.println("カードの残り枚数がゼロになりましたので，カードを元に戻します！");
			trump.initFlag();
			card2 = trump.pick();
		}



		// show picked card
		card.pickCard(card2);
		// return 1 if card2 is bigger than card1, and vice versa
		outcome = card.bigorsmall(card1,card2);
		//show card outcome
		card.show(card1, card2);

		System.out.println("****************************");


		if (card.choice(outcome) == card.choice(choice)) {
			System.out.println("Win!!");
			input*=2;
			System.out.println("チップ"+input+"枚を獲得しました");
			System.out.println("");
			card1 = card2;

		} else if(card.choice(outcome) != card.choice(choice)) {
			System.out.println("Lose...");
			System.out.println("");
			input = 0;

			flag = 1;
		}
	}

	public void throwInput(int input) throws Exception {


		if (input>20) {
			throw new MyException("入力されたデータが上限値を上回っています。");

		}else if(input<1) {
			throw new MyException("入力されたデータが下限値を下回っています。");

		}else if (input > chips_) {
			throw new MyException("入力されたデータが上限値を上回っています。");

		}
	}

	public void throwZeroOne(int input) throws Exception {
		if ((input != 0) && (input !=1)) {
			throw new MyException("正しく入力してください。");

		}
	}

}
