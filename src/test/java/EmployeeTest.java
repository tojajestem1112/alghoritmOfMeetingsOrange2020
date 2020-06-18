import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee emp1;
    Employee emp2;
    Employee emp3;
    Time t1;
    Time t2;
    Time t3;
    Time t4;
    Time t5;
    Time n;

    @BeforeEach
    void setAttributesOfEmployees()
    {
        t1 = new Time(8,25);
        t2 = new Time(9,32);
        t3 = new Time(10,11);
        t4 = new Time(16,16);
        t5 = new Time(17,25);
        n = null;

        emp1 = new Employee();
        emp1.setStartOfWork(t1);
        emp1.setEndOfWork(t5);

        emp2 = new Employee();
        emp2.setStartOfWork(t2);
        emp2.setEndOfWork(t4);

        emp3= new Employee();
    }
    @Test
    void testOfsetters()
    {
        NullPointerException exc1 = assertThrows (
                NullPointerException.class,() -> emp3.setStartOfWork(n)
        );
        assertEquals("Time is null!", exc1.getMessage());

        NullPointerException exc2 = assertThrows (
                NullPointerException.class, () -> emp3.setEndOfWork(n)
        );
        assertEquals("Time is null!", exc2.getMessage());
    }

    @Test
    void checkTimeOfNewMeeting(){
        //Creating example of planned meetings
        emp1.addMeeting(new Meeting(new Time(11,00), new Time(12,00)));
        //Null result -> employee accepted time of meeting
        Time result  =emp1.checkTimeOfNewMeeting(new Time(9,00), new Time(10,0));
        assertNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(9,00), new Time(11,0));
        assertNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(12,00), new Time(13,0));
        assertNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(12,30), new Time(13,0));
        assertNull(result);

        //Time can not be acceepted
        result  =emp1.checkTimeOfNewMeeting(new Time(11,00), new Time(12,0));
        assertNotNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(11,30), new Time(11,45));
        assertNotNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(9,00), new Time(11,05));
        assertNotNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(10,30), new Time(15,00));
        assertNotNull(result);
        result  =emp1.checkTimeOfNewMeeting(new Time(9,00), new Time(15,05));
        assertNotNull(result);

    }


}