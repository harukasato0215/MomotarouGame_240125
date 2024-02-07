package character.party;

import java.util.Random;

import character.demon.DemonIsland;
import item.Kibidango;
import item.Sword;
import main.Main;

public class PeachBoy extends PartyCharacter {
	private String name;
	private int hp = 3000;
	public Sword sword;
	public Kibidango kibidango;
	
	
	
	public String getName() {
		return this.name + "太郎";
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


	public void attack(DemonIsland demon) {
		int random =new Random().nextInt(200)+600;//100-300
		Main.put(this.name + "は剣で攻撃した！");
		//スペースきー
		Main.put("【"+ random  +"のダメージ！】");
		//てきのダメージをかく
		
	}

	


	


	
}
