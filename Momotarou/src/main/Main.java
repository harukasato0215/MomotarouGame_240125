package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.OldMan;
import character.OldWoman;
import character.demon.BigDemon;
import character.demon.ChildDemon;
import character.demon.DemonIsland;
import character.demon.MediumDemon;
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
		ArrayList<DemonIsland> demons = new ArrayList<DemonIsland>();
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
		//桃太郎誕生！名前とHP
		PeachBoy.beBorn(boy.getName(), boy.getHp());

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
		k.setNum(2);
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

		//仲間に食われられるキャラクターを作成
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
				MakeParty.negotiate(partyMember, animals,animalCount, boy, k);
				animalCount++;
				scan.nextLine();

			} else if (randomAdventure < 25) {

				//敵と戦う
				ChildDemon child = new ChildDemon();
				demons.add(child);

				DemonBattle.battle(boy, k, demons, partyMember);

				demons.remove(0);

			} else {
				//寝る〇

				SleepHeal.sleep(partyMember);
				
			}
		}

		//鬼ヶ島到着
		blank();
		System.out.printf("%Sたちは、船に乗って大海原を渡ることにします。", boy.getName());
		put("しばらくすると島が見えてきました。\n その島は荒々しく、岩山がそびえ立ち、黒い雲が島を覆っていました。");
		boy.talk("「鬼ヶ島だ！鬼を倒して、村のみんなを守るぞ！」");
		put("そして、桃太郎と仲間たちは決意を胸に、鬼ヶ島へと足を踏み入れました。");
		blank();

		put("鬼ヶ島に挑戦しますか？");
		ans();
		int ans = new Scanner(System.in).nextInt();
		if (ans == 2) {
			//家に帰るエンド
			goHome(boy);
		} else if (ans == 1) {
			//中鬼との戦い
			MediumDemon demon = new MediumDemon();
			demons.add(demon);
			DemonBattle.battle(boy, k, demons, partyMember);
			demons.remove(0);

		}
		
		//ボス鬼に立ち向かう
		put("鬼ヶ島の中心部にたどり着いた桃太郎たちは、そこに立ちはだかる巨大な洞窟を見つけました。");
		boy.talk("「ボス鬼はあの洞窟の中にいるはずだ。みんな、覚悟を決めろ！この戦いで村を守り抜こう！」");
		put("仲間たちは桃太郎の言葉に力強く頷き、一致団結して洞窟へと進みました。");
		
		
		//ボス鬼との戦い
		BigDemon bigDemon =new BigDemon();
		demons.add(bigDemon);
		DemonBattle.battle(boy, k, demons, partyMember);
		demons.remove(0);
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
		int gameSelect = new Scanner(System.in).nextInt();
		if (gameSelect == 2) {

			put("----【おしまい】----");
			put("また遊んでね♪");
			return;
		}

	}

	public static void goHome(PeachBoy boy) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("%sたちは、鬼ヶ島に行くのが怖くなりおうちに帰った。\n", boy.getName());
		put("時々村にくる鬼におびえながら暮らしていくのであった。");
		put("----【おしまい】----");
		scan.nextLine();
		put("もう一度遊ぶ？");
		ans();
		int gameSelect = new Scanner(System.in).nextInt();
		if (gameSelect == 2) {
			put("また遊んでね♪");

			return;
		}
	}

}
