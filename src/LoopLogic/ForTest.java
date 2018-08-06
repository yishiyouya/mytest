package LoopLogic;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ifConElse();
	}

	public static void ifConElse() {
		int a = 10;
		if(a > 1) {
			System.out.println("a > 1");
		}else if(a > 2) {
			System.out.println("a > 2");
		}
	}
	
	public static void forContinue() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(j > 1) {
					continue;
				}
				System.out.println(i+"\t"+j);
			}
		}
	}
}
