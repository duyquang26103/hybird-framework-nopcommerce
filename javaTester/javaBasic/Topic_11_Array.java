package javaBasic;


import java.util.Scanner;

import org.testng.annotations.Test;


public class Topic_11_Array {
	String name;
	int age;
	int score;

	public Topic_11_Array(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public void display() {
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("Score " + score);
		System.out.println("----------------");
	}

	Scanner sc = new Scanner(System.in);

	// @Test
	public void TC_01() {
		int[] arr = { 2, 7, 6, 8, 9 };
		int bigNum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < arr[i]) {
				bigNum = arr[i];
			}
		}
		System.out.println(bigNum);

	}

	// @Test
	public void TC_02() {
		int[] arr = { 2, 7, 6, 8, 9 };
		int sum = 0;

		sum = arr[0] + arr[arr.length - 1];

		System.out.println(sum);
	}

	// @Test
	public void TC_03() {
		int[] arr = { 2, 7, 6, 8, 9, 16, 17, 20 };
		for (int i : arr) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	// @Test
	public void TC_04() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int sum = 0;
		for (int i : arr) {
			if (i > 0 && i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	 //@Test
	public void TC_05() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };
		for (int i : arr) {
			if (i >= 0 && i <= 10) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void TC_06() {
		int[] arr = { 3, 7, 30, 5, 10, 8, -5, 10, 5 };
		float sum = 0;
		for (int i : arr) {
			sum += i;
		}
		System.out.println("Sum = " + sum);
		System.out.println("Average =" + sum / (arr.length));
	}


	public static void main(String[] args) {
		Topic_11_Array[] student = new Topic_11_Array[3];
		student[0] = new Topic_11_Array("Quang",24,100);
		student[1] = new Topic_11_Array("Huy",24,47);
		student[2] = new Topic_11_Array("Thuan",24,97);
		for(int i = 0;i <3;i++) {
			student[i].display();
		}
	}

}
