package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.OldMan;
import character.OldWoman;
import character.demon.ChildDemon;
import character.demon.DemonIsland;
import character.party.Bird;
import character.party.Dog;
import character.party.Monkey;
import character.party.PartyCharacter;
import character.party.PeachBoy;
import item.Kibidango;
import item.Sword;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PeachBoy boy = new PeachBoy();
		OldMan man = new OldMan();
		OldWoman woman = new OldWoman();
		ArrayList<PartyCharacter> partyMember = new ArrayList<PartyCharacter>();
		ArrayList<DemonIsland> demons =new ArrayList<DemonIsland>();
		partyMember.add(boy);

		put("【ももたろう】");
		scan.nextLine();
		
		put("昔々、ある老夫婦のおうちにとても大きなモモが届きました。");
		scan.nextLine();
		put("早速割ってみると中には元気な赤ちゃんがいました。");
		scan.nextLine();

		while (true) {
			put("あなたの名前は？>>");
			String name = scan.next();
			boy.setName(name);

			put(boy.getName() + "ですね？");
			ans();
			int select = scan.nextInt();
			if (select == 1) {
				break;
			}
		}

		put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
		put("");
		System.out.printf("名前:　%S　[㏋:　%d]　が生まれた！\n ", boy.getName(), boy.getHp());
		put("");
		put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
		put("");

		put("おばあさんとおじいさんは" + boy.getName() + "を大切に育ててくれました。");
		scan.nextLine();
		blank();
		scan.nextLine();
		put("そんなある日、おうちにボロボロになった村人たちがやってきました。");
		scan.nextLine();
		put("村人「たくさんの鬼が来て暴れているんだ！助けて；；」");
		scan.nextLine();
		boy.talk("「ぼく、鬼ヶ島へ行って、わるい鬼を退治します」");

		scan.nextLine();
		woman.talk("「それなら、きびだんごを用意してあげよう！」");
		scan.nextLine();
		woman.talk("「これを食べると体力が回復するし、動物と仲良くなれるよ！」");
		scan.nextLine();
		put("【　きびだんご×10　をゲットした！　】");
		//きびだんごをもった桃太郎
		Kibidango k = new Kibidango();
		k.setNum(10);
		boy.kibidango = k;

		scan.nextLine();
		man.talk("「この剣も持っていきなさい！これで鬼と戦うんだ！」");
		scan.nextLine();
		put("【　剣　をゲットした！　】");
		//剣をもった桃太郎
		Sword s = new Sword();
		boy.sword = s;
		scan.nextLine();

		boy.talk("「" + man.getName() + woman.getName() + "ありがとう！行ってきます！」");
		scan.nextLine();
		blank();
		scan.nextLine();

		//多分修正
		PartyCharacter monkey = new Monkey();
		PartyCharacter dog = new Dog();
		PartyCharacter bird = new Bird();
		PartyCharacter[] animals = { monkey, dog, bird };
		int animalCount = 0;

		//冒険開始
		//キジが出たら終了
		while (animalCount < 3) {
			put("歩いていると道が分かれた。どの道を通る？");
			put("【　1.右側の道　2.真ん中の道　3.左側の道　】>>");
			int adventureSelect = scan.nextInt();//道の選択
			int randomAdventure = new Random().nextInt(0, 101);//どこを選んでもランダム
			if (randomAdventure >= 50) {
				//仲間ゲット
				put("道を歩いていると" + animals[animalCount].getName() + "が現れた！");
				scan.nextLine();
				put(animals[animalCount].getName() + "「桃太郎さん、どこへ行くのですか？」");
				scan.nextLine();
				boy.talk("「鬼ヶ島へ、鬼退治に行くんだ」");
				scan.nextLine();
				put(animals[animalCount].getName() + "「それでは、お腰に付けたきび団子を１つ下さいな。"
						+ "おともしますよ」");
				scan.nextLine();
				put(animals[animalCount].getName() + "にきびだんごをあげる？");
				ans();
				int select = scan.nextInt();
				if (select == 1) {//仲間になったら
					put(animals[animalCount].getName() + "にきびだんごをあげた！");
					scan.nextLine();
					put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					put("");
					System.out.printf("名前:　%S　[㏋:　%d]　が仲間になった！\n ",
							animals[animalCount].getName(), animals[animalCount].getHp());
					put("");
					put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					put("");

					//仲間になったコード
					partyMember.add(animals[animalCount]);
				} else {//仲間スキップ
					put("悲しそうな顔をして" + animals[animalCount].getName() + "は去っていった…");

				}
				animalCount++;

			} else if (randomAdventure < 25) {

				//敵と戦う
				ChildDemon child = new ChildDemon();
				demons.add(child);
				
				DemonBattle.battle( boy , k , demons , partyMember);
				
				demons.remove(0);

			} else {
				//寝る〇
				put("道を歩いているといつの間にか夜になった。");
				scan.nextLine();
				scan.nextLine();
				put("眠くなってきたので、今日はゆっくり休むことにしよう。");
				scan.nextLine();
				//（いるキャラクター全てヒール）
				for (int i = 0; i < partyMember.size(); i++) {
					partyMember.get(i).sleepHeal();

				}

			}
		}

		//鬼ヶ島到着
		blank();
		System.out.printf("%Sたちは、船に乗って大海原を渡ることにします。", boy.getName());
		put("しばらくすると島が見えてきました。\n その島は荒々しく、岩山がそびえ立ち、黒い雲が島を覆っていました。");
		boy.talk("鬼ヶ島だ！鬼を倒して、村のみんなを守るぞ！");
		put("そして、桃太郎と仲間たちは決意を胸に、鬼ヶ島へと足を踏み入れました。");
		blank();

		put("鬼ヶ島に挑戦しますか？");
		ans();
		int ans =new Scanner(System.in).nextInt();
		if(ans ==2) {
			goHome(boy);
		}else if(ans ==1) {
			
			
		}
		
	}

	public static void put(String str) {
		System.out.println(str);
	}

	public static void blank() {
		put("・・・");
	}
	public static void ans() {
		put("1:はい　2:いいえ");
	}

	public static void gameOver() {
		Scanner scan = new Scanner(System.in);

		put("【　GAME　OVER　】");
		scan.nextLine();
		put("もう一度遊ぶ？");
		ans();
		int gameSelect =new Scanner(System.in).nextInt();
		if(gameSelect == 2) {
			
			put("----【おしまい】----");
			put("また遊んでね♪");
			return;
			}

	}
	
	public static void goHome(PeachBoy boy) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("%sたちは、鬼ヶ島に行くのが怖くなりおうちに帰った。", boy.getName());
		put("時々村にくる鬼におびえながら暮らしていくのであった。");
		put("----【おしまい】----");
		scan.nextLine();
		put("もう一度遊ぶ？");
		ans();
		int gameSelect =new Scanner(System.in).nextInt();
		if(gameSelect == 2) {
			put("また遊んでね♪");
			
			return;
			}
	}

	
}
