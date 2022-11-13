package com.bus.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bus.bean.Customer;
import com.bus.custom.ConsoleColors;
import com.bus.dao.AdminDao;
import com.bus.dao.AdminDaoImpl;
import com.bus.usecases.AddBus2usecase;
import com.bus.usecases.AdminLoginusecase;
import com.bus.usecases.BookTicketbNameusecase;
import com.bus.usecases.CancelTicketbNameusecase;
import com.bus.usecases.CreteAdmin;
import com.bus.usecases.CusLoginusecase;
import com.bus.usecases.CusSignUp2usecase;
import com.bus.usecases.UpdateStatususecase;
import com.bus.usecases.ViewAllTicketsusecase;
import com.bus.usecases.ViewTicketusecase;
import com.bus.usecases.showallBus;

public class main2 {
	static void AdminOrCustomer() {
		System.out.println(                          "+-----------------------------+" + "\n"+
						 						     "| 1. Login As Administrator.  |" + "\n"
						 						   + "| 2. Login As Customer        |" + "\n"
						 						   + "| 3. Exit                     |" + "\n"+
						 						     "+-----------------------------+" + "\n"
						 						  );
		choice();
	}
	
	static void choice() {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED + "Input type should be number" + ConsoleColors.RESET);
			AdminOrCustomer();
		}
		
		if (choice == 1) {
			System.out.println(ConsoleColors.DARK_BLUE + "Welcome Admin ! Please Login to your account" + ConsoleColors.RESET);
			System.out.println("+---------------------------+" );
			System.out.println("| 1. To Login as Admin      |");
			System.out.println("| 2. To create Admin Acount |");
			System.out.println("| 3. To  Back Menu          |");
			System.out.println("+---------------------------+" + "\n");

			int adminNo = sc.nextInt();
			if(adminNo == 1) {
			
			AdminLogin();
			}else if(adminNo ==2 ) {
               
				CreateAdmin();
				
			}else if(adminNo==3) {
				AdminOrCustomer();
			}
		}
		else if (choice == 2) {
			System.out.println(ConsoleColors.DARK_BLUE + "Welcome Customer !" + ConsoleColors.RESET);
			customerLoginOrSignup();
		}
		else if (choice == 3) {
			System.out.println(ConsoleColors.ROSY_PINK + "Thank you ! Visit again" + ConsoleColors.RESET);
			System.exit(0);
		}
		else {
			System.out.println(ConsoleColors.RED + "Please choose a number from below options" + ConsoleColors.RESET);
			AdminOrCustomer();
		}
	}
	static void CreateAdmin() {
		boolean flag = CreteAdmin.createAdmin();
		if(flag == false) {
			CreateAdmin();
		}else {
			AdminLogin();
		}
	}
	
	static void AdminLogin() {
		
		Boolean result = AdminLoginusecase.AdminLogin();

		if (result) adminMethods(); 
		else {
			AdminLogin();
		}
	}
	
	static void adminMethods() {
		System.out.println(
				           "+--------------------------------+" + "\n"+
						   "| Welcome Admin                  " + "\n"
						 + "| 1. Add Bus                     |" + "\n"
						 + "| 2. Confirm Tickets of Customer |" + "\n"
						 + "| 3. View All Bookings           |" + "\n"
						 + "| 4. Back                        |" + "\n"
						 + "| 5. Exit                        |" + "\n"
						 + "+--------------------------------+" );
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println(ConsoleColors.RED + "Please choose a number from below options" + ConsoleColors.RESET);
				adminMethods();
			}
			else adminChoice(choice);
		}
		catch (InputMismatchException e) {
			
			System.out.println(ConsoleColors.RED + "Input type should be number" + ConsoleColors.RESET);
			adminMethods();
		}
	}
	
	static void adminChoice(int choice) {
		
			switch(choice) {
				case 1 : {
					AddBus2usecase.AddBus();
					adminMethods();
				}
				break;
				case 2 : {
					UpdateStatususecase.updateStatus();
					adminMethods();
				}
				break;
				case 3 : {
					ViewAllTicketsusecase.viewAllTicket();
					adminMethods();
				}
				break;
				case 4 : AdminOrCustomer();
				break;	
				case 5 : {
					System.out.println(ConsoleColors.ROSY_PINK + "Thank you ! Visit again" + ConsoleColors.RESET);
					System.exit(0);
				}
			}
	}
	
	static void customerLoginOrSignup() {
		System.out.println( "+--------------------------------+" + "\n"
				                                + "| 1. Login to your Account       |" + "\n"
				                                + "| 2. Don't have Account? Sign Up |" + "\n"
				                                + "| 3. Back                        |" + "\n"
				                                + "| 4. Exit                        |" + "\n"
				                                + "+--------------------------------+" + ConsoleColors.RESET);
		try {
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			if (choice == 1) {
				customerLogin();
			}
			else if (choice == 2) {
				customerSignup();
			}
			else if (choice == 3) {
				AdminOrCustomer();
			}
			else if (choice == 4) {
				System.out.println(ConsoleColors.BLACK + "Thank you ! Visit again" + ConsoleColors.RESET);
				System.exit(0);
			}
			else {
				System.out.println(ConsoleColors.RED + "Please choose a number from below options" + ConsoleColors.RESET );
				customerLoginOrSignup();
			}
		}
		catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED + "Input type should be number" + ConsoleColors.RESET);
			customerLoginOrSignup();
		}
		
	}
	
	static void customerLogin() {
		Customer customer = CusLoginusecase.CusLogin();
		
		if (customer == null) {
			customerLogin();
		}
		else {
			System.out.println(ConsoleColors.GREEN_BACKGROUND + "Login Successfull" + ConsoleColors.RESET);
			customerMethods(customer);
		}
		
	}
	
	static void customerSignup() {
		boolean flag = CusSignUp2usecase.cusSignUp();
		
		if (flag) {
			System.out.println(ConsoleColors.BLACK + "Login to your Account" + ConsoleColors.RESET);
			customerLogin();
		}
		else {
			customerSignup();
		}
	}
	
	static void customerMethods(Customer customer) {
		System.out.println(ConsoleColors.BLACK + "+--------------------------------+" + "\n"
				 		 + "| 1. Book Bus Ticket             |" + "\n"
				         + "| 2. Cancel Bus Ticket           |" + "\n"
				         + "| 3. View Status of your Tickets |" + "\n"
				         + "| 4. View Bus Details            |" + "\n"
				         + "| 5. Back                        |" + "\n"
				         + "| 6. Exit                        |" + "\n"
				         + "+--------------------------------+" + ConsoleColors.RESET);
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println(ConsoleColors.RED + "Please choose a number from below options" + ConsoleColors.RESET);
				customerMethods(customer);
			}
			else customerChoice(choice, customer);
		}
		catch (InputMismatchException e) {
			
			System.out.println(ConsoleColors.RED + "Input type should be number" + ConsoleColors.RESET);
			customerMethods(customer);
		}
	}
	
	static void customerChoice(int choice, Customer customer) {
		switch(choice) {
		case 1 : {
			BookTicketbNameusecase.BookTicketbName(customer);
			customerMethods(customer);
		}
		break;
		case 2 : {
			CancelTicketbNameusecase.cancelTicket(customer);
			customerMethods(customer);
		}
		break;
		case 3 : {
			ViewTicketusecase.viewTicket(customer);
			customerMethods(customer);
		}
		break;
		case 4 : {
			showallBus.showBuDetails();
			customerMethods(customer);
		}
		case 5 : {
			customerLoginOrSignup();
		}
		case 6 : {
			System.out.println(ConsoleColors.BLACK + "Thank you ! Visit again" + ConsoleColors.RESET);
			System.exit(0);
		}
	}
	}
	

	public static void main(String[] args) {
		
		AdminOrCustomer();
				
	}	

}