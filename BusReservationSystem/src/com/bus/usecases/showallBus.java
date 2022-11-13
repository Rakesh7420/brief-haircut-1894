package com.bus.usecases;

import com.bus.dao.CustomerDao;
import com.bus.dao.CustomerDaoImpl;

public class showallBus {

	
public static void	showBuDetails() {
	System.out.println("| busNo |   bName   | routeFrom | routeTo | bType |       departure        |         arrival       | totalSeats | availSeats | fare");
//                    	  mubai  |  mubai  |  pune   2022-11-14 02:00:00  |  2022-11-14 05:00:00  |  100  |  80  |  500  
	System.out.println();
	CustomerDao dao = new CustomerDaoImpl();
   	dao.viewBusDetails();
   	System.out.println("------------------------------------------------------------------------------------------------------------------------------");
}
}
