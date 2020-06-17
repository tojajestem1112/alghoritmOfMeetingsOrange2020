import java.util.LinkedList;

public class Employee
{
    private Time startOfWork;
    private Time endOfWork;

    private LinkedList<Meeting> meetingsOfPerson = new LinkedList<Meeting>();

    public Employee(Time startOfWork, Time endOfWork)
    {
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
    }
    public Employee()
    {
        startOfWork = new Time();
        endOfWork = new Time();
    }

    public void setStartOfWork(Time startOfWork) {
        this.startOfWork = startOfWork;
    }

    public void addMeeting(Time start, Time end)
    {
        meetingsOfPerson.add(new Meeting(start, end));
    }

    public void setEndOfWork(Time endOfWork) {
        this.endOfWork = endOfWork;
    }

    public void showPerson()
    {
        System.out.println("PERS "+ startOfWork + " - " + endOfWork);
        for (int i=0; i<meetingsOfPerson.size();i++)
        {
            System.out.println(meetingsOfPerson.get(i));
        }
    }
}
