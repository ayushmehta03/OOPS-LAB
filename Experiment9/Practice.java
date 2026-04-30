package Experiment9;
class Account {
    String accNo;
    String name;
    double balance;

    Account(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    double calculateInterest() {
        return 0;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String a, String n, double b) {
        super(a, n, b);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String a, String n, double b) {
        super(a, n, b);
    }

    double calculateInterest() {
        return balance * 0.02;
    }
}

class Vehicle {
    String number;
    String type;

    Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }

    double calculateToll() {
        return 0;
    }
}

class Car extends Vehicle {
    Car(String n) {
        super(n, "Car");
    }

    double calculateToll() {
        return 50;
    }
}

class Truck extends Vehicle {
    Truck(String n) {
        super(n, "Truck");
    }

    double calculateToll() {
        return 150;
    }
}

class Bus extends Vehicle {
    Bus(String n) {
        super(n, "Bus");
    }

    double calculateToll() {
        return 100;
    }
}

class Staff {
    int id;
    double salary;

    Staff(int id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    double calculateSalary() {
        return salary;
    }
}

class Professor extends Staff {
    Professor(int id, double salary) {
        super(id, salary);
    }

    double calculateSalary() {
        return salary + 5000;
    }
}

class Administrator extends Staff {
    Administrator(int id, double salary) {
        super(id, salary);
    }

    double calculateSalary() {
        return salary + 3000;
    }
}

class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    double calculateDiscount() {
        return 0;
    }
}

class RegularCustomer extends Customer {
    RegularCustomer(double a) {
        super(a);
    }

    double calculateDiscount() {
        return amount * 0.05;
    }
}

class PremiumCustomer extends Customer {
    PremiumCustomer(double a) {
        super(a);
    }

    double calculateDiscount() {
        return amount * 0.1;
    }
}

class Order {
    int id;
    double price;

    Order(int id, double price) {
        this.id = id;
        this.price = price;
    }

    double calculateFinalBill() {
        return price;
    }
}

class VegOrder extends Order {
    VegOrder(int id, double p) {
        super(id, p);
    }

    double calculateFinalBill() {
        return price + price * 0.05;
    }
}

class NonVegOrder extends Order {
    NonVegOrder(int id, double p) {
        super(id, p);
    }

    double calculateFinalBill() {
        return price + price * 0.1;
    }
}

class InsurancePolicy {
    double amount;

    InsurancePolicy(double amount) {
        this.amount = amount;
    }

    double calculatePremium() {
        return 0;
    }
}

class HealthPolicy extends InsurancePolicy {
    HealthPolicy(double a) {
        super(a);
    }

    double calculatePremium() {
        return amount * 0.03;
    }
}

class VehiclePolicy extends InsurancePolicy {
    VehiclePolicy(double a) {
        super(a);
    }

    double calculatePremium() {
        return amount * 0.05;
    }
}

class SmartDevice {
    void operate() {
        System.out.println("Operating device");
    }
}

class SmartLight extends SmartDevice {
    void operate() {
        System.out.println("Light ON");
    }
}

class SmartFan extends SmartDevice {
    void operate() {
        System.out.println("Fan ON");
    }
}

class HospitalStaff {
    String name;

    HospitalStaff(String name) {
        this.name = name;
    }

    String getRoleDescription() {
        return "Staff";
    }
}

class Doctor extends HospitalStaff {
    Doctor(String n) {
        super(n);
    }

    String getRoleDescription() {
        return "Doctor treating patients";
    }
}

class Nurse extends HospitalStaff {
    Nurse(String n) {
        super(n);
    }

    String getRoleDescription() {
        return "Nurse assisting doctor";
    }
}

class PaymentMethod {
    void processPayment(double amt) {
        System.out.println("Processing payment");
    }
}

class CreditCardPayment extends PaymentMethod {
    void processPayment(double amt) {
        System.out.println("Paid " + amt + " via Credit Card");
    }
}

class UPIPayment extends PaymentMethod {
    void processPayment(double amt) {
        System.out.println("Paid " + amt + " via UPI");
    }
}

class Evaluation {
    double marks;

    Evaluation(double m) {
        marks = m;
    }

    double computeResult() {
        return marks;
    }
}

class TheoryEvaluation extends Evaluation {
    TheoryEvaluation(double m) {
        super(m);
    }

    double computeResult() {
        return marks * 0.7;
    }
}

class LabEvaluation extends Evaluation {
    LabEvaluation(double m) {
        super(m);
    }

    double computeResult() {
        return marks * 0.3;
    }
}

public class Practice {
    public static void main(String[] args) {

        Account a1 = new SavingsAccount("101", "Ayush", 5000);
        Account a2 = new CurrentAccount("102", "Ram", 5000);
        System.out.println(a1.calculateInterest());
        System.out.println(a2.calculateInterest());

        Vehicle v1 = new Car("C1");
        Vehicle v2 = new Truck("T1");
        Vehicle v3 = new Bus("B1");
        System.out.println(v1.calculateToll());
        System.out.println(v2.calculateToll());
        System.out.println(v3.calculateToll());

        Staff s1 = new Professor(1, 50000);
        Staff s2 = new Administrator(2, 40000);
        System.out.println(s1.calculateSalary());
        System.out.println(s2.calculateSalary());

        Customer c1 = new RegularCustomer(1000);
        Customer c2 = new PremiumCustomer(1000);
        System.out.println(c1.calculateDiscount());
        System.out.println(c2.calculateDiscount());

        Order o1 = new VegOrder(1, 200);
        Order o2 = new NonVegOrder(2, 200);
        System.out.println(o1.calculateFinalBill());
        System.out.println(o2.calculateFinalBill());

        InsurancePolicy i1 = new HealthPolicy(100000);
        InsurancePolicy i2 = new VehiclePolicy(100000);
        System.out.println(i1.calculatePremium());
        System.out.println(i2.calculatePremium());

        SmartDevice d1 = new SmartLight();
        SmartDevice d2 = new SmartFan();
        d1.operate();
        d2.operate();

        HospitalStaff h1 = new Doctor("Dr A");
        HospitalStaff h2 = new Nurse("Nurse B");
        System.out.println(h1.getRoleDescription());
        System.out.println(h2.getRoleDescription());

        PaymentMethod p1 = new CreditCardPayment();
        PaymentMethod p2 = new UPIPayment();
        p1.processPayment(5000);
        p2.processPayment(3000);

        Evaluation e1 = new TheoryEvaluation(80);
        Evaluation e2 = new LabEvaluation(80);
        System.out.println(e1.computeResult());
        System.out.println(e2.computeResult());
    }
}