package TerminalObjects;

import PeopleClasses.Passenger;
import PeopleClasses.Person;
import java.util.List;
import java.util.ArrayList;

public class Room {
    protected int roomID;
    protected List<Person> capacity;



    public Room(int roomID) {
        this.roomID = roomID;
        this.capacity = new ArrayList<Person>();
    }
}
