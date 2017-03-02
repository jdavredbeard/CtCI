package rc.cracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

import static jdk.nashorn.internal.objects.Global.Infinity;

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
    //my version of book solution using BitSet just for fun
    public static boolean unique4(String test) {
        BitSet checker = new BitSet();
        for (int i = 0; i<test.length();i++) {
            int testChar = test.charAt(i) - 'a';
            if (checker.get(testChar)) return false;
            checker.set(testChar);
        }
        return true;
    }


/////////// Arrays & Strings 1.2 ///////////
     public static boolean perm1(String str1, String str2) {
         if (str1.length() != str2.length()) return false;

         char[] ch1 = str1.toCharArray();
         char[] ch2 = str2.toCharArray();

         Arrays.sort(ch1);
         Arrays.sort(ch2);

         return Arrays.toString(ch1).equals(Arrays.toString(ch2));
     }

     // my solution with more abstraction
    public static String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public static boolean perm2(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    //for time efficiency, doing char counts instead of sorting. Also use an array of ints and the ASCII values of the
    //chars for indices rather than a HashMap

    public static boolean perm3(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] ch = s.toCharArray();
        int[] nums = new int[128]; //number of ascii chars
        for (char c: ch) {
            nums[c]++;
        }
        ch = t.toCharArray();
        for (char c: ch) {
            nums[c]--;
            if (nums[c] < 0) return false;
        }
        return true;
    }

    /////////////// 1.3 /////////////

    public static String urlify(String in, int tl) {
        int sh = in.length() - 1;
        char[] ch = in.toCharArray();
        for (int i = tl - 1; i >= 0; i--) {
            if (ch[i] != ' ') {
                ch[sh] = ch[i];
                sh--;

            }
            else {
                ch[sh] = '0';
                ch[sh - 1] = '2';
                ch[sh - 2] = '%';
                sh -= 3;
            }
        }
        return new String(ch);
    }

    ///////////// 1.4 ////////////

    public static boolean palinPerm(String p) {
        char[] chp = p.toLowerCase().replaceAll("\\s","").toCharArray();
        int[] nums = new int[128];
        for (char c: chp) {
            nums[c]++;
        }
        if (chp.length % 2 == 0) {
            for (int n: nums) {
                if (n != 0) {
                    if (n % 2 != 0) return false;
                }
            }
            return true;
        }
        else {
            boolean foundOdd = false;
            for (int n: nums) {
                if (n != 0) {
                    if (n % 2 != 0) {
                        if (foundOdd) return false;
                        foundOdd = true;
                    }
                }
            }
            return true;
        }
    }

    ///////////// 16.17 ///////////

    //my solution- unfortunately based on faulty assumptions- neat recursion but it doesn't
    //produce the right answer
    public static int findMaxSum(int[] arr) {
        int maxSum, arrSum, arr1Sum, arr2Sum;
        int[] arr1 = Arrays.copyOfRange(arr, 1, arr.length -1);
        int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length - 2);
        arrSum = findSum(arr);
        arr1Sum = findSum(arr1);
        arr2Sum = findSum(arr2);
        maxSum = Math.max(arrSum, arr1Sum);
        maxSum = Math.max(maxSum, arr2Sum);
        if (maxSum==arr1Sum) return findMaxSum(arr1);
        if (maxSum==arr2Sum) return findMaxSum(arr2);
        else return maxSum;

    }
    public static int findSum(int[] arr) {
        int arrSum = 0;
        arrSum = Arrays.stream(arr).sum();
        return arrSum;
    }
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        max = Arrays.stream(arr).reduce(max, (a,b) -> Math.max(a,b));
        return max;
    }

    public static int findMaxSumAditya(int[] arr) {
        int gm = findMax(arr);
        int msf = arr[0];
        for (int i = 1; i < arr.length; i++) {
            msf = Math.max(arr[i], msf + arr[i]);
            gm = Math.max(gm,msf);
        }
        return gm;
    }
    /// this doesn't work ////
    public static int findMaxSumAdityaJonReduce(int[] arr) {

        return Arrays.stream(arr).reduce(Integer.MIN_VALUE, (a,b) -> {
            if (Math.max(b,a+b) == b) {
                return b;
            }
            else {
                return a+b;
            }

        });

    }




}




