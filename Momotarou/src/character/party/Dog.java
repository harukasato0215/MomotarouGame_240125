package character.party;

import java.util.Random;

import character.demon.DemonIsland;
import main.Main;

public class Dog extends PartyCharacter{
	private String name ="イヌ";
	private int hp =2000;


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
	@Override
	public void attack(DemonIsland demon) {
		int random =new Random().nextInt(200)+400;//100-300
		Main.put(this.name + "はすねをかじった！");
		//スペースきー
		Main.put("【" + random  +"のダメージ！】");
		//てきのダメージをかく
	}

}
