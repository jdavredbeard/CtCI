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

}