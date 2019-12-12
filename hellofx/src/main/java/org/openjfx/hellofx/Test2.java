package org.openjfx.hellofx;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test2 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<String> dat = new ArrayList<String>();
		Test.getAll();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println(timeStamp);
		
		
	}

}