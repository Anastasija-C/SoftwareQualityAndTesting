import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class calTests {

    boolean month1 = false;
    boolean month2 = false;
    boolean m4 = false;
    boolean m100 = false;
    boolean m400 = false;

    public void makeMonth1() {
        month1 = true;
    }

    public void makeMonth2() {
        month2 = true;
    }

    public void makeM4() {
        m4 = true;
    }

    public void makeM100() {
        m100 = true;
    }

    public void makeM400() {
        m400 = true;
    }

    public boolean isSatisfactoryIf1() {
        if (month2 == month1) {
            return true;
        } else return false;
    }

    public boolean isSatisFactoryIf2(int m4, int m100, int m400) {
        if ((m4 != 0) || ((m100 == 0) && (m400 != 0))) {
            return true;
        } else return false;
    }

    calTests cal;

    @BeforeEach
    public void setUp() {
        cal = new calTests();
    }

    // P: month2 == month1
    @Test
    public void test2_If1() {
        cal.makeMonth2(); // 2: T F
        assertFalse(cal.isSatisfactoryIf1());
    }

    @Test
    public void test4_If1() {
        // 4: F F
        assertTrue(cal.isSatisfactoryIf1());
    }

    @Test
    public void test3_If1() {
        cal.makeMonth1(); // 3: F T
        assertFalse(cal.isSatisfactoryIf1());
    }


    // P: (m4 != 0) || ((m100 == 0) && (m400 != 0))
    @Test
    public void test4_If2() {
        cal.makeM4(); // 4: T F F
        assertTrue(cal.isSatisFactoryIf2(6, 8, 0));
    }

    @Test
    public void test8_If2() {
        // 8: F F F
        assertFalse(cal.isSatisFactoryIf2(0, 6, 0));
    }

    @Test
    public void test5_If2() {
        cal.makeM100();
        cal.makeM400(); // 5: F T T
        assertTrue(cal.isSatisFactoryIf2(0, 0, 8));
    }

    @Test
    public void test7_If2() {
        cal.makeM400(); // 7: F F T
        assertFalse(cal.isSatisFactoryIf2(0, 6, 8));
    }

    @Test
    public void test6_If2() {
        cal.makeM100(); // F T F
       assertFalse(cal.isSatisFactoryIf2(0, 0, 0));
    }

}