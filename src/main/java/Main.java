public class Main {

    public static void main(String args[])
    {
        Time time1 = new Time(9,0);
        Time time2 = new Time(12,50);

        time1.addTime(10,12);
        time2.addTime(12,13);
        System.out.println(time1 + "\n" + time2);
    }
}
