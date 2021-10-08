package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
	Scanner sc = new Scanner(System.in);

	// @Test
	public void TC_01() {
		int a = sc.nextInt();
		for (int i = 1; i <= a; i++)
			System.out.println(i + " ");
	}

	// @Test
	public void TC_02() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = a; i <= b; i++) {
			System.out.println(i + " ");
		}
	}

	// @Test
	public void TC_03() {
		for (int i = 1; i <= 10; i++)
			if (i % 2 == 0) {
				System.out.println(i + " ");
			}
	}

	// @Test
	public void TC_04() {
		int sum = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = a; i <= b; i++) {
			sum = sum + i;

		}
		System.out.println(sum);
	}

	// @Test
	public void TC_05() {
		int sum = 0;
		int a = sc.nextInt();
		for (int i = 0; i <= a; i++) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}

	// @Test
	public void TC_06() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}

	}

	@Test
	public void TC_07() {
		int sum = 1;
		int a = sc.nextInt();
		for (int i = 1; i <= a; i++) {
			sum = sum * i;
		}
		System.out.println(sum);
	}
}
