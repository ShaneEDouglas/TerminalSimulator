package AirportRooms;

import PeopleClasses.Person;
import java.util.List;
import java.util.ArrayList;

public abstract class Room {
    protected String roomID;
    protected List<Person> capacity;


    public Room(String roomID) {
        this.roomID = roomID;
        this.capacity = new ArrayList<Person>();
    }

    public int getCurrentCapacity() {
        return this.capacity.size();
    }


}
