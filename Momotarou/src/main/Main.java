package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.OldMan;
import character.OldWoman;
import character.demon.ChildDemon;
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
		partyMember.add(boy);

		put("【ももたろう】");
		scan.nextLine();
		prologue();

		while (true) {
			put("あなたの名前は？>>");
			String name = scan.next();
			boy.setName(name);

			put(boy.getName() + "ですね？");
			put("1:はい　2:いいえ");
			int select = scan.nextInt();
			if (select == 1) {
				break;
			}
		}
		String boyName = boy.getName();

		middleStory(boyName);

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

		boy.talk("「" + man.name + woman.name + "ありがとう！行ってきます！」");
		scan.nextLine();
		blank();
		scan.nextLine();

		//多分修正
		PartyCharacter monkey =new Monkey();
		PartyCharacter dog =new Dog();
		PartyCharacter bird =new Bird();
		PartyCharacter[] animals = { monkey , dog , bird };
		int animalCount = 0;

		//冒険開始
		//キジが出たら終了
		while (animalCount < 3) {
			put("歩いていると道が分かれた。どの道を通る？");
			put("【　1.右側の道　2.真ん中の道　3.左側の道　】>>");
			int adventureSelect = scan.nextInt();//道の選択
			int randomAdventure = new Random().nextInt(3);//どこを選んでもランダム
			switch (randomAdventure) {
			case 0://仲間ゲット
				put("道を歩いていると" + animals[animalCount].name + "が現れた！");
				scan.nextLine();
				put(animals[animalCount].name + "「桃太郎さん、どこへ行くのですか？」");
				scan.nextLine();
				boy.talk("「鬼ヶ島へ、鬼退治に行くんだ」");
				scan.nextLine();
				put(animals[animalCount].name + "「それでは、お腰に付けたきび団子を１つ下さいな。"
						+ "おともしますよ」");
				scan.nextLine();
				put(animals[animalCount].name + "にきびだんごをあげる？");
				put("1:はい　2:いいえ");
				int select = scan.nextInt();
				if (select == 1) {//仲間になったら
					put(animals[animalCount].name + "にきびだんごをあげた！");
					scan.nextLine();
					put("【　" + animals[animalCount].name + "が仲間になった　】");
					scan.nextLine();
					//仲間になった動物のステータス？表示

					//仲間になったコード記入
					partyMember.add(animals[animalCount]);
				} else {//仲間スキップ
					put("悲しそうな顔をして" + animals[animalCount].name + "は去っていった…");

				}
				animalCount++;
				break;

			case 1://敵と戦う
				ChildDemon child = new ChildDemon();
				put("道を歩いていると" + child.getName() + "が現れた！");
				scan.nextLine();

				while (child.getHp() > 0) {
					if (boy.getHp() <= 0) {
						gameOver();
					} else {
						put("どうする？");
						put("【　1.戦う　2.回復する　3.逃げる　4.仲間の状態を見る　】>>");
						int battleSelect = scan.nextInt();
						switch (battleSelect) {
						case 1://戦う
							for(int i = 0 ; i < partyMember.size(); i++) {
								
								//桃太郎サイド攻撃
								int partyRandom = new Random().nextInt(2);
								if(partyRandom == 0) {
									partyMember.get(i).attack(child);
								}else {
									partyMember.get(i).noAttack();
								}
							}
							put(child.getName() +"の㏋は" + child.getHp() +"になった");
							
							//小鬼サイド攻撃
							int childRandom = new Random().nextInt(2);
							if(childRandom == 0) {
								child.attack();
							}else {
								child.noAttack();
							}
							
							//ステータス表示
							
							
							
							
							break;

						case 2://回復
							System.out.printf("誰を回復する？きびだんご残り%d個", k.getNum());
							//↓ファイル読み込み？とかで表示できるならしたい
							System.out.print("【　");
							for(int i = 0 ; i < partyMember.size(); i++) {
								System.out.print((partyMember.size()+1) + partyMember.get(i).name);//いる人表示させたい
							}
							System.out.print("　】");
							
							//回復する人の選択
							int healSelect = scan.nextInt();
							switch(healSelect) {
							case 1:
								partyMember.get(0).heal();
//								put("は" + partyMember.get(0).getHp());
//								k.setNum(setNum - 1);
								break;
							case 2:
								partyMember.get(1).heal();
								break;
							case 3:
								partyMember.get(2).heal();
								break;
							case 4:
								partyMember.get(3).heal();
								break;
							
							}

							break;
						case 3://逃げる
							boy.run();
							break;

						case 4://状態
							break;

						}
					}
				}
				break;
			case 2://寝る
				put("道を歩いているといつの間にか夜になった。");
				scan.nextLine();
				scan.nextLine();
				put("眠くなってきたので、今日はゆっくり休むことにしよう。");
				scan.nextLine();
				//（いるキャラクター全てヒール）
				//【？？は？？hp回復した】 
				break;

			}

		}
		//鬼ヶ島到着
		blank();

	}

	public static void put(String str) {
		System.out.println(str);
	}

	public static void prologue() {
		Scanner scan = new Scanner(System.in);
		put("昔々、ある老夫婦のおうちにとても大きなモモが届きました。");
		scan.nextLine();
		put("早速割ってみると中には元気な赤ちゃんがいました。");
		scan.nextLine();

	}

	public static void middleStory(String boyName) {
		Scanner scan = new Scanner(System.in);

		put("おばあさんとおじいさんは" + boyName + "を大切に育ててくれました。");
		scan.nextLine();
		blank();
		scan.nextLine();
		put("そんなある日、おうちにボロボロになった村人たちがやってきました。");
		scan.nextLine();
		put("村人「たくさんの鬼が来て暴れているんだ！助けて；；」");
		scan.nextLine();
		put(boyName + "「ぼく、鬼ヶ島へ行って、わるい鬼を退治します」");
		scan.nextLine();

	}

	public static void blank() {
		put("・・・");
	}

	public static void gameOver() {
		Scanner scan = new Scanner(System.in);

		put("【　GAME　OVER　】");
		scan.nextLine();
		put("もう一度遊ぶ？");
		put("1:はい　2:いいえ");

	}
}
