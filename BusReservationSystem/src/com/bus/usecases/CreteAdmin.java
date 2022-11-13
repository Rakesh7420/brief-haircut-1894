package com.bus.usecases;

import java.util.Scanner;

import com.bus.dao.AdminDao;
import com.bus.dao.AdminDaoImpl;

public class CreteAdmin {

	public static boolean createAdmin() {
		Scanner sc = new Scanner(System.in);
		boolean flag= false;
		
		System.out.println("Enter Password to create Admin ");
		int pass = sc.nextInt();
		
		if( pass == 1234) {
			
			AdminDao dao  = new AdminDaoImpl();
			System.out.println("Enter Username");
			String username = sc.next();
			
			System.out.println("Enter password");
			String password = sc.next();
        String ans =	 dao.createAdmin(username, password);
        if( ans == "Successful") {
        	flag = true;
        }
		}
		
		return flag;
	}
	
}
