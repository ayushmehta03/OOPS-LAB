package Experiment15;
import java.util.*;
import java.util.stream.*;

interface Bonus {
    double apply(double salary);
}

interface Bill {
    double compute(double units);
}

interface Formatter {
    String format(String msg);
}

interface Discount {
    double apply(double amount);
}

interface Operation {
    double apply(double a, double b);
}

class Product {
    String name;
    double price;
    double rating;

    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String toString() {
        return name + " " + price + " " + rating;
    }
}

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Practice {
    public static void main(String[] args) {

        List<Integer> marks = Arrays.asList(45, 67, 89, 34, 76);
        marks.stream().filter(m -> m > 60).forEach(System.out::println);

        List<Employee> emp = Arrays.asList(
                new Employee("A", 50000),
                new Employee("B", 60000)
        );

        Bonus fixed = s -> s * 0.10;
        Bonus performance = s -> s * 0.20;
        Bonus special = s -> s + 5000;

        emp.forEach(e -> {
            System.out.println(e.name + " " + e.salary + " -> " + (e.salary + fixed.apply(e.salary)));
            System.out.println(e.name + " " + e.salary + " -> " + (e.salary + performance.apply(e.salary)));
            System.out.println(e.name + " " + e.salary + " -> " + special.apply(e.salary));
        });

        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 20000, 4.5));
        products.add(new Product("Laptop", 60000, 4.8));
        products.add(new Product("Tablet", 15000, 4.2));

        products.sort((a, b) -> Double.compare(a.price, b.price));
        products.forEach(System.out::println);

        products.sort((a, b) -> Double.compare(a.rating, b.rating));
        products.forEach(System.out::println);

        products.sort((a, b) -> a.name.compareTo(b.name));
        products.forEach(System.out::println);

        Bill domestic = u -> u * 5;
        Bill commercial = u -> u * 8;
        Bill peak = u -> u * 10;

        System.out.println(domestic.compute(100));
        System.out.println(commercial.compute(100));
        System.out.println(peak.compute(100));

        List<Integer> attendance = Arrays.asList(75, 60, 85, 40);
        attendance.stream().filter(a -> a >= 75).forEach(a -> System.out.println("Eligible " + a));
        attendance.stream().filter(a -> a < 75).forEach(a -> System.out.println("Not Eligible " + a));

        Formatter upper = s -> s.toUpperCase();
        Formatter lower = s -> s.toLowerCase();
        Formatter title = s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        Formatter time = s -> s + " " + new Date();

        System.out.println(upper.format("hello"));
        System.out.println(lower.format("HELLO"));
        System.out.println(title.format("java"));
        System.out.println(time.format("msg"));

        double amount = 1000;

        Discount festive = a -> a * 0.9;
        Discount student = a -> a * 0.85;
        Discount gst = a -> a * 1.18;

        System.out.println(festive.apply(amount));
        System.out.println(student.apply(amount));
        System.out.println(gst.apply(amount));

        new Thread(() -> System.out.println("Notification")).start();
        new Thread(() -> System.out.println("Update")).start();
        new Thread(() -> System.out.println("Background Task")).start();

        List<String> feedback = Arrays.asList(
                "excellent service",
                "late delivery",
                "need refund",
                "excellent support"
        );

        feedback.stream().filter(f -> f.contains("excellent")).forEach(System.out::println);
        feedback.stream().filter(f -> f.contains("late")).forEach(System.out::println);
        feedback.stream().filter(f -> f.contains("refund")).forEach(System.out::println);

        Operation add = (a, b) -> a + b;
        Operation sub = (a, b) -> a - b;
        Operation mul = (a, b) -> a * b;
        Operation div = (a, b) -> a / b;

        double x = 10, y = 5;

        System.out.println(add.apply(x, y));
        System.out.println(sub.apply(x, y));
        System.out.println(mul.apply(x, y));
        System.out.println(div.apply(x, y));
    }
}