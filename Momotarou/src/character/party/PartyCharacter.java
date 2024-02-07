package character.party;

import java.util.Random;

import character.BattleCharacter;
import character.demon.DemonIsland;
import main.Main;

public abstract class PartyCharacter extends BattleCharacter {


	public abstract void attack(DemonIsland demon);
	

	//きびだんごでの回復
	public void heal() {
		int random =new Random().nextInt(200)+100;//100-300
		Main.put(this.name + "はきびだんごを食べて" + random + "回復した" );
		this.hp += random ;
	}

	//寝た時の回復
	public void sleepHeal() {
		int random =new Random().nextInt(500)+300;
		Main.put(this.name + "は"+ random +"回復した！");
		this.hp += random;
	}
}
