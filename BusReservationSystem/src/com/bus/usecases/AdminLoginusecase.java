package com.bus.usecases;

import java.util.Scanner;

import com.bus.custom.ConsoleColors;
import com.bus.dao.AdminDao;
import com.bus.dao.AdminDaoImpl;

public class AdminLoginusecase {

	public static boolean AdminLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username" );
		String username = sc.next();
		
		System.out.println( "Enter password" );
		String password = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		boolean result =  dao.adminLogin(username, password);
		
		if (result){
			System.out.println( result);
			return true;
		}
		else {
			System.out.println( result);
			return false;
		}

	}

}
