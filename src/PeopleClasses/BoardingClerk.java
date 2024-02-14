package PeopleClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardingClerk extends Employee {

    //We need to use a map/ Hashmap to group passengers by their respective flight number
    // Doing this for easy look up and
    private Map<String, List<Passenger>> FlightandPassengerMap;


    public BoardingClerk(String name, String gender, String employeeID, String jobtitle) {
        super(name,gender, employeeID);
        this.JobTitle = "Boarding Clerk";
        this.FlightandPassengerMap = new HashMap<>();
    }


    // Sort passengers by their flights
    public void sortPassengerForFlight(Passenger passenger) {
        FlightandPassengerMap.putIfAbsent(passenger.getFlightNumber(), new ArrayList<>());
        FlightandPassengerMap.get(passenger.getFlightNumber()).add(passenger);
    }

    public void announceAllBoardings() {
        FlightandPassengerMap.forEach((flightNumber, passengers) -> {
            if (!passengers.isEmpty()) {
                System.out.println("Boarding now for flight " + flightNumber + ": " + passengers.size() + " passengers.");
            } else {
                System.out.println("No passengers being boarded for flight " + flightNumber + ".");
            }
        });
        FlightandPassengerMap.clear(); // Clear the map after announcements
    }






}
