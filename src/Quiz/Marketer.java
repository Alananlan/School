/*
Alan Ly
Prof. Iverson
CS211
6 January 2021
 */

public class Marketer extends Employee {

    public Marketer() {
        super();
    }

    public double getSalary() {
        return  super.getSalary() + 10000;
    }

    public String toString() {
        return "Act now, while supplies last!";
    }

}
