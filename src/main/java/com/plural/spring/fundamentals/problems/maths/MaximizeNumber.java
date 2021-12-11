package com.plural.spring.fundamentals.problems.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximizeNumber {

    public String maxValue(String n, int x) {
        boolean isNegative = n.charAt(0) == '-';
        int position = n.length();
        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '-') continue;
            int num = n.charAt(i) - '0';
            if (isNegative && num > x || !isNegative && num < x) position = i;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < position; i++) answer.append(n.charAt(i));
        answer.append(x);
        if (position < n.length()) {
            for (int i = position; i < n.length(); i++) answer.append(n.charAt(i));
        }
        new PriorityQueue<Integer>((o1, o2) -> 0);
        return answer.toString();
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    private Queue<Student> queue;

    public Priorities() {
        queue = new PriorityQueue<Student>((Student s1, Student s2) -> {
            if (s1.getName().equals(s2.getName())
                    && s1.getCGPA() == s2.getCGPA()) {
                return Integer.compare(s1.getID(), s2.getID());
            } else if (s1.getCGPA() == s2.getCGPA()) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return Double.compare(s1.getCGPA(), s2.getCGPA());
            }
        });
    }

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            String[] args = event.split(" ");
            if (args.length == 4) {
                queue.add(new Student(Integer.parseInt(args[3]), args[1], Double.parseDouble(args[2])));
            } else {
                Student served = queue.poll();
                System.out.println(served.getName());
            }
        }
        return new ArrayList<Student>(queue);
    }
}