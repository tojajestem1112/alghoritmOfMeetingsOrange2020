import java.util.LinkedList;

public class ProposingMeetings
{
    private Time lowerRangeTime;
    private Time upperRangeTime;
    private Time cursorTime;
    private LinkedList<Meeting> proposedMeetings = new LinkedList<>();
    private Employee emp1;
    private Employee emp2;
    private int durationTimeInMinutes;

    public ProposingMeetings(Employee emp1, Employee emp2, int durationTimeInMinutes) {
        if(durationTimeInMinutes<1)
            throw new ArithmeticException("Meeting is too brief...");
        if(emp1 == null || emp2 == null)
            throw new NullPointerException("Employee doesnt exist!");
        this.emp1 = emp1;
        this.emp2 = emp2;
        this.durationTimeInMinutes = durationTimeInMinutes;
        //lower range as latest time of starting work
        setLowerRangeTime();

        //upper range as the earliest time of ending work
        setUpperRangeTime();

        cursorTime = new Time(lowerRangeTime);
        cursorTime.addTime(0, durationTimeInMinutes);

    }

    public void generatePropositions()
    {
        if(lowerRangeTime == null || upperRangeTime == null || cursorTime==null)
            throw new NullPointerException("Valid times.");

        while(cursorTime.compareWithOtherTime(upperRangeTime)<1)
        {
            if(!hasEmployeeAcceptedTime(emp1))
                continue;

            if(!hasEmployeeAcceptedTime(emp2))
                continue;

            Meeting newProposition = new Meeting (new Time (lowerRangeTime), new Time (cursorTime));
            proposedMeetings.add(newProposition);
            lowerRangeTime = new Time(cursorTime);
            cursorTime = new Time(lowerRangeTime);
            cursorTime.addTime(0, durationTimeInMinutes);
        }


    }
    public String getPropositions()
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<proposedMeetings.size();i++)
        {
            sb.append(proposedMeetings.get(i));
        }
        return sb.toString();
    }
    public String getIntervals()
    {
        StringBuilder returnedValue = new StringBuilder("[");
        boolean startHasBeenShown = false;
        for(int i=0; i<proposedMeetings.size()-1;i++)
        {
            if(!startHasBeenShown) {
                returnedValue.append("["+proposedMeetings.get(i).getStartOfMeeting());
                startHasBeenShown=true;
            }
            if(proposedMeetings.get(i).getEndOfMeeting().compareWithOtherTime(proposedMeetings.get(i+1).getStartOfMeeting())!=0)
            {
                returnedValue.append("," + proposedMeetings.get(i).getEndOfMeeting()+"]");
                startHasBeenShown = false;
            }
            else if (i == proposedMeetings.size()-2)
            {
                returnedValue.append("," + proposedMeetings.get(i+1).getEndOfMeeting()+"]]");
                startHasBeenShown = false;
            }
        }
        return returnedValue.toString();
    }

    private void setLowerRangeTime()
    {
        int isStartTimeBiggerThanSecond = emp1.getStartOfWork().compareWithOtherTime(
                emp2.getStartOfWork());

        if (isStartTimeBiggerThanSecond > 0)//1 stars later or at the same time
            lowerRangeTime = new Time(emp1.getStartOfWork());
        else //2 empl starts later
            lowerRangeTime = new Time(emp2.getStartOfWork());
    }
    private void setUpperRangeTime()
    {
        int isEndTimeBiggerThanSecond = emp1.getEndOfWork().compareWithOtherTime(
                emp2.getEndOfWork());

        if (isEndTimeBiggerThanSecond > 0)//1st ends work later
            upperRangeTime = new Time(emp2.getEndOfWork());
        else
            upperRangeTime = new Time(emp1.getEndOfWork());
    }
    private boolean hasEmployeeAcceptedTime(Employee empl)
    {
        Time proposedNewTimeFromFirstEmp=empl.checkTimeOfNewMeeting(lowerRangeTime, cursorTime);
        if(proposedNewTimeFromFirstEmp!= null)
        {
            lowerRangeTime=new Time(proposedNewTimeFromFirstEmp);
            cursorTime = new Time(lowerRangeTime);
            cursorTime.addTime(0, durationTimeInMinutes);
            return false;
        }
        return true;
    }
}
