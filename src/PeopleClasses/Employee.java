package PeopleClasses;

public abstract class Employee extends Person {

    protected String EmployeeID;
    protected String JobTitle;

    public Employee(String name, String gender, String EmployeeID) {
        super(name, gender);
        this.IsPassenger = false;
    }

}
