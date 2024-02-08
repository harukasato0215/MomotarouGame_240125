package character.party;

import java.util.Random;
import java.util.Scanner;

import character.demon.DemonIsland;
import main.Main;

public class Monkey extends PartyCharacter{
	
	
	public Monkey() {
		setName("サル");
		setHp(2200);
	}
	
	public void attack(DemonIsland demon) {
		int random =new Random().nextInt(100,301);
		Main.put(getName() + "は顔をひっかいた！");
		new Scanner(System.in).nextLine();
		System.out.printf("【　%sは、%sに　%d　のダメージを与えた！　】\n",getName(),demon.getName(),random );
		demon.setHp(demon.getHp() - random);
		new Scanner(System.in).nextLine();
		
	}


}
