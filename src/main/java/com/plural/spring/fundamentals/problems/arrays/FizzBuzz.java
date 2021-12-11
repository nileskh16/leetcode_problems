package com.plural.spring.fundamentals.problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String value = "";
            if (i % 15 == 0) value = "FizzBuzz";
            else if (i % 5 == 0) value = "Buzz";
            else if (i % 3 == 0) value = "Fizz";
            else value = String.valueOf(i);
            answer.add(i-1, value);
        }
        return answer;
    }
    
    static class A {
        A() {
            System.out.println("Constructor A");
        }

        void run() {
            System.out.println("A is running");
        }
    }

    static class B extends A {

        B() {
            System.out.println("Constructor B");
        }

        @Override
        public void run() {
            System.out.println("B is running");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.run();
        b.run();
    }
}
