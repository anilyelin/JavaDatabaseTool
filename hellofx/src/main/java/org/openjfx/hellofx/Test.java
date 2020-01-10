package org.openjfx.hellofx;

import java.util.ArrayList;

import filehandling.CsvReader;

public class Test {
	
	public static ArrayList<String> data;
	
	public Test(ArrayList<String> data) {
		this.data = data;
	}
	
	public static void getAll() {
		System.out.println(data);
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<String> ex = new ArrayList<String>();
		
		Test t = new Test(ex);
		ex.add("AA");
		ex.add("BB");
		t.getAll();
	}

}