package Experiment3;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte b = 10;
        short s = 100;
        int i = 1000;
        long l = 100000L;
        float f = 10.5f;
        double d = 99.99;
        char c = 'A';
        boolean bool = true;

        System.out.println("Primitive Data Types:");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);

        System.out.print("\nEnter two integers: ");
        int a = sc.nextInt();
        int x = sc.nextInt();

        System.out.println("Addition: " + (a + x));
        System.out.println("Subtraction: " + (a - x));
        System.out.println("Multiplication: " + (a * x));
        System.out.println("Division: " + (a / x));
        System.out.println("Modulus: " + (a % x));

        System.out.print("\nEnter three numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        System.out.println("n1 > n2 && n1 > n3: " + (n1 > n2 && n1 > n3));
        System.out.println("n1 > n2 || n1 > n3: " + (n1 > n2 || n1 > n3));

        int num = 5;
        System.out.println("\nInitial value: " + num);
        System.out.println("Pre-increment: " + (++num));
        System.out.println("Post-increment: " + (num++));
        System.out.println("After increment: " + num);
        System.out.println("Pre-decrement: " + (--num));
        System.out.println("Post-decrement: " + (num--));
        System.out.println("After decrement: " + num);

        int result = 10 + 5 * 2;
        System.out.println("\nExpression 10 + 5 * 2 = " + result);

        sc.close();
    }
}
