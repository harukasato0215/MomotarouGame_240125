package character;

import main.Main;

public abstract class Character  {
	public String name;
	public int hp;
	
	public void talk(String comment) {
		Main.put(this.name + comment);
	}
}
