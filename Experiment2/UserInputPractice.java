package Experiment2;
import java.util.Scanner;
import java.time.Year;

public class UserInputPractice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== JAVA PRACTICE QUESTIONS =====");
            System.out.println("1. Sum and Average of two numbers");
            System.out.println("2. Area and Circumference of Circle");
            System.out.println("3. Area and Perimeter of Rectangle");
            System.out.println("4. Celsius to Fahrenheit");
            System.out.println("5. Total and Percentage of 3 subjects");
            System.out.println("6. Age Calculation");
            System.out.println("7. Salary Calculation");
            System.out.println("8. Even or Odd");
            System.out.println("9. Positive / Negative / Zero");
            System.out.println("10. Swap two numbers (without third variable)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter first number: ");
                    int a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int b = sc.nextInt();
                    int sum = a + b;
                    double avg = sum / 2.0;
                    System.out.println("Sum = " + sum);
                    System.out.println("Average = " + avg);
                    break;

                // 2. Circle
                case 2:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    double area = Math.PI * r * r;
                    double circumference = 2 * Math.PI * r;
                    System.out.println("Area = " + area);
                    System.out.println("Circumference = " + circumference);
                    break;

                // 3. Rectangle
                case 3:
                    System.out.print("Enter length: ");
                    double length = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double breadth = sc.nextDouble();
                    System.out.println("Area = " + (length * breadth));
                    System.out.println("Perimeter = " + (2 * (length + breadth)));
                    break;

                // 4. Temperature
                case 4:
                    System.out.print("Enter temperature in Celsius: ");
                    double c = sc.nextDouble();
                    double f = (c * 9 / 5) + 32;
                    System.out.println("Fahrenheit = " + f);
                    break;

                // 5. Marks
                case 5:
                    System.out.print("Enter marks of Subject 1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter marks of Subject 2: ");
                    int m2 = sc.nextInt();
                    System.out.print("Enter marks of Subject 3: ");
                    int m3 = sc.nextInt();
                    int total = m1 + m2 + m3;
                    double percentage = total / 3.0;
                    System.out.println("Total Marks = " + total);
                    System.out.println("Percentage = " + percentage + "%");
                    break;

                // 6. Age
                case 6:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter year of birth: ");
                    int yob = sc.nextInt();
                    int age = Year.now().getValue() - yob;
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    break;

                // 7. Salary
                case 7:
                    System.out.print("Enter basic salary: ");
                    double salary = sc.nextDouble();
                    double hra = salary * 0.20;
                    double da = salary * 0.10;
                    double grossSalary = salary + hra + da;
                    System.out.println("HRA = " + hra);
                    System.out.println("DA = " + da);
                    System.out.println("Gross Salary = " + grossSalary);
                    break;

                // 8. Even or Odd
                case 8:
                    System.out.print("Enter number: ");
                    int num = sc.nextInt();
                    if (num % 2 == 0)
                        System.out.println("Even Number");
                    else
                        System.out.println("Odd Number");
                    break;

                // 9. Positive / Negative / Zero
                case 9:
                    System.out.print("Enter number: ");
                    int n = sc.nextInt();
                    if (n > 0)
                        System.out.println("Positive Number");
                    else if (n < 0)
                        System.out.println("Negative Number");
                    else
                        System.out.println("Zero");
                    break;

                // 10. Swap without third variable
                case 10:
                    System.out.print("Enter first number: ");
                    int x = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int y = sc.nextInt();

                    x = x + y;
                    y = x - y;
                    x = x - y;

                    System.out.println("After Swapping:");
                    System.out.println("First number = " + x);
                    System.out.println("Second number = " + y);
                    break;

                case 0:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}