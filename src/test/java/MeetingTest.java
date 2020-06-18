import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {


    Time time1;
    Time time2;

    @BeforeEach
    public void init()
    {
        time1 = new Time(9,10);
        time2 = new Time(10,25);
    }

    @Test
    void testConstructor()
    {
        Time temp = null;
        NullPointerException exc1 = assertThrows (
                NullPointerException.class, () -> new Meeting (temp,time1)
        );
        assertEquals("Time is NULL!", exc1.getMessage());

        ArithmeticException exc2 = assertThrows (
                ArithmeticException.class, () -> new Meeting (time1,time1)
        );
        assertEquals("Start time must be BEFORE endtime", exc2.getMessage());

        Meeting meeting = new Meeting(time1, time2);
        assertEquals(9, meeting.getStartOfMeeting().getHours());
        assertEquals(10, meeting.getStartOfMeeting().getMinutes());
        assertEquals(10, meeting.getEndOfMeeting().getHours());
        assertEquals(25, meeting.getEndOfMeeting().getMinutes());
    }

    @Test
    void toString1() {
        Meeting meeting = new Meeting(time1, time2);
        boolean result = false;
        if(meeting.toString().equals("[\"09:10\",\"10:25\"]"))
            result=true;
        assertTrue(result);
    }
}