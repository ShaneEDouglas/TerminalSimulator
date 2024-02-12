package Rooms;

import PeopleClasses.Passenger;
import PeopleClasses.Person;
import TerminalObjects.metalDetector;

import java.util.ArrayList;
import java.util.List;

public class TSA extends Room {
    private metalDetector metaldetector;
    protected List<Passenger> PassengerCapacity;

    public TSA(String roomID) {
        super(roomID);
        this.metaldetector = new metalDetector();
        this.PassengerCapacity = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        this.capacity.add(passenger);
    }


  public void processPassengers(BoardingRoom boardingRoom) {

        List<Person> Copyofcapacity = new ArrayList<>(capacity);

        for (Person person: Copyofcapacity) {
            if (person instanceof  Passenger) {
                Passenger passenger = (Passenger) person;
                boolean hasMetal = metaldetector.ScanLuggageandCheckforMetal(passenger);

                if(!hasMetal) {

                    boardingRoom.addPassenger(passenger);
                    capacity.remove(passenger);
                }
            }
        }
  }



}
