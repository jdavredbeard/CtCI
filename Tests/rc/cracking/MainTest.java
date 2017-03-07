package rc.cracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by jonathandavenport on 3/1/17.
 */
public class MainTest {
    @Test
    public void uniqueTest2() {
        assertEquals(true,Main.unique("a"));
    }
    @Test
    public void uniqueTest() throws Exception {
        assertEquals(false,Main.unique("aabcde"));
    }
    @Test
    public void uniqueTest3() {
        assertEquals(true,Main.unique2("a"));
    }
    @Test
    public void uniqueTest4() throws Exception {
        assertEquals(false,Main.unique2("aabcde"));
    }
    @Test
    public void uniqueTest5() {
        assertEquals(true,Main.unique3("a"));
    }
    @Test
    public void uniqueTest6() throws Exception {
        assertEquals(false,Main.unique3("aabcde"));
    }
    @Test
    public void uniqueTest7() {
        assertEquals(true,Main.unique4("a"));
    }
    @Test
    public void uniqueTest8() throws Exception {
        assertEquals(false,Main.unique4("aabcde"));
    }
    ////////////// 1.2 ///////////////
    @Test
    public void permTest1() {
        assertEquals(true, Main.perm1("abc","bac"));
    }
    @Test
    public void permTest2() {
        assertEquals(true, Main.perm1("abcd","bdac"));
    }
    @Test
    public void permTest3() {
        assertEquals(false, Main.perm1("abcd","bdace"));
    }
    @Test
    public void permTest4() {
        assertEquals(true, Main.perm2("abc","bac"));
    }
    @Test
    public void permTest5() {
        assertEquals(true, Main.perm2("abcd","bdac"));
    }
    @Test
    public void permTest6() { assertEquals(false, Main.perm2("abcd","bdace")); }
    @Test
    public void permTest6a() { assertEquals(false, Main.perm2("abcd","bdae")); }
    @Test
    public void permTest7() {
        assertEquals(true, Main.perm3("abc","bac"));
    }
    @Test
    public void permTest8() {
        assertEquals(true, Main.perm3("abcd","bdac"));
    }
    @Test
    public void permTest9() {
        assertEquals(false, Main.perm3("abcd","bdace"));
    }
    @Test
    public void permTest9a() {
        assertEquals(false, Main.perm3("abcd","bdae"));
    }

    ////////////// 1.3 ////////////////
    @Test
    public void urlifyTest1() {
        assertEquals("Mr%20John%20Smith", Main.urlify("Mr John Smith    ",13));
    }

    ///////////// 1.4 /////////////
    @Test
    public void palinPermTest() {
        assertEquals(true, Main.palinPerm("Tact Coa"));
    }

    ///////////// 16.17 //////////////
//    @Test
//    public void findMaxSumTest() {
//        assertEquals(5,Main.findMaxSum(new int[]{2,-8,3,-2,4,-10}));
//    }
    @Test
    public void findMaxSumAdityaTest() {
        assertEquals(5, Main.findMaxSumAditya(new int[]{2,-8,3,-2,4,-10}));
    }

//    @Test
//    public void findMaxSumAdityaJonReduceTest() {
//        assertEquals(5, Main.findMaxSumAdityaJonReduce(new int[]{2,-8,3,-2,4,-10}));
//    }

    ///////////// 17.7 /////////////
    @Test
    public void babyNamesTest() {
        HashMap<String, Integer> freqs = new HashMap<String, Integer>();
        String[] names = new String[]{"John","Jon","Chris","Kris","Christopher"};
        int[] fr = new int[]{15,12,13,4,19};
        for (int i = 0; i<names.length;i++) {
            freqs.put(names[i],fr[i]);
        }

        HashMap<String, ArrayList<String>> syns = new HashMap<String, ArrayList<String>>();
        syns.put("Jon", new ArrayList<String>(Arrays.asList("John")));
        syns.put("John",new ArrayList<String>(Arrays.asList("Johnny")));
        syns.put("Chris", new ArrayList<String>(Arrays.asList("Kris","Christopher")));

        assertEquals("{Kris=36, John=27}", Main.babyNames(freqs,syns).toString());
    }

}