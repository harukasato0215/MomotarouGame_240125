package character.party;

import java.util.Random;
import java.util.Scanner;

import character.demon.DemonIsland;
import item.Kibidango;
import item.Sword;
import main.Main;

public class PeachBoy extends PartyCharacter {
	
	public Sword sword;
	public Kibidango kibidango;
	
	public PeachBoy() {
		setHp(3000);
	}
	
	public String getName() {
		return super.getName() + "太郎";
	}
	




	public void attack(DemonIsland demon) {
		int random =new Random().nextInt(600,801);//100-300
		Main.put(getName() + "は剣で攻撃した！");
		new Scanner(System.in).nextLine();
		System.out.printf("【　%sは、%sに　%d　のダメージを与えた！　】\n",getName(),demon.getName(),random );
		demon.setHp(demon.getHp() - random);
		new Scanner(System.in).nextLine();
		
		
	}
	public static void beBorn(String name,int hp) {
		Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
		Main.put("");
		System.out.printf("名前:　%S　[㏋:　%d]　が生まれた！\n ", name, hp);
		Main.put("");
		Main.put("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
		Main.put("");
	}

	


	


	
}
