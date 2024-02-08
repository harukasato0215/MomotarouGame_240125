package character.party;

import java.util.Random;

import character.BattleCharacter;
import character.demon.DemonIsland;
import main.Main;

public abstract class PartyCharacter extends BattleCharacter {

	public PartyCharacter() {
		setName(getName());
		setHp(getHp());
	}

	public abstract void attack(DemonIsland demon);
	

	//きびだんごでの回復
	public void heal() {
		int random =new Random().nextInt(100,301);//100-300
		Main.put(getName() + "はきびだんごを食べて " + random + " 回復した" );
		setHp(getHp() + random) ;
	}

	//寝た時の回復
	public void sleepHeal() {
		int random =new Random().nextInt(300,800);
		Main.put(getName() + "は"+ random +"回復した！");
		setHp(getHp() + random) ;
	}
}
