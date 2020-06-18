public class Time
{
    private int hours;
    private int minutes;

    public Time()
    {
        int hours = 0;
        int minutes = 0;
    }

    public Time(int hours, int minutes)
    {
        if(hours<0 || minutes <0)
            throw new ArithmeticException("Number of minutes and hours must be positive!");

        this.hours = hours;
        this.minutes = minutes;
        checkTime();
    }

    public Time(Time time)
    {
        if(time == null)
            throw new NullPointerException("Time is NULL!");
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
    }

    private void checkTime()
    {
        while(minutes >= 60)
        {
            hours++;
            minutes-=60;
        }
        while(hours >=24)
        {
            hours-= 24;
        }
    }

    public void addTime(int hours, int minutes)
    {
        if(hours<0 || minutes < 0)
            throw new ArithmeticException("Wrong number of minutes or hours!");
        this.minutes += minutes;
        this.hours += hours;
        checkTime();
    }

    public int compareWithOtherTime(Time secondTime)
    {

        //0 -> times are the same
        //1 -> time is 'bigger' than second
        //-1 ...
        if(secondTime == null)
            throw new NullPointerException("Time is NULL!");
        int hoursOfSecondTime = secondTime.getHours();
        int minutesOfSecondTime = secondTime.getMinutes();

        if(hours == hoursOfSecondTime && minutes == minutesOfSecondTime)
            return 0;
        else if(hours > hoursOfSecondTime || (hours == hoursOfSecondTime && minutes > minutesOfSecondTime))
            return 1;
        else
            return -1;

    }

    private String getNumberWithTwoDigits(int number)
    {
        String numberWithTwoDigits = String.valueOf(number);
        if(numberWithTwoDigits.length()  < 2)
        {
            numberWithTwoDigits = "0" + numberWithTwoDigits;
        }
        return numberWithTwoDigits;
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public String toString()
    {
        return"\""+ getNumberWithTwoDigits(hours) + ":"+ getNumberWithTwoDigits(minutes)+"\"";
    }
}
