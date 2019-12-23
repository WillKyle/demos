package com.will.lucifer.prime;

import java.util.BitSet;
import java.util.Scanner;

public class TwinPrime2 {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        BitSet bs = new BitSet(100000001);
        bs.set(2);
        bs.set(3);
        bs.set(5);
        bs.set(7);
        for (int i = 11; i < 100000001; i += 2) {
            calculate(i, bs);
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

    private static void calculate(int num, BitSet bs) {
        int boun = (int) Math.sqrt(num);
        int index = bs.nextSetBit(3);
        while (index != -1 && index <= boun) {
            if (num % index == 0)
                return;
            index = bs.nextSetBit(index + 1);
        }
        System.out.println(num);
        bs.set(num);
    }
}
