package bigorsmall;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BigorSmall {
	Card card = new Card();
	Trump trump = new Trump();
	Chips chips = new Chips();
	Scanner scanner = new Scanner(System.in);
	private int data[] = new int[2];
	private int data2[] = new int[2];
	private int cash[] = new int[2];
	private int ten = 10;
	private int one = 0;
	private int input;
	private int choice;
	private String BorS = "";
	private int outcome;
	private int sum;
	private int flag = 0;
	private int game = 0;
	private int option =0;
	BigorSmall(){
		chips.setChips(ten, one);
		trump.setNum(0);
	}


	public void start() {
		while (game == 0) {
			game();
			System.out.println("*****現在のチップ枚数*****");
			chips.show(ten, one);
			System.out.println("****************************");
			while (true){
				try{
					System.out.println("[ゲームを続けますか？]: 0:Yes 1:No");
					game = scanner.nextInt();
					takeChoice(game);
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

			if (0 >= chips.sum(ten, one)) {
				System.out.println("チップが0枚になりました．");
				break;
			}
			if (game == 0) {
				trump.setNum(0);
				flag = 0;
			}

		}

		System.out.println("");
		System.out.println("END");


	}

	public void game() {
		data = trump.pick();
		System.out.println("*****チップ枚数とカード*****");
		chips.show(ten, one);
		card.currentCard(data[0],data[1]);
		System.out.println("****************************");
		System.out.println("");

		bet();
		while (flag == 0) {

			bigorsmall();
			play();

			if (flag == 1) break;



			while (true){
				try{
					System.out.println("[獲得したチップ"+input+"枚でBig or Smallを続けますか？]: 0:Yes 1:No");
					flag = scanner.nextInt();
					takeChoice(flag);
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
		sum+=input;
		cash = chips.toCash(0,sum);
		ten = cash[0];
		one = cash[1];

	}

	public void bet() {
	System.out.println("■BET枚数選択");
	while (option == 0){
		try{
			System.out.println("BETするチップ数を入力して下さい(最低1～最大20)");
			input = scanner.nextInt();
			sum = chips.sum(ten, one);
			takeChips(input);
			sum-=input;
			cash = chips.toCash(0,sum);
			ten = cash[0];
			one = cash[1];
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

	public void bigorsmall() {
		System.out.println("■Big or Small選択");
		card.currentCard(data[0],data[1]);
		while (true){
			try{
				System.out.println("[Big or Small]: 0:BIg 1:Small");
				choice = scanner.nextInt();
				takeChoice(choice);
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
		System.out.println("********Big or Small********");
		System.out.println("BET数:"+input);
		BorS = BorS(choice);
		System.out.println("あなたの選択:" +BorS);
		card.currentCard(data[0],data[1]);
		data2 = trump.pick();
		card.pickCard(data2[0],data2[1]);
		outcome = oneorzero(data,data2);

		System.out.println(card.show(data2[0], data2[1])+"は"+card.show(data[0], data[1])+"より"+BorS(outcome));

		System.out.println("****************************");

		if (BorS == BorS(outcome)) {
			System.out.println("Win!!");
			input*=2;
			System.out.println("チップ"+input+"枚を獲得しました");
			System.out.println("");
			data = data2;

		} else if(BorS != BorS(outcome)) {
			System.out.println("Lose...");
			System.out.println("");
			input = 0;

			flag = 1;
		}
	}

	public void takeChips(int input) throws Exception {
		int sum;
		sum = chips.sum(ten,one);

		if (input>20) {
			throw new MyException("入力されたデータが上限値を上回っています。");

		}else if(input<1) {
			throw new MyException("入力されたデータが下限値を下回っています。");

		}else if (input > sum) {
			throw new MyException("入力されたデータが上限値を上回っています。");

		}
	}

	public void takeChoice(int input) throws Exception {
		if ((input != 0) && (input !=1)) {
			throw new MyException("正しく入力してください。");

		}
	}

	public String BorS(int input) {
		String small = "Small";
		String big = "Big";
		if (input == 1) {
			return small;
		}else if(input == 0) {
			return big;
		}
		return big;
	}

	public int oneorzero(int[] data1, int[] data2) {
		if (data1[1]>data2[1]) {
			return 1;
		} else if (data1[1]<data2[1]) {
			return 0;
		} else if (data1[0]>data2[0]) {
			return 0;
		} else if (data1[0]<data2[1]) {
			return 1;
		}
		return 1;
	}


}
