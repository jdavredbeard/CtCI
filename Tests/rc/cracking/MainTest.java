package rc.cracking;

import org.junit.Test;

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
    public void findMaxSumTest() {
        assertEquals(5,Main.findMaxSum(new int[]{2,-8,3,-2,4,-10}));
    }
    @Test
    public void findMaxSumAdityaTest() {
        assertEquals(5, Main.findMaxSumAditya(new int[]{2,-8,3,-2,4,-10}));
    }

}