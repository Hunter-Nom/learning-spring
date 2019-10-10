package com.hunter.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void loop() {
		List<User> list = new ArrayList<User>();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.add(new User());
			System.out.println("add to list...");
		}
	}

	@Test
	public void init() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(">>>" + name);
		}

	}

	public void gcTest() {
		int[] nums = new int[] { 4, 3, 4, 7, 3, 8, 6, 7, 6 };
//		System.out.println(singleNumber(nums));
	}

	public static String toBinary(int num, int digits) {
		int value = 1 << digits | num;
		String bs = Integer.toBinaryString(value); // 0x20 | 这个是为了保证这个string长度是6位数
		return bs.substring(1);
	}

	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}
		return result;
	}

	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int res = 0;
		while (x > res) {
			res = res * 10 + x % 10;
			x = x / 10;
			// System.out.println(res+" "+x);
		}
		return (x == res || x == res / 10);
	}

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i : nums) {
			System.out.println(result + " " + i);
			result ^= i;

		}
		return result;
	}

}