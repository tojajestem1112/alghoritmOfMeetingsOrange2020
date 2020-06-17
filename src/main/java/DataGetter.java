import com.sun.xml.internal.ws.util.StringUtils;

import javax.xml.bind.ValidationException;
import java.util.LinkedList;

public class DataGetter
{
    public DataGetter(){}

    public int getDurationTime(String text)
    {

        String durationTime = text.substring(text.indexOf("[") +1, text.indexOf("]"));
        int hours = Integer.parseInt(durationTime.split(":")[0]);
        int minutes = Integer.parseInt(durationTime.split(":")[1]);
        return hours * 60 + minutes;
    }
    public void getEmployee(String text) throws ValidationException {
        text = text.trim().replaceAll("[\\[\\]\\{\\},\n\t ]","");
        String[] tempTable = text.split("[\"\\:]");

        boolean workFlag = false;
        boolean meetingFlag = false;
        Employee emp = new Employee();
        Time tempTime = new Time();
        LinkedList<String> elementsOfCalendar = new LinkedList<>();
        for(int i=0;i<tempTable.length;i++)
            if(tempTable[i].length()!=0) elementsOfCalendar.add(tempTable[i]);

        for(int i=0;i<elementsOfCalendar.size();i++)
        {
            System.out.println(elementsOfCalendar.get(i));
            if(elementsOfCalendar.get(i).equals("working_hours"))
            {
                workFlag = true;
                meetingFlag = false;
            }
            else if(elementsOfCalendar.get(i).equals("planned_meeting"))
            {
                workFlag = false;
                meetingFlag = true;
            }
            else if(elementsOfCalendar.get(i).equals("start"))
            {
                if(!elementsOfCalendar.get(i+3).equals("end"))
                    throw new ValidationException("Invalid structure of calendar");
                int startHours = Integer.parseInt(elementsOfCalendar.get(i+1));
                int startMinutes = Integer.parseInt(elementsOfCalendar.get(i+2));
                int endHours = Integer.parseInt(elementsOfCalendar.get(i+4));
                int endMinutes = Integer.parseInt(elementsOfCalendar.get(i+5));
                i+=5;
                if(workFlag && !meetingFlag) {
                    emp.setStartOfWork(new Time(startHours, startMinutes));
                    emp.setEndOfWork(new Time(endHours, endMinutes));
                }
                else if (!workFlag && meetingFlag)
                {
                    emp.addMeeting(new Time(startHours, startMinutes), new Time(endHours, endMinutes));
                }
                else
                    throw new ValidationException("Invalid structure of calendar");
            }
            else
                throw new ValidationException("Invalid structure of calendar");

        }
        emp.showPerson();

    }
}
