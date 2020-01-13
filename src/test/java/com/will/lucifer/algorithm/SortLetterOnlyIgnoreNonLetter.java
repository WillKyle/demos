package com.will.lucifer.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * 输入字符串，按要求排序：
 * 字符从A-Z排列，不区分大小写。
 * 同一个字母大小写同时存在，不改变输入顺序。
 * 非英文字母不改变其顺序。
 */
@Slf4j
public class SortLetterOnlyIgnoreNonLetter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String in = scanner.nextLine();
            char[] arr = in.toCharArray();
            String sort = sort(arr);
            System.out.println(sort);
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                char cur = arr[i];
                if ((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z')) {
                    arr[i] = sort.charAt(index++);
                }
            }
            System.out.println(new String(arr));
        }
    }

    private static String sort(char[] arr) {
        Map<Character, String> map = new HashMap<>();
        for (char ch : arr) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                char key = Character.toLowerCase(ch);
                if (map.get(key) == null) {
                    map.put(key, ch + "");
                } else {
                    map.put(key, map.get(key) + ch);
                }
            }
        }
        System.out.println("map=" + map);
        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            String temp = map.get((char) i);
            if (temp != null) {
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
