import java.io.File;
import java.io.FileWriter;
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




public class Tester {
    public static void main(String[] args) throws IOException{
        
        //Creates object variable of the Garage class to store cars coming in and out of the garage
        Garage nextCar = new Garage();
        
        //Writes the results of the car parking and depaarting in an output file called Output.txt
        PrintWriter outputFile = new PrintWriter( new FileWriter ("Output.txt", true));
        
        //String that holds a YES or NO value to indicate whether a car has parked in the garage when the arrive() method is invoked
        String hasCarParked = null;
        
        //String that holds a YES or NO value to indicate whether the car has departed from the garage when the depart()method is invoked
        String hasCarDeparted = null;
        
        //Scanner Object reading from the Cars.txt file that has Licence Plate and Car operation
        Scanner fileInput = new Scanner( new File ("Cars.txt"));
        
        //Searches for input from text file until end of file.
        while(fileInput.hasNextLine())
        {
        
            String carInfo = fileInput.nextLine();
        
            //Stores a string that contains only the license plate from the input file
            String licensePlate = carInfo.substring(0,6);
        
            Car nextCarIn = new Car(licensePlate);
        
            //Truncates the carInfo string to just include the operation of the vehicle. I.e. ARRIVE or DEPART
            String operation = carInfo.substring(7,13); 
        
                if(operation.equals("ARRIVE"))
                {
                    outputFile.print(operation + "= ");
            
                    hasCarParked = nextCar.arrive(licensePlate);
            
                        if(hasCarParked.equals("NO"))
                        {
                        
                            outputFile.println("Car " + licensePlate + " is not able to park. The garage is full.");
                
                        }
                        else if(hasCarParked.equals("YES"))
                        {
                
                            outputFile.println("Car " + licensePlate + " has succesfully entered the garage.");
                
                        }
            
                }   
                else if(operation.equals("DEPART"))
                {
            
                    outputFile.print(operation + "= ");
            
                    hasCarDeparted = nextCar.depart(licensePlate);
            
                        if(hasCarDeparted.equals("NO"))
                        {
                
                            outputFile.println("Car " + licensePlate + " did not depart due to the vehicle not present in the parking garage. Car moved 0 times.");
                
                            nextCarIn.addNumTimesMoved(0);
                
                        }
                        else if(operation.equals("YES"))
                        {
                
                            int numTimesCarHasMoved = nextCar.moveCar(licensePlate);
                
                            outputFile.println("Car " + licensePlate + " moved " + numTimesCarHasMoved + " times while departing from the garage.");
                
                            nextCarIn.addNumTimesMoved(numTimesCarHasMoved);
                
                        }
        
                }
        
        }
        outputFile.close();
    }
}
