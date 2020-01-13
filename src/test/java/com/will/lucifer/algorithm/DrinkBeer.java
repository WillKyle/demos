package com.will.lucifer.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * 10块钱能喝几瓶酒 2块钱一瓶； 2个瓶子换一瓶； 4个盖子换一瓶。
 */
@Slf4j
public class DrinkBeer {

    public static void main(String[] args) {
        int money = 10;
        int total = money/2;
        System.out.println(total(total,total,total));
    }

    private static int total(int total, int bo, int lip) {
        //换得瓶数
        int add = bo / 2 + lip / 4;
        total += add;
        //剩余瓶子数
        bo = bo % 2 + add;
        //剩余盖子数
        lip = lip % 4 + add;
        if (bo>=2||lip>=4){
            return total(total, bo, lip);
        }else{
            return total;
        }
    }

}
