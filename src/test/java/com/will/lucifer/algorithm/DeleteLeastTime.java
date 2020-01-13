package com.will.lucifer.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * 不考虑非法输入，删除出现次数最少的字符。 次数一样，都删除。 其他字符不改变其顺序。
 */
@Slf4j
public class DeleteLeastTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String in = scanner.nextLine();
            Map<Character, Integer> index = toMap(in);
            Set<Entry<Character, Integer>> entries = index.entrySet();
            Optional<Entry<Character, Integer>> option = entries.stream()
                .min(Comparator.comparing(Entry::getValue));
            if (!option.isPresent()) {
                return;
            }
            int leastTime = option.get().getValue();
            List<Character> li = entries.stream().filter(en -> en.getValue() == leastTime)
                .map(Entry::getKey).collect(Collectors.toList());
            for (Character ch : li) {
                in = in.replace(ch.toString(), "");
            }
            System.out.println(in);
        }
    }

    private static Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> index = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            index.merge(ch, 1, Integer::sum);
        }
        return index;
    }
}
