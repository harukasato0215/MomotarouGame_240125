package character.party;

import java.util.Random;
import java.util.Scanner;

import character.demon.DemonIsland;
import main.Main;

public class Dog extends PartyCharacter{
	
	
	public Dog() {
		setName("イヌ");
		setHp(2000);
	}
	
	public void attack(DemonIsland demon) {
		int random =new Random().nextInt(300,501);
		Main.put(getName() + "はすねをかじった！");
		new Scanner(System.in).nextLine();
		System.out.printf("【　%sは、%sに　%d　のダメージを与えた！　】\n",getName(),demon.getName(),random );
		demon.setHp(demon.getHp() - random);
		new Scanner(System.in).nextLine();
		
	}

}
