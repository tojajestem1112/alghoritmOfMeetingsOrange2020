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
        this.minutes += minutes;
        this.hours += hours;
        checkTime();
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

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public String toString()
    {
        return getNumberWithTwoDigits(hours) + " : "+ getNumberWithTwoDigits(minutes);
    }
}
