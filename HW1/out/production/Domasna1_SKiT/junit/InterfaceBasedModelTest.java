package junit;

import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class InterfaceBasedModelTest {

    public static Set setDifference(Set set1, Set set2) {
        if (set1 == null || set2 == null) {
            throw new NullPointerException();
        }

        if(set1.isEmpty()) {
            return null;
        }

        set1.removeAll(set2);

        if(!set1.isEmpty()) {
            return set1;
        }
        return null;
    }

    public Set<Integer> set1 = new HashSet<>();
    public Set<Integer> set2 = new HashSet<>();


    // Test 0: TTTT
    // c1: set1 is non null => T
    // c2: set2 is non null => T
    // c3: set1 is not empty => T
    // c4: set2 is not empty => T
    @Test
    public void baseCase_Test() {

        set1.add(27);
        set1.add(29);
        set1.add(1);
        set1.add(9);

        set2.add(6);
        set2.add(0);
        set2.add(1);

        setDifference(set1,set2);

        assertNotNull(set1);

        assertNotNull(set2);

        assertFalse(set1.isEmpty());

        assertFalse(set2.isEmpty());
    }


    // Test 1: FTTT
    // c1_F: set1 is null
    @Test(expected = NullPointerException.class)
    public void c1_Test() {

        Set<Integer> set1 = null;

        set1.add(19);

        set2.add(27);
        set2.add(7);

        setDifference(set1, set2);

        assertNull(set1);
    }

    // Test 2: TFTT (infeasible)
    // c2_F: set2 is null
    @Test(expected = NullPointerException.class)
    public void c2_Test(){

        Set<Integer> set2 = null;

        set1.add(19);

        set2.add(7);

        setDifference(set1, set2);

        assertNull(set2);
    }

    // Test 3: TTFT
    // c3_F: set1 is empty
    @Test
    public void c3_Test(){

        set2.add(6);
        set2.add(0);

        assertTrue(set1.isEmpty());
    }

    // Test 4: TTTF
    // c4_F: set2 is empty
    @Test
    public void c4_Test(){

        set1.add(17);

        assertTrue(set2.isEmpty());
    }
}
