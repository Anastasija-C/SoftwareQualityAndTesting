package junit;

import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.*;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionalityBasedModelTest {

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

    // Test 0: TTT
    // c1: set1 & set2 are not equal => T
    // c2: set1 has more elements than set2 => T
    // c3: elements that are in set1, but not in set2 => T
    @Test
    public void baseCase_Test(){
        set1.add(0);
        set1.add(27);
        set1.add(19);
        set1.add(1);

        set2.add(27);
        set2.add(19);

        assertFalse(set1.equals(set2));

        assertTrue(set1.size()>set2.size());

        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(0);
        expectedSet.add(1);
        assertEquals(expectedSet,setDifference(set1,set2));
    }

    // Test 1: TFT
    // c2_F: set1 does not have more elements than set2
    @Test
    public void c2_Test() {
        set1.add(19);
        set1.add(9);
        set1.add(27);

        set2.add(1);
        set2.add(27);
        set2.add(29);
        set2.add(0);

        assertFalse(set1.equals(set2));

        assertFalse(set1.size()>set2.size());

        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(19);
        expectedSet.add(9);
        assertEquals(expectedSet,setDifference(set1,set2));
    }

    // Test 2: FTT
    // c1_F: set1 & set2 are equal
    @Test
    public void c1_Test(){
        set1.add(19);

        set2.add(19);

        assertTrue(set1.equals(set2));

        assertFalse(set1.size()>set2.size());

        Set<Integer> expectedSet = null;
        assertEquals(expectedSet,setDifference(set1,set2));
    }

    // Test 3: TTF
    // c3_F: elements in set2 that aren't in set1
    @Test
    public void c3_Test(){
        set1.add(29);
        set1.add(19);
        set1.add(9);
        set1.add(0);

        set2.add(17);
        set2.add(21);

        assertFalse(set1.equals(set2));

        assertTrue(set1.size()>set2.size());

        Set<Integer> expectedSet = null;
        assertNotEquals(expectedSet,setDifference(set1,set2));
    }
}
