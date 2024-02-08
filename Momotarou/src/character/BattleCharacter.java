package character;

import java.util.Scanner;

import main.Main;

public abstract class BattleCharacter extends Character {
	
	public BattleCharacter() {
		setName(getName());
	}
	//public abstract void attack() ;
	public abstract void heal() ;
	
	
	public void noAttack() {
		Main.put(getName() +"の攻撃は当たらなかった…");
		new Scanner(System.in).nextLine();
	}
	
	public void run() {
		System.out.println(getName() + "は逃げ出した！");
		
	}
	
	

}
