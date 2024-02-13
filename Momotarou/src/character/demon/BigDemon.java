package character.demon;

import java.util.Random;
import java.util.Scanner;

import character.party.PartyCharacter;
import main.Main;

public class BigDemon extends DemonIsland {

	public BigDemon() {
		setName("ボス鬼");
		setHp(5000);
	}

	public void attack(PartyCharacter p) {
		Main.put(getName() + "は雷ビームをだしてきた！");
		new Scanner(System.in).nextLine();
		int damage = new Random().nextInt(300, 901);
		p.setHp(p.getHp() - damage);
		System.out.printf("【　%sは、　%d　のダメージを受けた！　】\n",p.getName(),damage );
		new Scanner(System.in).nextLine();
	}

	public void heal() {

		int heal = new Random().nextInt(300,901 );
		setHp(getHp() + heal);
		Main.put("_________________ ＋_________________");
		Main.put("");
		Main.put("");
		Main.put(getName() + "は雷をあびて " + heal + " 回復した！");
		Main.put(getName() +"のHPは" + getHp() +"になった");
		Main.put("");
		Main.put("");
		Main.put("_________________ ＋ _________________");
	}

}
