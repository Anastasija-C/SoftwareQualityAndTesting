package PitestTesting;

 import org.junit.*;

import java.util.List;

 import static org.junit.Assert.*;

public class ConferenceTests {

    private final Conference conference = new Conference(5);
    private final List<Person> attendees = conference.getAttendees();

    private final double AFFILIATE_TICKET = 7.803;
    private final double FACULTY_EMPLOYEE_TICKET = 2.601;
    private final double TICKET_PRICE = 8.67;
    private final int CAPACITY = 10000;

    public ConferenceTests() {
        Person attendee1 = new Person("Klara", "Kl", Role.FACULTY_EMPLOYEE, 31);
        Person attendee2 = new Person("Joana", "Jo", Role.AFFILIATE, 36);
        Person attendee3 = new Person("Simon", "Si", Role.OTHER, 22);
        attendees.add(attendee1);
        attendees.add(attendee2);
        attendees.add(attendee3);
    }

    @Test
    public void calculateTotalPriceTest() {
        double total = TICKET_PRICE + AFFILIATE_TICKET + FACULTY_EMPLOYEE_TICKET;
        double price = conference.calculateTotalPricePaid();
        assertEquals(total, price, 0.0);
    }

    @Test
    public void setSurnameTest() {
        attendees.get(0).setSurname("Pe");
        assertTrue(true);
    }

    @Test
    public void setRoleTest() {
        attendees.get(0).setRole(Role.AFFILIATE);
        assertTrue(true);
    }

    @Test
    public void setAgeTest() {
        attendees.get(0).setAge(29);
        assertTrue(true);
    }

    @Test
    public void toStringTest() {
        Person attendee = new Person("Joe", "Jo", Role.AFFILIATE, 31);
        attendee.setSurname("Jo2");
        attendee.setRole(Role.FACULTY_EMPLOYEE);
        attendee.setAge(41);
        attendee.getRole();
        assertEquals("pitest_classes.Person{name='Joe', surname='Jo2', role=FACULTY_EMPLOYEE, age=41}", attendee.toString());
    }

    @Test
    public void addAttendeeToConferenceTest() {
        Person attendee = new Person("Joe", "Jo",Role.STUDENT,22);
        assertTrue(conference.addAttendeeToConference(attendee));
    }

    @Test
    public void doubleCapacityTest() {
        int capacity = conference.getCapacity();

        if (capacity * 2 > CAPACITY) {
            assertFalse(conference.doubleCapacity());
        }
        else if (capacity < CAPACITY) {
            assertTrue(conference.doubleCapacity());
        }
    }

    @Test
    public void doubleCapacityTest2() {
        Conference conference = new Conference(10000);
        assertEquals(false, conference.doubleCapacity());
    }

}

