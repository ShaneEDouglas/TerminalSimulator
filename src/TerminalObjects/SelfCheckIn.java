package TerminalObjects;

import PeopleClasses.Passenger;

import java.util.LinkedList;
import java.util.Queue;

public class SelfCheckIn {

    protected String kioskID;
    protected boolean isOperational;
    protected Queue<Passenger>  PassengerQueue;

    public String getKioskID() {
        return kioskID;
    }

    public void setKioskID(String kioskID) {
        this.kioskID = kioskID;
    }



    public void setOperational(boolean operational) {
        isOperational = operational;
    }

    public SelfCheckIn(String kioskID){
        this.kioskID = kioskID;
        this.isOperational = true;
        this.PassengerQueue = new LinkedList<>();
    }


    public boolean Checkin(Passenger passenger) {

        // check for operational, then next function add to passengerqueue

        if (!isOperational) {
            System.out.println("Kiosk " + kioskID + "is not operational");
            return false;
        }

        passenger.checkIn();
        System.out.println("Passenger " + passenger.getName() + " has checked in at kiosk " + kioskID + ".");
        addToQueue(passenger);
        return true;


    }
        public void addToQueue (Passenger passenger) {

        PassengerQueue.add(passenger);

    }



   //getters and setters
    public Queue<Passenger> getPassengerQueue() {
        return PassengerQueue;
    }

    public void setPassengerQueue(Queue<Passenger> passengerQueue) {
        PassengerQueue = passengerQueue;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public Passenger processNextPassenger() {
        if (!isOperational || PassengerQueue.isEmpty()) {
            System.out.println("Kiosk " + kioskID + " cannot process passengers at this time");
        }
        return PassengerQueue.poll();
    }
}
