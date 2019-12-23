package com.will.lucifer.prime;

import java.util.Scanner;

public class CheckPrime2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int in = scan.nextInt();
            int count = 0;
            for (int i = 2; i <= in; ) {
                if (i == 2) {
                    System.out.println(i);
                    count++;
                    i += 1;
                } else {
                    if (isPrime1(i)) {
                        System.out.println(i);
                        count++;
                    }
                    i += 2;
                }
            }
            System.out.println("总数=" + count);
        }
    }

    private static boolean isPrime1(int num) {
        int boun = (int) Math.sqrt(num);
        if (num == 2)
            return true;
        for (int i = 3; i <= boun; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
