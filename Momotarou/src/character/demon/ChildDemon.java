package character.demon;

import main.Main;

public class ChildDemon extends DemonIsland{

	private String name = "小鬼";
	private int hp = 800;
	
	public String getName() {
		return this.name ;
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
	
		
	}




	@Override
	public void heal() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
