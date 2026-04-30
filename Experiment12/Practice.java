package Experiment12;
import java.util.*;
import java.util.concurrent.*;

class DownloadTask extends Thread {
    String name;
    DownloadTask(String name) { this.name = name; }

    public void run() {
        for (int i = 0; i <= 100; i += 25) {
            synchronized (System.out) {
                System.out.println(name + " Download: " + i + "%");
            }
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }
}

class BankAccount {
    int balance = 1000;

    synchronized void deposit(int amt) {
        balance += amt;
    }

    synchronized void withdraw(int amt) {
        if (balance >= amt) balance -= amt;
    }
}

class TrafficSignal extends Thread {
    String name;

    TrafficSignal(String name) { this.name = name; }

    public void run() {
        try {
            System.out.println(name + " Green");
            Thread.sleep(200);
            System.out.println(name + " Yellow");
            Thread.sleep(200);
            System.out.println(name + " Red");
        } catch (Exception e) {}
    }
}

class OrderProcessor extends Thread {
    BlockingQueue<Integer> queue;

    OrderProcessor(BlockingQueue<Integer> q) { this.queue = q; }

    public void run() {
        try {
            while (true) {
                Integer order = queue.poll(1, TimeUnit.SECONDS);
                if (order == null) break;
                System.out.println(Thread.currentThread().getName() + " processed order " + order);
            }
        } catch (Exception e) {}
    }
}

class PrimeTask extends Thread {
    int start, end;
    int count = 0;

    PrimeTask(int s, int e) { start = s; end = e; }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) count++;
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}

class ChatUser extends Thread {
    String name;

    ChatUser(String name) { this.name = name; }

    public void run() {
        synchronized (System.out) {
            System.out.println(name + ": Hello!");
        }
    }
}

class Buffer {
    Queue<Integer> q = new LinkedList<>();
    int size = 5;

    synchronized void produce(int val) throws InterruptedException {
        while (q.size() == size) wait();
        q.add(val);
        System.out.println("Produced: " + val);
        notify();
    }

    synchronized void consume() throws InterruptedException {
        while (q.isEmpty()) wait();
        int val = q.poll();
        System.out.println("Consumed: " + val);
        notify();
    }
}

class Producer extends Thread {
    Buffer b;
    Producer(Buffer b) { this.b = b; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try { b.produce(i); } catch (Exception e) {}
        }
    }
}

class Consumer extends Thread {
    Buffer b;
    Consumer(Buffer b) { this.b = b; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try { b.consume(); } catch (Exception e) {}
        }
    }
}

class Stock {
    Map<String, Integer> data = new HashMap<>();

    synchronized void update(String name, int price) {
        data.put(name, price);
    }

    synchronized void display() {
        System.out.println(data);
    }
}

class StockUpdater extends Thread {
    Stock s;
    String name;

    StockUpdater(Stock s, String name) {
        this.s = s;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            s.update(name, new Random().nextInt(1000));
        }
    }
}

class FileProcessor extends Thread {
    String file;

    FileProcessor(String file) { this.file = file; }

    public void run() {
        try {
            Thread.sleep(200);
            System.out.println(file + " processed");
        } catch (Exception e) {}
    }
}

class PriorityTask extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}

public class Practice {
    public static void main(String[] args) throws Exception {

        new DownloadTask("File1").start();
        new DownloadTask("File2").start();

        BankAccount acc = new BankAccount();
        Thread t1 = new Thread(() -> acc.deposit(500));
        Thread t2 = new Thread(() -> acc.withdraw(300));
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Balance: " + acc.balance);

        new TrafficSignal("Signal1").start();

        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);
        for (int i = 1; i <= 5; i++) q.add(i);
        new OrderProcessor(q).start();

        PrimeTask p1 = new PrimeTask(1, 50);
        PrimeTask p2 = new PrimeTask(51, 100);
        p1.start(); p2.start();
        p1.join(); p2.join();
        System.out.println("Total primes: " + (p1.count + p2.count));

        new ChatUser("User1").start();
        new ChatUser("User2").start();

        Buffer b = new Buffer();
        new Producer(b).start();
        new Consumer(b).start();

        Stock s = new Stock();
        new StockUpdater(s, "AAPL").start();
        new StockUpdater(s, "GOOG").start();
        Thread.sleep(300);
        s.display();

        long start = System.currentTimeMillis();
        FileProcessor f1 = new FileProcessor("file1");
        FileProcessor f2 = new FileProcessor("file2");
        f1.start(); f2.start();
        f1.join(); f2.join();
        System.out.println("Time: " + (System.currentTimeMillis() - start));

        PriorityTask pt1 = new PriorityTask();
        PriorityTask pt2 = new PriorityTask();
        pt1.setPriority(Thread.MIN_PRIORITY);
        pt2.setPriority(Thread.MAX_PRIORITY);
        pt1.start(); pt2.start();
    }
}