//Question1-1 : Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures

// Thinking: what exactly is the character set, is it the ASCII or just a-z ?

// Big-O : O(n)

public class Solution {

    // use boolean array to represent different characters
    public static boolean isUniqueChar(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];

        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) return false;
            else {
                charSet[val] = true;
            }
        }
        return true;
    }

    // use bit manipulation to save space
    public static boolean isUniqueChar2(String str) {
        if (str.length() > 128) return false;

        int[] charSet = new int[4];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            int idx = val / Integer.SIZE;
            int shift = val % Integer.SIZE;
            if ((charSet[idx] & (1 << shift)) != 0) {
                return false;
            } else {
                charSet[idx] |= (1 << shift);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* the output should be
           abcdef:true true
           :true true
            :true true
           abca:false false
        */
        String[] words = {"abcdef", "", " ", "  ", "abca"};
        for (String word : words) {
            System.out.println(word + ":" + isUniqueChar(word) + " " + isUniqueChar2(word));
        }
    }
}
