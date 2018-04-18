package com.Spring.Main;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.Spring.Config.ApplicationConfig;
import com.Spring.Model.Reports;
import com.Spring.Service.CarService;

/**
* 
* @author Faiz Akram
*
*/
public class App {
	public static void main(String args[]) {
		 
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CarService carService = (CarService) context.getBean("carService");
        
        // Delete All cars
      /*  carService.deleteAll();
 
        Car polo = new Car("Volkswagen", "Polo");
        carService.create(polo);
 
        Car jetta = new Car("Volkswagen", "Jetta");
        carService.create(jetta);
 
        Car swift = new Car("Maruti Suzuki", "Swift");
        carService.create(swift);
 
        Car ertiga = new Car("Maruti Suzuki", "Ertiga");
        carService.create(ertiga);
 
        Car i10 = new Car("Hyundai", "i10");
        carService.create(i10);
 
        Car i20 = new Car("Hyundai", "i20");
        carService.create(i20);
 
        System.out.println("Find One:- " + carService.find(swift));
 
        System.out.println("Find All!!");
 
        List < Car > cars = carService.findAll();
        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println();
        carService.delete(swift);
 
        System.out.println();
        i10.setModel("i10 Nxt");
        carService.update(i10);
 
        System.out.println("Find All After Update!!");
 
        cars = carService.findAll();
        for (Car car: cars) {
            System.out.println(car);
        }*/
      //  Car swift = new Car("Maruti Suzuki", "Swift");
       
       /* Car swift = new Car("Maruti Suzuki", "Swift");
        
     carService.create(swift);
        
        Car swift1 = carService.find(swift);
        
        System.out.println(swift1);
        
        System.out.println("Find One:- " + carService.find(swift));
      // carService.delete(swift);
       List < Car > cars = carService.findAll();
       for (Car car: cars) {
           System.out.println(car);
       }*/
        
        Reports reports = new Reports();
        reports.setAvgChats(10);
        reports.setAvgResolutionTime(10L);
        reports.setAvgResponseTime(10L);
        reports.setDate(addDaysToDate(new Date(), 0));
        reports.setMaxResolutionTime(10L);
        reports.setMaxResponseTime(10L);
        reports.setRhId("Cbc123");
        reports.setTotalChats(20);
        reports.setTotalTimeLoggedIn(300L);
        carService.create(reports);
       /* ChatHistory ChatHistory = new ChatHistory();
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        ChatHistory.setChat_Date(utc.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        ChatHistory.setSessionId("937457349573945793475");
        ChatHistory.setUuId("32424234234234234234234234");
        Set<Long> ids = new HashSet<Long>();
        ids.add(1L);
        ids.add(1L);
        ids.add(2L)*/;
        
       /* ChatHistory.setProctorIds(ids);
        carService.createChat(ChatHistory);*/
        context.close();
    }
	
	public static Date addDaysToDate(Date inputDate, int daysToAdd) {
        Calendar calender = Calendar.getInstance();

        calender.setTime(inputDate);
        calender.add(Calendar.DAY_OF_MONTH, daysToAdd);

        return calender.getTime();
    }
}
