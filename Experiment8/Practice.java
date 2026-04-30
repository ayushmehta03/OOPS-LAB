package Experiment8;
import java.util.*;

class SmartCalculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

class StudentProfile {
    String name;
    int roll;
    String branch;

    StudentProfile() {
        this("Unknown", 0, "NA");
    }

    StudentProfile(String name, int roll) {
        this(name, roll, "NA");
    }

    StudentProfile(String name, int roll, String branch) {
        this.name = name;
        this.roll = roll;
        this.branch = branch;
    }

    void display() {
        System.out.println(name + " " + roll + " " + branch);
    }
}

class LoanEMI {
    double p, r, t;

    LoanEMI(double p, double r, double t) {
        this.p = p;
        this.r = r;
        this.t = t;
    }

    LoanEMI(double p, double t) {
        this(p, 7.5, t);
    }

    double calculateEMI() {
        double R = r / (12 * 100);
        double N = t * 12;
        return (p * R * Math.pow(1 + R, N)) / (Math.pow(1 + R, N) - 1);
    }

    void display() {
        System.out.println("EMI: " + calculateEMI());
    }
}

class ShippingCalculator {
    double calculateCost(double w) {
        return w * 10;
    }

    double calculateCost(double w, double d) {
        return w * d * 0.5;
    }

    double calculateCost(double w, double d, int priority) {
        return w * d * 0.5 + priority * 50;
    }
}

class MeasurementTool {
    double area(double r) {
        return Math.PI * r * r;
    }

    double area(double l, double b) {
        return l * b;
    }

    double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double volume(int side) {
        return side * side * side;
    }

    double volume(double r, double h) {
        return Math.PI * r * r * h;
    }
}

class ParkingFee {
    double fee;

    ParkingFee(int hours, String type) {
        fee = hours * (type.equals("car") ? 20 : 10);
    }

    ParkingFee(String type, int days) {
        fee = days * (type.equals("car") ? 200 : 100);
    }

    void display() {
        System.out.println("Fee: " + fee);
    }
}

class GradeCalculator {
    String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 50) return "C";
        return "Fail";
    }

    String calculateGrade(int marks, int attendance) {
        if (attendance < 75) return "Fail";
        return calculateGrade(marks);
    }
}

class TemperatureConverter {
    double convert(double c) {
        return (c * 9 / 5) + 32;
    }

    double convert(int f) {
        return (f - 32) * 5.0 / 9;
    }
}

class MobilePlan {
    String type;
    double base;

    MobilePlan(String type) {
        this.type = type;
        this.base = 199;
    }

    MobilePlan(String type, double base) {
        this.type = type;
        this.base = base;
    }

    double bill(double addon) {
        return base + addon;
    }
}

class TransactionProcessor {
    void transfer(String acc) {
        System.out.println("Transfer to " + acc);
    }

    void transfer(String acc, double amt) {
        System.out.println("Transfer " + amt + " to " + acc);
    }

    void transfer(String acc, double amt, String remarks) {
        System.out.println("Transfer " + amt + " to " + acc + " Remarks: " + remarks);
    }
}

public class Practice {
    public static void main(String[] args) {

        SmartCalculator sc = new SmartCalculator();
        System.out.println(sc.add(2, 3));
        System.out.println(sc.add(2.5, 3.5));
        System.out.println(sc.add(1, 2, 3));

        StudentProfile s1 = new StudentProfile();
        StudentProfile s2 = new StudentProfile("Ayush", 1);
        StudentProfile s3 = new StudentProfile("Ayush", 1, "CSE");
        s1.display();
        s2.display();
        s3.display();

        LoanEMI l1 = new LoanEMI(100000, 8.5, 2);
        LoanEMI l2 = new LoanEMI(100000, 2);
        l1.display();
        l2.display();

        ShippingCalculator ship = new ShippingCalculator();
        System.out.println(ship.calculateCost(5));
        System.out.println(ship.calculateCost(5, 10));
        System.out.println(ship.calculateCost(5, 10, 2));

        MeasurementTool m = new MeasurementTool();
        System.out.println(m.area(5));
        System.out.println(m.area(4, 6));
        System.out.println(m.area(3, 4, 5));
        System.out.println(m.volume(3));
        System.out.println(m.volume(3, 5));

        ParkingFee p1 = new ParkingFee(5, "car");
        ParkingFee p2 = new ParkingFee("bike", 2);
        p1.display();
        p2.display();

        GradeCalculator g = new GradeCalculator();
        System.out.println(g.calculateGrade(85));
        System.out.println(g.calculateGrade(85, 80));

        TemperatureConverter t = new TemperatureConverter();
        System.out.println(t.convert(25));
        System.out.println(t.convert(77));

        MobilePlan mp = new MobilePlan("prepaid");
        System.out.println(mp.bill(50));

        TransactionProcessor tp = new TransactionProcessor();
        tp.transfer("123");
        tp.transfer("123", 5000);
        tp.transfer("123", 5000, "Rent");
    }
}