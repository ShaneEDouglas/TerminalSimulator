package PeopleClasses;

import TerminalObjects.SelfCheckIn;

public class Passenger extends Person {

    protected int Passengerid;
    protected String FlightNumber;
    protected int Luggage;


    protected boolean isCheckedIn;


    public Passenger(String name, String gender,String FlightNumber, int Luggage) {
        super(name, gender);
        this.IsPassenger = true;
        this.FlightNumber = FlightNumber;
        this.Luggage = Luggage;
        this.isCheckedIn = false;

    }

//    public boolean checkin(SelfCheckIn sc) {
//
//        return  sc.isChecked(true);
//    }


    // Method to mark the passenger as checked in
    public void checkIn() {
        this.isCheckedIn = true;
    }

    // Getter for check-in status
    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void WaitForFlight() {

    }

    public String getName() {
        return super.name;
    }



    ///////////////////////////////////////////////////

    public int getLuggage() {
        return Luggage;
    }

    public void setLuggage(int luggage) {
        Luggage = luggage;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    public int getPassengerid() {
        return Passengerid;
    }

    public void setPassengerid(int passengerid) {
        Passengerid = passengerid;
    }






}



