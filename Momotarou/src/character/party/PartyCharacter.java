package character.party;

import java.util.Random;
import java.util.Scanner;

import character.BattleCharacter;
import character.demon.DemonIsland;
import main.Main;

public abstract class PartyCharacter extends BattleCharacter {

	public PartyCharacter() {
		
	}

	public abstract void attack(DemonIsland demon);
	

	//きびだんごでの回復
	public void heal() {
		int random =new Random().nextInt(100,301);//100-300
		Main.put("_________________ ʚ♡ɞ _________________");
		Main.put("");
		Main.put("");
		System.out.printf("【%sは、　%d　回復した！ 】\n",getName(),random);
		Main.put("");
		Main.put("");
		Main.put("_________________ ʚ♡ɞ _________________");
		setHp(getHp() + random) ;
		new Scanner(System.in).nextLine();
	}

	//寝た時の回復
	public void sleepHeal() {
		int random =new Random().nextInt(300,800);
		Main.put("_________________ ʚ♡ɞ _________________");
		Main.put("");
		Main.put("");
		System.out.printf("【%sは、　%d　回復した！ 】\n",getName(),random);
		Main.put("");
		Main.put("");
		Main.put("_________________ ʚ♡ɞ _________________");
		setHp(getHp() + random) ;
		new Scanner(System.in).nextLine();
	}
}
