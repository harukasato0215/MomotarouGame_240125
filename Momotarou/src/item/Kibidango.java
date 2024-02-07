package item;

import main.Main;

public class Kibidango {
	String name = "きびだんご";
	int heal;
	private int num =0;//きびだんごの個数
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num <= 0) {
			Main.put("もうきびだんごは残っていない…");
		}else {
			this.num = num;
		}
	}
}
