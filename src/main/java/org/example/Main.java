package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input sides of triangle:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String result = triangleChecker(a, b, c);
        System.out.println(result);

    }

    public static String triangleChecker(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "no triangle";
        }
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                return "equilateral";
            } else if (a == b || b == c || a == c) {
                return "isosceles";
            } else {
                return "scalene";
            }
        } else {
            return "no triangle";
        }
    }
}