package Experiment4;

import java.util.Scanner;

public class Practice2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");

        System.out.print("\nEnter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int largest = a > b ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("Largest: " + largest);

        System.out.print("\nEnter two numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.print("Choose operation (+ - * /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result: " + (x + y)); break;
            case '-': System.out.println("Result: " + (x - y)); break;
            case '*': System.out.println("Result: " + (x * y)); break;
            case '/': System.out.println("Result: " + (x / y)); break;
            default: System.out.println("Invalid Operator");
        }

        System.out.print("\nEnter N: ");
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++)
            System.out.print(i + " ");

        int sum = 0, i = 1;
        while (i <= N) {
            sum += i;
            i++;
        }
        System.out.println("\nSum: " + sum);

        System.out.print("\nEnter a number to check prime: ");
        int p = sc.nextInt();
        boolean prime = true;
        if (p <= 1) prime = false;
        for (i = 2; i <= p / 2; i++) {
            if (p % i == 0) {
                prime = false;
                break;
            }
        }
        System.out.println(prime ? "Prime" : "Not Prime");

        System.out.print("\nEnter number to reverse: ");
        int r = sc.nextInt();
        int rev = 0;
        while (r != 0) {
            rev = rev * 10 + r % 10;
            r /= 10;
        }
        System.out.println("Reversed: " + rev);

        System.out.print("\nEnter number for table: ");
        int t = sc.nextInt();
        int k = 1;
        do {
            System.out.println(t + " x " + k + " = " + (t * k));
            k++;
        } while (k <= 10);

        System.out.print("\nEnter number to count digits: ");
        int d = sc.nextInt();
        int count = 0;
        while (d != 0) {
            count++;
            d /= 10;
        }
        System.out.println("Digits: " + count);

        System.out.print("\nEnter rows for star pattern: ");
        int rows = sc.nextInt();
        for (i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        sc.close();
}
}
