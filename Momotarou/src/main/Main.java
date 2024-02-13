package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		ArrayList<PartyCharacter> partyMember = new ArrayList<>();
		ArrayList<DemonIsland> demons = new ArrayList<DemonIsland>();

		put("【ももたろう】");
		scan.nextLine();

		ArrayList<String> list = new ArrayList<String>();
		//冒頭　ファイル読み込む
		String path = "1.csv";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : list) {
			put(s);
			scan.nextLine();
		}

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
		partyMember.add(boy);

		String partyPath = "Party.csv";

		//ファイル書き込み
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(partyPath), "UTF-8"))) {
			for (int i = 0; i < partyMember.size(); i++) {
				bw.write((i + 1) + "：" + partyMember.get(i).getName() +
						",　HP：" + partyMember.get(i).getHp() + "\n");
			}

		} catch (

		IOException e) {
			e.printStackTrace();

		}

		put("おばあさんとおじいさんは" + boy.getName() + "を大切に育ててくれました。");
		scan.nextLine();
		blank();

		//ファイル読み込み
		ArrayList<String[]> list2 = new ArrayList<>();
		String path2 = "2.csv";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path2), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				list2.add(line.split(","));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] string : list2) {

			switch (string[0]) {
			case "no":
				put(string[1]);
				scan.nextLine();
				break;

			case "boy":
				boy.talk(string[1]);
				scan.nextLine();
				break;
			case "man":
				man.talk(string[1]);
				scan.nextLine();
				break;
			case "woman":
				woman.talk(string[1]);
				scan.nextLine();
				break;
			}
		}

		//きびだんごをもった
		Kibidango k = new Kibidango();
		k.setNum(10);
		boy.kibidango = k;

		//剣をもった
		Sword s = new Sword();
		boy.sword = s;
		scan.nextLine();

		boy.talk("「" + man.getName() + woman.getName() + "ありがとう！行ってきます！」");
		scan.nextLine();
		blank();
		scan.nextLine();

		//仲間になるキャラクターを作成
		PartyCharacter monkey = new Monkey();
		PartyCharacter dog = new Dog();
		PartyCharacter bird = new Bird();
		PartyCharacter[] animals = { monkey, dog, bird };
		int animalCount = 0;
		ChildDemon child = new ChildDemon();

		//冒険開始
		//キジが出たら終了
		while (animalCount < 3) {
			put("歩いていると道が分かれた。どの道を通る？");
			put("【　1.右側の道　2.真ん中の道　3.左側の道　】>>");
			int adventureSelect = scan.nextInt();//道の選択
			int randomAdventure = new Random().nextInt(0, 101);//どこを選んでもランダム

			//50％の確率で仲間ゲットがでる
			if (randomAdventure >= 50) {

				//仲間ゲット
				MakeParty.negotiate(partyMember, animals, animalCount, boy, k);
				animalCount++;
				scan.nextLine();

			} else if (randomAdventure < 25) {

				//敵と戦う
				
				demons.add(child);

				DemonBattle.battle(boy, k, demons, partyMember,child);

				demons.remove(0);

			} else {
				//寝る〇

				SleepHeal.sleep(partyMember);

			}
		}

		//鬼ヶ島到着
		blank();
		System.out.printf("%Sたちは、船に乗って大海原を渡ることにします。", boy.getName());
		scan.nextLine();
		put("しばらくすると島が見えてきました。\n その島は荒々しく、岩山がそびえ立ち、黒い雲が島を覆っていました。");
		scan.nextLine();
		boy.talk("「鬼ヶ島だ！鬼を倒して、村のみんなを守るぞ！」");
		scan.nextLine();
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
			DemonBattle.battle(boy, k, demons, partyMember,child);
			demons.remove(0);

		}

		//ボス鬼に立ち向かう
		ArrayList<String[]> list3 = new ArrayList<>();
		String path3 = "3.csv";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path3), "UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				list3.add(line.split(","));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] string : list3) {

			switch (string[0]) {
			case "no":
				put(string[1]);
				scan.nextLine();
				break;

			case "boy":
				boy.talk(string[1]);
				scan.nextLine();
				break;
			}
		}

		//ボス鬼との戦い
		BigDemon bigDemon = new BigDemon();
		demons.add(bigDemon);
		DemonBattle.battle(boy, k, demons, partyMember,child);
		demons.remove(0);

		//倒した！
		System.out.printf("そして、長い戦いの末、%sたちの勇気と結束が勝利をもたらしました。\n"
				+ "ボス鬼は倒れ、小さな鬼たちは降伏しました。\n"
				+ "%sたちは喜びに満ちた笑顔で村に帰り、村人たちと幸せに暮らしました。\n", boy.getName(), boy.getName());

		put("-------------✩--------------");
		put("");
		put("　　　 【GAME　CLEAR】　　　");
		put("　　　めでたしめでたし　　　");
		put("");
		put("-------------✩--------------");
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
