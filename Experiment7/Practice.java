package Experiment7;
import java.util.*;

class ATMAccount {
    private String accNo;
    private String name;
    private double balance;

    ATMAccount(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void statement() {
        System.out.println(accNo + " " + name + " Balance: " + balance);
    }
}

class CabRide {
    private String rideId;
    private double distance;
    private double farePerKm;

    CabRide(String rideId, double distance, double farePerKm) {
        this.rideId = rideId;
        this.distance = distance;
        this.farePerKm = farePerKm;
    }

    double calculateFare(boolean peak) {
        double fare = distance * farePerKm;
        if (peak) fare *= 1.5;
        return fare;
    }

    void display(boolean peak) {
        System.out.println(rideId + " Fare: " + calculateFare(peak));
    }
}

class ElectricityBill {
    private String consumer;
    private int units;

    void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    void setUnits(int units) {
        this.units = units;
    }

    double calculateBill() {
        if (units <= 100) return units * 2;
        else if (units <= 300) return 100 * 2 + (units - 100) * 4;
        else return 100 * 2 + 200 * 4 + (units - 300) * 6;
    }

    void display() {
        System.out.println(consumer + " Bill: " + calculateBill());
    }
}

class Book {
    private String title, author;
    private int delayDays;

    Book(String t, String a, int d) {
        title = t;
        author = a;
        delayDays = d;
    }

    double fine() {
        return delayDays * 2;
    }

    void display() {
        System.out.println(title + " Fine: " + fine());
    }
}

class Employee {
    private int id;
    private double basic;
    private String dept;

    Employee(int id, double basic, String dept) {
        this.id = id;
        this.basic = basic;
        this.dept = dept;
    }

    double gross() {
        return basic + (0.2 * basic) + (0.1 * basic);
    }

    void slip() {
        System.out.println(id + " " + dept + " Salary: " + gross());
    }
}

class Student {
    private int roll;
    private String name;
    private ArrayList<String> courses = new ArrayList<>();

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    void enroll(String c) {
        courses.add(c);
    }

    void drop(String c) {
        courses.remove(c);
    }

    void display() {
        System.out.println(name + " Courses: " + courses.size());
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    void purchase(int qty) {
        if (qty <= stock) {
            stock -= qty;
        } else {
            System.out.println("Stock not enough");
        }
    }

    double discount(int qty) {
        if (qty > 10) return price * 0.9;
        return price;
    }

    void display() {
        System.out.println(name + " Stock: " + stock);
    }
}

class Patient {
    private int id;
    private String name;
    private int age;
    private String diagnosis;

    Patient(int id, String name, int age, String diagnosis) {
        if (age > 0) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.diagnosis = diagnosis;
        }
    }

    void updateDiagnosis(String d) {
        diagnosis = d;
    }

    void display() {
        System.out.println(name + " Diagnosis: " + diagnosis);
    }
}

class LoanApplicant {
    private double income;
    private int credit;
    private double loan;

    LoanApplicant(double income, int credit, double loan) {
        this.income = income;
        this.credit = credit;
        this.loan = loan;
    }

    boolean eligible() {
        return income > 30000 && credit > 650 && loan < income * 10;
    }

    void display() {
        System.out.println("Loan Eligible: " + eligible());
    }
}

class FlightTicket {
    private String name, flight, seat;
    private double price;

    FlightTicket(String name, String flight, String seat, double price) {
        this.name = name;
        this.flight = flight;
        this.seat = seat;
        this.price = price;
    }

    double finalFare() {
        return price + (0.18 * price);
    }

    void display() {
        System.out.println(name + " " + flight + " " + seat + " Fare: " + finalFare());
    }
}

public class Practice {
    public static void main(String[] args) {

        ATMAccount a = new ATMAccount("101", "Ayush", 5000);
        a.deposit(1000);
        a.withdraw(2000);
        a.statement();

        CabRide r = new CabRide("R1", 10, 15);
        r.display(true);

        ElectricityBill e = new ElectricityBill();
        e.setConsumer("Ayush");
        e.setUnits(350);
        e.display();

        Book b = new Book("Java", "Author", 5);
        b.display();

        Employee emp = new Employee(1, 30000, "IT");
        emp.slip();

        Student s = new Student(1, "Ayush");
        s.enroll("DSA");
        s.enroll("Java");
        s.display();

        Product p = new Product(1, "Laptop", 50000, 20);
        p.purchase(5);
        p.display();

        Patient pt = new Patient(1, "Ram", 25, "Flu");
        pt.updateDiagnosis("Cold");
        pt.display();

        LoanApplicant l = new LoanApplicant(50000, 700, 200000);
        l.display();

        FlightTicket f = new FlightTicket("Ayush", "AI101", "12A", 5000);
        f.display();
    }
}

