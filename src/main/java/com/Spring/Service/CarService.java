package com.Spring.Service;

import java.util.List;

import com.Spring.Model.Car;
import com.Spring.Model.ChatHistory;
import com.Spring.Model.Reports;

/**
* 
* @author Faiz Akram
*
*/
public interface CarService {
 
    public void create(Car car);
    
    public void createChat(ChatHistory car);
 
    public void update(Car car);
 
    public void delete(Car car);
 
    public void deleteAll();
 
    public Car find(Car car);
 
    public List < Car > findAll();

	public void create(Reports reports);
    
}
