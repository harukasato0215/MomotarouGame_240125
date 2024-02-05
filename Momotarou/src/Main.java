import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Peachboy boy = new Peachboy();
		Oldman man =new Oldman();
		Oldwoman woman = new Oldwoman();
		childDemon child = new childDemon();

		put("【ももたろう】");
		scan.nextLine();
		prologue();

		while (true) {
			put("あなたの名前は？>>");
			String name = scan.next();
			boy.setName(name);

			put(boy.getName() + "ですね？");
			put("1:はい　2:いいえ");
			int select = scan.nextInt();
			if (select == 1) {
				break;
			}
		}
		String boyName = boy.getName();
		
		middleStory(boyName);
		
		scan.nextLine();
		put(woman.name + "「それなら、きびだんごを用意してあげよう！」");
		scan.nextLine();
		put(woman.name + "「これを食べると体力が回復するし、動物と仲良くなれるよ！」");
		scan.nextLine();
		put("【きびだんごをゲットした！】");
		//きびだんごをもった桃太郎
		Kibidango k =new Kibidango();
		boy.kibidango = k;
		
		scan.nextLine();
		put(man.name +"「この剣も持っていきなさい！これで鬼と戦うんだ！」");
		scan.nextLine();
		put("【剣をゲットした！】");
		//剣をもった桃太郎
		Sword s = new Sword();
		boy.sword = s;
		scan.nextLine();
		
		put(boyName +"「"  +man.name + woman.name +"ありがとう！行ってきます！」");
		scan.nextLine();
		put("・・・");
		scan.nextLine();
		
		//冒険開始
		while(true) {
		put("歩いていると道が分かれた。どの道を通る？");
		put("【1.右側の道　2.真ん中の道　3.左側の道】>>");
		int adventureSelect =scan.nextInt();
		int randomAdventure = new Random().nextInt(3);
		int getCount =0;
		switch(randomAdventure) {
		case 0 ://仲間ゲット
			String[] animalNames = {"サル","",""}; 
			switch(getCount) {
			case 0:
			put("道を歩いていると" +  +"が現れた！");
				
			}
			
			break;
		case 1 ://敵と戦う
			put("道を歩いていると" +child.name  +"が現れた！");
			scan.nextLine();
			put("どうする？");
			put("【1.戦う　2.回復する　3.逃げる】>>");
			
			
			
			break;
		case 2 ://寝る
			put("道を歩いているといつの間にか夜になった。");
			scan.nextLine();
			put("眠くなってきたので、今日は寝るとしよう。");
			//（いるキャラクター全てヒール）
			//【？？は？？hp回復した】 後で入力
			break;
				
		}
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	
	public static void put(String str) {
		System.out.println(str);
	}

	public static void prologue() {
		Scanner scan = new Scanner(System.in);
		put("昔々、ある老夫婦のおうちにとても大きなモモが届きました。");
		scan.nextLine();
		put("早速割ってみると中には元気な赤ちゃんがいました。");
		scan.nextLine();

	}
	
	
	public static void middleStory(String boyName) {
		Scanner scan = new Scanner(System.in);
		
		put("おばあさんとおじいさんは" + boyName +"を大切に育ててくれました。");
		scan.nextLine();
		put("・・・");
		scan.nextLine();
		put("そんなある日、おうちにボロボロになった村人たちがやってきました。");
		scan.nextLine();
		put("村人「たくさんの鬼が来て暴れているんだ！助けて；；」");
		scan.nextLine();
		put(boyName + "「ぼく、鬼ヶ島へ行って、わるい鬼を退治します」");
		scan.nextLine();
		
	}
}
