import PeopleClasses.BoardingClerk;
import PeopleClasses.Passenger;
import PeopleClasses.SecurityGuard;
import Rooms.BoardingRoom;
import Rooms.MainLobby;
import Rooms.TSA;
import TerminalObjects.SelfCheckIn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Employees
        SecurityGuard securityGuard1 = new SecurityGuard("Officer Jones", "Male", "SG123", "SecurityGuard");
        BoardingClerk clerk = new BoardingClerk("Jane", "Female", "BC123", "Boarding Clerk");

        // Main Rooms
        MainLobby mainlobby = new MainLobby("MainLobby");
        TSA tsa = new TSA("TSA",securityGuard1);
        BoardingRoom boardingRoom = new BoardingRoom("BoardingRoom",clerk);





        //Main Lobby/ self Checkin
        Passenger passenger1 = new Passenger("John", "male","A123",4);
        Passenger passenger2 = new Passenger("Jenny", "Female","B123",2);

        SelfCheckIn kiosk = new SelfCheckIn("kiok1");
        SelfCheckIn kiosk2 = new SelfCheckIn("kiosk2");

        kiosk.Checkin(passenger1);

        mainlobby.MoveToTsA(tsa, passenger1);

        //TSA

        tsa.processPassengers(boardingRoom,securityGuard1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Boarding Room Logic
        boardingRoom.scheduleBoardingAnnouncements();






    }
}