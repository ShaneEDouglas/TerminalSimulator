package PeopleClasses;

import TerminalObjects.MetalDetector;

import java.util.Random;

public class SecurityGuard extends Employee{

    public SecurityGuard(String name,String gender, String EmployeeID, String Jobtitle) {
        super(name,gender, EmployeeID);
        this.JobTitle = "Security Guard";

    }

    public boolean inspectPassenger(Passenger passenger, MetalDetector metalDetector) {
        return metalDetector.ScanLuggageandCheckforMetal(passenger);
    }

    public boolean secondInspection(Passenger passenger, MetalDetector metalDetector) {

        //Simulate a 30% chance of finding a dangerous weapon or substance
        if (Math.random() > 0.3) {
            System.out.println("Dangerous Weapon or Substance found on passenger " + passenger.getName() + ". Security Alerted");
            return true;

        } else {
            System.out.println("No dangerous Weapon or Substance found on passenger " + passenger.getName() + ". Will go through the metal detector again.");
            return false;
        }




    }
}
