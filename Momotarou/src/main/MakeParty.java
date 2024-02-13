package main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import character.party.PartyCharacter;
import character.party.PeachBoy;
import item.Kibidango;

public class MakeParty {
	public static void negotiate(ArrayList<PartyCharacter> partyMember, PartyCharacter[] animals, int animalCount,
			PeachBoy boy, Kibidango k) {
		Scanner scan = new Scanner(System.in);
		Main.put("道を歩いていると" + animals[animalCount].getName() + "が現れた！");
		scan.nextLine();
		Main.put(animals[animalCount].getName() + "「桃太郎さん、どこへ行くのですか？」");
		scan.nextLine();
		boy.talk("「鬼ヶ島へ、鬼退治に行くんだ」");
		scan.nextLine();
		Main.put(animals[animalCount].getName() + "「それでは、お腰に付けたきび団子を１つ下さいな。"
				+ "おともしますよ」");
		scan.nextLine();
		Main.put(animals[animalCount].getName() + "にきびだんごをあげる？（残り" + k.getNum() + "個）");
		Main.ans();
		int select = scan.nextInt();
		if (select == 1) {//きびだんごをあげる
			if (k.getNum() <= 0) {//きびだんごなくなってた
				Main.put("仲間にしたかったがきびだんごがなかった…");
				Main.put("悲しそうな顔をして" + animals[animalCount].getName() + "は去っていった…");
			} else {
				Main.put(animals[animalCount].getName() + "にきびだんごをあげた！");

				scan.nextLine();
				k.setNum(k.getNum() - 1);
				Main.put("✦••┈┈┈••┈┈┈••┈┈┈••✦★✦••┈┈┈••┈┈┈••┈┈┈••✦");
				Main.put("");
				Main.put("");
				System.out.printf("名前:　%S　[㏋:　%d]　が仲間になった！\n ",
						animals[animalCount].getName(), animals[animalCount].getHp());
				Main.put("");
				Main.put("");
				Main.put("✦••┈┈┈••┈┈┈••┈┈┈••✦★✦••┈┈┈••┈┈┈••┈┈┈••✦");
				Main.put("");

				//仲間になったコード
				partyMember.add(animals[animalCount]);

				//ファイルに追加
				String partyPath = "Party.csv";
				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(partyPath), "UTF-8"))) {
					for (int i = 0; i < partyMember.size(); i++) {
						bw.write((i + 1) + "：" + partyMember.get(i).getName() +
								",　HP：" + partyMember.get(i).getHp() + "\n");
					}

				} catch (

				IOException e) {
					e.printStackTrace();

				}
			}
		} else {//仲間スキップ
			Main.put("悲しそうな顔をして" + animals[animalCount].getName() + "は去っていった…");

		}

	}

}
