package com.bus.usecases;

import java.util.Scanner;

import com.bus.bean.Customer;
import com.bus.custom.ConsoleColors;
import com.bus.dao.CustomerDao;
import com.bus.dao.CustomerDaoImpl;
import com.bus.exceptions.BusException;

public class CancelTicketbNameusecase {
	
	public  static void cancelTicket(Customer customer) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE + "Enter Bus Name" + ConsoleColors.RESET);
		String bName = sc.nextLine();
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			
			int cusId = customer.getCusId();
			String message = dao.cancelTicket(bName, cusId);
			
			if (message.equals("Ticket cancelled Successfully")) {
				System.out.println( message );
			}
			else {
				System.out.println( message);
			}
			
		} catch (BusException e) {
			System.out.println(e.getMessage() );
		}
	
	}
}
