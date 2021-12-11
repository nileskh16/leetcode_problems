package com.plural.spring.fundamentals.interview;

import com.plural.spring.fundamentals.utils.BoundedBufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public void findThirdLargestNumber(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>((Integer a, Integer b) -> Integer.compare(b, a));
        for (int num : arr) {
            queue.add(num);
        }
        int count = 0;
        while (count != 2) {
            queue.poll();
            count++;
        }
        System.out.println(queue.peek());
    }

    public void countCharCount(String arg) {
        if (arg == null || arg.isEmpty()) return;
        Map<Character, Integer> charMap = new HashMap<>(arg.length());
        for (char ch : arg.toLowerCase().toCharArray()) {
            charMap.putIfAbsent(ch, 0);
            charMap.put(ch, charMap.get(ch) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.findThirdLargestNumber(new int[]{4, 9, 1, 6, 8});
        solution.countCharCount("hHpLLpllooP");
        ProcessString stringProcessor = new ProcessString() {
            @Override
            public void reverseString(String s) {
                System.out.println(new StringBuilder(s).reverse());
            }
        };
        stringProcessor.reverseString("Hello");
        MobileCalculator calculator = new MobileCalculator(4, 5);
        System.out.println(calculator.operate());
        System.out.printf("Formatted string -> '%s'%n", new String(new char[]{'h', 'e', 'l', 'l', 'o'}, 0, 0));
        runOriginalBufferedReader();
        runCustomBufferedReader();
        String tar = "Happy";
        System.out.println(tar.substring(4));
        System.out.println(tar.substring(5));
    }

    public static interface ProcessString {
        void reverseString(String s);
    }

    static class BasicCalculator {
        protected int a;
        protected int b;

        protected BasicCalculator(int a, int b) {
            this.a = a;
            this.b = b;
        }

        protected int add() {
            return a + b;
        }
    }

    static class MobileCalculator extends BasicCalculator {
        int a;
        int b;

        public MobileCalculator(int a, int b) {
            super(a, b);
            this.a = a * 2;
            this.b = b * 2;
        }

        public int adds() {
            return a * b;
        }

        public int operate() {
            return add();
        }
    }

    private static void runOriginalBufferedReader() {
        int lines = 0;
        String line;
        try (FileReader is = new FileReader("C:\\Users\\nswami\\Documents\\NiceCode\\sp\\clientadapter\\src\\test\\resources\\input\\user_data.CSV");
             BufferedReader reader = new BufferedReader(is)) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lines++;
            }
            System.out.println("Lines found in file " + lines);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void runCustomBufferedReader() {
        int lines = 0;
        String line;
        try (FileReader is = new FileReader("C:\\Users\\nswami\\Documents\\NiceCode\\sp\\clientadapter\\src\\test\\resources\\input\\user_data.CSV");
             BufferedReader reader = new BoundedBufferedReader(is)) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lines++;
            }
            System.out.println("Lines found in file " + lines);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
