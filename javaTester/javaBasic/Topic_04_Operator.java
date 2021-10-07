package javaBasic;

import java.util.Scanner;

public class Topic_04_Operator {
	
	static String name = "Nguyen Thi Luom";
	static int old = 15;
	
	
	public void trans() {
		
	}
	public static void main(String[] args) {
		int oldafter = old + 15;
		System.out.println("After 15 years, age of " + name +" will be " + oldafter);
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = a;
		a = b;
		b = c;
		System.out.println(a);
		System.out.println(b);
		
		int a1 = sc.nextInt();
		int b2 = sc.nextInt();
		if(a1 > b2) {
			System.out.println("true");
		}else
			System.out.println("false");

	}

}
