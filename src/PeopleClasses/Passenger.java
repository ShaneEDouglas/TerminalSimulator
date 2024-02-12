package PeopleClasses;

import TerminalObjects.SelfCheckIn;

public class Passenger extends Person {

    protected int Passengerid;
    protected int NumOfFlights;
    protected int Luggage;


    protected boolean isCheckedIn;



    public Passenger(String name, String gender) {
        super(name, gender);
        this.IsPassenger = true;
        this.NumOfFlights = NumOfFlights;
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

    public int getNumOfFlights() {
        return NumOfFlights;
    }

    public void setNumOfFlights(int numOfFlights) {
        NumOfFlights = numOfFlights;
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



