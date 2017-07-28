package com.github.sfyc23.java;

import java.util.*;

/**
 * 49. Group Anagrams
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class J49_Group_Anagrams {

    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String strSort = new String(cc);

            if (map.containsKey(strSort)) {
                map.get(strSort).add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(strSort, tempList);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}
