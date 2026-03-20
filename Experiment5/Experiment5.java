package Experiment5;
import java.util.*;

public class Experiment5 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. WiFi Usage Analytics");
            System.out.println("2. Parking Lot System");
            System.out.println("3. Stock Market Analyzer");
            System.out.println("4. Cinema Seat Booking");
            System.out.println("5. ICU Bed Tracker");
            System.out.println("6. Shopping Cart Billing");
            System.out.println("7. Election Analysis");
            System.out.println("8. Warehouse Search");
            System.out.println("9. Temperature Heatmap");
            System.out.println("10. Student Performance");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: wifiUsage(); break;
                case 2: parkingLot(); break;
                case 3: stockMarket(); break;
                case 4: cinema(); break;
                case 5: icu(); break;
                case 6: shopping(); break;
                case 7: election(); break;
                case 8: search(); break;
                case 9: temperature(); break;
                case 10: student(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    // 1. WiFi Usage
    static void wifiUsage() {
        int[] usage = new int[24];
        int total = 0, max = 0, hour = 0;

        System.out.println("Enter 24 hourly usage:");
        for (int i = 0; i < 24; i++) {
            usage[i] = sc.nextInt();
            total += usage[i];

            if (usage[i] > max) {
                max = usage[i];
                hour = i;
            }
        }

        System.out.println("Total: " + total);
        System.out.println("Average: " + (total / 24.0));
        System.out.println("Max at hour: " + hour);
    }

    // 2. Parking Lot
    static void parkingLot() {
        int[][] parking = new int[5][4];

        System.out.print("Enter row and column: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (parking[r][c] == 0) {
            parking[r][c] = 1;
            System.out.println("Booked!");
        } else {
            System.out.println("Already occupied!");
        }

        int occ = 0, vac = 0;

        for (int[] row : parking) {
            for (int val : row) {
                if (val == 1) occ++;
                else vac++;
            }
        }

        System.out.println("Occupied: " + occ);
        System.out.println("Vacant: " + vac);
    }

    // 3. Stock Market
    static void stockMarket() {
        int[] prices = new int[7];
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        System.out.println("Enter 7 prices:");
        for (int i = 0; i < 7; i++) {
            prices[i] = sc.nextInt();
            sum += prices[i];

            if (prices[i] > max) max = prices[i];
            if (prices[i] < min) min = prices[i];
        }

        System.out.println("Average: " + (sum / 7.0));
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        if (prices[6] > prices[0])
            System.out.println("Trend: Increasing");
        else
            System.out.println("Trend: Decreasing");
    }

    // 4. Cinema
    static void cinema() {
        int[][] seats = new int[5][5];

        System.out.print("Enter row and column: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (seats[r][c] == 0) {
            seats[r][c] = 1;
            System.out.println("Seat booked!");
        } else {
            System.out.println("Already booked!");
        }

        for (int[] row : seats) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // 5. ICU
    static void icu() {
        int[][] beds = {
            {1, 0, 1},
            {0, 1, 1}
        };

        int total = 0, occ = 0;

        for (int[] row : beds) {
            for (int val : row) {
                total++;
                if (val == 1) occ++;
            }
        }

        System.out.println("Occupied: " + occ);
        System.out.println("Available: " + (total - occ));
        System.out.println("Occupancy %: " + (occ * 100.0 / total));
    }

    // 6. Shopping
    static void shopping() {
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double total = 0, max = 0;

        for (int i = 0; i < n; i++) {
            double price = sc.nextDouble();
            total += price;

            if (price > max) max = price;
        }

        if (total > 5000) total *= 0.9;

        System.out.println("Most Expensive: " + max);
        System.out.println("Final Amount: " + total);
    }

    // 7. Election
    static void election() {
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        int[] votes = new int[n];
        int total = 0, max = 0, winner = 0;

        for (int i = 0; i < n; i++) {
            votes[i] = sc.nextInt();
            total += votes[i];

            if (votes[i] > max) {
                max = votes[i];
                winner = i;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Candidate " + i + ": " + (votes[i] * 100.0 / total) + "%");
        }

        System.out.println("Winner: Candidate " + winner);
    }

    // 8. Search
    static void search() {
        int[] arr = {101, 102, 103, 104};

        System.out.print("Enter ID to search: ");
        int key = sc.nextInt();

        int comp = 0;

        for (int i = 0; i < arr.length; i++) {
            comp++;
            if (arr[i] == key) {
                System.out.println("Found at index " + i);
                break;
            }
        }

        System.out.println("Comparisons: " + comp);
    }

    // 9. Temperature
    static void temperature() {
        int[][] temp = new int[7][24];

        int max = Integer.MIN_VALUE;
        int hottestDay = 0;
        int maxSum = 0;

        for (int i = 0; i < 7; i++) {
            int sum = 0;

            for (int j = 0; j < 24; j++) {
                temp[i][j] = (int)(Math.random() * 40);
                sum += temp[i][j];

                if (temp[i][j] > max)
                    max = temp[i][j];
            }

            if (sum > maxSum) {
                maxSum = sum;
                hottestDay = i;
            }
        }

        System.out.println("Highest Temp: " + max);
        System.out.println("Hottest Day: " + hottestDay);
    }

    // 10. Student
    static void student() {
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int sum = 0, max = 0, min = 100;

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
            sum += marks[i];

            if (marks[i] > max) max = marks[i];
            if (marks[i] < min) min = marks[i];
        }

        double avg = sum / (double)n;
        int count = 0;

        for (int m : marks) {
            if (m > avg) count++;
        }

        System.out.println("Average: " + avg);
        System.out.println("Highest: " + max);
        System.out.println("Lowest: " + min);
        System.out.println("Above Avg: " + count);
    }
}