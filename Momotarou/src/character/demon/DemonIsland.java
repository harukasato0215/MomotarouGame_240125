package character.demon;

import character.BattleCharacter;
import main.Main;

public abstract  class DemonIsland extends BattleCharacter {


	public void heal() {
		Main.put(this.name + "はポケットに入っていた木の実を食べた！");
		this.hp += 150;
		
	}



	

}
