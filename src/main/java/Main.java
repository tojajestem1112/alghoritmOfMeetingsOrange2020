import javax.xml.bind.ValidationException;

public class Main {

    public static void main(String args[])
    {
        System.out.println("******Spotkajmy się******");
        String calendar1 = "{\n" +
                "working_hours: {\n" +
                "start: \"09:00\",\n" +
                "end: \"20:00\"\n" +
                "},\n" +
                "planned_meeting: [\n" +
                "{\n" +
                "start: \"09:00\",\n" +
                "end: \"10:30\"\n" +
                "},\n" +
                "{\n" +
                "start: \"12:00\",\n" +
                "end: \"13:00\"\n" +
                "},\n" +
                "{\n" +
                "start: \"16:00\",\n" +
                "end: \"18:30\"\n" +
                "}\n" +
                "]\n" +
                "}";
        String calendar2 = "{\n" +
                "working_hours: {\n" +
                "start: \"10:00\",\n" +
                "end: \"18:30\"\n" +
                "},\n" +
                "planned_meeting: [\n" +
                "{\n" +
                "start: \"10:00\",\n" +
                "end: \"11:30\"\n" +
                "},\n" +
                "{\n" +
                "start: \"12:30\",\n" +
                "end: \"14:30\"\n" +
                "},\n" +
                "{\n" +
                "start: \"14:30\",\n" +
                "end: \"15:00\"\n" +
                "},\n" +
                "{\n" +
                "start: \"16:00\",\n" +
                "end: \"17:00\"\n" +
                "}\n" +
                "]\n" +
                "}";
        String meetingDuration = "meeting duration: [01:30]";
        DataGetter dg = new DataGetter();
        int durationTimeInMinutes = dg.getDurationTime(meetingDuration);
        System.out.println(durationTimeInMinutes);
        try {
            dg.getEmployee(calendar1);
        } catch (ValidationException e) {
            e.printStackTrace();
        }


    }
}
