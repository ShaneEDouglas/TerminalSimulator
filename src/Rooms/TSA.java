package Rooms;

import PeopleClasses.Passenger;
import PeopleClasses.Person;
import PeopleClasses.SecurityGuard;
import TerminalObjects.MetalDetector;

import java.util.ArrayList;
import java.util.List;

public class TSA extends Room {
    private MetalDetector metaldetector;
    private SecurityGuard securityGuard;
    protected List<Passenger> PassengerCapacity;

    public TSA(String roomID,SecurityGuard securityGuard) {
        super(roomID);
        this.securityGuard = securityGuard;
        this.metaldetector = new MetalDetector();
        this.PassengerCapacity = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        this.capacity.add(passenger);
    }


  public void processPassengers(BoardingRoom boardingRoom, SecurityGuard securityGuard) {

        List<Person> Copyofcapacity = new ArrayList<>(capacity);

        for (Person person: Copyofcapacity) {
            if (person instanceof  Passenger) {
                Passenger passenger = (Passenger) person;
                boolean hasMetal = securityGuard.inspectPassenger(passenger, metaldetector);

                if(hasMetal) {
                    // Meaning that specific passenger failed the inspection
                    boolean dangerousWeaponfound = securityGuard.secondInspection(passenger, metaldetector);

                    if (!dangerousWeaponfound) {
                        capacity.remove(passenger);
                        boardingRoom.addPassenger(passenger);
                        System.out.println(passenger.getName() + " is cleared for boarding the plane.");

                    } else {
                        //dangerous weapon found on passenger and still fail inspection
                        capacity.remove(passenger);
                        System.out.println(passenger.getName() + " will be taken in for further investigation");
                    }
                }
                else {
                    //passenger passed inspection on the first try completely

                    boardingRoom.addPassenger(passenger);
                    capacity.remove(passenger);

                }
            }
        }
  }



}
