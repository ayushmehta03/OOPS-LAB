package Experiment10;
interface Refundable {
    void initiateRefund(double amount);
}

abstract class Payment {
    abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment implements Refundable {
    void processPayment(double amount) {
        System.out.println("Credit Card Payment: " + amount);
    }

    public void initiateRefund(double amount) {
        System.out.println("Refund to Credit Card: " + amount);
    }
}

class UPIPayment extends Payment implements Refundable {
    void processPayment(double amount) {
        System.out.println("UPI Payment: " + amount);
    }

    public void initiateRefund(double amount) {
        System.out.println("Refund to UPI: " + amount);
    }
}

interface Controllable {
    void turnOn();
    void turnOff();
}

abstract class SmartAppliance {
    String name;

    SmartAppliance(String name) {
        this.name = name;
    }
}

class SmartLight extends SmartAppliance implements Controllable {
    SmartLight(String name) {
        super(name);
    }

    public void turnOn() {
        System.out.println(name + " Light ON");
    }

    public void turnOff() {
        System.out.println(name + " Light OFF");
    }
}

class SmartAC extends SmartAppliance implements Controllable {
    SmartAC(String name) {
        super(name);
    }

    public void turnOn() {
        System.out.println(name + " AC ON");
    }

    public void turnOff() {
        System.out.println(name + " AC OFF");
    }
}

interface FareCalculator {
    double calculateFare();
}

abstract class Ride {
    int id;
    double distance;

    Ride(int id, double distance) {
        this.id = id;
        this.distance = distance;
    }
}

class BikeRide extends Ride implements FareCalculator {
    BikeRide(int id, double d) {
        super(id, d);
    }

    public double calculateFare() {
        return distance * 5;
    }
}

class CabRide extends Ride implements FareCalculator {
    CabRide(int id, double d) {
        super(id, d);
    }

    public double calculateFare() {
        return distance * 10;
    }
}

interface ReportGenerator {
    void generateReport();
}

abstract class Assessment {
    abstract void evaluate();
}

class ObjectiveAssessment extends Assessment implements ReportGenerator {
    void evaluate() {
        System.out.println("Objective Evaluation Done");
    }

    public void generateReport() {
        System.out.println("Objective Report Generated");
    }
}

class SubjectiveAssessment extends Assessment implements ReportGenerator {
    void evaluate() {
        System.out.println("Subjective Evaluation Done");
    }

    public void generateReport() {
        System.out.println("Subjective Report Generated");
    }
}

interface Auditable {
    void log();
}

abstract class BankTransaction {
    abstract void execute(double amt);
}

class DepositTransaction extends BankTransaction implements Auditable {
    void execute(double amt) {
        System.out.println("Deposited: " + amt);
    }

    public void log() {
        System.out.println("Deposit logged");
    }
}

class WithdrawalTransaction extends BankTransaction implements Auditable {
    void execute(double amt) {
        System.out.println("Withdrawn: " + amt);
    }

    public void log() {
        System.out.println("Withdrawal logged");
    }
}

interface Taxable {
    double tax(double salary);
}

abstract class Employee {
    double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class PermanentEmployee extends Employee implements Taxable {
    PermanentEmployee(double s) {
        super(s);
    }

    double calculateBonus() {
        return salary * 0.2;
    }

    public double tax(double salary) {
        return salary * 0.1;
    }
}

class ContractEmployee extends Employee implements Taxable {
    ContractEmployee(double s) {
        super(s);
    }

    double calculateBonus() {
        return salary * 0.1;
    }

    public double tax(double salary) {
        return salary * 0.05;
    }
}

interface TransportService {
    double calculateFare(double distance);
}

class BusService implements TransportService {
    public double calculateFare(double d) {
        return d * 2;
    }
}

class MetroService implements TransportService {
    public double calculateFare(double d) {
        return d * 3;
    }
}

class TaxiService implements TransportService {
    public double calculateFare(double d) {
        return d * 10;
    }
}

interface Sharable {
    void shareFile(String name);
}

abstract class CloudStorage {
    abstract void uploadFile(String name);
}

class GoogleDriveStorage extends CloudStorage implements Sharable {
    void uploadFile(String name) {
        System.out.println("Uploaded to Drive: " + name);
    }

    public void shareFile(String name) {
        System.out.println("Shared via Drive: " + name);
    }
}

class DropboxStorage extends CloudStorage implements Sharable {
    void uploadFile(String name) {
        System.out.println("Uploaded to Dropbox: " + name);
    }

    public void shareFile(String name) {
        System.out.println("Shared via Dropbox: " + name);
    }
}

interface Rewardable {
    void rewardPoints(int points);
}

abstract class DiscountPolicy {
    abstract double applyDiscount(double amount);
}

class FestiveDiscount extends DiscountPolicy implements Rewardable {
    double applyDiscount(double amount) {
        return amount * 0.8;
    }

    public void rewardPoints(int points) {
        System.out.println("Festive Points: " + points);
    }
}

class MembershipDiscount extends DiscountPolicy implements Rewardable {
    double applyDiscount(double amount) {
        return amount * 0.85;
    }

    public void rewardPoints(int points) {
        System.out.println("Membership Points: " + points);
    }
}

interface Downloadable {
    void download();
}

abstract class MediaContent {
    abstract void play();
}

class AudioContent extends MediaContent implements Downloadable {
    void play() {
        System.out.println("Playing Audio");
    }

    public void download() {
        System.out.println("Audio Downloaded");
    }
}

class VideoContent extends MediaContent implements Downloadable {
    void play() {
        System.out.println("Playing Video");
    }

    public void download() {
        System.out.println("Video Downloaded");
    }
}

public class Practice {
    public static void main(String[] args) {

        Payment p1 = new CreditCardPayment();
        Payment p2 = new UPIPayment();
        p1.processPayment(1000);
        p2.processPayment(2000);
        ((Refundable)p1).initiateRefund(500);

        Controllable c1 = new SmartLight("Room");
        Controllable c2 = new SmartAC("Hall");
        c1.turnOn();
        c2.turnOff();

        FareCalculator r1 = new BikeRide(1, 10);
        FareCalculator r2 = new CabRide(2, 10);
        System.out.println(r1.calculateFare());
        System.out.println(r2.calculateFare());

        Assessment a1 = new ObjectiveAssessment();
        Assessment a2 = new SubjectiveAssessment();
        a1.evaluate();
        ((ReportGenerator)a1).generateReport();

        BankTransaction t1 = new DepositTransaction();
        BankTransaction t2 = new WithdrawalTransaction();
        t1.execute(5000);
        ((Auditable)t1).log();

        Employee e1 = new PermanentEmployee(50000);
        Employee e2 = new ContractEmployee(50000);
        System.out.println(e1.calculateBonus());
        System.out.println(((Taxable)e1).tax(50000));

        TransportService ts = new TaxiService();
        System.out.println(ts.calculateFare(10));

        CloudStorage cs = new GoogleDriveStorage();
        cs.uploadFile("file.txt");
        ((Sharable)cs).shareFile("file.txt");

        DiscountPolicy d = new FestiveDiscount();
        System.out.println(d.applyDiscount(1000));
        ((Rewardable)d).rewardPoints(100);

        MediaContent m = new AudioContent();
        m.play();
        ((Downloadable)m).download();
    }
}