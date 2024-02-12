import PeopleClasses.Passenger;
import Rooms.BoardingRoom;
import Rooms.MainLobby;
import Rooms.TSA;
import TerminalObjects.SelfCheckIn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Main Rooms
        MainLobby mainlobby = new MainLobby("MainLobby");
        TSA tsa = new TSA("TSA");
        BoardingRoom boardingRoom = new BoardingRoom("BoardingRoom");


        // Passenger Logic

        //Main Lobby/ self Checkin
        Passenger passenger1 = new Passenger("John", "male");
        Passenger passenger2 = new Passenger("Jenny", "Female");

        SelfCheckIn kiosk = new SelfCheckIn("kiok1");
        SelfCheckIn kiosk2 = new SelfCheckIn("kiosk2");

        kiosk.Checkin(passenger1);

        mainlobby.MoveToTsA(tsa, passenger1);

        //TSA
        tsa.processPassengers(boardingRoom);





    }
}