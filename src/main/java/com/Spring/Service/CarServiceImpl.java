package com.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.CarDao;
import com.Spring.Model.Car;

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
}
