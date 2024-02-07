package character;

import main.Main;

public abstract class Character  {
	private String name;
	private int hp;
	
	public void talk(String comment) {
		Main.put(this.name + comment);
	}
}
