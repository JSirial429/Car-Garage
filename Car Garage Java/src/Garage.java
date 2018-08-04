//import java.io.File;
//import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

//Name: Jorge Sirias
//Class: COP 3337 Programing II
//Professor: Greg Shaw
//Section: U07
//Date: 10/3/17
//
//I affirm that this program is entirely my own work and none of it is the work of any other person.
//  _Jorge Siras__________________
//	(your signature)

public class Garage {
    
    private String car []; //Array of cars to be stored in the garage
    private final int MAX_NUM_CARS = 10; //Maximum Capacity the garage can hold
    private int count; //counter
    
    public Garage(){
        
        car = new String[MAX_NUM_CARS];
        count = 0;
        
    }
    
    /**
     * Adds car to the array by checking to see if the counter is less than the 
     * garage maximum capacity of ten. 
     * @param nextArrival The License plate to add to the array.
     * @return A string of either "YES" or "NO" to indicate if either car was able
     * to park inside the garage or "NO" because the garage was full.
     */
    public String arrive(String nextArrival){  
                             
        String arrived = nextArrival; //Car's license plate number
        
        String didCarPark = null; //Stores either "YES" or "NO"
        
        if( count == MAX_NUM_CARS ){
            
            didCarPark = "NO";
            
        }
        //Fills array one car at a time. 
        else if( count < MAX_NUM_CARS ){  
            
            car[count++] = arrived;
            
            didCarPark = "YES";
        
        }
        
        return didCarPark;
    
    }
    
    /**
     * This method searches the array list for a car that will depart the garage.
     * Returns a string "YES" if car is present in the garage. Returns string "NO"
     * if car is not present in the garage
     * @param licensePlate the car to look for. 
     * @return String "YES" or "NO"
     */
    public String depart(String licensePlate){
        
        String didCarDepart = null;
        
        String licenseNum = licensePlate;//Stores either "YES" or "NO"
        //Checks the array to see if car is present in the garage. 
        for(int i = 0; i<car.length; i++){
            
            if(licenseNum.equals(car[i])){
                
                didCarDepart = "YES";
                
            }    
            
            didCarDepart = "NO";
            
        }
        
        return didCarDepart;
        
    }
    
    /**
     * This method searches the array list for a car that will depart the garage.
     * Removes the car from the garage and the cars behind it are moved up one in the array.
     * @param licensePlate The license plate of the car to look for moving out of the garage. 
     * @return integer that specifies the number of times the car was moved
     */
    public int moveCar(String licensePlate){
        
        int numTimesMoved = 0;
        
        String licenseNum = licensePlate;//Car's license plate to be removed 
        
        for(numTimesMoved = 0; numTimesMoved<car.length; numTimesMoved++){
            
            if(licenseNum.equals(car[numTimesMoved])){
                
                
                for(int carsMoveUpOne = numTimesMoved; carsMoveUpOne < car.length; carsMoveUpOne ++){
                    
                    car[carsMoveUpOne] = car[carsMoveUpOne++];
                    
                }
                
                numTimesMoved++;
                
                count--;
                
                break;
            }
            
            numTimesMoved++;
        }
        
        return numTimesMoved;
        
    }
    

}

