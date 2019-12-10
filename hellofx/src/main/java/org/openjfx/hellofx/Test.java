package org.openjfx.hellofx;

import java.util.ArrayList;

public class Test {
	
	public static ArrayList<String> data;
	
	
	public Test(ArrayList<String> data) {
		this.data = data;
	}
	
	public static void getAll() {
		System.out.println(data);
	}
	
	public static void main(String[] args) {
		String str1 = "Hallo";
		String str2 = "Hallo";
		
		if (str1=="Hallo") 
			System.out.println("same");
		else
			System.out.println("wrong");
		
		ArrayList<String> ex = new ArrayList<String>();
		
		Test t = new Test(ex);
		ex.add("AA");
		ex.add("BB");
		t.getAll();
	}

}