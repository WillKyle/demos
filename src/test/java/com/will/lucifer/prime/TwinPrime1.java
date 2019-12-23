package com.will.lucifer.prime;

import org.junit.Test;

import java.util.BitSet;
import java.util.Scanner;

public class TwinPrime1 {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        BitSet bs = new BitSet(100000001);
        bs.set(2);
        bs.set(3);
        for (int i = 5; i <= 100000000; i += 6) {
            if (isPrime1(i)) {
                System.out.println(i);
                bs.set(i);
            }
        }
        for (int i = 7; i <= 100000000; i += 6) {
            if (isPrime1(i)) {
                System.out.println(i);
                bs.set(i);
            }
        }
        System.out.println(System.currentTimeMillis() - s1);
        while (scan.hasNextInt()) {
            long s2 = System.currentTimeMillis();
            int in = scan.nextInt();
            int count = 0;
            for (int i = 5; i <= in; i += 2) {
                if (bs.get(i) && bs.get(i - 2)) {
                    count++;
                    System.out.println("(" + (i - 2) + "," + i + ")");
                }
            }
            System.out.println("总数=" + count);
            System.out.println(System.currentTimeMillis() - s2);
        }
    }

    private static boolean isPrime1(int num) {
        int boun = (int) Math.sqrt(num);
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 5; i <= boun; i += 6) {
            if (num % i == 0) {
                return false;
            }
        }
        for (int i = 7; i <= boun; i += 6) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void func() {
        System.out.println(isPrime1(99999587));
        System.out.println(isPrime1(99999589));
    }
}
