package main;
import java.util.Random;
import java.util.Scanner;

import character.OldMan;
import character.OldWoman;
import character.demon.ChildDemon;
import character.party.PeachBoy;
import item.Kibidango;
import item.Sword;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PeachBoy boy = new PeachBoy();
		OldMan man = new OldMan();
		OldWoman woman = new OldWoman();
		ChildDemon child = new ChildDemon();

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
		put("【　きびだんご×10　をゲットした！】");
		//きびだんごをもった桃太郎
		Kibidango k = new Kibidango();
		boy.kibidango = k;

		scan.nextLine();
		man.talk("「この剣も持っていきなさい！これで鬼と戦うんだ！」");
		scan.nextLine();
		put("【　剣　をゲットした！】");
		//剣をもった桃太郎
		Sword s = new Sword();
		boy.sword = s;
		scan.nextLine();

		boy.talk("「" + man.name + woman.name + "ありがとう！行ってきます！」");
		scan.nextLine();
		blank();
		scan.nextLine();

		
		String[] animalNames = { "サル", "イヌ", "キジ" };
		int animalCount = 0;
			
			//冒険開始
			//キジが出たら終了
			while (animalCount < 3) {
				put("歩いていると道が分かれた。どの道を通る？");
				put("【1.右側の道　2.真ん中の道　3.左側の道】>>");
				int adventureSelect = scan.nextInt();//道の選択
				int randomAdventure = new Random().nextInt(3);//どこを選んでもランダム
				switch (randomAdventure) {
				case 0://仲間ゲット
						put("道を歩いていると" + animalNames[animalCount] + "が現れた！");
						scan.nextLine();
						put(animalNames[animalCount] + "「桃太郎さん、どこへ行くのですか？」");
						scan.nextLine();
						boy.talk("「鬼ヶ島へ、鬼退治に行くんだ」");
						scan.nextLine();
						put(animalNames[animalCount] + "「それでは、お腰に付けたきび団子を１つ下さいな。"
								+ "おともしますよ」");
						scan.nextLine();
						put(animalNames[animalCount] + "にきびだんごをあげる？");
						put("1:はい　2:いいえ");
						int select = scan.nextInt();
						if (select == 1) {//仲間になったら
							put(animalNames[animalCount] + "にきびだんごをあげた！");
							scan.nextLine();
							put("【" + animalNames[animalCount] + "が仲間になった】");
							scan.nextLine();
							//仲間になった動物のステータス？表示

							//仲間になったコード記入

						} else {//仲間スキップ
							put("悲しそうな顔をして" + animalNames[animalCount] + "は去っていった…");

						}
						animalCount++;
					break;
					
					
					
				case 1://敵と戦う
					put("道を歩いていると" + child.name + "が現れた！");
					scan.nextLine();
					put("どうする？");
					put("【1.戦う　2.回復する　3.逃げる】>>");
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
}
