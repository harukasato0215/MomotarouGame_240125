import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("【ももたろう】");
		
		System.out.println("あなたの名前は？");
		String name =scan.nextLine();
		
		Peachboy boy = new Peachboy(name);
		
		System.out.println(boy.name);
	}
	public static void put(String str) {
		System.out.println(str);
	}

}

