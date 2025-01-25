package com.library.person;

public class Librarian extends Person {
    private double salary;

    public Librarian(String id, String name, String phoneNumber, double salary) {
        super(id, name, phoneNumber);
        this.salary = salary;
    }

    @Override
    public void showInfo() {
        System.out.println("Librarian Info: " + super.toString()
                + ", Salary: " + salary);
    }
}
