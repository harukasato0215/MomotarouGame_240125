package character.party;

import java.util.Random;
import java.util.Scanner;

import character.demon.DemonIsland;
import main.Main;

public class Bird extends PartyCharacter {

	public Bird() {
		setName("キジ");
		setHp(1700);
	}
	
	

	public void attack(DemonIsland demon) {
		int random =new Random().nextInt(400,601);
		Main.put(getName() + "は目をつついた！");
		new Scanner(System.in).nextLine();
		System.out.printf("【　%sは、%sに　%d　のダメージを与えた！　】\n",getName(),demon.getName(),random );
		demon.setHp(demon.getHp() - random);
		new Scanner(System.in).nextLine();
		
	}



}
