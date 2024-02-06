package character.party;

import character.BattleCharacter;
import item.Kibidango;
import item.Sword;

public class PeachBoy extends BattleCharacter {
	private String name;
	private int hp = 1000;
	public Sword sword;
	public Kibidango kibidango;
	
	
	
	public String getName() {
		return this.name + "太郎";
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return this.hp;
	}
	
	public void setName(int hp) {
		if (hp < 0) {
			this.hp = 0;}
		else{
			this.hp = hp;
		}
	}

	@Override
	public void attack() {
		
		
	}


	@Override
	public void heal() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
}
