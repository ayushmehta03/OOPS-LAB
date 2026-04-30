package Experiment14;
import java.util.*;

class ResultBox<T> {
    private T value;

    public ResultBox(T value) {
        this.value = value;
    }

    public void display() {
        System.out.println("Value: " + value + " | Type: " + value.getClass().getSimpleName());
    }
}

class CatalogItem<T> {
    private String name;
    private T id;
    private double price;

    public CatalogItem(String name, T id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name + ", ID: " + id + ", Price: " + price);
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void display() {
        System.out.println(key + " -> " + value);
    }
}

class GenericQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public void insert(T item) {
        queue.add(item);
    }

    public void remove() {
        if (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.poll());
        } else {
            System.out.println("Queue is empty");
        }
    }

    public void display() {
        System.out.println("Queue: " + queue);
    }
}

class Enrollment<T> {
    private String studentName;
    private T ref;

    public Enrollment(String studentName, T ref) {
        this.studentName = studentName;
        this.ref = ref;
    }

    public void display() {
        System.out.println("Student: " + studentName + ", Reference: " + ref);
    }
}

class GenericStack<T> {
    private Stack<T> stack = new Stack<>();

    public void push(T item) {
        stack.push(item);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        } else {
            System.out.println("Stack empty");
        }
    }

    public void peek() {
        if (!stack.isEmpty()) {
            System.out.println("Top: " + stack.peek());
        } else {
            System.out.println("Stack empty");
        }
    }

    public void display() {
        System.out.println("Stack: " + stack);
    }
}

public class Practice {

    public static <T> void search(T[] arr, T key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                System.out.println("Found at index: " + i);
                return;
            }
        }
        System.out.println("Not found");
    }

    public static <T extends Comparable<T>> T max(T a, T b, T c) {
        T m = a;
        if (b.compareTo(m) > 0) m = b;
        if (c.compareTo(m) > 0) m = c;
        return m;
    }

    public static <T extends Number> double average(T[] arr) {
        double sum = 0;
        for (T val : arr) {
            sum += val.doubleValue();
        }
        return sum / arr.length;
    }

    public static <T> void compare(T a, T b) {
        if (a.equals(b)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }

    public static void main(String[] args) {

        ResultBox<Integer> marks = new ResultBox<>(85);
        ResultBox<Double> cgpa = new ResultBox<>(8.9);
        ResultBox<String> remarks = new ResultBox<>("Excellent");

        marks.display();
        cgpa.display();
        remarks.display();

        System.out.println("-----------");

        // 2. CatalogItem
        CatalogItem<Integer> item1 = new CatalogItem<>("Laptop", 101, 55000);
        CatalogItem<String> item2 = new CatalogItem<>("Phone", "SKU123", 20000);

        item1.display();
        item2.display();

        System.out.println("-----------");

        // 3. Pair
        Pair<String, Integer> p1 = new Pair<>("Ayush", 1200000);
        Pair<String, Integer> p2 = new Pair<>("Google", 25);

        p1.display();
        p2.display();

        System.out.println("-----------");

        // 4. Search
        Integer[] ids = {1, 2, 3, 4};
        String[] names = {"A", "B", "C"};

        search(ids, 3);
        search(names, "D");

        System.out.println("-----------");

        // 5. Max
        System.out.println("Max Int: " + max(1, 5, 3));
        System.out.println("Max Double: " + max(2.3, 5.6, 1.2));
        System.out.println("Max String: " + max("A", "Z", "M"));

        System.out.println("-----------");

        // 6. Queue
        GenericQueue<Integer> q1 = new GenericQueue<>();
        q1.insert(1);
        q1.insert(2);
        q1.display();
        q1.remove();

        GenericQueue<String> q2 = new GenericQueue<>();
        q2.insert("A1");
        q2.insert("B2");
        q2.display();

        System.out.println("-----------");

        // 7. Enrollment
        Enrollment<String> e1 = new Enrollment<>("Ayush", "CS101");
        Enrollment<Integer> e2 = new Enrollment<>("Rahul", 202);

        e1.display();
        e2.display();

        System.out.println("-----------");

        // 8. Average
        Integer[] arr1 = {1, 2, 3};
        Double[] arr2 = {2.5, 3.5};

        System.out.println("Avg Int: " + average(arr1));
        System.out.println("Avg Double: " + average(arr2));

        System.out.println("-----------");

        // 9. Compare
        compare(10, 10);
        compare("A", "B");

        System.out.println("-----------");

        // 10. Stack
        GenericStack<String> s1 = new GenericStack<>();
        s1.push("Google");
        s1.push("YouTube");
        s1.display();
        s1.peek();
        s1.pop();

        GenericStack<Integer> s2 = new GenericStack<>();
        s2.push(1);
        s2.push(2);
        s2.display();
    }
}