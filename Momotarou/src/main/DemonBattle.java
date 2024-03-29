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

import character.demon.ChildDemon;
import character.demon.DemonIsland;
import character.party.PartyCharacter;
import character.party.PeachBoy;
import item.Kibidango;

public class DemonBattle {
	String partyPath = "Party.csv";
	ArrayList<String> party = new ArrayList<>();

	public static void battle(PeachBoy boy, Kibidango k, ArrayList<DemonIsland> demons,
			ArrayList<PartyCharacter> partyMember,ChildDemon child) {
		Scanner scan = new Scanner(System.in);
		String partyPath = "Party.csv";
		ArrayList<String> party = new ArrayList<>();
		appear(demons);

		scan.nextLine();
		boolean isRun = false;

		while (demons.get(0).getHp() > 0 && !isRun) {

			//桃太郎のHPが０になったらゲームオーバー
			if (boy.getHp() <= 0) {
				Main.gameOver();

			} else {
				Main.put("どうする？");
				Main.put("【　1.戦う　2.回復する　3.逃げる　4.仲間の状態を見る　】>>");
				int battleSelect = scan.nextInt();
				switch (battleSelect) {

				case 1://戦う

					PartyAttack(demons, partyMember);
					DemonAttack(demons, partyMember);
					
					//回復した文を書き込み
					try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(partyPath), "UTF-8"))) {
						for (int i = 0; i < partyMember.size(); i++) {
							bw.write((i + 1) + "：" + partyMember.get(i).getName() +
									",　HP：" + partyMember.get(i).getHp() + "\n");
						}

					} catch (

					IOException e) {
						e.printStackTrace();

					}

					//ステータス表示
					break;

				case 2://回復
					
					try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(partyPath), "UTF-8"))) {
						for (int i = 0; i < partyMember.size(); i++) {
							bw.write((i + 1) + "：" + partyMember.get(i).getName() +
									",　HP：" + partyMember.get(i).getHp() + "\n");
						}

					} catch (

					IOException e) {
						e.printStackTrace();

					}
					
					if (k.getNum() > 0) {
						System.out.printf("【　誰を回復する？(きびだんご残り　%d個　】>>\n", k.getNum());

						//メンバー表示
						Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
						Main.put("");
						try (BufferedReader br = new BufferedReader(
								new InputStreamReader(new FileInputStream(partyPath), "UTF-8"))) {
							String line = null;
							while ((line = br.readLine()) != null) {
								party.add(line);
								
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (String s : party) {
							System.out.println(s);
						}

						Main.put("");
						Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
						
						//リスト削除
						party.clear();
						int healSelect = scan.nextInt();
						partyMember.get(healSelect - 1).heal();
						k.setNum(k.getNum() - 1);
						
						
						
						
					} else {
						Main.put("もうきびだんごは残っていない…");
					}

					DemonAttack(demons, partyMember);
					break;

				case 3://逃げる
					Main.put("本当に逃げる？>>");
					Main.ans();
					int ans = scan.nextInt();
					
					if (ans == 1 ) {
						if(demons.get(0) == child) {
						boy.run();
						isRun = true;
						}
						
					}
					break;

				case 4://状態
					
					try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(partyPath), "UTF-8"))) {
						for (int i = 0; i < partyMember.size(); i++) {
							bw.write((i + 1) + "：" + partyMember.get(i).getName() +
									",　HP：" + partyMember.get(i).getHp() + "\n");
						}

					} catch (

					IOException e) {
						e.printStackTrace();

					}
					
					Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					Main.put("");
					try (BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(partyPath), "UTF-8"))) {
						String line = null;
						while ((line = br.readLine()) != null) {
							party.add(line);
							
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					for (String s : party) {
						System.out.println(s);
					}

				
					Main.put("");
					Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
					party.clear();
					new Scanner(System.in).nextLine();
					break;

				}

			}
		}
		isRun = false;

	}

	public static void appear(ArrayList<DemonIsland> demons) {
		System.out.print("道を歩いていると、");
		for (DemonIsland d : demons) {
			System.out.printf("%s　[HP:%d　]", d.getName(), d.getHp());
		}
		System.out.print("が現れた！\n");

	}

	public static void PartyAttack(ArrayList<DemonIsland> demons, ArrayList<PartyCharacter> partyMember) {
		for (int i = 0; i < partyMember.size(); i++) {

			for (DemonIsland d : demons) {
				if (d.getHp() > 0) {
					//桃太郎サイド攻撃
					if (partyMember.get(i).getHp() > 0) {
						int partyRandom = new Random().nextInt(2);
						if (partyRandom == 0) {
							partyMember.get(i).attack(d);
						} else {
							partyMember.get(i).noAttack();
						}
					}
				} else {
					break;
				}
			}

		}

		//桃太郎サイド攻撃終了したときに出る鬼の最終HP

		for (DemonIsland d : demons) {
			if (d.getHp() > 0) {
				Main.put("_________________ ＋_________________");
				Main.put("");
				Main.put("");
				Main.put(d.getName() + "の㏋は　" + d.getHp() + "　になった\n");
				Main.put("");
				Main.put("");
				Main.put("_________________ ＋ _________________");
				new Scanner(System.in).nextLine();
			} else {
				break;
			}

		}

	}

	public static void DemonAttack(ArrayList<DemonIsland> demons, ArrayList<PartyCharacter> partyMember) {
		//鬼サイド攻撃
		for (DemonIsland d : demons) {
			if (d.getHp() < 0) {
				break;
			} else {
				int healRandom = new Random().nextInt(100);
				if (healRandom > 31) {
					if (d.getHp() > 0) {
					d.heal();
					}
				} else {
					for (PartyCharacter p : partyMember) {

						if (p.getHp() > 0) {
							//鬼サイド攻撃
							if (d.getHp() > 0) {
								int partyRandom = new Random().nextInt(2);
								if (partyRandom == 0) {
									d.attack(p);
								} else {
									d.noAttack();
								}
							}
						} else {
							break;
						}
					}
				}
			}

		}
	}

}
