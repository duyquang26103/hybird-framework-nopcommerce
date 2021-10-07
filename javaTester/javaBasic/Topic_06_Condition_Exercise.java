package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
	
	Scanner sc = new Scanner(System.in);
	
	//@Test
	public void TC_01() {
		
		int n = sc.nextInt();
		if(n%2 == 0) {
			System.out.println("This is odd number");
		}else {
			System.out.println("This is even number");
		}
			
	}
	
	//@Test
	public void TC_02() {
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a >= b) {
			System.out.println("a lớn hơn hoặc bằng b");
		}else {
			System.out.println("a nhỏ hơn hoặc bằng b");
		}
			
	}
	
	//@Test
	public void TC_03() {
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		if(a.equals(b)) {
			System.out.println("2 người cùng tên");
		}else {
			System.out.println("2 người khác tên");
		}
			
	}
	
	//@Test
	public void TC_04() {
	
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a >= b || a >= c) {
			System.out.println(a);
		}else if (b >= c){
			System.out.println(b);
		}else {
			System.out.println(c);
		}
	}
	
	//@Test
	public void TC_05() {
		int a = sc.nextInt();
		if(a > 10 && a < 100) {
			System.out.println("a nằm trong {10,100}");
		}else {
			System.out.println("a không nằm trong {10,100}");
		}
	}
	
	//@Test
	public void TC_06() {
		double a = sc.nextDouble();
		if(a >= 0 && a < 5) {
			System.out.println("Điểm D");
		}else if(a >= 5 && a < 7.5){
			System.out.println("Điểm C");
		}else if(a >= 7.5 && a < 8.5){
			System.out.println("Điểm B");
		}else if(a >= 8.5 && a <= 10){
			System.out.println("Điểm A");
		}
		
	}
	
	@Test
		public void TC_07() {
		int a = sc.nextInt();
			if(a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a == 12 ) {
				System.out.println("31");
			}else if(a ==2){
				System.out.println("28");
			}else {
				System.out.println("30");
			}
			
		}
	
}
