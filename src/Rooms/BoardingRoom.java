package Rooms;

import PeopleClasses.BoardingClerk;
import PeopleClasses.Passenger;

import java.util.*;

public class BoardingRoom extends Room {

    private Map<String, List<Passenger>> flightPassengerMap;
    private BoardingClerk boardingClerk;



    public BoardingRoom(String roomID, BoardingClerk boardingclerk) {
        super(roomID);
        this.flightPassengerMap = new HashMap<>();
        this.boardingClerk = boardingclerk;
    }


    public void addPassenger(Passenger passenger) {
        this.capacity.add(passenger);
        boardingClerk.sortPassengerForFlight(passenger);

    }


    // Method / function to trigger boarding annoucements for all flights after a 1-minute delay

    public void scheduleBoardingAnnouncements() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Will announce the boarding for each flight
                boardingClerk.announceAllBoardings();
            }
        }, 60000);
    }

}
