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
		PartyCharacter[] animals = { monkey, dog, bird };
		int animalCount = 0;

		ChildDemon child = new ChildDemon();
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
				boy1.talk("「鬼ヶ島へ、鬼退治に行くんだ」");
				scan.nextLine();
				put(animals[animalCount].getName() + "「それでは、お腰に付けたきび団子を１つ下さいな。"
						+ "おともしますよ」");
				scan.nextLine();
				put(animals[animalCount].getName() + "にきびだんごをあげる？");
				put("1:はい　2:いいえ");
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
				System.out.printf("道を歩いていると、 %s[HP: %d ] が現れた！\n", child.getName(), child.getHp());

				scan.nextLine();
				boolean isRun = false;
				while (child.getHp() > 0 && !isRun) {
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
									if (partyMember.get(i).getHp() > 0) {
										int partyRandom = new Random().nextInt(2);
										if (partyRandom == 0) {
											partyMember.get(i).attack(child);
										} else {
											partyMember.get(i).noAttack();
										}
									}
								} else {
									break;
								}
							}
							if (child.getHp() > 0) {
								put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
								put("");
								put(child.getName() + "の㏋は　" + child.getHp() + "　になった\n");
								put("");
								put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
								new Scanner(System.in).nextLine();
							} else {
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
							break;

						case 3://逃げる
							put("本当に逃げる？>>");
							put("1:はい　2:いいえ");
							int ans = scan.nextInt();
							if (ans == 1) {
								boy1.run();
								isRun = true;
							}
							break;
						case 4://状態
							put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
							put("");
							for (int i = 0; i < partyMember.size(); i++) {
								put((i + 1) + ": " + partyMember.get(i).getName() + "　HP:　 "
										+ partyMember.get(i).getHp());//いる人表示させたい
							}
							put("");
							put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
							new Scanner(System.in).nextLine();
							break;

						}

					}
				}
				isRun = false;

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

//
//System.out.printf("道を歩いていると、 %s[HP: %d ] が現れた！\n", child.getName(), child.getHp());
//
//scan.nextLine();
//boolean isRun = false;
//
//while (child.getHp() > 0 && !isRun) {
//	if (boy.getHp() <= 0) {
//		gameOver();
//	} else {
//		put("どうする？");
//		put("【　1.戦う　2.回復する　3.逃げる　4.仲間の状態を見る　】>>");
//		int battleSelect = scan.nextInt();
//		switch (battleSelect) {
//		case 1://戦う
//
//			for (int i = 0; i < partyMember.size(); i++) {
//				if (child.getHp() > 0) {
//					//桃太郎サイド攻撃
//					if (partyMember.get(i).getHp() > 0) {
//						int partyRandom = new Random().nextInt(2);
//						if (partyRandom == 0) {
//							partyMember.get(i).attack(child);
//						} else {
//							partyMember.get(i).noAttack();
//						}
//					}
//				} else {
//					break;
//				}
//			}
//			if (child.getHp() > 0) {
//				put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
//				put("");
//				put(child.getName() + "の㏋は　" + child.getHp() + "　になった\n");
//				put("");
//				put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
//				new Scanner(System.in).nextLine();
//			} else {
//				break;
//			}
//
//			//小鬼サイド攻撃
//			for (int i = 0; i < partyMember.size(); i++) {
//				scan.nextLine();
//				int childRandom = new Random().nextInt(2);
//				if (childRandom == 0) {
//					child.attack(partyMember.get(i));
//				} else {
//					child.noAttack();
//				}
//			}
//
//			break;
//		//ステータス表示
//
//		case 2://回復
//			System.out.printf("【　誰を回復する？(きびだんご残り　%d個　】>>\n", k.getNum());
//			//↓ファイル読み込み？とかで表示できるならしたい
//
//			for (int i = 0; i < partyMember.size(); i++) {
//				put((i + 1) + ": " + partyMember.get(i).getName());//いる人表示させたい
//
//			}
//			//回復する人の選択
//			int healSelect = scan.nextInt();
//			switch (healSelect) {
//			case 1:
//				partyMember.get(0).heal();
//				break;
//			case 2:
//				partyMember.get(1).heal();
//				break;
//			case 3:
//				partyMember.get(2).heal();
//				break;
//			case 4:
//				partyMember.get(3).heal();
//				break;
//
//			}
//			break;
//
//		case 3://逃げる
//			put("本当に逃げる？>>");
//			ans();
//			int ans = scan.nextInt();
//			if (ans == 1) {
//				boy.run();
//				isRun = true;
//			}
//			break;
//		case 4://状態
//			put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
//			put("");
//			for (int i = 0; i < partyMember.size(); i++) {
//				put((i + 1) + ": " + partyMember.get(i).getName() + "　HP:　 "
//						+ partyMember.get(i).getHp());//いる人表示させたい
//			}
//			put("");
//			put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
//			new Scanner(System.in).nextLine();
//			break;
//
//		}
//
//	}
//}
//isRun = false;































//public static void DemonAttack(ArrayList<DemonIsland> demons, ArrayList<PartyCharacter> partyMember) {
//	//小鬼サイド攻撃
//	for (DemonIsland d : demons) {
//		for (PartyCharacter p : partyMember) {
//
//			if (p.getHp() > 0) {
//				//小鬼サイド攻撃
//				if (d.getHp() > 0) {
//					int partyRandom = new Random().nextInt(2);
//					if (partyRandom == 0) {
//						d.attack(p);
//					} else {
//						d.noAttack();
//					}
//				}
//			} else {
//				break;
//			}
//		}
//	}