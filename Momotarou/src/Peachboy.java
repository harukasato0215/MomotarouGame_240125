
public class Peachboy extends Character {
	private String name;
	private int hp = 1000;
	Sword sword;
	Kibidango kibidango;
	
	
	
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

	
}
