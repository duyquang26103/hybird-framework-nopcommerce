package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Swich_Case {
	Scanner sc = new Scanner(System.in);

	// @Test
	public void TC_01() {
		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		}

	}

	// @Test
	public void TC_02() {
		String suba = sc.next();
		int a = sc.nextInt();
		int b = sc.nextInt();

		switch (suba) {
		case "+":
			System.out.println(a + b);
			break;
		case "-":
			System.out.println(a - b);
			break;
		case "*":
			System.out.println(a * b);
			break;
		case "/":
			System.out.println(a / b);
			break;
		case "%":
			System.out.println(a % b);
			break;

		}
	}
	@Test
	public void TC_03() {
		int a = sc.nextInt();
		switch (a) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30");
			break;
		case 2:
			System.out.println("28");
			break;

		}
	}

}
