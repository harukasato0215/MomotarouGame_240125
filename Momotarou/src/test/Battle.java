package test;

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

public class Battle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PeachBoy boy1 = new PeachBoy();
		boy1.setName("ああ");

		OldMan man = new OldMan();
		OldWoman woman = new OldWoman();
		PartyCharacter monkey = new Monkey();
		PartyCharacter dog = new Dog();
		PartyCharacter bird = new Bird();

		Sword s = new Sword();
		boy1.sword = s;
		Kibidango k = new Kibidango();
		k.setNum(10);
		boy1.kibidango = k;

		ArrayList<PartyCharacter> partyMember = new ArrayList<PartyCharacter>();
		partyMember.add(boy1);
		partyMember.add(monkey);
		partyMember.add(dog);
		partyMember.add(bird);

		ChildDemon child = new ChildDemon();
		System.out.printf("道を歩いていると、 %s[HP: %d ] が現れた！\n", child.getName(), child.getHp());

		scan.nextLine();
		boolean isRun =false;
		while (child.getHp() > 0&& !isRun) {
			if (boy1.getHp() <= 0) {
				gameOver();
			} else {
				put("どうする？");
				put("【　1.戦う　2.回復する　3.逃げる　4.仲間の状態を見る　】>>");
				int battleSelect = scan.nextInt();
				switch (battleSelect) {
				case 1://戦う
					for (int i = 0; i < partyMember.size(); i++) {
						if (child.getHp() > 0) {
							//桃太郎サイド攻撃
							int partyRandom = new Random().nextInt(2);
							if (partyRandom == 0) {
								partyMember.get(i).attack(child);
							} else {
								partyMember.get(i).noAttack();
							}
						}else {
							break;
						}
					}
					if(child.getHp() > 0) {
					put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					put(child.getName() + "の㏋は　" + child.getHp() + "　になった\n");
					put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					new Scanner(System.in).nextLine();
					}else {
						break;
					}

					//小鬼サイド攻撃
					for (int i = 0; i < partyMember.size(); i++) {
						scan.nextLine();
						int childRandom = new Random().nextInt(2);
						if (childRandom == 0) {
							child.attack(partyMember.get(i));
						} else {
							child.noAttack();
						}
					}

					break;
				//ステータス表示

				case 2://回復
					System.out.printf("【　誰を回復する？(きびだんご残り　%d個　】>>\n", k.getNum());
					//↓ファイル読み込み？とかで表示できるならしたい

					for (int i = 0; i < partyMember.size(); i++) {
						put((i + 1) + ": " + partyMember.get(i).getName());//いる人表示させたい

					}
					//回復する人の選択
					int healSelect = scan.nextInt();
					switch (healSelect) {
					case 1:
						partyMember.get(0).heal();
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
				case 3://逃げる
					put("本当に逃げる？>>");
					put("1:はい　2:いいえ");
					int select = scan.nextInt();
					if(select ==1) {
						boy1.run();
						isRun =true;
					}
					break;
				case 4://状態
					put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					for (int i = 0; i < partyMember.size(); i++) {
						put((i + 1) + ": " + partyMember.get(i).getName() + "　HP:　 " + partyMember.get(i).getHp());//いる人表示させたい
					}
					put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					new Scanner(System.in).nextLine();
					break;

				}
				
			}
		}
		isRun =false;
	}

	public static void put(String str) {
		System.out.println(str);
	}

	public static void gameOver() {
		Scanner scan = new Scanner(System.in);

		put("【　GAME　OVER　】");
		scan.nextLine();
		put("もう一度遊ぶ？");
		put("1:はい　2:いいえ");

	}

}
