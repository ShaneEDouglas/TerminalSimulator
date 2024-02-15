package AirportRooms;

import PeopleClasses.BoardingClerk;
import PeopleClasses.Passenger;

import java.util.*;

public class BoardingRoom extends Room {

    private Map<String, List<Passenger>> flightPassengerMap;
    private BoardingClerk boardingClerk;
    private Map<String, Plane> planesMap;



    public BoardingRoom(String roomID, BoardingClerk boardingclerk, Map<String, Plane> planesMap) {
        super(roomID);
        this.flightPassengerMap = new HashMap<>();
        this.boardingClerk = boardingclerk;
        this.planesMap = planesMap;
    }


    public void addPassenger(Passenger passenger) {
        String flightNumber = passenger.getFlightNumber();
        if (planesMap.containsKey(flightNumber)) {
            Plane plane = planesMap.get(flightNumber);
            boolean added = plane.addPassenger(passenger);
            if (added) {
                System.out.println("Passenger " + passenger.getName() + " boarded to flight " + flightNumber);
            } else {
                System.out.println("Flight " + flightNumber + " is full. Cannot board " + passenger.getName());
            }
        } else {
            System.out.println("Flight " + flightNumber + " not found. Cannot board " + passenger.getName());
        }

    }


    public void prepareForBoarding() {
        planesMap.forEach((flightNumber, plane) -> {
            // Here, Change the staus of each plane to being completed
            plane.changeStatus("Boarding Complete");
        });
    }



    // Method / function to trigger boarding annoucements for all flights after a 1-minute delay

    public void scheduleBoardingAnnouncements() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // announce boardings
                boardingClerk.announceAllBoardings();

                // Now check and proceed with status changes
                planesMap.forEach((flightNumber, plane) -> {
                    if ("Boarding Complete".equals(plane.getStatus())) {
                        // Sequential status changes with logical delays
                        plane.scheduleStatusChange("Ready for Takeoff", 1000); // 1 second after announcements
                        plane.scheduleStatusChange("In Flight", 6000); // Additional 5 seconds for "In Flight"
                        plane.scheduleStatusChange("Landed", 11000); // Additional 5 seconds for "Landed"
                    }
                });
            }
        }, 0); // Start immediately after calling this method
    }



}
