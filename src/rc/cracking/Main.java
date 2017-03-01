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
         char[] ch1 = str1.toCharArray();
         char[] ch2 = str2.toCharArray();

         Arrays.sort(ch1);
         Arrays.sort(ch2);

         return Arrays.toString(ch1).equals(Arrays.toString(ch2));
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

    public static int findMaxSumAditya(int[] arr) {
        int gm = findMax(arr);
        int msf = arr[0];
        for (int i = 0; i < arr.length; i++) {
            msf = Math.max(arr[i], msf + arr[i]);
            gm = Math.max(gm,msf);
        }
        return gm;


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



}




