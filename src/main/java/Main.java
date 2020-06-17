public class Main {

    public static void main(String args[])
    {

        Time time1 = new Time(9,0);
        Time time2 = new Time(12,50);

        Meeting meeting1 = new Meeting(time1, time2);
        System.out.println(meeting1);
    }
}
