package rc.cracking;

import java.util.BitSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }


//////////// Arrays & Strings 1.1 //////////////
    //my paper solution
    public static boolean unique(String test) {
        HashMap<Character,Integer> chars = new HashMap<Character, Integer>();
        char[] testChars = test.toCharArray();

        for (char ch: testChars) {
            if (chars.containsKey(ch)) return false;
            chars.put(ch,1);
        }
        return true;
    }
    //alter my paper solution to be less redundant with the charArray
    public static boolean unique2(String test) {
        HashMap<Character,Integer> chars = new HashMap<Character, Integer>();

        for (int i = 0; i<test.length();i++) {
            char ch = test.charAt(i);
            if (chars.containsKey(ch)) return false;
            chars.put(ch,1);
        }
        return true;
    }
    //book solution using an int to represent bit flags for the presence of each letter
    public static boolean unique3(String test) {
        int checker = 0;
        for (int i = 0; i<test.length();i++) {
            int testChar = test.charAt(i) - 'a';
            if ((checker & (1 << testChar)) > 0) return false;
            checker |= (1 << testChar);
        }
        return true;
    }
    //my version of boo solution using BitSet just for fun
    public static boolean unique4(String test) {
        BitSet checker = new BitSet();
        for (int i = 0; i<test.length();i++) {
            int testChar = test.charAt(i) - 'a';
            if (checker.get(testChar)) return false;
            checker.set(testChar);
        }
        return true;
    }
}
