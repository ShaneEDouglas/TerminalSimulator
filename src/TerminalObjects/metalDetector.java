package TerminalObjects;

import PeopleClasses.Passenger;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class metalDetector {

    private Random random = new Random();
    //ten percent chance to detect metal in a luggage
    protected List<Integer> LuggageCount;

    public metalDetector() {
        LuggageCount = new ArrayList<>();
    }


    public boolean ScanLuggageandCheckforMetal(Passenger passenger) {

        boolean hasMetal = random.nextInt(10) == 0;

        if (hasMetal) {
            System.out.println(passenger.getName() + "has " + passenger.getLuggage() + " bags and has metal. Step away form the line");
            return true;
        } else {
            System.out.println(passenger.getName() + "has " + passenger.getLuggage() + " bags and does not have metal. Move to the boarding room");
            return false;
        }

    }

}
