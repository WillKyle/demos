package com.will.lucifer.algorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * 计算岛屿的数量；
 * 1为陆地，0为海洋。
 * 只计算上下左右相邻，不计对角线。
 * 给点一个矩阵，计算矩阵表示的岛屿的个数。
 *
 * 第一行表示函数和列数。
 */
@Slf4j
public class CountIslands {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            String in = scan.nextLine();
            System.out.println(in);

        }
    }

    @Test
    public void func(){
        //5行4列；
        int[][] arr = {
            {1,0,1,0},
            {1,1,1,1},
            {1,0,0,0},
            {0,1,0,1},
            {0,0,0,1}
        };
        Set<String> set = getSet(arr);
        int count = 0;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 3; j++) {
                String index = i + "=" + j;
                if (set.contains(index)){
                    deal(set, i, j);
                    log.info("set="+set);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private void deal(Set<String> set, int i, int j) {
        String index = i + "=" + j;
        set.remove(index);
        String up = (i - 1) + "=" + j;
        String down = (i + 1) + "=" + j;
        String left = i + "=" + (j - 1);
        String right = i + "=" + (j + 1);
        if (set.contains(up)) {
            log.info("up-->" + up);
            String[] split = up.split("=");
            deal(set, Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        if (set.contains(down)) {
            log.info("down-->" + down);
            String[] split = down.split("=");
            deal(set, Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        if (set.contains(left)) {
            log.info("left-->" + left);
            String[] split = left.split("=");
            deal(set, Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        if (set.contains(right)) {
            log.info("right-->" + right);
            String[] split = right.split("=");
            deal(set, Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
    }

    private Set<String> getSet(int[][] arr){
        Set<String> set = new HashSet<>();
        for (int i = 0; i<=4; i++){
            for (int j = 0; j<=3; j++){
                String index = i + "=" + j;
                // log.info("arr[{}][{}]==={}", i , j, arr[i][j]);
                if (arr[i][j]==1){
                    set.add(index);
                }
            }
        }
        System.out.println(set);
        return set;
    }
}
