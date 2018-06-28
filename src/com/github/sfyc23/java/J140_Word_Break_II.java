package com.github.sfyc23.java;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class J140_Word_Break_II {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        String s = "catsanddog";

//        List<String> list = Arrays.asList(new String[]{"aaaa", "aa", "a"});
//        String s = "aaaaaaa";

        System.out.println(wordBreak(s, list));

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return myDfs(wordDict, new HashMap<>(), s);
    }


    public static List<String> myDfs(List<String> wordDict, Map<String, List<String>> map, String s) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = myDfs(wordDict, map, s.substring(word.length()));
                for (String sub : subList){
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }

            }
        }
        map.put(s, result);
        return result;
    }
}
