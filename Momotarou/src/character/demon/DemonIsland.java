package character.demon;

import java.util.Random;

import character.BattleCharacter;
import main.Main;

public abstract  class DemonIsland extends BattleCharacter {

	public DemonIsland() {
		setName(getName());
		setHp(getHp());
	}

	public void heal() {
		
		int heal = new Random().nextInt(100,200);
		setHp(getHp() + heal);
		Main.put(getName() + "は木の実を食べて " +heal +" 回復した！");
	}



	

}
