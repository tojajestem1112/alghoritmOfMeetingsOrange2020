import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProposingMeetingsTest {


    Employee emp1;
    Employee emp2;
    Employee empNull;

    @BeforeEach
    void init()
    {
        emp1 = new Employee();
        emp2 = new Employee();
        emp1.setStartOfWork(new Time(8,0));
        emp1.setEndOfWork(new Time(20,0));

        emp2.setStartOfWork(new Time(9,0));
        emp2.setEndOfWork(new Time(21,0));

        emp1.addMeeting(new Meeting(new Time(10,00), new Time (11,00)));
        emp2.addMeeting(new Meeting(new Time(11,00), new Time (12,00)));

        empNull = null;
    }
    @Test
    void generatePropositionsAndGetPropositions() {
        //is lower rage working?
        ProposingMeetings mp = new ProposingMeetings(emp1, emp2, 30);
        mp.generatePropositions();
        String result = mp.getPropositions();
        String correctAnwser = "[\"09:00\",\"09:30\"][\"09:30\",\"10:00\"][\"12:00\",\"12:30\"]"+
                                "[\"12:30\",\"13:00\"][\"13:00\",\"13:30\"][\"13:30\",\"14:00\"]"+
                                "[\"14:00\",\"14:30\"][\"14:30\",\"15:00\"][\"15:00\",\"15:30\"]"+
                                "[\"15:30\",\"16:00\"][\"16:00\",\"16:30\"][\"16:30\",\"17:00\"]"+
                                "[\"17:00\",\"17:30\"][\"17:30\",\"18:00\"][\"18:00\",\"18:30\"]"+
                                "[\"18:30\",\"19:00\"][\"19:00\",\"19:30\"][\"19:30\",\"20:00\"]";
        assertTrue(result.equals(correctAnwser));

    }


    @Test
    void showIntervals() {
        ProposingMeetings mp = new ProposingMeetings(emp1, emp2, 30);
        emp1.addMeeting(new Meeting(new Time(15,0), new Time(17,0)));
        mp.generatePropositions();
        String intervals = mp.getIntervals();
        String correctAnwser ="[[\"09:00\",\"10:00\"][\"12:00\",\"15:00\"][\"17:00\",\"20:00\"]]";
        assertTrue(intervals.equals(correctAnwser));
    }
}