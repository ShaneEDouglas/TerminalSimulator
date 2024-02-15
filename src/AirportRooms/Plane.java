package AirportRooms;

import PeopleClasses.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Plane extends Room{

    protected String FlightNumber;
    protected int capacity;
    protected List<Passenger> passengers;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    protected String destination;
    protected String Status;


    public Plane(String FlightNumber, int capacity, String destination, String Status) {
        super("Plane" + FlightNumber);

        this.FlightNumber = FlightNumber;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        this.destination = destination;
        this.Status = Status;

    }


    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            System.out.println("Passenger " + passenger.getName() + " added to flight " + FlightNumber);
            return true;
        } else {
            System.out.println("Flight " + FlightNumber + " is full. Cannot add " + passenger.getName());
            return false;

        }
    }

    public void removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)){
            System.out.println("Passenger " + passenger.getName() + " removed from flight " + FlightNumber);
        } else {
            System.out.println("Passenger " + passenger.getName() + " not found on flight " + FlightNumber);
        }
    }

    public boolean isFull() {
        return passengers.size() >= capacity;
    }

    public void changeStatus(String newStatus) {
        this.Status = newStatus;
        System.out.println("Flight " + FlightNumber + " status changed to " + newStatus);
    }

    public void listPassengers() {
        System.out.println("Passengers on flight " + FlightNumber + ":");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getName());
        }
    }

    public void fly(long flyingTimeMillis) {
        // Change status to "In Flight" immediately
        changeStatus("In Flight");
        System.out.println("Flight " + FlightNumber + " is now in flight to " + destination);

        // Schedule a change to "Landed" after the flyingTimeMillis duration
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                changeStatus("Landed");
                System.out.println("Flight " + FlightNumber + " has landed at " + destination);
                // Here, you might also simulate deboarding passengers or other post-landing activities
            }
        }, flyingTimeMillis);
    }


    // makes scheduled status changes based on the timing
    public void scheduleStatusChange(String newStatus, long delayMillis) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                changeStatus(newStatus);
            }
        }, delayMillis);
    }









}
