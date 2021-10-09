package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While {
	Scanner sc = new Scanner(System.in);

	// @Test
	public void TC_01() {
		int a = sc.nextInt();

		while (a <= 100) {
			if (a % 2 == 0) {
				System.out.println(a);
			}
			a++;
		}

	}

	// @Test
	public void TC_02() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		while (a < b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	// @Test
	public void TC_03() {
		int a = sc.nextInt();
		int sum = 0;
		int i = 0;
		while (i <= a) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
	}

	// @Test
	public void TC_04() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		while (a < b) {
			if (a % 3 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	// @Test
	public void TC_05() {
		int a = sc.nextInt();
		int sum = 1;
		int i = 1;
		while (i <= a) {
			sum *= i;
			i++;
		}
		System.out.println(sum);
	}

	@Test
	public void TC_06() {
		int a = 1;
		int b = 10;
		int sum = 0;
		while (a <= b) {
			if (a % 2 == 0) {
				sum += a;
			}
			a++;
		}
		System.out.println(sum);

	}
}
