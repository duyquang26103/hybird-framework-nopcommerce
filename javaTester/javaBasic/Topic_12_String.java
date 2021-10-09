package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String {

	Scanner sc = new Scanner(System.in);

	// @Test
	public void TC_01() {
		String a = sc.next();
		char[] results = a.toCharArray();
		int count = 0;
		for (char c : results) {
			if (c >= 'A' && c <= 'Z') {
				count++;
			}
		}
		System.out.println(count);
	}

	//@Test
	public void TC_02() {
		String course = "Automation Testing 345 Tutorials Online 789";
		String[] courses = course.split("");
		int count = 0;
		for (String c : courses) {
			if (c.equals("a") || c.equals("A")) {
				count++;
			}
		}
		System.out.println(count);

		System.out.println("Kiểm tra chuỗi có bao gồm Testing: " + course.contains("Testing"));
		System.out.println("Kiểm tra chuỗi bắt đầu bằng Automation: " + course.startsWith("Automation"));
		System.out.println("Vị trí của Tutorials: " + course.indexOf("Tutorials"));
		System.out.println("Thay thế online => offline: " + course.replaceAll("Online", "Offlne"));
		char[] courseChar = course.toCharArray();
		int countNum = 0;
		for (char c : courseChar) {
			if (c >= '0'&& c <= '9') {
				countNum++;
			}
		}System.out.println(countNum);
	}
	
	@Test
	public void TC_03() {
		String a = sc.nextLine();
		char a1[] = a.toCharArray();
		for(int i = a.length()-1; i>= 0; i--){
			System.out.println(a1[i]);
		}
		
	}
	
	

}
