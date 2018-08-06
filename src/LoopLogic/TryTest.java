package LoopLogic;

public class TryTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tryTe());
	}

	public static String tryTe() {
		try {
			System.out.println("try");
			return "tryh";
		}catch(Exception e) {
			
		}finally {
			System.out.println("finally");
			return "finalh";
		}
	}
}
