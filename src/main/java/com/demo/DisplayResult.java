package com.demo;

public class DisplayResult {
	public void displayAnswer() {
//		FindSum findSum = new FindSum();
		int ans = FindSum.findSum(12, 13);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		DisplayResult d = new DisplayResult();
		d.displayAnswer();

	}

}
