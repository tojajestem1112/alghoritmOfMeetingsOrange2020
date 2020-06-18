import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    Time timeTest1;
    Time timeTest2;
    Time timeTest3;
    @org.junit.jupiter.api.BeforeEach
    void initializeTimeTest()
    {
        timeTest1 = new Time(9,30);
        timeTest2 = new Time(10,25);
        timeTest3 = new Time(8,1);
    }


    @org.junit.jupiter.api.Test
    void addTime() {
        timeTest1.addTime(1,30);
        assertEquals(11, timeTest1.getHours());
        assertEquals(0, timeTest1.getMinutes());
        timeTest1.addTime(15,21);
        assertEquals(2, timeTest1.getHours());
        assertEquals(21, timeTest1.getMinutes());
    }

    @org.junit.jupiter.api.Test
    void compareWithOtherTime() {
        int result = timeTest1.compareWithOtherTime(timeTest1);
        assertEquals(0, result);

        result = timeTest1.compareWithOtherTime(timeTest2);
        assertEquals(-1, result);

        result = timeTest1.compareWithOtherTime(timeTest3);
        assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void toString1() {
        boolean result = true;
        if(!timeTest1.toString().equals("\"09:30\""))
            result = false;
        if(!timeTest3.toString().equals("\"08:01\""))
            result = false;
        assertTrue(result);
    }

}