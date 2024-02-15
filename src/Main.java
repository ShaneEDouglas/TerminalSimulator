import PeopleClasses.BoardingClerk;
import PeopleClasses.Passenger;
import PeopleClasses.SecurityGuard;
import AirportRooms.BoardingRoom;
import AirportRooms.MainLobby;
import AirportRooms.Plane;
import AirportRooms.TSA;
import TerminalObjects.SelfCheckIn;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Employees
        SecurityGuard securityGuard1 = new SecurityGuard("Officer Jones", "Male", "SG123", "SecurityGuard");
        BoardingClerk clerk = new BoardingClerk("Jane", "Female", "BC123", "Boarding Clerk");

        //Planes
        Map<String, Plane> planesMap = new HashMap<>();
        planesMap.put("A123", new Plane("A123", 150, "New York", "Boarding"));
        planesMap.put("B456", new Plane("B456", 150, "Los Angeles", "Boarding"));


        // Airport Main AirportRooms
        MainLobby mainlobby = new MainLobby("MainLobby");
        TSA tsa = new TSA("TSA",securityGuard1);
        BoardingRoom boardingRoom = new BoardingRoom("BoardingRoom",clerk, planesMap);


        //Main Lobby/ self Checkin
        Passenger passenger1 = new Passenger("John", "male","A123",4);
        Passenger passenger2 = new Passenger("Jenny", "Female","B456",2);

        SelfCheckIn kiosk = new SelfCheckIn("kiosk1");
        SelfCheckIn kiosk2 = new SelfCheckIn("kiosk2");

        kiosk.Checkin(passenger1);
        kiosk2.Checkin(passenger2);

        mainlobby.MoveToTsA(tsa, passenger1);
        mainlobby.MoveToTsA(tsa, passenger2);

        //TSA
        tsa.processPassengers(boardingRoom,securityGuard1);


        //Boarding Room Logic
        boardingRoom.prepareForBoarding();
        boardingRoom.scheduleBoardingAnnouncements();


        // Delay and Run the timers asynchronously excute before ending the program
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}