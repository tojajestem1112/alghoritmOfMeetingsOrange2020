import java.util.LinkedList;

public class Employee
{
    private Time startOfWork;
    private Time endOfWork;
    private LinkedList<Meeting> meetingsOfPerson = new LinkedList<Meeting>();

    public Employee()
    {
        startOfWork = new Time();
        endOfWork = new Time();
    }

    public void addMeeting(Meeting meeting)
    {
        meetingsOfPerson.add(meeting);
    }

    public Time checkTimeOfNewMeeting(Time startOfMeeting, Time endOfMeeting)
    {
        //return -> null - employee can take part in meeting
        //return -> other time -> gives a minimum time in which next meeting can be planned
        for(int i=0; i<meetingsOfPerson.size();i++)
        {
            Time startOfAnalysedMeeting = meetingsOfPerson.get(i).getStartOfMeeting();
            Time endOfAnalysedMeeting = meetingsOfPerson.get(i).getEndOfMeeting();

            if((startOfMeeting.compareWithOtherTime(startOfAnalysedMeeting)>=0 &&       //Starttime is in other meeting
                        startOfMeeting.compareWithOtherTime(endOfAnalysedMeeting)<0) ||
                    (endOfMeeting.compareWithOtherTime(startOfAnalysedMeeting)>0 &&     //Endtime is in other meeting
                        endOfMeeting.compareWithOtherTime(endOfAnalysedMeeting)<=0) ||
                    (startOfMeeting.compareWithOtherTime(startOfAnalysedMeeting)<=0 &&  //Other meeting is in a time in which we want to make meeting
                        endOfMeeting.compareWithOtherTime(endOfAnalysedMeeting)>=0))
            {
                return endOfAnalysedMeeting;    //we are returning new minimal time, which can be used
            }
        }
        return null;        //everything is fine, that employee can take part in that meeting
    }

    public void setEndOfWork(Time endOfWork) {
        if(endOfWork==null)
            throw new NullPointerException("Time is null!");
        this.endOfWork = endOfWork;
    }

    public Time getStartOfWork() {
        return startOfWork;
    }

    public Time getEndOfWork() {
        return endOfWork;
    }


    public void setStartOfWork(Time startOfWork) {
        if(startOfWork==null)
            throw new NullPointerException("Time is null!");
        this.startOfWork = startOfWork;
    }

    /*
    //Method for testing
    public void showPerson()
    {
        System.out.println("PERS "+ startOfWork + " - " + endOfWork);
        for (int i=0; i<meetingsOfPerson.size();i++)
        {
            System.out.println(meetingsOfPerson.get(i));
        }
    }*/
}
