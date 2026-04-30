package Experiment6;

import java.util.*;

public class Experiment6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Password Strength Evaluation System");
        String password = sc.nextLine();
        evaluatePassword(password);

        System.out.println("\n2. Email Address Validation Module");
        String email = sc.nextLine();
        validateEmail(email);

        System.out.println("\n3. Chat Message Content Analyzer");
        String sentence = sc.nextLine();
        analyzeText(sentence);

        System.out.println("\n4. Spam Keyword Detection System");
        String message = sc.nextLine();
        detectSpam(message);

        System.out.println("\n5. Username Generation Utility");
        String fullName = sc.nextLine();
        generateUsername(fullName);

        System.out.println("\n6. Enhanced Palindrome Verification Tool");
        String palindromeInput = sc.nextLine();
        checkPalindrome(palindromeInput);

        System.out.println("\n7. Basic Text Encryption (Caesar Cipher)");
        String text = sc.nextLine();
        encryptText(text);

        System.out.println("\n8. DNA Sequence Validation System");
        String dna = sc.nextLine();
        validateDNA(dna);

        System.out.println("\n9. Word Frequency Counter");
        String paragraph = sc.nextLine();
        wordFrequency(paragraph);

        System.out.println("\n10. Resume Information Extractor");
        String resume = sc.nextLine();
        extractResume(resume);
    }

    static void evaluatePassword(String password) {
        boolean upper = false, lower = false, digit = false, special = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isLowerCase(c)) lower = true;
            else if (Character.isDigit(c)) digit = true;
            else special = true;
        }
        if (password.length() < 8) {
            System.out.println("Weak Password");
        } else if (upper && lower && digit && special) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Moderate Password");
        }
    }

    static void validateEmail(String email) {
        if (email.contains("@") && email.indexOf("@") > 0 && email.indexOf("@") < email.length() - 1) {
            String[] parts = email.split("@");
            if (parts.length == 2 && parts[1].contains(".")) {
                System.out.println("Valid Email");
                return;
            }
        }
        System.out.println("Invalid Email");
    }

    static void analyzeText(String text) {
        String[] words = text.trim().split("\\s+");
        int digits = 0, special = 0;
        String longest = "";

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) digits++;
            else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) special++;
        }

        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }

        System.out.println("Words: " + words.length);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + special);
        System.out.println("Longest Word: " + longest);
    }

    static void detectSpam(String message) {
        String msg = message.toLowerCase();
        if (msg.contains("free") || msg.contains("win") || msg.contains("urgent") || msg.contains("offer")) {
            System.out.println("Warning: Potential Spam");
        } else {
            System.out.println("Message is Safe");
        }
    }

    static void generateUsername(String name) {
        String[] parts = name.trim().toLowerCase().split("\\s+");
        if (parts.length >= 2) {
            System.out.println(parts[0] + "_" + parts[parts.length - 1]);
        } else {
            System.out.println(parts[0]);
        }
    }

    static void checkPalindrome(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        if (cleaned.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    static void encryptText(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + 2) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + 2) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        System.out.println(result.toString());
    }

    static void validateDNA(String dna) {
        String seq = dna.toUpperCase();
        if (seq.matches("[ATGC]+")) {
            System.out.println("Valid DNA Sequence");
        } else {
            System.out.println("Invalid DNA Sequence");
        }
    }

    static void wordFrequency(String text) {
        text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        String[] words = text.split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String word : map.keySet()) {
            System.out.println(word + " : " + map.get(word));
        }
    }

    static void extractResume(String text) {
        String[] parts = text.split(",");
        for (String part : parts) {
            String p = part.trim();
            if (p.toLowerCase().contains("name")) {
                System.out.println("Name: " + p.split(":")[1].trim());
            } else if (p.toLowerCase().contains("email")) {
                System.out.println("Email: " + p.split(":")[1].trim());
            } else if (p.toLowerCase().contains("phone")) {
                System.out.println("Phone: " + p.split(":")[1].trim());
            }
        }
    }
}