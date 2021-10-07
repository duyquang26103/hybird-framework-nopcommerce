package javaBasic;

public class Topic_03_Data_Type {
	static int a = 6;
	static int b = 2;
	
	static float a1 = 7.5f;
	static float a2 = 3.8f;
	
	static String name = "Automation Testing";
	public static void main(String[] args) {
		int sum = a +b;
		int sub = a -b;
		int ex = a*b;
		int de = a /b;
		System.out.println("a + b = " + sum);
		System.out.println("a + b = " + sub);
		System.out.println("a + b = " + ex);
		System.out.println("a + b = " + de);
		
		float area = a1*a2;
		System.out.println("area = " + area);
		
		System.out.println("Hello! " + name);

	}
}
