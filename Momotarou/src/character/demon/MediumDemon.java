package character.demon;

import java.util.Random;
import java.util.Scanner;

import character.party.PartyCharacter;
import main.Main;

public class MediumDemon  extends DemonIsland{

	public MediumDemon() {
		setName("鬼");
		int hp = new Random().nextInt(2000,3001);
		setHp(hp);
	}

	
	
	public void attack(PartyCharacter p) {
		Main.put(getName() + "は石を投げてきた！");
		new Scanner(System.in).nextLine();
		int damage = new Random().nextInt(200,701);
		p.setHp(getHp() - damage);
		Main.put("【" + getName() + "は" + damage +"のダメージ！】");
	
	}

}
