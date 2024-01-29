
public abstract class BattleCharacter extends Character {
	String name;
	int hp;
	
	public abstract void attack() ;
	public void run() {
		System.out.println(this.name + "は逃げ出した！");
		
	}

}
