package character.party;

import java.util.Random;
import java.util.Scanner;

import character.BattleCharacter;
import character.demon.DemonIsland;

public abstract class PartyCharacter extends BattleCharacter {

	public PartyCharacter() {
		setName(getName());
		setHp(getHp());
	}

	public abstract void attack(DemonIsland demon);
	

	//きびだんごでの回復
	public void heal() {
		int random =new Random().nextInt(100,301);//100-300
		System.out.printf("【%sは、　%d　回復した！ 】\n",getName(),random);
		setHp(getHp() + random) ;
		new Scanner(System.in).nextLine();
	}

	//寝た時の回復
	public void sleepHeal() {
		int random =new Random().nextInt(300,800);
		System.out.printf("【%sは、　%d　回復した！ 】\n",getName(),random);
		setHp(getHp() + random) ;
		new Scanner(System.in).nextLine();
	}
}
