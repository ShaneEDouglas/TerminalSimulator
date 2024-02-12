package Rooms;

import PeopleClasses.Passenger;

public class BoardingRoom extends Room {



    public BoardingRoom(String roomID) {
        super(roomID);
    }


    public void addPassenger(Passenger passenger) {
        this.capacity.add(passenger);
    }
}
