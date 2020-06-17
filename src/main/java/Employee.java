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
}
