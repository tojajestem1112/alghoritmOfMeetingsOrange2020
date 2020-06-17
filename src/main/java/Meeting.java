public class Meeting
{
    private Time startOfMeeting;
    private Time endOfMeeting;

    public Meeting (Time startOfMeeting, Time endOfMeeting)
    {
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
        return "["+startOfMeeting+" - " + endOfMeeting + "]";
    }
}
