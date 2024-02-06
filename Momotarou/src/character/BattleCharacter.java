package character;

public abstract class BattleCharacter extends Character {
	
	
	public abstract void attack() ;
	public abstract void heal() ;
	
	public void run() {
		System.out.println(this.name + "は逃げ出した！");
		
	}

}
