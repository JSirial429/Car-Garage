/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Name: Jorge Sirias
//Class: COP 3337 Programing II
//Professor: Greg Shaw
//Section: U07
//Date: 10/3/17
//
//I affirm that this program is entirely my own work and none of it is the work of any other person.
//  _Jorge Siras__________________
//	(your signature)

public class Car {
    
    private String licensePlate;//Holds the current license plate of the car
    private int numTimesMoved; //hold the number of times the car has moved
    
    public Car(String carInfo){
    
       licensePlate = carInfo;
       numTimesMoved = 0;
    }
    
    /**
     * Adds the number of times moved by the vehicle in the garage.
     * @param numTimes the number of times the car moved.
     */
    public void addNumTimesMoved(int numTimes){
        
        numTimesMoved = numTimesMoved + numTimes;
        
    }
    
    
    




}

