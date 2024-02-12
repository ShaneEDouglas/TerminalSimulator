package PeopleClasses;

public class Employee extends Person {

    protected int EmployeeID;

    protected String JobTitle;

    public Employee(String name, String gender) {
        super(name, gender);
        this.IsPassenger = false;
    }

    public void dojob() {

    }
}
