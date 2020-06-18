import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataGetterTest {

    DataGetter dataGetter = new DataGetter();
    @Test
    void getDurationTime() {
        String meetingDuration1 = "meeting duration: [00:30]";
        String meetingDuration2 = "meeting duration: [01:30]";
        String meetingDuration3 = "meeting duration: [00:01]";
        assertEquals(30,dataGetter.getDurationTime(meetingDuration1));
        assertEquals(90,dataGetter.getDurationTime(meetingDuration2));
        assertEquals(1,dataGetter.getDurationTime(meetingDuration3));
    }

}