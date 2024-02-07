package character;

import main.Main;

public abstract class BattleCharacter extends Character {
	
	
	//public abstract void attack() ;
	public abstract void heal() ;
	
	
	public void noAttack() {
		Main.put(this.name +"の攻撃は当たらなかった…");
	}
	
	public void run() {
		System.out.println(this.name + "は逃げ出した！");
		
	}
	
	public void die() {
		Main.put(this.name +"は倒れた！");
	}

}
