public class Meeting
{
    private Time startOfMeeting;
    private Time endOfMeeting;

    public Meeting (Time startOfMeeting, Time endOfMeeting)
    {
        if(startOfMeeting == null || endOfMeeting == null)
            throw new NullPointerException("Time is NULL!");
        if(startOfMeeting.compareWithOtherTime(endOfMeeting)>=0)
            throw new ArithmeticException("Start time must be BEFORE endtime");

        this.startOfMeeting = startOfMeeting;
        this.endOfMeeting = endOfMeeting;
    }

    public Time getStartOfMeeting()
    {
        return startOfMeeting;
    }
    public Time getEndOfMeeting()
    {
        return endOfMeeting;
    }


    public String toString()
    {
        return "["+startOfMeeting+"," + endOfMeeting + "]";
    }
}
