package character.demon;

import java.util.Random;

import character.BattleCharacter;
import character.party.PartyCharacter;
import main.Main;

public abstract  class DemonIsland extends BattleCharacter {

	public DemonIsland() {
		setName(getName());
		setHp(getHp());
	}

	public abstract void attack(PartyCharacter p);
	
	public void heal() {
		
		int heal = new Random().nextInt(100,200);
		setHp(getHp() + heal);
		Main.put("_________________ ＋_________________");
		Main.put("");
		Main.put("");
		Main.put(getName() + "は木の実を食べて " +heal +" 回復した！");
		Main.put(getName() +"のHPは" + getHp() +"になった");
		Main.put("");
		Main.put("");
		Main.put("_________________ ＋ _________________");
	}



	

}
