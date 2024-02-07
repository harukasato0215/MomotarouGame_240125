package character.demon;

import main.Main;

public class MediumDemon  extends DemonIsland{


	public String getName() {
		return this.name ;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		if (hp < 0) {
			this.hp = 0;
			Main.put(this.name + "は倒れた！");}
		else{
			this.hp = hp;
		}
	}
	
	
	public void attack() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void heal() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
