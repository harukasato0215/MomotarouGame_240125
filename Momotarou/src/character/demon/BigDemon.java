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
		p.setHp(getHp() - damage);
		Main.put("【" + getName() + "は" + damage + "のダメージ！】");

	}

	public void heal() {

		int heal = new Random().nextInt(300,401 );
		setHp(getHp() + heal);
		Main.put(getName() + "は木の実を食べて " + heal + " 回復した！");
	}

}
