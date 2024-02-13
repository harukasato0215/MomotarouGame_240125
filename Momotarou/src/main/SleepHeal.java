package main;

import java.util.ArrayList;
import java.util.Scanner;

import character.party.PartyCharacter;

public class SleepHeal {
	
	public static void sleep(ArrayList<PartyCharacter> partyMember) {
		Scanner scan = new Scanner(System.in);
	
	Main.put("道を歩いているといつの間にか夜になった。");
		scan.nextLine();
		Main.put("眠くなってきたので、今日はゆっくり休むことにしよう。");
		scan.nextLine();
		//（いるキャラクター全てヒール）
		for (int i = 0; i < partyMember.size(); i++) {
			partyMember.get(i).sleepHeal();

			
	}
	}
}
