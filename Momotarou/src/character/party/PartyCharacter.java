package character.party;

import character.BattleCharacter;
import main.Main;

public abstract class PartyCharacter extends BattleCharacter {

	@Override
	public abstract void attack();

	@Override
	public void heal() {
		Main.put(this.name + "はきびだんごを食べて100回復した" );
		this.hp += 100;
	}

	public void sleepHeal() {
		int randomHeal =new java.util.Random().nextInt();
		Main.put(this.name + "は"+ randomHeal +"回復した！");
		this.hp += randomHeal;
	}
}
