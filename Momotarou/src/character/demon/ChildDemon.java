package character.demon;

import java.util.Random;
import java.util.Scanner;

import character.party.PartyCharacter;

public class ChildDemon extends DemonIsland{

	public ChildDemon() {
		setName("小鬼");
		int hp = new Random().nextInt(3000,5001);//（）内は以上、未満
		setHp(hp);
	}
	

	public void attack(PartyCharacter p) {
		System.out.printf("%sは、%sに石を投げてきた！\n",getName(),p.getName());
		new Scanner(System.in).nextLine();
		int damage = new Random().nextInt(100,451);
		p.setHp(getHp() - damage);
		System.out.printf("【　%sは、　%d　のダメージを受けた！　】",p.getName(),damage );
		new Scanner(System.in).nextLine();
	}

}
