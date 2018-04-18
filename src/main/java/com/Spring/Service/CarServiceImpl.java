package com.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.CarDao;
import com.Spring.Model.Car;
import com.Spring.Model.ChatHistory;
import com.Spring.Model.Reports;

/**
* 
* @author Faiz Akram
*
*/
@Service("carService")
public class CarServiceImpl implements CarService {
 
    @Autowired
    private CarDao carDao;
 
    public void create(Car car) {
        carDao.create(car);
    }
 
    public void update(Car car) {
        carDao.update(car);
    }
 
    public void delete(Car car) {
        carDao.delete(car);
    }
 
    public List < Car > findAll() {
        return carDao.findAll();
    }
 
    public Car find(Car car) {
        return carDao.find(car);
    }
 
    public void deleteAll() {
        carDao.deleteAll();
    }

	@Override
	public void createChat(ChatHistory chatHistory) {
		// TODO Auto-generated method stub
		carDao.updateChatHistory(chatHistory);
	}

	@Override
	public void create(Reports reports) {
		// TODO Auto-generated method stub
		carDao.create(reports);
	}
}
