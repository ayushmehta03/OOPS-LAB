package Experiment11;
import java.util.*;
import java.io.*;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidPasswordException extends Exception {
    InvalidPasswordException(String msg) {
        super(msg);
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

class PaymentFailedException extends Exception {
    PaymentFailedException(String msg) {
        super(msg);
    }
}

class SeatAlreadyBookedException extends Exception {
    SeatAlreadyBookedException(String msg) {
        super(msg);
    }
}

class InvalidMarksException extends Exception {
    InvalidMarksException(String msg) {
        super(msg);
    }
}

public class Practice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 5000;
        try {
            double amt = sc.nextDouble();
            if (amt > balance) throw new InsufficientBalanceException("Insufficient Balance");
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            String user = sc.next();
            String pass = sc.next();
            if (pass.length() < 6) throw new InvalidPasswordException("Password too short");
            if (!pass.matches(".*\\d.*")) throw new InvalidPasswordException("Password must contain digit");
            System.out.println("Login Successful");
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }

        try {
            int age = sc.nextInt();
            if (age < 0 || age < 18) throw new InvalidAgeException("Invalid Age");
            System.out.println("Access Granted");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        try (FileReader fr = new FileReader("test.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error");
        }

        try {
            double amt = sc.nextDouble();
            String method = sc.next();
            if (amt <= 0) throw new PaymentFailedException("Invalid Amount");
            if (!method.equals("UPI") && !method.equals("CARD"))
                throw new PaymentFailedException("Invalid Method");
            System.out.println("Payment Success");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input Type");
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        boolean seats[][] = new boolean[3][3];
        try {
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (seats[r][c]) throw new SeatAlreadyBookedException("Already Booked");
            seats[r][c] = true;
            System.out.println("Seat Booked");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Seat");
        } catch (SeatAlreadyBookedException e) {
            System.out.println(e.getMessage());
        }

        try {
            int marks;
            while (true) {
                marks = sc.nextInt();
                if (marks < 0 || marks > 100) throw new InvalidMarksException("Invalid Marks");
                break;
            }
            System.out.println("Marks Accepted");
        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        }

        try {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number");
        }

        try {
            double sender = sc.nextDouble();
            double transfer = sc.nextDouble();
            String acc = sc.next();
            if (transfer <= 0) throw new Exception("Invalid Amount");
            if (!acc.matches("\\d{5}")) throw new Exception("Invalid Account");
            if (transfer > sender) throw new Exception("Insufficient Balance");
            System.out.println("Transfer Successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int arr[] = {10, 0, 5};
        for (int i = 0; i < 5; i++) {
            try {
                try {
                    System.out.println(10 / arr[i]);
                } catch (ArithmeticException e) {
                    System.out.println("Arithmetic Error");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index Error");
            }
        }
    }
}