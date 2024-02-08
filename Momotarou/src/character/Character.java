package character;

import main.Main;

public abstract class Character  {
	private String name;
	private int hp;
	
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
			Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
			Main.put(this.name + "は倒れた！");
			Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
		}
		
		else{
			this.hp = hp;
		}
	}
	
	public void talk(String comment) {
		Main.put(getName() + comment);
	}
}
