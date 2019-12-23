package com.will.lucifer.prime;

import java.util.Scanner;

public class CheckPrime1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int in = scan.nextInt();
            int count = 0;
            for (int i = 2; i <= in; i++) {
                if (isPrime3(i)) {
                    System.out.println(i);
                    count++;
                }
            }
            System.out.println("总数=" + count);
        }
    }

    private static boolean isPrime1(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrime2(int num) {
        int boun = num / 2;
        for (int i = 2; i <= boun; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrime3(int num) {
        int boun = (int) Math.sqrt(num);
        for (int i = 2; i <= boun; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
